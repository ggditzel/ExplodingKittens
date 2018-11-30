import java.awt.Dimension;

import javax.swing.JFrame;

public class TelaConfirmacaoNope extends JFrame {
	
	public TelaConfirmacaoNope(boolean possuiNope, String descricaoCarta) {
		super("Seu oponente jogou " + descricaoCarta);
		setPreferredSize(new Dimension(200, 100));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		setLocationRelativeTo(null);
		
		setVisible(true);
	}
}
