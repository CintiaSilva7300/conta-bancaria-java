package conta.model;

public class ContaCorrente {
	String titularCorrente;
	
	public ContaCorrente(String titular) {
		this.titularCorrente = titular;	
	}

	public String getTitular() {
		return titularCorrente;
	}

	public void setTitular(String titular) {
		this.titularCorrente = titular;
	}
	
	public void visualizar() {
		
		System.out.println("\n\n***********************************************************");
		System.out.println("Dados da Conta Corrente:");
		System.out.println("***********************************************************");
		System.out.println("Nome do titular da conta corrente: " + this.titularCorrente);

	}
}
