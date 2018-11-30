import br.ufsc.inf.leobr.cliente.Jogada;

public class Jogador implements Jogada{

	protected String nome;
	protected Mao mao;

	public Jogador() {
		this.mao = new Mao();
	}
	
	public Jogador(String nome) {
		this.mao = new Mao();
		this.nome = nome;
	}
	
	public Jogador(String nome, Mao mao) {
		this.mao = mao;
		this.nome = nome;
	}
	
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}

	public Mao getMao() {
		return this.mao;
	}

	public Carta retirarCartaAleatoria() {
		return this.mao.retirarCartaAleatoria();
	}

	/**
	 * 
	 * @param carta
	 */
	public void inserirCarta(Carta carta) {
		this.mao.inserirCarta(carta);
	}

	/**
	 * 
	 * @param posicao
	 */
	public Carta retirarCarta(int posicao) {
		return this.mao.retirarCarta(posicao);
	}
	
	public void retirarDefuse() {
		this.mao.retirarDefuse();
	}
	public boolean possuiDefuse() {
		return this.mao.possuiDefuse();
	}
	
	public boolean possuiPar() {
		return this.mao.possuiPar();
	}

	public boolean possuiNope() {
		return this.mao.possuiNope();
	}
	public void retirarNope() {
		this.mao.retirarNope();
		
	}

}