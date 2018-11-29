
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


public class TelaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	
	protected AtorJogador atorJogador;
	protected JMenuBar barraDeMenu;
	protected JMenu menu;
	protected JMenu conexao;
	protected JMenuItem conectarServidor;
	protected JMenuItem alterarServidor;
	protected JMenuItem desconectar;
	protected JMenu partida;
	protected JMenuItem iniciarNovaPartida;
	protected JMenuItem desistirDaPartida;
	protected JMenuItem sair;
	protected JMenuItem ajuda;
	protected Font fontePadrao;
	protected TratadoraDeEvento tratadoraDeEvento = new TratadoraDeEvento();
	protected TelaJogo jogo;
	
	public TelaPrincipal(String nomeJanela) {
		super(nomeJanela);
		configurarInterface(new AtorJogador(this));
		carregarMenu();
		pack();
		setVisible(true);
	}
	
	public void configurarInterface(AtorJogador atorJogador) {
		this.atorJogador = atorJogador;
		setPreferredSize(new Dimension(900, 700));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		//setResizable(false);
	}
	
	public void carregarMenu() {
		Color corDeFundo = Color.WHITE;
		
		barraDeMenu = new JMenuBar();
		barraDeMenu.setPreferredSize(new Dimension(500, 30));
		barraDeMenu.setBackground(corDeFundo);
		barraDeMenu.setOpaque(true);
		setJMenuBar(barraDeMenu);
		
		menu = new JMenu("Menu");
		menu.setBackground(corDeFundo);
		menu.setMnemonic(KeyEvent.VK_M);
		barraDeMenu.add(menu);
		
		conexao = new JMenu("Conexão");
		conexao.setOpaque(true);
		conexao.setBackground(corDeFundo);
		menu.add(conexao);
		
		conectarServidor = new JMenuItem("Conectar servidor");
		conectarServidor.setBackground(corDeFundo);
		conectarServidor.addActionListener(tratadoraDeEvento);
		conectarServidor.setActionCommand(Constante.CONECTAR_SERVIDOR);
		conexao.add(conectarServidor);
		
		alterarServidor = new JMenuItem("Alterar servidor");
		alterarServidor.setBackground(corDeFundo);
		alterarServidor.addActionListener(tratadoraDeEvento);
		alterarServidor.setActionCommand(Constante.ALTERAR_SERVIDOR);
		conexao.add(alterarServidor);
		
		desconectar = new JMenuItem("Desconectar");
		desconectar.setBackground(corDeFundo);
		desconectar.addActionListener(tratadoraDeEvento);
		desconectar.setActionCommand(Constante.DESCONECTAR);
		conexao.add(desconectar);
		
		partida = new JMenu("Partida");
		partida.setOpaque(true);
		partida.setBackground(corDeFundo);
		menu.add(partida);
		
		iniciarNovaPartida = new JMenuItem("Iniciar nova partida");
		iniciarNovaPartida.setBackground(corDeFundo);
		iniciarNovaPartida.addActionListener(tratadoraDeEvento);
		iniciarNovaPartida.setActionCommand(Constante.INICIAR_NOVA_PARTIDA);
		partida.add(iniciarNovaPartida);
		
		desistirDaPartida = new JMenuItem("Desistir da partida");
		desistirDaPartida.setBackground(corDeFundo);
		desistirDaPartida.addActionListener(tratadoraDeEvento);
		desistirDaPartida.setActionCommand(Constante.DESISTIR_DA_PARTIDA);
		partida.add(desistirDaPartida);
		
		sair = new JMenuItem("Sair");
		sair.setBackground(corDeFundo);
		sair.addActionListener(tratadoraDeEvento);
		sair.setActionCommand(Constante.SAIR);
		menu.add(sair);
		
		ajuda = new JMenuItem("Ajuda");
		ajuda.setBackground(corDeFundo);
		ajuda.setMnemonic(KeyEvent.VK_A);
		ajuda.addActionListener(tratadoraDeEvento);
		ajuda.setActionCommand(Constante.AJUDA);
		barraDeMenu.add(ajuda);
	}
	
	public void conectar() {
		atorJogador.conectar();
		
	}

	public boolean confirmarAcao(String acao) {
		Object[] opcoes = {"sim", "cancelar"};
		
		if (obterOpcao(opcoes, "Você deseja realmente " + acao + "?", "Confirmar") == 0)
			return true;
		
		return false;
	}

	public void exibirMensagem(String titulo, String mensagem) {
		JOptionPane.showMessageDialog(this, mensagem, titulo, JOptionPane.PLAIN_MESSAGE);
	}

	public int obterOpcao(Object[] opcoes, String mensagem, String titulo) {
		return	JOptionPane.showOptionDialog(this, mensagem,
				titulo, JOptionPane.PLAIN_MESSAGE,
				JOptionPane.QUESTION_MESSAGE, null, opcoes, null);
	}

	public void desconectar() {
		atorJogador.desconectar();
	}

	public void ajuda() {
		JOptionPane.showMessageDialog(null, Constante.AJUDA, "Ajuda", JOptionPane.INFORMATION_MESSAGE);
	}

	public void sair() {
		if (atorJogador.sair())
			System.exit(0);
	}

	public void iniciarNovaPartida() {
		atorJogador.iniciarNovaPartida();
	}

	public void desistirPartida() {
		atorJogador.desistirPartida();
	}
	
	public void alterarAtorJogador(AtorJogador atorJogador) {
		this.atorJogador = atorJogador;
	}
	
	public String obterServidor() {
		String idServidor = ("localhost");
		idServidor = JOptionPane.showInputDialog(this, ("Insira o endereço do servidor"), idServidor);
		return idServidor;
	}

	public String obterIdJogador() {
		String idJogador = ("jogador");
		idJogador = JOptionPane.showInputDialog(this, ("Insira o nome do jogador"));
		return idJogador;
	}
	
	private class TratadoraDeEvento implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String comando = e.getActionCommand();
			System.out.println(comando);
			
			switch (comando) {
				case Constante.CONECTAR_SERVIDOR: conectar(); break;
				case Constante.DESCONECTAR: desconectar(); break;
				case Constante.INICIAR_NOVA_PARTIDA: iniciarNovaPartida(); break;
				case Constante.DESISTIR_DA_PARTIDA: desistirPartida(); break;
				case Constante.SAIR: sair(); break;
				case Constante.AJUDA: ajuda(); break;
			}
		}
	}

	public void comecaJogo(EstadoMesa estadoMesa) {
		this.jogo = new TelaJogo(estadoMesa);
		add(jogo);
		jogo.setBounds(100, 15, 800, 700);
		
	}
}
