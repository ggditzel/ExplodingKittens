
// interface grafica do jogador
public class AtorJogador {
	
	private String nome = "Joao"; // solicitar via interface grafica
	
	private AtorNetgames atorNetgames;
	
	public AtorJogador() {
		super();
		atorNetgames = new AtorNetgames(this);
	}
	
	public void go() {
		
		// solicitar nome, depois conectar
		
		atorNetgames.conectar("localhost", nome); // servidor na propria maquina onde esta o jogo
		
		
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
		String nomeOutroJogador = atorNetgames.obterNomeAdversario();
		
		if (comecoJogando) {
			// inserir criacao de mesa, etc
		}
		

		
	}

	public void receberJogada(Lance lance) {
		// recebe a jogada via servidor, implementar a logica
		
	}

}
