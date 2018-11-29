import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Baralho implements Jogada{

	//topo do baralho sera a posicao 0
	protected ArrayList<Carta> cartas;
	
	public Baralho() {
		this.cartas = new ArrayList<>();
		cartas.add(new CartaEfeito(EfeitoCarta.EXPLODING_KITTEN)); 
		for(int i = 0; i < 3; i++) {
			cartas.add(new CartaEfeito(EfeitoCarta.CHANGE_THE_FUTURE));
			cartas.add(new CartaEfeito(EfeitoCarta.DEFUSE));
			cartas.add(new CartaEfeito(EfeitoCarta.FAVOR));
			cartas.add(new CartaEfeito(EfeitoCarta.NOPE));
			cartas.add(new CartaEfeito(EfeitoCarta.SEE_THE_FUTURE));
			cartas.add(new CartaEfeito(EfeitoCarta.SKIP));
			cartas.add(new CartaKitten(TriboKitten.KITTEN_GARFIELD));
			cartas.add(new CartaKitten(TriboKitten.KITTEN_MEOW));
			cartas.add(new CartaKitten(TriboKitten.KITTEN_PUSS_IN_BOOTS));
			cartas.add(new CartaKitten(TriboKitten.KITTEN_SYLVESTER));
		}
		cartas.add(new CartaKitten(TriboKitten.KITTEN_GARFIELD));
		cartas.add(new CartaKitten(TriboKitten.KITTEN_MEOW));
		cartas.add(new CartaKitten(TriboKitten.KITTEN_PUSS_IN_BOOTS));
		cartas.add(new CartaKitten(TriboKitten.KITTEN_SYLVESTER));
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
		System.out.println("ordem antiga: ");
		System.out.println(Arrays.toString(cartas.subList(0, cartasTopo.size()).toArray()));
		cartas.subList(0, cartasTopo.size()).clear();
		cartas.addAll(0, cartasTopo);
		System.out.println("nova ordem:");
		System.out.println(Arrays.toString(cartas.subList(0, cartasTopo.size()).toArray()));
	}

	public void inserirExplodingKitten(int posicao) {
		cartas.add(posicao, new CartaEfeito(EfeitoCarta.EXPLODING_KITTEN));
	}

	public void embaralhar() {
		Collections.shuffle(cartas);
	}

	public CartaEfeito removeExpoddingKitten() {
		for(Carta c: cartas) {
			if(c instanceof CartaEfeito) {
				CartaEfeito cEfeito = (CartaEfeito) c;
				if(cEfeito.getEfeito() == EfeitoCarta.EXPLODING_KITTEN) {
					cartas.remove(cEfeito);
					return cEfeito;
				}
			}
		}
		return null;
	}

	public CartaEfeito removeDefuse() {
		for(Carta c: cartas) {
			if(c instanceof CartaEfeito) {
				CartaEfeito cEfeito = (CartaEfeito) c;
				if(cEfeito.getEfeito() == EfeitoCarta.DEFUSE) {
					cartas.remove(cEfeito);
					return cEfeito;
				}
			}
		}
		return null;
	}

	public void inserir(Carta carta) {
		this.cartas.add(carta);
	}
}