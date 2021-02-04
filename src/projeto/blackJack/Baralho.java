package projeto.blackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Baralho {
	private List<Carta> cartas;
	
	Baralho() {
		cartas = new ArrayList<Carta>(); // criação de lista de cartas
		 String numero = " 0 ";
		 String naipe = "Fake";
		 int valor = 0;
		 
		 for (int numeroCarta = 1; numeroCarta < 14; numeroCarta++) {
			for (int naipeCarta = 0; naipeCarta < 5; naipeCarta++) {
				Carta c = new Carta();
				//verificar número
				if(numeroCarta==1) {
					numero = "A";
					valor = 1;
				}else if(numeroCarta==11) {
					numero = "J";
					valor = 11;
				}else if(numeroCarta==12) {
					numero = "Q";
					valor = 12;
				}else if(numeroCarta==13) {
					numero = "K";
					valor = 13;
				}else {
					numero = String.valueOf(numeroCarta);
					valor = numeroCarta;
				}
				//varificar naipe
				switch(naipeCarta) {
				case 1 : naipe = "Paus"; break;
				case 2 : naipe = "Ouro"; break;
				case 3 : naipe = "Copas"; break;
				case 4 : naipe = "Espada"; break;
				default : naipe = "Fake"; break;
				}
				//setar carta
				c.setNumero(numero);
				c.setNaipe(naipe);
				c.setValor(valor);
				
				//adicionar Carta ao Baralho
				this.cartas.add(c);
				
				
			}//fim ForSecundário
		}//fim ForPrincipal
	}//fim Baralho
	public void listarCartas() {
		for (Carta carta : this.cartas) {
			System.out.println(carta.getNumero() + " de " + carta.getNaipe() + ". Valor: " + carta.getValor());
		}
	}
	protected void embaralhar() {
		Random roleta = new Random();
		Carta cartaAleatoria = new Carta();
		for (int i = 0; i < 500; i++) {
			//gera um numero aleatorio e remove a carta do baralho. cartaAleatoria recebe esta carga
			cartaAleatoria = this.cartas.remove(roleta.nextInt(this.cartas.size() - 1) );
			this.cartas.add(cartaAleatoria);
		}
	}
	protected Carta pegarCarta() throws ExBaralhoVazio{
		if(cartas.size() > 0) {
			return cartas.remove(0); //Remove retira da lista e retorna o elemento removido
		}else {
			throw new ExBaralhoVazio();
		}
	}
	
}
