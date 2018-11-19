package sample.entity;

public abstract class Carta {

	public static final String CARTA_IMG_PATH = "src\\sample\\images\\";
	protected int id;
	protected int custoMana;
	protected String caminhoImagem;

	public int getId() {
		return this.id;
	}

	public int getCustoMana() {
		return this.custoMana;
	}

	public String getCaminhoImagem() {
		return this.caminhoImagem;
	}

	/**
	 * 
	 * @param id
	 * @param custoMana
	 * @param caminhoImagem
	 */
	public Carta(int id, int custoMana, String caminhoImagem) {
		// TODO - implement Carta.Carta
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idCarta
	 */
	public static <T extends sample.entity.Carta>T getCartaById(int idCarta) {
		// TODO - implement Carta.getCartaById
		throw new UnsupportedOperationException();
	}

}