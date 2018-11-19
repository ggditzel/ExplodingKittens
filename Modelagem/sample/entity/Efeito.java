package sample.entity;

public class Efeito {

	public static final int DANO_HEROI_INIMIGO = 1;
	public static final int COMPRA_CARTA = 2;
	public static final int DESTROI_INIMIGOS = 3;
	public static final int GANHA_MANA = 4;
	public static final int DANO_HEROI_JOGADOR = 5;
	protected int efeitoId;
	protected int qtdEfeito;

	public int getEfeitoId() {
		return this.efeitoId;
	}

	public int getQtdEfeito() {
		return this.qtdEfeito;
	}

	/**
	 * 
	 * @param efeitoId
	 * @param qtdEfeito
	 */
	public Efeito(int efeitoId, int qtdEfeito) {
		// TODO - implement Efeito.Efeito
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param efeito
	 */
	public static void aplicarEfeito(Efeito efeito) {
		// TODO - implement Efeito.aplicarEfeito
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param efeitoId
	 * @param qtdEfeito
	 */
	public static void aplicarEfeito(int efeitoId, int qtdEfeito) {
		// TODO - implement Efeito.aplicarEfeito
		throw new UnsupportedOperationException();
	}

}