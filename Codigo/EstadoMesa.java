import br.ufsc.inf.leobr.cliente.Jogada;

public class EstadoMesa implements Jogada{
	protected Jogador jogador1;
	protected Jogador jogador2;
	protected Baralho baralho;
	protected Jogador jogadorDaVez;
	protected boolean skip;
	
	public EstadoMesa(Jogador jogador1, Jogador jogador2, Baralho baralho, Jogador jogadorDaVez, boolean skip) {
		super();
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
		this.baralho = baralho;
		this.jogadorDaVez = jogadorDaVez;
		this.skip = skip;
	}
	
	public Jogador getJogador1() {
		return jogador1;
	}
	public Jogador getJogador2() {
		return jogador2;
	}
	public Baralho getBaralho() {
		return baralho;
	}
	public Jogador getJogadorDaVez() {
		return jogadorDaVez;
	}
	public boolean isSkip() {
		return skip;
	}
	
	
}
