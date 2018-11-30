import br.ufsc.inf.leobr.cliente.Jogada;

public class PretensaoJogarCarta implements Jogada{
	protected CartaEfeito carta;

	public PretensaoJogarCarta(CartaEfeito cartaEfeito) {
		this.carta = carta;
	}
	
	public CartaEfeito getCarta() {
		return carta;
	}
	
}