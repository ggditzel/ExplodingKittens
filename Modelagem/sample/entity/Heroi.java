package sample.entity;

public class Heroi {

	protected int id;
	protected String caminhoImg;
	protected PoderHeroico poderHeroico;
	protected Baralho baralho;

	public int getId() {
		return this.id;
	}

	public String getCaminhoImg() {
		return this.caminhoImg;
	}

	public PoderHeroico getPoderHeroico() {
		return this.poderHeroico;
	}

	public Baralho getBaralho() {
		return this.baralho;
	}

	/**
	 * 
	 * @param id
	 * @param poderHeroico
	 * @param baralho
	 * @param caminhoImg
	 */
	public Heroi(int id, PoderHeroico poderHeroico, Baralho baralho, String caminhoImg) {
		// TODO - implement Heroi.Heroi
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idHeroi
	 */
	public static Heroi getHeroiById(int idHeroi) {
		// TODO - implement Heroi.getHeroiById
		throw new UnsupportedOperationException();
	}

}