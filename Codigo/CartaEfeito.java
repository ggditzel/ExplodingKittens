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

	@Override
	public String urlImagem() {
		String url = "";
		switch (efeito) {
		case CHANGE_THE_FUTURE:
			url = "changeTheFuture.jpg";
			break;
		case DEFUSE:
			url = "defuse.jpg";
			break;
		case EXPLODING_KITTEN:
			url = "verso2.jpg";
			break;
		case FAVOR:
			url = "favor.jpg";
			break;
		case NOPE:
			url = "nope.jpg";
			break;
		case SEE_THE_FUTURE:
			url = "seeTheFuture.jpg";
			break;
		case SKIP:
			url = "skip.jpg";
			break;
		}
		return url;
	}
	

}