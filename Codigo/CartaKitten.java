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
			url = "Codigo/imagens/Garfield.jpg";
			break;
		case KITTEN_MEOW:
			url = "Codigo/imagens/meow.png";
			break;
		case KITTEN_PUSS_IN_BOOTS:
			url = "Codigo/imagens/gatoDeBotas.jpg";
			break;
		case KITTEN_SYLVESTER:
			url = "Codigo/imagens/frajola.jpg";
			break;
		}
		return url;
	}

}