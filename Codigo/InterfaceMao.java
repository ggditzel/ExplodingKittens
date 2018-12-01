import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InterfaceMao extends JPanel{

	public InterfaceMao(Mao mao, boolean jogadorPrincipal) {
		setPreferredSize (new Dimension(700, 150));
		setLayout(null);
		
		if(jogadorPrincipal) {
			for(int i = 0; i < mao.cartas.size(); i++) {
				JLabel carta = new JLabel();
				add(carta);
				carta.setBounds(0 + (i * 60), 20, 50, 85);
				Image iconVerso = new ImageIcon(mao.getCarta(i).urlImagem()).getImage()
						.getScaledInstance(carta.getWidth(), carta.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imageIcon = new ImageIcon(iconVerso);
				carta.setIcon(imageIcon);
				
				JLabel posicao = new JLabel(""+ i);
				add(posicao);
				posicao.setBounds(18 + (i * 60), 0, 20, 15);
				
				JLabel descricao = new JLabel(mao.getCarta(i).getDescricao());
				add(descricao);
				descricao.setBounds(0 + (i * 60), 90, 50, 40);
				
			}
		} else {
			for(int i = 0; i < mao.cartas.size(); i++) {
				JLabel versoCarta = new JLabel();
				add(versoCarta);
				versoCarta.setBounds(0 + (i * 60), 0, 50, 85);
				Image iconVerso = new ImageIcon("imagens/verso2.jpg").getImage()
						.getScaledInstance(versoCarta.getWidth(), versoCarta.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imageIcon = new ImageIcon(iconVerso);
				versoCarta.setIcon(imageIcon);
			}
		}
	}

}
