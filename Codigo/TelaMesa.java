import java.util.ArrayList;
import java.util.Scanner;


public class TelaMesa {

	Scanner sc =  new Scanner(System.in);
	
	public int mostrarCartasViradasBaixo(int qtdCartas) {
		System.out.println("Voce possui uma defuse \n Escolha em qual posicao voce colocara o EXPLODING KITTEN");
		for(int i = 0; i < qtdCartas; i++) {
			System.out.print(" [" + i + "] ");
		}
		return sc.nextInt();
	}

	public void mostrarAjuda(String descricao) {
		// TODO Auto-generated method stub
		
	}

	public void mostrarCartasTopo(ArrayList<Carta> cartas) {
		// TODO Auto-generated method stub
		
	}

	public int[] perguntaCartasTopo(ArrayList<Carta> cartas) {
		// TODO Auto-generated method stub
		return new int[0];
	}

	public String perguntaNomeJogador() {
		System.out.println("insira seu nome: ");
		return sc.nextLine();
	}

	public void falaMao(Jogador jogador) {
		System.out.println("mao do jogador " + jogador.getNome() + " :");
		for(int i = 0; i < jogador.getMao().cartas.size(); i++) {
			System.out.println("" + i + " - " + jogador.getMao().getCarta(i).getDescricao());
		}
		
	}

	public int perguntaJogada(Jogador jogadorDaVez) {
		System.out.println(jogadorDaVez.getNome() + " escolha sua jogada:");
		falaMao(jogadorDaVez);
		if(jogadorDaVez.possuiPar()) {
			System.out.println(jogadorDaVez.getMao().cartas.size() + " - jogar par");
			System.out.println((jogadorDaVez.getMao().cartas.size() + 1) + " - acabar turno");
		} else {
			System.out.println(jogadorDaVez.getMao().cartas.size() + " - acabar turno");
		}
		return sc.nextInt();
	}

	public int[] perguntaPar() {
		int[] par = new int[2];
		System.out.print("Carta1: ");
		par[0] = sc.nextInt();
		System.out.print("Carta2: ");
		par[1] = sc.nextInt();
		System.out.println();
		return par;
	}

}
