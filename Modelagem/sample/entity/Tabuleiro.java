package sample.entity;

public class Tabuleiro {

	protected Jogador jogador;
	protected Jogador adversario;
	protected CartaLacaio[] cartaPosicoesJogador;
	protected CartaLacaio[] cartaPosicoesAdversario;

	public Jogador getJogador() {
		return this.jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public Jogador getAdversario() {
		return this.adversario;
	}

	public void setAdversario(Jogador adversario) {
		this.adversario = adversario;
	}

	public CartaLacaio[] getCartaPosicoesJogador() {
		return this.cartaPosicoesJogador;
	}

	public void setCartaPosicoesJogador(CartaLacaio[] cartaPosicoesJogador) {
		this.cartaPosicoesJogador = cartaPosicoesJogador;
	}

	public CartaLacaio[] getCartaPosicoesAdversario() {
		return this.cartaPosicoesAdversario;
	}

	public void setCartaPosicoesAdversario(CartaLacaio[] cartaPosicoesAdversario) {
		this.cartaPosicoesAdversario = cartaPosicoesAdversario;
	}

	public Tabuleiro() {
		// TODO - implement Tabuleiro.Tabuleiro
		throw new UnsupportedOperationException();
	}

	public Integer[] getIdCartaPosicoesJogador1() {
		// TODO - implement Tabuleiro.getIdCartaPosicoesJogador1
		throw new UnsupportedOperationException();
	}

	public Integer[] getIdCartaPosicoesJogador2() {
		// TODO - implement Tabuleiro.getIdCartaPosicoesJogador2
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param arrayLacaios
	 */
	private Integer[] getIdCartas(CartaLacaio[] arrayLacaios) {
		// TODO - implement Tabuleiro.getIdCartas
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idCartas
	 */
	public void setIdCartaPosicoesJogador(Integer[] idCartas) {
		// TODO - implement Tabuleiro.setIdCartaPosicoesJogador
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idCartas
	 */
	public void setIdCartaPosicoesAdversario(Integer[] idCartas) {
		// TODO - implement Tabuleiro.setIdCartaPosicoesAdversario
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idCartas
	 * @param cartas
	 */
	private void setIdCartas(Integer[] idCartas, CartaLacaio[] cartas) {
		// TODO - implement Tabuleiro.setIdCartas
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param cartalacaio
	 */
	public boolean adicionaLacaio(CartaLacaio cartalacaio) {
		// TODO - implement Tabuleiro.adicionaLacaio
		throw new UnsupportedOperationException();
	}

	public void destruirLacaiosInimigos() {
		// TODO - implement Tabuleiro.destruirLacaiosInimigos
		throw new UnsupportedOperationException();
	}

	public void promoverAtaques() {
		// TODO - implement Tabuleiro.promoverAtaques
		throw new UnsupportedOperationException();
	}

	public Integer[] getVidaLacaiosJogador() {
		// TODO - implement Tabuleiro.getVidaLacaiosJogador
		throw new UnsupportedOperationException();
	}

	public Integer[] getVidaLacaiosAdversario() {
		// TODO - implement Tabuleiro.getVidaLacaiosAdversario
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param cartas
	 */
	private Integer[] getVidaCartas(CartaLacaio[] cartas) {
		// TODO - implement Tabuleiro.getVidaCartas
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param vidaLacaiosJogador
	 */
	public void setVidaLacaiosJogador(Integer[] vidaLacaiosJogador) {
		// TODO - implement Tabuleiro.setVidaLacaiosJogador
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param vidaLacaiosAdversario
	 */
	public void setVidaLacaiosAdversario(Integer[] vidaLacaiosAdversario) {
		// TODO - implement Tabuleiro.setVidaLacaiosAdversario
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param vidas
	 * @param cartas
	 */
	private void setVidaCartas(Integer[] vidas, CartaLacaio[] cartas) {
		// TODO - implement Tabuleiro.setVidaCartas
		throw new UnsupportedOperationException();
	}

}