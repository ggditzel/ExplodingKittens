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
			url = "Codigo/imagens/changeTheFuture.jpg";
			break;
		case DEFUSE:
			url = "Codigo/imagens/defuse.jpg";
			break;
		case EXPLODING_KITTEN:
			url = "Codigo/imagens/verso2.jpg";
			break;
		case FAVOR:
			url = "Codigo/imagens/favor.jpg";
			break;
		case NOPE:
			url = "Codigo/imagens/nope.jpg";
			break;
		case SEE_THE_FUTURE:
			url = "Codigo/imagens/seeTheFuture.jpg";
			break;
		case SKIP:
			url = "Codigo/imagens/skip.jpg";
			break;
		}
		return url;
	}
	

}