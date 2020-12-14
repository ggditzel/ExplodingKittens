import javax.swing.JFrame;

import br.ufsc.inf.leobr.cliente.Jogada;

public class AtorJogador {
	
	private String nome; 
	
	private AtorNetgames atorNetgames;
	protected Mesa mesa;
	protected TelaPrincipal tela;
	

	
	public AtorJogador(TelaPrincipal telaPrincipal) {
		atorNetgames = new AtorNetgames(this);
		this.tela = telaPrincipal;
	}

	public void conectar() {
		
		
		String servidor = tela.obterServidor();
		String idUsuario = tela.obterIdJogador();
		this.nome = idUsuario;
		
		atorNetgames.conectar(servidor, idUsuario); 
		
		
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
	
//	public void iniciar() {
//		atorNetgames.iniciarPartida(); // quando o jogador quiser iniciar a partida, em vez de esperar solicitacao
//	}
	
	public void iniciarPartida(boolean comecoJogando) { // chamado pelo AtorNetgames, apos receber solicitacao do servidor
		
		if (comecoJogando) {
			String nomeOutroJogador = atorNetgames.obterNomeAdversario();
			mesa = new Mesa(this);
			mesa.jogador1.setNome(nome);
			mesa.jogador2.setNome(nomeOutroJogador);
			System.out.println("enviei mesa");
			EstadoMesa estado = mesa.getEstadoMesa();
			tela.comecaJogo(estado);
			EstadoInicialMesa estadoInicial = mesa.getEstadoInicial();
			enviarJogada(estadoInicial);
			
		}
	}

	public void receberJogada(Jogada lance) {
		if(lance instanceof EstadoInicialMesa) { 
			mesa = new Mesa((EstadoInicialMesa) lance, this);
			EstadoMesa estado = mesa.getEstadoMesa();
			tela.comecaJogo(estado);
			System.out.println("recebi mesa");
		} else if(lance instanceof PretensaoJogarCarta) {
			System.out.println("chegou pretensao");
			PretensaoJogarCarta aux = (PretensaoJogarCarta) lance;
			System.out.println(aux.getCarta());
			mesa.verificarNope((PretensaoJogarCarta) lance);
		} else if(lance instanceof RespostaNope) {
			mesa.jogarCarta((RespostaNope) lance);
		} else if(lance instanceof EstadoMesa) { 
			mesa.mudarTurno((EstadoMesa) lance);
		} else if(lance instanceof JogoEncerrado){
			mesa.encerraJogo(true);
		} else {
			System.out.println("deu ruim" + lance);

		}

		
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

	public void comprarCarta() {
		mesa.comprarCarta();
		
	}
	
	public void jogarCarta(int posicao) {
		mesa.retirarCarta(posicao);
	}

	public void jogarPar(int[] posicoes) {
		mesa.jogarPar(posicoes);
		
	}

	public void setTelaJogo(TelaJogo telaJogo) {
		this.mesa.setTelaJogo(telaJogo);
		
	}
	
	public void mudarIdioma() {
		if(mesa != null) this.mesa.mudarIdioma();
	}
	
}
