package conta.model;

public class ContaPoupanca {
String titularPoupanca;
	
	public ContaPoupanca(String titularPoupanca) {
		this.titularPoupanca = titularPoupanca;	
	}

	public String getTitular() {
		return titularPoupanca;
	}

	public void setTitular(String titularPoupanca) {
		this.titularPoupanca = titularPoupanca;
	}
	
	public void visualizar() {
		
		System.out.println("\n\n***********************************************************");
		System.out.println("Dados da Conta Corrente:");
		System.out.println("***********************************************************");
		System.out.println("Nome do titular da conta corrente: " + this.titularPoupanca);

	}
}
