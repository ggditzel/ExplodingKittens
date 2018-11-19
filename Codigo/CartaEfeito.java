public class CartaEfeito extends Carta {

	protected EfeitoCarta efeito;

	@Override
	public boolean isCartaEfeito() {
		return true;
	}
	
	public EfeitoCarta getEfeito() {
		return this.efeito;
	}

}