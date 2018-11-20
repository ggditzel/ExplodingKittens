import java.util.ArrayList;
import java.util.Random;

public class Mesa {

	protected Jogador jogador1;
	protected Jogador jogador2;
	protected Baralho baralho;
	protected Jogador jogadorDaVez;
	protected boolean skip;
	protected TelaMesa tela;

	public Mesa() {
		this.jogador1 = new Jogador();
		this.jogador2 = new Jogador();
		this.baralho = new Baralho();
		embaralhar();
		this.jogadorDaVez = new Random().nextDouble() >= 0.5 ? jogador1 : jogador2;
		this.skip = false;
	}
	
	public Mesa(Jogador jogador1, Jogador jogador2) {
		this.baralho = new Baralho();
		embaralhar();
		this.skip = false;
		this.jogadorDaVez = new Random().nextDouble() >= 0.5 ? jogador1 : jogador2;
	}
	
	public Mesa(Jogador jogador1, Jogador jogador2, Jogador jogadorDaVez) {
		this.baralho = new Baralho();
		embaralhar();
		this.skip = false;
		this.jogadorDaVez = jogadorDaVez;
	}
	
	public Mesa(Jogador jogador1, Jogador jogador2, Baralho baralho, Jogador jogadorDaVez, boolean skip) {
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

	public void desativarExplpodingKitten() {
		// TODO - implement Mesa.desativarExplpodingKitten
		throw new UnsupportedOperationException();
	}

	public void mostrarCartasViradasBaixo() {
		// TODO - implement Mesa.mostrarCartasViradasBaixo
		throw new UnsupportedOperationException();
	}
	
	//jogar carta
	public void retirarCarta(int posicao) {
		Carta cartaSelecionada = jogadorDaVez.retirarCarta(posicao);
		
		if(!verificarNope(cartaSelecionada) ) {
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
					this.skip = true;
					break;
			}
		}
		
	}



	public void jogarDefuse() {
		if(jogadorDaVez.possuiDefuse()) {
			jogadorDaVez.retirarDefuse();
			ArrayList<Carta> cartas = baralho.getCartas();
			int posicao = tela.mostrarCartasViradasBaixo(cartas.size());
			baralho.inserirDefuse(posicao);
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
		} else {
			this.skip = !this.skip;
		}
	}
	
	public void encerraJogo() {
		System.out.println("fim de jogo");
	}
	
	public void mostrarDescricaoCarta(int posicao, Jogador jogador) {
		String descricao = jogador.getMao().getCarta(posicao).getDescricao();
		tela.mostrarAjuda(descricao);
	}
	
	public int[] perguntaCartasTopo(ArrayList<Carta> cartas) {
		return tela.perguntaCartasTopo(cartas);
	}

}