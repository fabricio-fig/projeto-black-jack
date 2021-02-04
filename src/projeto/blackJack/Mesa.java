package projeto.blackJack;

import java.util.Scanner;

public class Mesa {
	private Jogador jogador1;
	private Jogador jogador2;
	private Baralho baralho;
	private Scanner scan;
	public Mesa() {
		this.jogador1 = new Jogador("fabricio@gmail.com.br", "Fabricio", "26");
		this.jogador2 = new Jogador("fulano@teste.com.br", "Fulana", "32");
		baralho = new Baralho();
	}
	Mesa(Jogador jogador_1, Jogador jogador_2){
		this.jogador1 = jogador_1;
		this.jogador2 = jogador_2;
	}
	public String getNomeJogador1() {
		return this.jogador1.getNome();
	}
	public String getNomeJogador2() {
		return this.jogador2.getNome();
	}
	public void dadosJogador1() {
		this.jogador1.dadosJogador();
	}
	public void dadosJogador2() {
		this.jogador2.dadosJogador();
	}
	public void listarCartas() {
		this.baralho.listarCartas();
	}
	public void embaralhar() {
		baralho.embaralhar();
	}
	protected Carta pegarCarta() throws ExBaralhoVazio{
		return baralho.pegarCarta();
	}
	protected void mostrarPlacar() {
		System.out.println(jogador1.getNome()+ ": " + jogador1.getPontos() );
		System.out.println(jogador2.getNome()+ ": " + jogador2.getPontos() );
	}
	public void Jogar() {
		this.baralho.embaralhar(); // embaralhar cartas
		boolean ambosParam = true; //variável de controle
		scan = new Scanner(System.in); // ler teclado dos jogadores
		
		String opcao; // ler opção do jogador
		Carta carta1 = new Carta(); // carta sacada pelo jogador1
		Carta carta2 = new Carta(); // carta sacada pelo jogador2
		
		do {
			System.out.println("\n\n\n");
			System.out.println("***********************************************");
			this.mostrarPlacar();
			ambosParam = true;
			
			//jogador1
			System.out.println(jogador1.getNome()+ " Deseja puxar uma carta? 1 - SIM \t 2 - NÃO");
			opcao = scan.nextLine();
			if(opcao.equals("1")) {
				// deseja puxar carta, puxa a carta, retira do baralho, adiciona no jogador e mostra o placar
				ambosParam = false; // ambos não param pois o jogador1 puxou uma carta
				try {
					carta1 = this.baralho.pegarCarta(); // jogador1 pegou a carta
				}catch(ExBaralhoVazio ex) {
					System.out.println(ex.getMessage());
					System.exit(0);
				}
				jogador1.adicionarCartaSacada(carta1);// jogador2 adicionou sua carta ao seu montante
			}else {
				System.out.println("Jogador não puxou carta");
				ambosParam = ambosParam && true;
			}
			if(jogador1.getPontos()>=21)
				ambosParam = true;
			else {
				//jogador2
				System.out.println("\n\n\n");
				this.mostrarPlacar();
				System.out.println(jogador2.getNome() + " : Deseja puxar uma carta? 1 - SIM \t 2 - NÃO");
				opcao = scan.nextLine();
				if(opcao.equals("1")) {
					//// deseja puxar carta, puxa a carta, retira do baralho, adiciona no jogador e mostra o placar
					ambosParam = false; // ambos param pois o jogador1 já puxou a carta
					try {
						carta2 = this.baralho.pegarCarta();//jogador1 pegou uma carta
					}catch(ExBaralhoVazio ex) {
						System.out.println(ex.getMessage());
						System.exit(0);
					}
					jogador2.adicionarCartaSacada(carta2); // jogador2 adicionou carta sacada ao seu montante
				}else {
					System.out.println("Jogador não puxou carta");
					ambosParam = ambosParam && true;
				}
			}
			
		}while ( (jogador1.getPontos()<21) && (jogador2.getPontos()<21) && (ambosParam==false)   );
		//verifica o vencedor
		System.out.println("PLACAR FINAL");
		this.mostrarPlacar();
		if(jogador1.getPontos() == jogador2.getPontos()) // empate
			System.out.println("EMPATE!");
		else {
			if( (jogador1.getPontos() > jogador2.getPontos()) && jogador1.getPontos()<=21) { // jogador 1 vence
				System.out.println(jogador1.getNome()+": VENCEU!");
				System.out.print(jogador1.getNome()+ " DIZ: ");
				this.jogador1.mensagemVitoria();
				
			}else {
				System.out.println(jogador2.getNome()+": VENCEU!"); // jogador2 venceu;
				this.jogador2.mensagemVitoria();
				System.out.print(jogador2.getNome()+ " DIZ: ");
				this.jogador2.mensagemVitoria();
			}
		}
	}// fim Método Jogar
}
