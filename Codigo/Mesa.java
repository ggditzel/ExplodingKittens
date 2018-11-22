import java.util.ArrayList;
import java.util.Random;

public class Mesa {

	protected Jogador jogador1;
	protected Jogador jogador2;
	protected Baralho baralho;
	protected Jogador jogadorDaVez;
	protected boolean skip;
	protected TelaMesa tela;
	
	protected boolean encerrado;

	public Mesa() {
		this.encerrado = false;
		this.jogador1 = new Jogador();
		this.jogador2 = new Jogador();
		this.baralho = new Baralho();
		embaralhar();
		this.jogadorDaVez = new Random().nextDouble() >= 0.5 ? jogador1 : jogador2;
		this.skip = false;
		this.tela = new TelaMesa();
		System.out.println("mesa criada");
		perguntaNomes();
		distribuiCartas();
		realizaJogada();
	}
	


	public Mesa(Jogador jogador1, Jogador jogador2) {
		this.encerrado = false;
		this.baralho = new Baralho();
		embaralhar();
		this.skip = false;
		this.jogadorDaVez = new Random().nextDouble() >= 0.5 ? jogador1 : jogador2;
	}
	
	public Mesa(Jogador jogador1, Jogador jogador2, Jogador jogadorDaVez) {
		this.encerrado = false;
		this.baralho = new Baralho();
		embaralhar();
		this.skip = false;
		this.jogadorDaVez = jogadorDaVez;
	}
	
	public Mesa(Jogador jogador1, Jogador jogador2, Baralho baralho, Jogador jogadorDaVez, boolean skip) {
		this.encerrado = false;
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
		this.baralho = baralho;
		this.jogadorDaVez = jogadorDaVez;
		this.skip = skip;
	}



	public void roubarCartaAdversario() {
		if(jogadorDaVez.equals(jogador1)) {
			Carta carta = jogador2.retirarCartaAleatoria();
			jogador1.inserirCarta(carta);
		} else {
			Carta carta = jogador1.retirarCartaAleatoria();
			jogador2.inserirCarta(carta);
		}
		falaMaos();
	}

	public void trocaSkip() {
		this.skip = !this.skip;
	}

	public ArrayList<Carta> getCartasTopo() {
		return this.baralho.getCartasTopo();
	}

	/**
	 * 
	 * @param cartas
	 */
	public void mostrarCartasTopo(ArrayList<Carta> cartas) {
		tela.mostrarCartasTopo(cartas);
	}
	


	/**
	 * 
	 * @param cartas, int[] ordem 
	 */
	public void definirOrdemTopo(ArrayList<Carta> cartas, int[] ordem ) {
		ArrayList<Carta> cartasTopo = new ArrayList<>();
		for(int i = 0; i < ordem.length; i++) {
			cartasTopo.add(cartas.get(ordem[i]));
		}
		this.baralho.setCartasTopo(cartasTopo);
	}

	public boolean verificarNope(Carta cartaSelecionada) {
		// TODO - implement Mesa.verificarNope
		throw new UnsupportedOperationException();
	}


	public void mostrarCartasViradasBaixo() {
		// TODO - implement Mesa.mostrarCartasViradasBaixo
		throw new UnsupportedOperationException();
	}
	
	//jogar carta
	public void retirarCarta(int posicao) throws Exception {
		Carta cartaSelecionada = jogadorDaVez.retirarCarta(posicao);
		System.out.println("carta selecionada: " + cartaSelecionada.getDescricao());
		
		//if(!verificarNope(cartaSelecionada) ) {
		if(cartaSelecionada.isCartaEfeito()) {
			CartaEfeito cartaEfeito = (CartaEfeito) cartaSelecionada;
			switch (cartaEfeito.getEfeito()) {
				case CHANGE_THE_FUTURE: 
					ArrayList<Carta> cartas = getCartasTopo();
					int[] posicoes = perguntaCartasTopo(cartas);
					definirOrdemTopo(cartas, posicoes);
					break;
				case SEE_THE_FUTURE:
					ArrayList<Carta> cartasTopo = getCartasTopo();
					mostrarCartasTopo(cartasTopo);
					break;
				case FAVOR:
					roubarCartaAdversario();
					break;
				case SKIP:
					if(this.skip = true) {
						jogadorDaVez.inserirCarta(cartaSelecionada);
						throw new Exception(cartaEfeito.descricao + " ja foi jogada nesse turno");
					} else {
						this.skip = true;
						break;
					}
				default:
					jogadorDaVez.inserirCarta(cartaSelecionada);
					throw new Exception(cartaEfeito.descricao + " nao pode ser jogada em seu turno");
			}
		} else {
			jogadorDaVez.inserirCarta(cartaSelecionada);
			throw new Exception("Cartas kitten nao podem ser jogada sem ser em par");
		}
		//}
		
	}



	public void jogarDefuse() {
		System.out.println("\n \n \n \n !! comprou kitten !! \n \n \n \n");
		if(jogadorDaVez.possuiDefuse()) {
			jogadorDaVez.retirarDefuse();
			ArrayList<Carta> cartas = baralho.getCartas();
			int posicao = tela.mostrarCartasViradasBaixo(cartas.size() + 1);
			baralho.inserirExplodingKitten(posicao);
			mudarTurno();
		} else {
			encerraJogo();
		}
	}

	public void embaralhar() {
		this.baralho.embaralhar();
	}

	public void adicionarJogador() {
		// TODO - implement Mesa.adicionarJogador
		throw new UnsupportedOperationException();
	}

	public void comprarCarta() {
		if(!skip) {
			Carta carta = baralho.removeCartaTopo();
			if(carta.isCartaEfeito()) {
				CartaEfeito cartaEfeito = (CartaEfeito) carta;
				if(cartaEfeito.getEfeito() == EfeitoCarta.EXPLODING_KITTEN) {
					jogarDefuse();
					return;
				}
			}
			jogadorDaVez.inserirCarta(carta);
		} 
		mudarTurno();
	}
	



	public void encerraJogo() {
		System.out.println("fim de jogo");
		this.encerrado = true;
	}
	
	public void mostrarDescricaoCarta(int posicao, Jogador jogador) {
		String descricao = jogador.getMao().getCarta(posicao).getDescricao();
		tela.mostrarAjuda(descricao);
	}
	
	public int[] perguntaCartasTopo(ArrayList<Carta> cartas) {
		return tela.perguntaCartasTopo(cartas);
	}
	
	public void distribuiCartas() {
		CartaEfeito explodingKitten = baralho.removeExpoddingKitten();
		CartaEfeito defuse1 = baralho.removeDefuse();
		CartaEfeito defuse2 = baralho.removeDefuse();
		for(int i = 0; i < 7; i++) {
			jogador1.inserirCarta(baralho.removeCartaTopo());
			jogador2.inserirCarta(baralho.removeCartaTopo());
		}
		jogador1.inserirCarta(defuse1);
		jogador2.inserirCarta(defuse2);
		baralho.inserir(explodingKitten);
		embaralhar();
		falaMaos();
	}


	public void realizaJogada() {
		while(!encerrado) {
			int jogada = -1;
			while(true) {
				jogada = tela.perguntaJogada(jogadorDaVez);
				if(jogada != jogadorDaVez.getMao().cartas.size() && jogada != jogadorDaVez.getMao().cartas.size() + 1) {
					try  {
						retirarCarta(jogada);
					} catch(Exception e) {
						System.out.println(e.getMessage());
					}
				} else if(jogada == jogadorDaVez.getMao().cartas.size() && jogadorDaVez.possuiPar()){
					try  {
						jogarPar();
					} catch(Exception e) {
						System.out.println(e.getMessage());
					}
				} else {
					comprarCarta();
					break;
				}
			}
		}
	}


	public void mudarTurno() {
		jogadorDaVez = jogadorDaVez.equals(jogador1) ? jogador2 : jogador1;
		this.skip = false;
	}


	public void jogarPar() throws Exception {
		int[] posicoes = tela.perguntaPar();
		jogadorDaVez.getMao().retirarCartas(posicoes[0], posicoes[1]);
		roubarCartaAdversario();
	}
	



	//---------------------------------------------------------------------------------------------------------------------------------------
	private void perguntaNomes() {
		this.jogador1.setNome(tela.perguntaNomeJogador());
		this.jogador2.setNome(tela.perguntaNomeJogador());
		System.out.println("o jogador que comeca sera: " + jogadorDaVez.getNome());
	}

	private void falaMaos() {
		tela.falaMao(jogador1);
		tela.falaMao(jogador2);
	}



}