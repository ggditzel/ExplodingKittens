

import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoJogandoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;

public class AtorNetgames implements OuvidorProxy {
	
	private static final long serialVersionUID = 1L;
	
	private AtorJogador atorJogador; // ainda falta implementar o atorJogador
	
	private Proxy proxy;
	
	private boolean ehMinhaVez = false;
	
	protected ResourceBundle resourceBundle;

	
	
	public AtorNetgames(AtorJogador atorJogador) {
		//super();
		this.resourceBundle = resourceBundle.getBundle("resources.ArquivoMensagens", GameLocale.locale);

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
			System.out.println("conectou");
			
		} catch (JahConectadoException e) {
			this.resourceBundle = resourceBundle.getBundle("resources.ArquivoMensagens", GameLocale.locale);

			if(resourceBundle.getLocale().getCountry().equalsIgnoreCase("BR")) {
				JOptionPane.showMessageDialog(atorJogador.getTela(), e.getMessage());	
			} else {
				JOptionPane.showMessageDialog(atorJogador.getTela(), resourceBundle.getString("JahConectadoException"));
			}
			
		} catch (NaoPossivelConectarException e) {
			this.resourceBundle = resourceBundle.getBundle("resources.ArquivoMensagens", GameLocale.locale);

			if(resourceBundle.getLocale().getCountry().equalsIgnoreCase("BR")) {
				JOptionPane.showMessageDialog(atorJogador.getTela(), e.getMessage());
			} else {
				JOptionPane.showMessageDialog(atorJogador.getTela(), resourceBundle.getString("NaoPossivelConectarException"));
			}
		} catch (ArquivoMultiplayerException e) {
			this.resourceBundle = resourceBundle.getBundle("resources.ArquivoMensagens", GameLocale.locale);

			if(resourceBundle.getLocale().getCountry().equalsIgnoreCase("BR")) {
				JOptionPane.showMessageDialog(atorJogador.getTela(), e.getMessage());
			} else {
				JOptionPane.showMessageDialog(atorJogador.getTela(), resourceBundle.getString("ArquivoMultiplayerException"));
			}
		}
	}
	
	/**
	 * Inicia uma partida entre cliente e servidor
	 */
	public void iniciarPartida() {

		try {
			proxy.iniciarPartida(2); // solicita ao servidor; servidor manda msg para cada jogador, via metodo inicarNovaPartida
			System.out.println("criou sala para 2 jogadores");
		} catch (NaoConectadoException e) {
			this.resourceBundle = resourceBundle.getBundle("resources.ArquivoMensagens", GameLocale.locale);

			if(resourceBundle.getLocale().getCountry().equalsIgnoreCase("BR")) {
				JOptionPane.showMessageDialog(atorJogador.getTela(), e.getMessage());
			} else {
				JOptionPane.showMessageDialog(atorJogador.getTela(), resourceBundle.getString("NaoConectadoException"));
			}
		}
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
		
//		if (posicao == 1) {
//			ehMinhaVez = true;
//		} else if (posicao == 2) {
//			ehMinhaVez = false;
//		}
		ehMinhaVez = posicao == 1;
		System.out.println("criou uma partida, vez de " + ehMinhaVez);
		atorJogador.iniciarPartida(ehMinhaVez);

	}
	
	public void enviarJogada(Jogada jogada) {
		try {
			proxy.enviaJogada(jogada);
			ehMinhaVez = false; // apos jogar, nao eh mais sua vez
			System.out.println("enviou jogada");
		} catch (NaoJogandoException e) {
			this.resourceBundle = resourceBundle.getBundle("resources.ArquivoMensagens", GameLocale.locale);

			if(resourceBundle.getLocale().getCountry().equalsIgnoreCase("BR")) {
				JOptionPane.showMessageDialog(atorJogador.getTela(), e.getMessage());
			} else {
				JOptionPane.showMessageDialog(atorJogador.getTela(), resourceBundle.getString("NaoJogandoException"));
			}
		}
	}
	
	
	// metodo chamado pelo servidor
	@Override
	public void receberJogada(Jogada jogada) {
		ehMinhaVez = true; 
		System.out.println("recebeu jogada");
		atorJogador.receberJogada(jogada); 
	}
	
	public void desconectar() {
		try {
			proxy.desconectar();
		} catch (NaoConectadoException e) {
			this.resourceBundle = resourceBundle.getBundle("resources.ArquivoMensagens", GameLocale.locale);

			if(resourceBundle.getLocale().getCountry().equalsIgnoreCase("BR")) {
				JOptionPane.showMessageDialog(atorJogador.getTela(), e.getMessage());
			} else {
				JOptionPane.showMessageDialog(atorJogador.getTela(), resourceBundle.getString("NaoConectadoException"));
			}

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
	
	public void mudarIdioma() {
		this.resourceBundle = resourceBundle.getBundle("resources.ArquivoMensagens", GameLocale.locale);
	}
}
