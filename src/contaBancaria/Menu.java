package contaBancaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import conta.controller.ContaControlle;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.model.ModelConta;
import conta.util.Cores;

public abstract class Menu {
	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		ArrayList<ModelConta> contaLista = new ArrayList<>();
		ArrayList<ContaCorrente> contaCorrenteList = new ArrayList<>();
		ArrayList<ContaControlle> contaControlleList = new ArrayList<>();

		int numero;
		int agencia;
		int tipo;
		String titular;
		String titularCorrente;
		float saldo;
		double valor;

		int opcao;

		while (true) {

			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO DO BRAZIL COM Z                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
//			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - filtrar conta por Numero            ");
			System.out.println("            10 - listar todas                        ");
			System.out.println("            11 - Cadastrar nova conta                ");
			System.out.println("            12 - Sair                                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			opcao = leia.nextInt();

			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Criar Conta\n\n");

				System.out.println("Digite o numero da conta");
				numero = leia.nextInt();

				System.out.println("Digite o numero da agencia");
				agencia = leia.nextInt();

				System.out.println("Tipo da conta: 1 - Conta Corrente. 2 - Conta Poupança");
				tipo = leia.nextInt();

				System.out.println("Digite o valor do deposito");
				saldo = leia.nextInt();

				leia.nextLine();

				System.out.println("Digite o nome do titular da conta");
				titular = leia.nextLine();

				ModelConta newConta = new ModelConta(numero, agencia, tipo, titular, saldo);

				newConta.visualizar();

				break;

			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n\n");

				// if (contaLista.isEmpty()) {
				// System.out.println("Nenhuma conta cadastrada.");
				// } else {
				// for (ModelConta conta : contaLista) {
				// conta.visualizar();
				// }
				// }
				break;

			case 3:
				System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número\n\n");
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");
				ContaControlle.cadastrar();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE + "Saque\n\n");
				ContaControlle contaControlle = new ContaControlle(1234567, "Cintia", 10000);
				
				System.out.println("Digite o valor do saque");
				valor = leia.nextDouble();
				
				contaControlle.sacar(valor);
				
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");
				break;
			case 9:
				System.out.println(Cores.TEXT_WHITE + "Filtrar por numero");
				ContaControlle.procurarPorNumero();
				break;

			case 10:
				System.out.println(Cores.TEXT_WHITE + "Filtrar por numero");
				contaControlleList.add(new ContaControlle(1234567, "Cintia", 10000));
				System.out.println(contaControlleList);
				ContaControlle.listarTodas();
				break;
			case 11:
				System.out.println(Cores.TEXT_WHITE + "Cadastrar nova conta");
				ContaControlle.cadastrar();
				break;
			
			case 12:
				break;	

			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Cintia");
		System.out.println("https://github.com/CintiaSilva7300/conta-bancaria-java");
		System.out.println("*********************************************************");

		ContaCorrente Newcorrent = new ContaCorrente("Cintia");
		Newcorrent.visualizar();

		ContaPoupanca NewPoupanca = new ContaPoupanca("Cintia poupança");
		NewPoupanca.visualizar();
	}

}
