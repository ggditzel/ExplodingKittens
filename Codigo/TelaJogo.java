import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class TelaJogo extends JPanel {
	
	protected JLabel baralho;
	protected JLabel restantes;
	protected JLabel vez;
	protected JButton comprarCarta;
	protected JButton jogarPar;
	protected JButton jogarCarta;
	protected InterfaceMao maoJogador;
	protected InterfaceMao maoOponente;
	protected EstadoMesa estado;
	protected AtorJogador atorJogador;
	
	protected ResourceBundle resourceBundle; 
	
	public TelaJogo(EstadoMesa estado, AtorJogador atorJogador) {
		this.estado = estado;
		this.atorJogador = atorJogador;
		this.resourceBundle = ResourceBundle.getBundle("resources.ArquivoMensagens", GameLocale.locale);
		config();
		this.atorJogador.setTelaJogo(this);
	}
	
	public void atualiza(EstadoMesa estado) {
		this.estado = estado;
		config();
	}
	
	private void config() {		
		
		removeAll();
		setPreferredSize (new Dimension(1100, 700));
		setLayout(null);
		
		vez = new JLabel(this.resourceBundle.getString("turnoDe") + estado.getJogadorDaVez().getNome());
		add(vez);
		vez.setBounds(380, 0, 130, 20);
		
		restantes = new JLabel(this.resourceBundle.getString("cartasRestantes") + estado.getBaralho().getCartas().size());
		add(restantes);
		restantes.setBounds(0, 350, 120, 25);
		
		baralho = new JLabel();
		add(baralho);
		baralho.setBounds(0, 200, 75, 135);
		Image iconVerso = new ImageIcon("Codigo/imagens/verso2.jpg").getImage()
				.getScaledInstance(baralho.getWidth(), baralho.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(iconVerso);
		baralho.setIcon(imageIcon);
		
		comprarCarta = new JButton(this.resourceBundle.getString("passarTurno"));
		comprarCarta.addActionListener(tratadorBotoes);
		add(comprarCarta);
		comprarCarta.setBounds(120, 250, 120, 40);
		
		jogarCarta = new JButton(this.resourceBundle.getString("jogarCarta"));
		jogarCarta.addActionListener(tratadorBotoes);
		add(jogarCarta);
		jogarCarta.setBounds(600, 200, 120, 30);
		
		jogarPar = new JButton(this.resourceBundle.getString("jogarPar"));
		jogarPar.addActionListener(tratadorBotoes);
		add(jogarPar);
		jogarPar.setBounds(600, 250, 120, 30);
		
		
//		System.out.println("estado do jogo: \n" + "mao jogador 1:");
//		for(int i = 0; i < estado.jogador1.getMao().cartas.size(); i++) {
//			System.out.println("" + i + " - " + estado.jogador1.getMao().getCarta(i).getDescricao());
//		}
//		System.out.println("jogador 2:");
//		for(int i = 0; i < estado.jogador2.getMao().cartas.size(); i++) {
//			System.out.println("" + i + " - " + estado.jogador2.getMao().getCarta(i).getDescricao());
//		}
		maoJogador = new InterfaceMao(estado.jogador1.getMao(), true);
		add(maoJogador);
		maoJogador.setBounds(10, 450, 1000, 150);
		
		maoOponente = new InterfaceMao(estado.jogador2.getMao(), false);
		add(maoOponente);
		maoOponente.setBounds(10, 50, 1000, 150);
		
	}
	
	private ActionListener tratadorBotoes = new ActionListener() {
		
		ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.ArquivoMensagens", GameLocale.locale);
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(!estado.jogadorDaVez.equals(estado.jogador1)) {
				JOptionPane.showMessageDialog(null, this.resourceBundle.getString("esperarTurno"), this.resourceBundle.getString("naoVez"), JOptionPane.PLAIN_MESSAGE);
				return;
			}
			if(e.getSource().equals(comprarCarta)) {
				atorJogador.comprarCarta();
			} else if(e.getSource().equals(jogarCarta)) {
				String posicaoCarta = JOptionPane.showInputDialog(this.resourceBundle.getString("inserirPosicaoMao"));
				try {
					int posicao = Integer.parseInt(posicaoCarta);
					atorJogador.jogarCarta(posicao);
				} catch (Exception error) {
					JOptionPane.showMessageDialog(null, this.resourceBundle.getString("inserirApenasPosicao"), this.resourceBundle.getString("PosicaoInvalida"), JOptionPane.PLAIN_MESSAGE);
				}
			} else if(e.getSource().equals(jogarPar)) {
				if(estado.jogador1.mao.possuiPar()) {
					int[] posicoes = new int[2];
					String posicao1String = JOptionPane.showInputDialog(this.resourceBundle.getString("inserirPosicaoPar"));
					String posicao2String = JOptionPane.showInputDialog(this.resourceBundle.getString("inserirPosicaoPar2"));
					
					try {
						int posicao1 = Integer.parseInt(posicao1String);
						int posicao2 = Integer.parseInt(posicao2String);
						posicoes[0] = posicao1;
						posicoes[1] = posicao2;
						atorJogador.jogarPar(posicoes);
					} catch (Exception error) {
						JOptionPane.showMessageDialog(null, this.resourceBundle.getString("inserirApenasPosicao"), this.resourceBundle.getString("PosicaoInvalida"), JOptionPane.PLAIN_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, this.resourceBundle.getString("naoTemPar"), this.resourceBundle.getString("Oops"), JOptionPane.PLAIN_MESSAGE);
				}
			}
			
		}
	};

	public void enviaMensagem(String mensagem) {
		JOptionPane.showMessageDialog(this, mensagem, this.resourceBundle.getString("Oops"), JOptionPane.PLAIN_MESSAGE);
	}

	public boolean perguntaNope(CartaEfeito cartaEfeito) {		
		if(estado.jogador1.possuiNope()) {
			int resposta = JOptionPane.showConfirmDialog (this, this.resourceBundle.getString("perguntaNOPE"),this.resourceBundle.getString("oponenteJogou") + cartaEfeito.getDescricao(), JOptionPane.YES_NO_OPTION);
			return resposta == JOptionPane.YES_OPTION;
			
		} else {
			JOptionPane.showMessageDialog(null, this.resourceBundle.getString("Voce nao possui carta NOPE"), this.resourceBundle.getString("oponenteJogou") + cartaEfeito.getDescricao(), JOptionPane.PLAIN_MESSAGE);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {}
			return false;
		}
	}

	public int[] perguntaCartasTopo(ArrayList<Carta> cartas) {
		int[] ordem = new int[cartas.size()];
		String[] stringOrdem = new String[cartas.size()];
		System.out.println("Selecione a ordem das cartas:");
		String stringCartas = "";
		for(int i = 0; i < cartas.size(); i++) {
			System.out.println(i + " - " + cartas.get(i).getDescricao());
			stringCartas += i + " - " + cartas.get(i).getDescricao() + " \n";
		}
		for(int i = 0; i < cartas.size(); i++) {
			boolean respostaOK = false;
			do{
				String posicaoString = JOptionPane.showInputDialog(this.resourceBundle.getString("cartasTopo") + stringCartas +this.resourceBundle.getString("perguntaPosicao") + i + " " + this.resourceBundle.getString("perguntaPosicao2"));
				try {
					ordem[i] = Integer.parseInt(posicaoString);
					respostaOK = true;
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, this.resourceBundle.getString("erroPosicao"), this.resourceBundle.getString("PosicaoInvalida"), JOptionPane.PLAIN_MESSAGE);
				}
			} while(!respostaOK);
		}
		return ordem;
	}

	public void mostrarCartasTopo(ArrayList<Carta> cartas) {
		String cartasTopo = "";
		for(int i = 0; i < cartas.size(); i++) {
			cartasTopo += "[" + i +"] " + cartas.get(i).getDescricao() + " \n ";
			//System.out.println("[" + i +"] " + cartas.get(i).getDescricao());
		}
		JOptionPane.showMessageDialog(null, this.resourceBundle.getString("cartasTopo") + cartasTopo, "SEE THE FUTURE", JOptionPane.PLAIN_MESSAGE);
		
	}

	public int mostrarCartasViradasBaixo(int qtdCartas) {
		String posicoes = "";
		int posicao = 0;
		System.out.println(this.resourceBundle.getString("temDefuse"));
		for(int i = 0; i < qtdCartas; i++) {
//			System.out.print(" [" + i + "] ");
			posicoes += " [" + i + "] ";
		}
		boolean respostaOK = false;
		JOptionPane.showMessageDialog(this, this.resourceBundle.getString("masTemDefuse"), this.resourceBundle.getString("comprouEK"), JOptionPane.PLAIN_MESSAGE);		
		do{
			
			String posicaoString = JOptionPane.showInputDialog(this.resourceBundle.getString("escolherPosicaoEK") + posicoes);
			try {
				posicao = Integer.parseInt(posicaoString);
				if(posicao >= qtdCartas) throw new Exception();
				respostaOK = true;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, this.resourceBundle.getString("insiraPosicao"), this.resourceBundle.getString("PosicaoInvalida"), JOptionPane.PLAIN_MESSAGE);
			}
		} while(!respostaOK); 
		return posicao;
	}

	public void acabaJogo(boolean venceu) {
		if(venceu) {
			JOptionPane.showMessageDialog(this, this.resourceBundle.getString("venceu"), this.resourceBundle.getString("fimDePartida"), JOptionPane.PLAIN_MESSAGE);		

		} else {
		JOptionPane.showMessageDialog(this, this.resourceBundle.getString("naoPossuiDefuse"), this.resourceBundle.getString("comprouEK"), JOptionPane.PLAIN_MESSAGE);		
		JOptionPane.showMessageDialog(this, this.resourceBundle.getString("perdeu"), this.resourceBundle.getString("fimDePartida"), JOptionPane.PLAIN_MESSAGE);		
	
		}
	}

	public void mudarLingua() {
		this.resourceBundle = ResourceBundle.getBundle("resources.ArquivoMensagens", GameLocale.locale);
		this.maoJogador.mudarIdioma();
		this.maoOponente.mudarIdioma();
		config();
		
	}

}

