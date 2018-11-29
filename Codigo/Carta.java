import br.ufsc.inf.leobr.cliente.Jogada;

public abstract class Carta implements Jogada{

	protected String descricao;

	public String getDescricao() {
		return this.descricao;
	}

	public abstract boolean isCartaEfeito();

}