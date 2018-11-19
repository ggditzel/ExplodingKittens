package sample.netgames;

public class AtorRede {

	protected br.ufsc.inf.leobr.cliente.Proxy proxy;
	/**
	 * protected final String servidor = "netgames.labsoft.ufsc.br";
	 */
	protected final String servidor = "localhost";

	public AtorRede() {
		// TODO - implement AtorRede.AtorRede
		throw new UnsupportedOperationException();
	}

	public boolean conectar() {
		// TODO - implement AtorRede.conectar
		throw new UnsupportedOperationException();
	}

	public void buscarPartida() {
		// TODO - implement AtorRede.buscarPartida
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param jogada
	 */
	public void enviaJogada(br.ufsc.inf.leobr.cliente.Jogada jogada) {
		// TODO - implement AtorRede.enviaJogada
		throw new UnsupportedOperationException();
	}

	public boolean desconectar() {
		// TODO - implement AtorRede.desconectar
		throw new UnsupportedOperationException();
	}

	public boolean finalizarPartida() {
		// TODO - implement AtorRede.finalizarPartida
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param posicao
	 */
	@Override
	public void iniciarNovaPartida(Integer posicao) {
		// TODO - implement AtorRede.iniciarNovaPartida
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param message
	 */
	@Override
	public void finalizarPartidaComErro(String message) {
		// TODO - implement AtorRede.finalizarPartidaComErro
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param msg
	 */
	@Override
	public void receberMensagem(String msg) {
		// TODO - implement AtorRede.receberMensagem
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param jogada
	 */
	@Override
	public void receberJogada(br.ufsc.inf.leobr.cliente.Jogada jogada) {
		// TODO - implement AtorRede.receberJogada
		throw new UnsupportedOperationException();
	}

	@Override
	public void tratarConexaoPerdida() {
		// TODO - implement AtorRede.tratarConexaoPerdida
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param message
	 */
	@Override
	public void tratarPartidaNaoIniciada(String message) {
		// TODO - implement AtorRede.tratarPartidaNaoIniciada
		throw new UnsupportedOperationException();
	}

}