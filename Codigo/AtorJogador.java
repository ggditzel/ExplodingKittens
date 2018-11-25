
// interface grafica do jogador
public class AtorJogador {
	
	private String nome = "Joao"; // solicitar via interface grafica
	
	private AtorNetgames atorNetgames;
	
	public AtorJogador() {
		atorNetgames = new AtorNetgames(this);
	}
	
	public AtorJogador(String nome) {
		this.nome = nome;
		atorNetgames = new AtorNetgames(this);
	}
	
	public void conectar() {
		
		// solicitar nome, depois conectar
		
		atorNetgames.conectar("localhost", "ze"); // servidor na propria maquina onde esta o jogo
		
		
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
		String nomeOutroJogador = atorNetgames.obterNomeAdversario();
		
		if (comecoJogando) {
			System.out.println("Eu ("+this.nome+") que jogo");// inserir criacao de mesa, etc
		}
	}

	public void receberJogada(Lance lance) {
		// recebe a jogada via AtorNetgames/servidor, implementar a logica
		// pode ter varios getters...
		System.out.println(lance.getMessage());
		
	}

	public void enviarJogada(Lance lance) {
		atorNetgames.enviarJogada(new Lance("Uma jogada"));
		
	}

	public void iniciarNovaPartida() {
		// TODO Auto-generated method stub
		
	}

	public void desistirPartida() {
		// TODO Auto-generated method stub
		
	}
	
}
