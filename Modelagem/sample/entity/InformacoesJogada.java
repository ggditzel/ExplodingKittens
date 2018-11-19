package sample.entity;

import br.ufsc.inf.leobr.cliente.*;

public class InformacoesJogada implements Jogada {

	protected int vidaJogador;
	protected int vidaAdversario;
	protected int[] idCartasNoCampoJogador;
	protected int[] idCartasNoCampoAdversario;
	protected int[] vidaLacaiosJogador;
	protected int[] vidaLacaiosAdversario;
	protected boolean jogoAcabou;

	public int getVidaJogador() {
		return this.vidaJogador;
	}

	public void setVidaJogador(int vidaJogador) {
		this.vidaJogador = vidaJogador;
	}

	public int getVidaAdversario() {
		return this.vidaAdversario;
	}

	public void setVidaAdversario(int vidaAdversario) {
		this.vidaAdversario = vidaAdversario;
	}

	public int[] getIdCartasNoCampoJogador() {
		return this.idCartasNoCampoJogador;
	}

	public void setIdCartasNoCampoJogador(int[] idCartasNoCampoJogador) {
		this.idCartasNoCampoJogador = idCartasNoCampoJogador;
	}

	public int[] getIdCartasNoCampoAdversario() {
		return this.idCartasNoCampoAdversario;
	}

	public void setIdCartasNoCampoAdversario(int[] idCartasNoCampoAdversario) {
		this.idCartasNoCampoAdversario = idCartasNoCampoAdversario;
	}

	public int[] getVidaLacaiosJogador() {
		return this.vidaLacaiosJogador;
	}

	public void setVidaLacaiosJogador(int[] vidaLacaiosJogador) {
		this.vidaLacaiosJogador = vidaLacaiosJogador;
	}

	public int[] getVidaLacaiosAdversario() {
		return this.vidaLacaiosAdversario;
	}

	public void setVidaLacaiosAdversario(int[] vidaLacaiosAdversario) {
		this.vidaLacaiosAdversario = vidaLacaiosAdversario;
	}

	public boolean isJogoAcabou() {
		return this.jogoAcabou;
	}

	public void setJogoAcabou(boolean jogoAcabou) {
		this.jogoAcabou = jogoAcabou;
	}

}