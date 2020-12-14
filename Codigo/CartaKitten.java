public class CartaKitten extends Carta {

	protected TriboKitten tribo;

	public CartaKitten(TriboKitten tribo) {
		this.tribo = tribo;
		descricao = tribo.toString();
	}
	
	@Override
	public boolean isCartaEfeito() {
		return false;
	}
	
	public TriboKitten getTribo() {
		return this.tribo;
	}

	@Override
	public String urlImagem() {
		String url = "";
		switch(tribo) {
		case KITTEN_GARFIELD:
			url = "Garfield.jpg";
			break;
		case KITTEN_MEOW:
			url = "meow.jpg";
			break;
		case KITTEN_PUSS_IN_BOOTS:
			url = "gatoDeBotas.jpg";
			break;
		case KITTEN_SYLVESTER:
			url = "frajola.jpg";
			break;
		}
		return url;
	}

}