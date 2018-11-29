import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaJogo extends JPanel {
	
	protected JLabel baralho;
	protected JLabel restantes;
	protected JButton comprarCarta;
	protected JButton jogarPar;
	protected JButton jogarCarta;
	protected InterfaceMao maoJogador;
	protected InterfaceMao maoOponente;
	protected EstadoMesa estado;
	
	public TelaJogo(EstadoMesa estado) {
		this.estado = estado;
		config();
	}
	
	protected void config() {		
		
		setPreferredSize (new Dimension(800, 700));
		setLayout(null);
		
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
		add(comprarCarta);
		comprarCarta.setBounds(120, 250, 120, 30);
		
		jogarCarta = new JButton("Jogar carta");
		add(jogarCarta);
		jogarCarta.setBounds(600, 200, 120, 30);
		
		jogarPar = new JButton("Jogar par");
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
		maoOponente.setBounds(10, 10, 600, 150);
		
	}
}
