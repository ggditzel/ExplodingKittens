import javax.swing.JFrame;

import br.ufsc.inf.leobr.cliente.Jogada;

// interface grafica do jogador
public class AtorJogador {
	
	private String nome = "Joao"; // solicitar via interface grafica
	
	private AtorNetgames atorNetgames;
	protected Mesa mesa;
	protected TelaPrincipal tela;
	
	public AtorJogador() {
		atorNetgames = new AtorNetgames(this);
	}
	
	public AtorJogador(String nome) {
		this.nome = nome;
		atorNetgames = new AtorNetgames(this);
	}
	
	public AtorJogador(TelaPrincipal telaPrincipal) {
		atorNetgames = new AtorNetgames(this);
		this.tela = telaPrincipal;
	}

	public void conectar() {
		
		// solicitar nome, depois conectar
		
		String servidor = tela.obterServidor();
		String idUsuario = tela.obterIdJogador();
		
		atorNetgames.conectar(servidor, idUsuario); // servidor na propria maquina onde esta o jogo
		
		
	}
	
	public void desconectar() {
		
		atorNetgames.desconectar();

	}
	
	public boolean sair() {

		atorNetgames.desconectar();
		
		return true;
	}

	/*
	 * A tela do jogador pode solicitar o inicio da partida com o metodo "iniciar()"; esta opcao do menu vai chamar
	 * o metodo correspondente do Netgames para iniciar a partida no servidor; quando o servidor responder, o Netgames
	 * vai chamar o metodo "iniciarPartida()" para efetivamente iniciar a partida
	 */
	
	public void iniciar() {
		atorNetgames.iniciarPartida(); // quando o jogador quiser iniciar a partida, em vez de esperar solicitacao
	}
	
	public void iniciarPartida(boolean comecoJogando) { // chamado pelo AtorNetgames, apos receber solicitacao do servidor
		
		if (comecoJogando) {
			String nomeOutroJogador = atorNetgames.obterNomeAdversario();
			mesa = new Mesa(this);
			mesa.jogador1.setNome(nome);
			mesa.jogador2.setNome(nomeOutroJogador);
			System.out.println("enviei mesa");
			tela.comecaJogo(mesa.getEstadoMesa());
			enviarJogada(mesa.getEstadoInicial());
			//System.out.println("Eu ("+this.nome+") que jogo");// inserir criacao de mesa, etc
		}
	}

	public void receberJogada(Jogada lance) {
		System.out.println("deu ruim" + lance);
		if(lance instanceof EstadoInicialMesa) { //se for passado o estado inicial da mesa entao eh a criacao da mesa pro jogador 2
			mesa = new Mesa((EstadoInicialMesa) lance, this);
			tela.comecaJogo(mesa.getEstadoMesa());
			System.out.println("recebi mesa");
		} else if(lance instanceof PretensaoJogarCarta) {
			mesa.verificarNope((PretensaoJogarCarta) lance);
		} else if(lance instanceof RespostaNope) {
			mesa.jogarCarta((RespostaNope) lance);
		} else if(lance instanceof EstadoMesa) { // se for passado o estado da mesa eh para a troca de turno
			System.out.println("burro");
			mesa.mudarTurno((EstadoMesa) lance);
		}else {
			System.out.println("deu ruim" + lance);
		}
		// recebe a jogada via AtorNetgames/servidor, implementar a logica
		// pode ter varios getters...
		//System.out.println(lance.getMessage());
		
	}

	public void enviarJogada(Jogada lance) {
		atorNetgames.enviarJogada(lance);
		
	}

	public void iniciarNovaPartida() {
		atorNetgames.iniciarPartida();
		
	}

	public void desistirPartida() {
		// TODO Auto-generated method stub
		
	}
	
	public JFrame getTela() {
		return this.tela;
	}
	
}
