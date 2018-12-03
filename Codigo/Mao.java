import java.util.ArrayList;
import java.util.Random;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Mao implements Jogada{

	protected ArrayList<Carta> cartas;
	protected int quantidadeKittenGarfield;
	protected int quantidadeKittenPussInBoots;
	protected int quantidadeKittenSylvester;
	protected int quantidadeKittenMeow;
	protected int quantidadeNope;
	protected int quantidadeDefuse;

	
	public Mao() {
		this.cartas = new ArrayList<>();
		this.quantidadeDefuse = 0;
		this.quantidadeKittenGarfield = 0;
		this.quantidadeKittenMeow = 0;
		this.quantidadeKittenPussInBoots = 0;
		this.quantidadeKittenSylvester = 0;
		this.quantidadeNope = 0;
	}
//	public Mao(ArrayList<Carta> cartas) {
//		this.cartas = cartas;
//		atualizarQuantidades();
//	}
	
	
	/**
	 * 
	 * @param carta
	 */
	public void inserirCarta(Carta carta) {
		this.cartas.add(carta);
		if(carta.isCartaEfeito()) {
			CartaEfeito cartaEfeito = (CartaEfeito) carta;
			if(cartaEfeito.getEfeito() == EfeitoCarta.NOPE) {
				quantidadeNope++;
			} else if(cartaEfeito.getEfeito() == EfeitoCarta.DEFUSE) {
				quantidadeDefuse++;
			}
		} else {
			CartaKitten cartaKitten = (CartaKitten) carta;
			switch(cartaKitten.getTribo()) {
				case KITTEN_GARFIELD: 
					quantidadeKittenGarfield++;
					break;
				case KITTEN_MEOW:
					quantidadeKittenMeow++;
					break;
				case KITTEN_PUSS_IN_BOOTS:
					quantidadeKittenPussInBoots++;
					break;
				case KITTEN_SYLVESTER:
					quantidadeKittenSylvester++;
					break;
			}
		}
	}

	public Carta retirarCartaAleatoria() {
		int numeroCartas = cartas.size();
		int posicao = new Random().nextInt(numeroCartas);
		Carta cartaRemovida = cartas.remove(posicao);
		AtualizaRemocao(cartaRemovida);
		return cartaRemovida;
	}

//	private void atualizarQuantidades() {
//		this.quantidadeDefuse = 0;
//		this.quantidadeKittenGarfield = 0;
//		this.quantidadeKittenMeow = 0;
//		this.quantidadeKittenPussInBoots = 0;
//		this.quantidadeKittenSylvester = 0;
//		this.quantidadeNope = 0;
//		for(Carta carta: this.cartas) {
//			if(carta.isCartaEfeito()) {
//				CartaEfeito cartaEfeito = (CartaEfeito) carta;
//				if(cartaEfeito.getEfeito() == EfeitoCarta.NOPE) {
//					quantidadeNope++;
//				} else if(cartaEfeito.getEfeito() == EfeitoCarta.DEFUSE) {
//					quantidadeDefuse++;
//				}
//			} else {
//				CartaKitten cartaKitten = (CartaKitten) carta;
//				switch(cartaKitten.getTribo()) {
//					case KITTEN_GARFIELD: 
//						quantidadeKittenGarfield++;
//						break;
//					case KITTEN_MEOW:
//						quantidadeKittenMeow++;
//						break;
//					case KITTEN_PUSS_IN_BOOTS:
//						quantidadeKittenPussInBoots++;
//						break;
//					case KITTEN_SYLVESTER:
//						quantidadeKittenSylvester++;
//						break;
//				}
//			}
//		}
//	}

	/**
	 * 
	 * @param posicao
	 */
	public Carta retirarCarta(int posicao) {
		Carta cartaRemovida = cartas.remove(posicao);
		AtualizaRemocao(cartaRemovida);		
		return cartaRemovida;
	}
	
	private void AtualizaRemocao(Carta carta) {
		if(carta.isCartaEfeito()) {
			CartaEfeito cartaEfeito = (CartaEfeito) carta;
			if(cartaEfeito.getEfeito() == EfeitoCarta.NOPE) {
				quantidadeNope--;
			} else if(cartaEfeito.getEfeito() == EfeitoCarta.DEFUSE) {
				quantidadeDefuse--;
			}
		} else {
			CartaKitten cartaKitten = (CartaKitten) carta;
			switch(cartaKitten.getTribo()) {
				case KITTEN_GARFIELD: 
					quantidadeKittenGarfield--;
					break;
				case KITTEN_MEOW:
					quantidadeKittenMeow--;
					break;
				case KITTEN_PUSS_IN_BOOTS:
					quantidadeKittenPussInBoots--;
					break;
				case KITTEN_SYLVESTER:
					quantidadeKittenSylvester--;
					break;
			}
		}
	}

	public void retirarDefuse() {
		for(Carta c: cartas) {
			if(c.isCartaEfeito()) {
				CartaEfeito cartaEfeito = (CartaEfeito) c;
				if(cartaEfeito.getEfeito() == EfeitoCarta.DEFUSE) {
					cartas.remove(cartaEfeito);
					quantidadeDefuse--;
					return;
				} 
			}
		}
	}
	

	
	
	/**
	 * 
	 * @param posicao1
	 * @param posicao2
	 * @throws Exception 
	 */
	public void retirarCartas(int posicao1, int posicao2)  throws Exception {
		if(posicao1 == posicao2) {} //throw new Exception("Selecione duas cartas diferentes");
		Carta carta1 = cartas.get(posicao1);
		Carta carta2 = cartas.get(posicao2);
		if(carta1.isCartaEfeito() || carta2.isCartaEfeito() ) {
			throw new Exception("Carta de efeito nao pode ser jogada como par");
		}
		CartaKitten cartaKitten1 = (CartaKitten) carta1;
		CartaKitten cartaKitten2 = (CartaKitten) carta2;
		if(cartaKitten1.getTribo() != cartaKitten2.getTribo()) {
			throw new Exception("Cartas de tribo diferente nao podem ser jogadas como par");
		}
		
		if(posicao1 > posicao2) {
			cartas.remove(posicao1);
			cartas.remove(posicao2);
		} else {
			cartas.remove(posicao2);
			cartas.remove(posicao1);
		}
		AtualizaRemocao(carta1);
		AtualizaRemocao(carta2);
		
	}
	
	public boolean possuiNope() {
		return quantidadeNope > 0;
	}
	public boolean possuiDefuse() {
		return quantidadeDefuse > 0;
	}
	
	public Carta getCarta(int posicao) {
		return cartas.get(posicao);
	}
	public boolean possuiPar() {
		return quantidadeKittenGarfield > 1 || quantidadeKittenMeow > 1 || quantidadeKittenPussInBoots > 1 || quantidadeKittenSylvester > 1;
	}
	
	public void retirarNope() {
		for(Carta c: cartas) {
			if(c.isCartaEfeito()) {
				CartaEfeito cartaEfeito = (CartaEfeito) c;
				if(cartaEfeito.getEfeito() == EfeitoCarta.NOPE) {
					cartas.remove(cartaEfeito);
					quantidadeNope--;
					return;
				} 
			}
		}
		
	}


}