import br.ufsc.inf.leobr.cliente.Jogada;

public class PretensaoJogarCarta implements Jogada{
	protected CartaEfeito carta;

	public PretensaoJogarCarta(CartaEfeito carta) {
		this.carta = carta;
	}
	
	public Carta getCarta() {
		return carta;
	}
	
}
