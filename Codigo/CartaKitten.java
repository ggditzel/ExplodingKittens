public class CartaKitten extends Carta {

	protected TriboKitten tribo;

	public CartaKitten(TriboKitten tribo) {
		this.tribo = tribo;
	}
	
	@Override
	public boolean isCartaEfeito() {
		return false;
	}
	
	public TriboKitten getTribo() {
		return this.tribo;
	}

}