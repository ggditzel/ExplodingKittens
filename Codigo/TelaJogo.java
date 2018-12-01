import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	public TelaJogo(EstadoMesa estado, AtorJogador atorJogador) {
		this.estado = estado;
		this.atorJogador = atorJogador;
		config();
		this.atorJogador.setTelaJogo(this);
	}
	
	public void atualiza(EstadoMesa estado) {
		this.estado = estado;
		config();
	}
	
	private void config() {		
		
		removeAll();
		setPreferredSize (new Dimension(800, 700));
		setLayout(null);
		
		vez = new JLabel("turno de " + estado.getJogadorDaVez().getNome());
		add(vez);
		vez.setBounds(380, 0, 130, 20);
		
		restantes = new JLabel("Cartas Restantes: " + estado.getBaralho().getCartas().size());
		add(restantes);
		restantes.setBounds(0, 350, 120, 25);
		
		baralho = new JLabel();
		add(baralho);
		baralho.setBounds(0, 200, 75, 135);
		Image iconVerso = new ImageIcon("imagens/verso2.jpg").getImage()
				.getScaledInstance(baralho.getWidth(), baralho.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(iconVerso);
		baralho.setIcon(imageIcon);
		
		comprarCarta = new JButton("Comprar carta");
		comprarCarta.addActionListener(tratadorBotoes);
		add(comprarCarta);
		comprarCarta.setBounds(120, 250, 120, 30);
		
		jogarCarta = new JButton("Jogar carta");
		jogarCarta.addActionListener(tratadorBotoes);
		add(jogarCarta);
		jogarCarta.setBounds(600, 200, 120, 30);
		
		jogarPar = new JButton("Jogar par");
		jogarPar.addActionListener(tratadorBotoes);
		add(jogarPar);
		jogarPar.setBounds(600, 250, 120, 30);
		
		
		System.out.println("estado do jogo: \n" + "mao jogador 1:");
		for(int i = 0; i < estado.jogador1.getMao().cartas.size(); i++) {
			System.out.println("" + i + " - " + estado.jogador1.getMao().getCarta(i).getDescricao());
		}
		System.out.println("jogador 2:");
		for(int i = 0; i < estado.jogador2.getMao().cartas.size(); i++) {
			System.out.println("" + i + " - " + estado.jogador2.getMao().getCarta(i).getDescricao());
		}
		maoJogador = new InterfaceMao(estado.jogador1.getMao(), true);
		add(maoJogador);
		maoJogador.setBounds(10, 450, 600, 150);
		
		maoOponente = new InterfaceMao(estado.jogador2.getMao(), false);
		add(maoOponente);
		maoOponente.setBounds(10, 50, 600, 150);
		
	}
	
	private ActionListener tratadorBotoes = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(!estado.jogadorDaVez.equals(estado.jogador1)) {
				JOptionPane.showMessageDialog(null, "Espere seu turno para jogar", "Nao eh sua vez", JOptionPane.PLAIN_MESSAGE);
				System.out.println("FFFFFFFFFFFFFFF");
				return;
			}
			if(e.getSource().equals(comprarCarta)) {
				atorJogador.comprarCarta();
			} else if(e.getSource().equals(jogarCarta)) {
				String posicaoCarta = JOptionPane.showInputDialog("Insira a posicao da carta na mao");
				try {
					int posicao = Integer.parseInt(posicaoCarta);
					atorJogador.jogarCarta(posicao);
				} catch (Exception error) {
					JOptionPane.showMessageDialog(null, "Insira apenas a posicao da carta", "Posicao invalida", JOptionPane.PLAIN_MESSAGE);
				}
			} else if(e.getSource().equals(jogarPar)) {
					int[] posicoes = new int[2];
					String posicao1String = JOptionPane.showInputDialog("Insira a posicao de uma carta do par na mao");
					String posicao2String = JOptionPane.showInputDialog("Insira a posicao da outra carta do par na mao");
					
					try {
						int posicao1 = Integer.parseInt(posicao1String);
						int posicao2 = Integer.parseInt(posicao2String);
						posicoes[0] = posicao1;
						posicoes[1] = posicao2;
						atorJogador.jogarPar(posicoes);
					} catch (Exception error) {
						JOptionPane.showMessageDialog(null, "Insira apenas a posicao da carta", "Posicao invalida", JOptionPane.PLAIN_MESSAGE);
					}
			}
			
		}
	};

	public void enviaMensagem(String mensagem) {
		JOptionPane.showMessageDialog(this, mensagem, "Oops!", JOptionPane.PLAIN_MESSAGE);
	}

	public boolean perguntaNope(CartaEfeito cartaEfeito) {
		System.out.println("chegou aqui");
//		JLabel b = new JLabel("seu adversario jogou:" + carta.getDescricao());
//		add(b);
//		b.setBounds(300, 180, 300, 15);
		
		if(estado.jogador1.possuiNope()) {
//			JLabel a = new JLabel("Voce deseja jogar NOPE?");
//			add(a);
//			a.setBounds(300, 200, 300, 300);
			//String nome = carta.getDescricao();
			int resposta = JOptionPane.showConfirmDialog (null, "Voce deseja jogar NOPE?","carta",JOptionPane.YES_NO_OPTION);
			return resposta == JOptionPane.YES_OPTION;
		} else {
			return false;
//			JLabel a = new JLabel("Voce nao possui carta NOPE");
//			add(a);
////			a.setBounds(300, 200, 300, 300);
//			int resposta = JOptionPane.showConfirmDialog (null, "Are you sure?","WARNING",JOptionPane.YES_NO_OPTION);
//
//			//JOptionPane.showMessageDialog(null, "Voce nao possui carta NOPE", "seu adversario jogou:" + carta.getDescricao(), JOptionPane.PLAIN_MESSAGE);
//			return resposta == JOptionPane.YES_OPTION;
		}
	}


}

