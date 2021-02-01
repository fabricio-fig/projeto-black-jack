package projeto.blackJack;

public class ExBaralhoVazio extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExBaralhoVazio() {
		super("Baralho Vazio!");
	}
	@Override
	public String getMessage() {
		return "Baralho Vazio!";
	}
}
