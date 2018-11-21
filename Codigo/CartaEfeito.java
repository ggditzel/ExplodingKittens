public class CartaEfeito extends Carta {

	protected EfeitoCarta efeito;

	public CartaEfeito(EfeitoCarta efeito) {
		this.efeito = efeito;
		super.descricao = efeito.toString();
	}
	
	@Override
	public boolean isCartaEfeito() {
		return true;
	}
	
	public EfeitoCarta getEfeito() {
		return this.efeito;
	}

}