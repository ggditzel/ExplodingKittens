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
			url = "../imagens/changeTheFuture.jpg";
			break;
		case DEFUSE:
			url = "../imagens/defuse.jpg";
			break;
		case EXPLODING_KITTEN:
			url = "../imagens/verso2.jpg";
			break;
		case FAVOR:
			url = "../imagens/favor.jpg";
			break;
		case NOPE:
			url = "../imagens/nope.jpg";
			break;
		case SEE_THE_FUTURE:
			url = "../imagens/seeTheFuture.jpg";
			break;
		case SKIP:
			url = "../imagens/skip.jpg";
			break;
		}
		return url;
	}
	

}