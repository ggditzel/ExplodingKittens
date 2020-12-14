import java.util.Locale;

public class Main {
	public static void main(String[] args) {
		
		GameLocale gl = new GameLocale();
		gl.setLocale(new Locale("en", "US"));
		TelaPrincipal tp = new TelaPrincipal("Exploding Kittens");
		
	}
}
