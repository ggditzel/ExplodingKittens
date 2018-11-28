
public class RespostaNope {
	protected boolean jogouNope;
	protected CartaEfeito cartaJogada;

	
	public RespostaNope(boolean jogouNope, CartaEfeito cartaJogada) {
		this.jogouNope = jogouNope;
		this.cartaJogada = cartaJogada;
	}
	
	public boolean getJogouNope() {
		return jogouNope;
	}
	
	public CartaEfeito getCartaJogada() {
		return this.cartaJogada;
	}
}
