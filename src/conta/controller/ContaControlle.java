package conta.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ContaControlle {

	private static List<ContaControlle> contas = new ArrayList<>();
	private int numero;
	private String titular;
	private double saldo;

	public ContaControlle(int numero, String titular, double saldo) {
		super();
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Conta{" + "numero=" + numero + ", titular='" + titular + '\'' + ", saldo=" + saldo + '}';
	}

	public static void procurarPorNumero() {
		Scanner leia = new Scanner(System.in);
		int input;

		ContaControlle contaControlle = new ContaControlle(1234567, "Cintia", 10000);
		Optional<ContaControlle> conta = Optional.of(contaControlle);

		System.out.println("search: ");
		input = leia.nextInt();

		conta.map(res -> String.valueOf(res.getNumero()))
				.filter(searchNum -> searchNum.startsWith(String.valueOf(input)))
				.orElseThrow(() -> new InputMismatchException("Conta não encontrada!"));

		System.out.println("\nNome do Colaborador: " + conta.get().getNumero());
	}

	public static void listarTodas() {
		System.out.println("\nLista de Todas as Contas:");
		contas.forEach(System.out::println);
	}

	public static void cadastrar() {
		Scanner leia = new Scanner(System.in);
		int numero;
		String titular;
		int saldo;

		System.out.println("Insira o numero da conta: ");
		numero = leia.nextInt();

		System.out.println("Insira o titular da conta: ");
		titular = leia.next();

		System.out.println("Insira o saldo da conta: ");
		saldo = leia.nextInt();

		ContaControlle contaControlle = new ContaControlle(numero, titular, saldo);

		System.out.println(contaControlle);
	}

//	public static void atualizar() {
//		Scanner leia = new Scanner(System.in);
//		int numeroConta;
//
//		System.out.println("Informe o número da conta a ser atualizada: ");
//		numeroConta = leia.nextInt();
//
//		Optional<ContaControlle> contaOptional = contas.stream().filter(conta -> conta.getNumero() == numeroConta)
//				.findFirst();
//
//		if (contaOptional.isPresent()) {
//			ContaControlle conta = contaOptional.get();
//
//			System.out.println("Informe o novo titular da conta: ");
//			conta.setTitular(leia.next());
//
//			System.out.println("Informe o novo saldo da conta: ");
//			conta.setSaldo(leia.nextDouble());
//
//			System.out.println("Conta atualizada com sucesso!");
//		} else {
//			System.out.println("Conta não encontrada. Não foi possível atualizar.");
//		}
//	}
	
	public void sacar(double valor) {
	    if (this.getSaldo() < valor) {
	        System.out.println("\n Saldo Insuficiente!");
	    } else {
	        this.setSaldo(this.getSaldo() - valor);
	        System.out.println("Saque realizado com sucesso!");
	    }
	}
	
	public void atualizar(List<ContaControlle> contas) {
	    Scanner leia = new Scanner(System.in);
	    int numeroConta;

	    System.out.println("Informe o número da conta a ser atualizada: ");
	    numeroConta = leia.nextInt();

	    Optional<ContaControlle> contaOptional = contas.stream()
	            .filter(conta -> conta.getNumero() == numeroConta)
	            .findFirst();

	    if (contaOptional.isPresent()) {
	        ContaControlle conta = contaOptional.get();

	        System.out.println("Informe o novo titular da conta: ");
	        conta.setTitular(leia.next());

	        System.out.println("Informe o novo saldo da conta: ");
	        conta.setSaldo(leia.nextDouble());

	        System.out.println("Conta atualizada com sucesso!");
	    } else {
	        System.out.println("Conta não encontrada. Não foi possível atualizar.");
	    }
	}

}
