import java.util.ArrayList;
import java.util.Collections;

public class Baralho {

	//topo do baralho sera a posicao 0
	protected ArrayList<Carta> cartas;
	
	public Baralho() {
		this.cartas = new ArrayList<>();
		//adicionar as cartas do baralho
	}
	
	public Baralho(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}

	public Carta removeCartaTopo() {
		return cartas.remove(0);
	}

	public ArrayList<Carta> getCartas() {
		return this.cartas;
	}

	public ArrayList<Carta> getCartasTopo() {
		ArrayList<Carta> cartasTopo = new ArrayList<>();
		if(cartas.size() >= 3) {
			cartasTopo.addAll(cartas.subList(0, 3));
			return cartasTopo;
		} else {
			for(int i = 0; i < cartas.size(); i++) {
				cartasTopo.add(cartas.get(i));
			}
			return cartasTopo;
		}
		
	}

	/**
	 * 
	 * @param cartas
	 */
	public void setCartasTopo(ArrayList<Carta> cartasTopo) {
		cartas.subList(0, cartasTopo.size()).clear();
		cartas.addAll(0, cartasTopo);
	}

	public void inserirDefuse(int posicao) {
		cartas.add(posicao, new CartaEfeito(EfeitoCarta.DEFUSE));
	}

	public void embaralhar() {
		Collections.shuffle(cartas);
	}
}