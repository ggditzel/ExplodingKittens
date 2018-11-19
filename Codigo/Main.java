import javafx.application.*;
import sample.netgames.*;
import sample.entity.*;

public class Main extends Application {

	protected Stage stage;
	protected boolean procurou;
	protected Tabuleiro tabuleiro;
	protected boolean ganhou;
	protected int idPosicaoCartaMostrada;
	protected boolean acabou;
	protected boolean botoesCartaDisponiveis;
	private static Main instance;
	protected AtorRede atorRede;
	protected Tabuleiro tabuleiro2;
	protected Carta cartaMostrada;
	private static final String APP_TITLE = "HEARTHSTONE";
	private static final String ID_BOTAO_CONFIRMAR = "#confirmar_button";
	private static final String ID_BOTAO_CANCELAR = "#cancelar_button";
	private static final String ID_CARTA_SELECIONADA = "#carta_mostrada";
	private static final String ID_VIDA_HEROI_JOGADOR = "#vida_heroi_jogador";
	private static final String ID_VIDA_HEROI_ADVERSARIO = "#vida_heroi_adversario";
	private static final String ID_VIDA_CARTA_JOGADOR_1 = "#vida_carta_jogador_1";
	private static final String ID_VIDA_CARTA_JOGADOR_2 = "#vida_carta_jogador_2";
	private static final String ID_VIDA_CARTA_JOGADOR_3 = "#vida_carta_jogador_3";
	private static final String ID_VIDA_CARTA_JOGADOR_4 = "#vida_carta_jogador_4";
	private static final String ID_VIDA_CARTA_JOGADOR_5 = "#vida_carta_jogador_5";
	private static final String ID_VIDA_CARTA_ADVERSARIO_1 = "#vida_carta_adversario_1";
	private static final String ID_VIDA_CARTA_ADVERSARIO_2 = "#vida_carta_adversario_2";
	private static final String ID_VIDA_CARTA_ADVERSARIO_3 = "#vida_carta_adversario_3";
	private static final String ID_VIDA_CARTA_ADVERSARIO_4 = "#vida_carta_adversario_4";
	private static final String ID_VIDA_CARTA_ADVERSARIO_5 = "#vida_carta_adversario_5";
	private static final String ID_CARTA_1 = "#carta_1";
	private static final String ID_CARTA_2 = "#carta_2";
	private static final String ID_CARTA_3 = "#carta_3";
	private static final String ID_CARTA_4 = "#carta_4";
	private static final String ID_CARTA_5 = "#carta_5";
	private static final String ID_CARTA_6 = "#carta_6";
	private static final String ID_CARTA_MESA_JOGADOR_1 = "#carta_mesa_jogador_1";
	private static final String ID_CARTA_MESA_JOGADOR_2 = "#carta_mesa_jogador_2";
	private static final String ID_CARTA_MESA_JOGADOR_3 = "#carta_mesa_jogador_3";
	private static final String ID_CARTA_MESA_JOGADOR_4 = "#carta_mesa_jogador_4";
	private static final String ID_CARTA_MESA_JOGADOR_5 = "#carta_mesa_jogador_5";
	private static final String ID_CARTA_MESA_ADVERSARIO_1 = "#carta_mesa_adversario_1";
	private static final String ID_CARTA_MESA_ADVERSARIO_2 = "#carta_mesa_adversario_2";
	private static final String ID_CARTA_MESA_ADVERSARIO_3 = "#carta_mesa_adversario_3";
	private static final String ID_CARTA_MESA_ADVERSARIO_4 = "#carta_mesa_adversario_4";
	private static final String ID_CARTA_MESA_ADVERSARIO_5 = "#carta_mesa_adversario_5";
	private static final String ID_HEROI_JOGADOR = "#heroi_jogador";
	private static final String ID_HEROI_ADVERSARIO = "#heroi_adversario";
	private static final String ID_PH_JOGADOR = "#ph_jogador";
	private static final String ID_PH_ADVERSARIO = "#ph_adversario";
	private static final String ID_MANA_JOGADOR = "#mana_jogador";
	public static final String GANHOU_FXML = "ganhou.fxml";
	public static final String PERDEU_FXML = "perdeu.fxml";
	public static final String TELA_INICIAL_FXML = "tela_inicial.fxml";
	public static final String TELA_SELECAO_FXML = "tela_selecao.fxml";
	public static final String TELA_JOGO_FXML = "tela_jogo.fxml";
	protected boolean botoesGeraisDisponiveis = false;
	protected boolean callbackFeito = false;
	protected int posicaoMaoCartaMostrada;
	protected Integer mIdHeroijogador;
	private boolean desconectado = true;

	public Main getInstance() {
		return this.instance;
	}

	public Tabuleiro getTabuleiro2() {
		return this.tabuleiro2;
	}

	/**
	 * 
	 * @param idPosicaoMao
	 */
	public void abrirCarta(int idPosicaoMao) {
		// TODO - implement Main.abrirCarta
		throw new UnsupportedOperationException();
	}

	public void atualizaManaJogador() {
		// TODO - implement Main.atualizaManaJogador
		throw new UnsupportedOperationException();
	}

	public void atualizaMaoJogador() {
		// TODO - implement Main.atualizaMaoJogador
		throw new UnsupportedOperationException();
	}

	public void atualizaMesaAdversario() {
		// TODO - implement Main.atualizaMesaAdversario
		throw new UnsupportedOperationException();
	}

	public void atualizaMesaJogador() {
		// TODO - implement Main.atualizaMesaJogador
		throw new UnsupportedOperationException();
	}

	private void atualizarTelaJogoPrimeiraVez() {
		// TODO - implement Main.atualizarTelaJogoPrimeiraVez
		throw new UnsupportedOperationException();
	}

	public void atualizaTelaJogo() {
		// TODO - implement Main.atualizaTelaJogo
		throw new UnsupportedOperationException();
	}

	public void atualizaVidaJogadores() {
		// TODO - implement Main.atualizaVidaJogadores
		throw new UnsupportedOperationException();
	}

	public void cancelarCartaMostrada() {
		// TODO - implement Main.cancelarCartaMostrada
		throw new UnsupportedOperationException();
	}

	public boolean conectar() {
		// TODO - implement Main.conectar
		throw new UnsupportedOperationException();
	}

	public void desabilitarBotoes() {
		// TODO - implement Main.desabilitarBotoes
		throw new UnsupportedOperationException();
	}

	public void enviarJogada() throws Exception {
		// TODO - implement Main.enviarJogada
		throw new UnsupportedOperationException();
	}

	private void finalizaJogo() {
		// TODO - implement Main.finalizaJogo
		throw new UnsupportedOperationException();
	}

	public void finalizarComErro() {
		// TODO - implement Main.finalizarComErro
		throw new UnsupportedOperationException();
	}

	public void finalizarTurno() throws Exception {
		// TODO - implement Main.finalizarTurno
		throw new UnsupportedOperationException();
	}

	public Tabuleiro getTabuleiro() {
		return this.tabuleiro;
	}

	private void goToTelaGanhou() {
		// TODO - implement Main.goToTelaGanhou
		throw new UnsupportedOperationException();
	}

	public void goToTelaInicial() throws Exception {
		// TODO - implement Main.goToTelaInicial
		throw new UnsupportedOperationException();
	}

	public void goToTelaJogo() throws Exception {
		// TODO - implement Main.goToTelaJogo
		throw new UnsupportedOperationException();
	}

	private void goToTelaPerdeu() {
		// TODO - implement Main.goToTelaPerdeu
		throw new UnsupportedOperationException();
	}

	public void goToTelaSelecao() throws Exception {
		// TODO - implement Main.goToTelaSelecao
		throw new UnsupportedOperationException();
	}

	public void habilitarBotoes() {
		// TODO - implement Main.habilitarBotoes
		throw new UnsupportedOperationException();
	}

	public void hideBotoesCarta() {
		// TODO - implement Main.hideBotoesCarta
		throw new UnsupportedOperationException();
	}

	public void hideCartaAndBotoesCarta() {
		// TODO - implement Main.hideCartaAndBotoesCarta
		throw new UnsupportedOperationException();
	}

	public void partidaNaoEncontrada() {
		// TODO - implement Main.partidaNaoEncontrada
		throw new UnsupportedOperationException();
	}

	public void prepararInicioTurno() {
		// TODO - implement Main.prepararInicioTurno
		throw new UnsupportedOperationException();
	}

	public void prepararMaosPrimeiroTurno() throws Exception {
		// TODO - implement Main.prepararMaosPrimeiroTurno
		throw new UnsupportedOperationException();
	}

	public void procurarPartida() {
		// TODO - implement Main.procurarPartida
		throw new UnsupportedOperationException();
	}

	public void promoverAtaques() throws Exception {
		// TODO - implement Main.promoverAtaques
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param mIdHeroiSelecionado
	 */
	public void recebeIdHeroi(Integer mIdHeroiSelecionado) {
		// TODO - implement Main.recebeIdHeroi
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param jogada
	 */
	public void receberJogada(Jogada jogada) {
		// TODO - implement Main.receberJogada
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param jogada
	 */
	public void receberJogada(br.ufsc.inf.leobr.cliente.Jogada jogada) throws Exception {
		// TODO - implement Main.receberJogada
		throw new UnsupportedOperationException();
	}

	public void receberSolicitacaoInicio() {
		// TODO - implement Main.receberSolicitacaoInicio
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param fxml
	 */
	private javafx.scene.Parent replaceSceneContent(String fxml) throws Exception {
		// TODO - implement Main.replaceSceneContent
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	private void setImgGone(String id) {
		// TODO - implement Main.setImgGone
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	private void setImgVisible(String id) {
		// TODO - implement Main.setImgVisible
		throw new UnsupportedOperationException();
	}

	public void showBotoesCarta() {
		// TODO - implement Main.showBotoesCarta
		throw new UnsupportedOperationException();
	}

	public void showResultadoJogo() {
		// TODO - implement Main.showResultadoJogo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param primaryStage
	 */
	@Override
	public void start(javafx.stage.Stage primaryStage) throws Exception {
		// TODO - implement Main.start
		throw new UnsupportedOperationException();
	}

	public void usarCartaMostrada() {
		// TODO - implement Main.usarCartaMostrada
		throw new UnsupportedOperationException();
	}

	public void usarPoderHeroico() {
		// TODO - implement Main.usarPoderHeroico
		throw new UnsupportedOperationException();
	}

	public void verificaFimJogo() {
		// TODO - implement Main.verificaFimJogo
		throw new UnsupportedOperationException();
	}

	public Tabuleiro getTabuleiro() {
		return this.tabuleiro;
	}

}