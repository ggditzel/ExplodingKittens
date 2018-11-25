

import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoJogandoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;

public class AtorNetgames implements OuvidorProxy {
	
	private AtorJogador atorJogador; // ainda falta implementar o atorJogador
	
	private Proxy proxy;
	
	private boolean ehMinhaVez = false;
	
	public AtorNetgames(AtorJogador atorJogador) {
		super();
		this.atorJogador = atorJogador;
		proxy = Proxy.getInstance();
		proxy.addOuvinte(this); // para ouvir o Proxy, receber jogada do outro jogador
		
	}
	
	/**
	 * Dados para a conexao
	 * 
	 * @param servidor
	 * @param nome
	 */
	public void conectar(String servidor, String nome) {
		try {
			proxy.conectar(servidor, nome);
		} catch (JahConectadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NaoPossivelConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ArquivoMultiplayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Inicia uma partida entre cliente e servidor
	 */
	public void iniciarPartida() {
		try {
			proxy.iniciarPartida(2); // solicita ao servidor; servidor manda msg para cada jogador, via metodo inicarNovaPartida
		} catch (NaoConectadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void enviarJogada(Jogada jogada) {
		try {
			proxy.enviaJogada(jogada);
			ehMinhaVez = false; // apos jogar, nao eh mais sua vez
		} catch (NaoJogandoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// metodo chamado pelo servidor
	@Override
	public void receberJogada(Jogada jogada) {
		Lance lance = (Lance) jogada;
		ehMinhaVez = true; // se recebi uma jogada, agora eh minha vez
		atorJogador.receberJogada(lance); // ator jogador pode receber toda a informacao da jogada, atualizar telas, etc
		
	}
	
	public void desconectar() {
		try {
			proxy.desconectar();
		} catch (NaoConectadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String obterNomeAdversario() {
		String nome = "";
		if (ehMinhaVez) {
			nome = proxy.obterNomeAdversario(2);
		} else {
			nome = proxy.obterNomeAdversario(1);
		}
		return nome;
	}

	/**
	 * mensagem recebida pelo ouvidor proxy, quando recebe solicitacao do servidor
	 * 
	 * indica a "posicao" (vez) do jogador
	 * 
	 * posicao = 1 => jogador da vez;
	 * posicao = 2 => segundo a jogar;
	 */
	@Override
	public void iniciarNovaPartida(Integer posicao) {  // 1 se for jogador 1, 2 se for jogador 2, ...
		
		if (posicao == 1) {
			ehMinhaVez = true;
		} else if (posicao == 2) {
			ehMinhaVez = false;
		}
		atorJogador.iniciarPartida(ehMinhaVez);

	}

	@Override
	public void finalizarPartidaComErro(String message) {
		// TODO Auto-generated method stub
		
		// problema, por exemplo o outro jogador se desconectou

	}


	@Override
	public void tratarConexaoPerdida() {
		// TODO Auto-generated method stub
		
		// servidor caiu, ta sem cabo de rede...

	}

	@Override
	public void tratarPartidaNaoIniciada(String message) {
		// TODO Auto-generated method stub
		
		// servidor nao consegue iniciar partida, por exemplo so tem um jogador conectado

	}

	@Override
	public void receberMensagem(String msg) {
		// TODO Auto-generated method stub
		
	}
}
