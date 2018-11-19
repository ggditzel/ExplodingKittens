public class CartaKitten extends Carta {

	protected TriboKitten tribo;

	@Override
	public boolean isCartaEfeito() {
		return false;
	}
	
	public TriboKitten getTribo() {
		return this.tribo;
	}

}