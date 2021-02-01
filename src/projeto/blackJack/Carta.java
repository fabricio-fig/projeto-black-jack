package projeto.blackJack;

public class Carta {
	private String numero;
	private String naipe;
	private int valor;
	
	public Carta() {
		this.numero = "0";
		this.naipe = "Fake";
		this.valor = 0;
	}
	
	public Carta(String numero, String naipe, int valor) {
		super();
		this.numero = numero;
		this.naipe = naipe;
		this.valor = valor;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNaipe() {
		return naipe;
	}

	public void setNaipe(String naipe) {
		this.naipe = naipe;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	
}
