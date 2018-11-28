import br.ufsc.inf.leobr.cliente.Jogada;

// interface grafica do jogador
public class AtorJogador {
	
	private String nome = "Joao"; // solicitar via interface grafica
	
	private AtorNetgames atorNetgames;
	protected Mesa mesa;
	
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
		
		if (comecoJogando) {
			String nomeOutroJogador = atorNetgames.obterNomeAdversario();
			mesa = new Mesa();
			mesa.jogador1.setNome(nome);
			mesa.jogador2.setNome(nomeOutroJogador);
			enviarJogada(mesa.getEstadoMesa());
			System.out.println("Eu ("+this.nome+") que jogo");// inserir criacao de mesa, etc
		} else {
			
		}
	}

	public void receberJogada(Jogada lance) {
		if(lance instanceof EstadoMesa) { //se for passado apenas o estado da mesa entao eh a criacao da mesa pro jogador 2
			mesa = new Mesa((EstadoMesa) lance);
		}
		// recebe a jogada via AtorNetgames/servidor, implementar a logica
		// pode ter varios getters...
		//System.out.println(lance.getMessage());
		
	}

	public void enviarJogada(Jogada lance) {
		atorNetgames.enviarJogada(lance);
		
	}

	public void iniciarNovaPartida() {
		// TODO Auto-generated method stub
		
	}

	public void desistirPartida() {
		// TODO Auto-generated method stub
		
	}
	
}
