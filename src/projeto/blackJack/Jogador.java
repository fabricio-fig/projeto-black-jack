package projeto.blackJack;

import java.util.ArrayList;
import java.util.List;

public class Jogador extends Humano {
	private String email;
	private List<Carta> cartasSacadas;
	
	public Jogador(String email, String nome, String idade) {
		super(nome, idade);
		this.email = email;
		cartasSacadas = new ArrayList<Carta>();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	protected void dadosJogador() {
		System.out.println("Nome: "+this.getNome());
		System.out.println("Idade: "+this.getIdade());
		System.out.println("E-mail: "+this.getEmail());
	}
	public void mensagemVitoria() {
		System.out.println("Oba, venci!");
	}
	protected int getPontos() {
		int toalPontos = 0;
		for (Carta cartaSacada : this.cartasSacadas) {
			toalPontos+= cartaSacada.getValor();
		}
		return toalPontos;
	}
	public void adicionarCartaSacada(Carta novaCarta) {
		cartasSacadas.add(novaCarta);
	}
}
