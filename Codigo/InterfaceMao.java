import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InterfaceMao extends JPanel{
	
	protected ResourceBundle resourceBundle;

	public InterfaceMao(Mao mao, boolean jogadorPrincipal) {
		
		this.resourceBundle = resourceBundle.getBundle("resources.ArquivoMensagens", GameLocale.locale);
		
		setPreferredSize (new Dimension(1000, 150));
		setLayout(null);
		
		if(jogadorPrincipal) {
			for(int i = 0; i < mao.cartas.size(); i++) {
				JLabel carta = new JLabel();
				add(carta);
				carta.setBounds(0 + (i * 60), 20, 50, 85);
				Image iconVerso = new ImageIcon(this.resourceBundle.getString("prefixoImagens") + mao.getCarta(i).urlImagem()).getImage()
						.getScaledInstance(carta.getWidth(), carta.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imageIcon = new ImageIcon(iconVerso);
				carta.setIcon(imageIcon);
				
				JLabel posicao = new JLabel(""+ i);
				add(posicao);
				posicao.setBounds(18 + (i * 60), 0, 20, 15);
				
//				JLabel descricao = new JLabel(mao.getCarta(i).getDescricao());
//				add(descricao);
//				descricao.setBounds(0 + (i * 60), 90, 50, 40);
				
				JTextArea descricao = new JTextArea(mao.getCarta(i).getDescricao());  
				descricao.setEditable(false);  
				descricao.setLineWrap(true);  
				descricao.setWrapStyleWord(true);
				descricao.setBounds(0 + (i * 60), 110, 50, 60);
				descricao.setFont(new Font("Times New Roman", Font.BOLD, 10));
				add(descricao);
				
			}
		} else {
			for(int i = 0; i < mao.cartas.size(); i++) {
				JLabel versoCarta = new JLabel();
				add(versoCarta);
				versoCarta.setBounds(0 + (i * 60), 0, 50, 85);
				Image iconVerso = new ImageIcon("Codigo/imagens/verso2.jpg").getImage()
						.getScaledInstance(versoCarta.getWidth(), versoCarta.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imageIcon = new ImageIcon(iconVerso);
				versoCarta.setIcon(imageIcon);
			}
		}
	}
	
	public void mudarIdioma() {
		this.resourceBundle = resourceBundle.getBundle("resources.ArquivoMensagens", GameLocale.locale);
	}

}
