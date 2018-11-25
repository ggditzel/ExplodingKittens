
public class Main {
	public static void main(String[] args) {
		
		//new Mesa();
		
		AtorJogador aj1 = new AtorJogador("Jog1");
		AtorNetgames an1 = new AtorNetgames(aj1);

		aj1.go(); // conecta
		aj1.iniciar();

		while(true);
		
	}
}
