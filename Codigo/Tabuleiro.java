public class Tabuleiro {

	protected Jogador2 jogador1;
	protected Jogador2 jogador2;
	protected boolean partidaEmAndamento;
	protected int ultimaPosClicJogador1;
	protected int ultimoMovimento;
	protected AtorJogador jogador;
	protected boolean reiniciado;

	public Tabuleiro() {
		// TODO - implement Tabuleiro.Tabuleiro
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idJogador
	 * @param adversario
	 * @param posicao
	 */
	public void criarJogadores(String idJogador, String adversario, int posicao) {
		// TODO - implement Tabuleiro.criarJogadores
		throw new UnsupportedOperationException();
	}

	public boolean informaSePartidaEmAndamento() {
		// TODO - implement Tabuleiro.informaSePartidaEmAndamento
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param posicaoClicada
	 * @param tipoMovimento
	 */
	public void realizaJogada(int posicaoClicada, int tipoMovimento) {
		// TODO - implement Tabuleiro.realizaJogada
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param tipoMovimento
	 * @param posicaoClicada
	 */
	public void verificaMovimentoPosicao(int tipoMovimento, int posicaoClicada) {
		// TODO - implement Tabuleiro.verificaMovimentoPosicao
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param posicaoClicada
	 * @param posicaoAtual
	 * @param tipoMovimento
	 */
	public void calcularDistancia(int posicaoClicada, int posicaoAtual, int tipoMovimento) {
		// TODO - implement Tabuleiro.calcularDistancia
		throw new UnsupportedOperationException();
	}

	public Jogador2 getJogador1() {
		return this.jogador1;
	}

	/**
	 * 
	 * @param jogador
	 */
	public void setJogador1(Jogador2 jogador) {
		this.jogador1 = jogador;
	}

	public Jogador2 getJogador2() {
		return this.jogador2;
	}

	/**
	 * 
	 * @param jogador
	 */
	public void setJogador2(Jogador2 jogador) {
		this.jogador2 = jogador;
	}

	public boolean isPartidaEmAndamento() {
		return this.partidaEmAndamento;
	}

	/**
	 * 
	 * @param partidaEmAndamento
	 */
	public void setPartidaEmAndamento(int partidaEmAndamento) {
		// TODO - implement Tabuleiro.setPartidaEmAndamento
		throw new UnsupportedOperationException();
	}

	public int getUltimaPosClicJogador1() {
		return this.ultimaPosClicJogador1;
	}

	/**
	 * 
	 * @param UltimaPosClicJogador1
	 */
	public void setUltimaPosClicJogador1(int UltimaPosClicJogador1) {
		this.ultimaPosClicJogador1 = UltimaPosClicJogador1;
	}

	public int getUltimoMovimento() {
		return this.ultimoMovimento;
	}

	/**
	 * 
	 * @param UltimoMovimento
	 */
	public void setUltimoMovimento(int UltimoMovimento) {
		this.ultimoMovimento = UltimoMovimento;
	}

	public boolean isReiniciado() {
		return this.reiniciado;
	}

	/**
	 * 
	 * @param reiniciado
	 */
	public void setReiniciado(boolean reiniciado) {
		this.reiniciado = reiniciado;
	}

}