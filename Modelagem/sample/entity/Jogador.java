package sample.entity;

public class Jogador {

	protected int manaMaxima;
	protected int manaAtual;
	protected int pontosDeVida;
	protected boolean phHabilitado;
	protected Heroi heroi;
	protected Carta[] mao;

	public int getManaMaxima() {
		return this.manaMaxima;
	}

	public void setManaMaxima(int manaMaxima) {
		this.manaMaxima = manaMaxima;
	}

	public int getManaAtual() {
		return this.manaAtual;
	}

	public void setManaAtual(int manaAtual) {
		this.manaAtual = manaAtual;
	}

	public int getPontosDeVida() {
		return this.pontosDeVida;
	}

	public void setPontosDeVida(int pontosDeVida) {
		this.pontosDeVida = pontosDeVida;
	}

	public boolean isPhHabilitado() {
		return this.phHabilitado;
	}

	public void setPhHabilitado(boolean phHabilitado) {
		this.phHabilitado = phHabilitado;
	}

	public Heroi getHeroi() {
		return this.heroi;
	}

	public Carta[] getMao() {
		return this.mao;
	}

	public Jogador() {
		// TODO - implement Jogador.Jogador
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idHeroi
	 */
	public void setIdHeroi(int idHeroi) {
		// TODO - implement Jogador.setIdHeroi
		throw new UnsupportedOperationException();
	}

	public int getIdHeroi() {
		// TODO - implement Jogador.getIdHeroi
		throw new UnsupportedOperationException();
	}

	public void comprarCarta() {
		// TODO - implement Jogador.comprarCarta
		throw new UnsupportedOperationException();
	}

	public void receberMoeda() {
		// TODO - implement Jogador.receberMoeda
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idPosicao
	 */
	public void removeCarta(int idPosicao) {
		// TODO - implement Jogador.removeCarta
		throw new UnsupportedOperationException();
	}

}