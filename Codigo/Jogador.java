public class Jogador {

	protected String nome;
	protected Mao mao;

	public String getNome() {
		return this.nome;
	}

	public Mao getMao() {
		return this.mao;
	}

	public Carta retirarCartaAleatoria() {
		return this.mao.retirarCartaAleatoria();
	}

	/**
	 * 
	 * @param carta
	 */
	public void inserirCarta(Carta carta) {
		this.mao.inserirCarta(carta);
	}

	/**
	 * 
	 * @param posicao
	 */
	public Carta retirarCarta(int posicao) {
		return this.mao.retirarCarta(posicao);
	}
	
	public void retirarDefuse() {
		this.mao.retirarDefuse();
	}
	public boolean possuiDefuse() {
		return this.mao.possuiDefuse();
	}

}