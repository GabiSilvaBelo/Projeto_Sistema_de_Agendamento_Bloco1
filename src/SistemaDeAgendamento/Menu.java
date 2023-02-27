package SistemaDeAgendamento;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import SistemaDeAgendamento.controller.SistemaDeAgendamentoController;
import SistemaDeAgendamento.model.Paciente;
import SistemaDeAgendamento.model.Paciente_Sistema;

public class Menu {

	public static void main(String[] args) {
		int opcao, codigoPaciente, idadePaciente;
		String nomePaciente, generoPaciente, enderecoPaciente, emailPaciente, cpfPaciente, telefonePaciente, convenioPaciente;
		Scanner scanner = new Scanner (System.in);
	
	SistemaDeAgendamentoController paciente = new SistemaDeAgendamentoController();
	
	Paciente_Sistema paciente1 = new Paciente_Sistema(paciente.gerarCodigoPaciente(),"Thais", 27, "fem", "rua fulano", "email@email", "cpf", "telefone", "convenio");
	paciente.cadastrarPaciente(paciente1);
	
	Paciente_Sistema paciente2 = new Paciente_Sistema(paciente.gerarCodigoPaciente(),"Stephanie", 27, "fem", "rua fulano", "email@email", "cpf", "telefone", "convenio");
	paciente.cadastrarPaciente(paciente2);

while(true) {
	System.out.println("1 - Cadastrar um paciente:"); //OK
	System.out.println("2 - Marcar uma consulta:");
	System.out.println("3 - Marcar um exame:");
	System.out.println("4 - Listar pacientes no sistema:"); //OK
	System.out.println("5 - Buscar cadastro de paciente:"); //OK
	System.out.println("6 - Deletar paciente do sistema:"); //OK
	System.out.println("7 - Atualizar dados de paciente:"); //OK
	System.out.println("0 - Sair");
	System.out.println("\n");
	System.out.print("Opção escolhida: ");
	
try {
	opcao=scanner.nextInt();
}catch(InputMismatchException e) {
	 System.out.println("\nDigite um numero válido das opções do menu abaixo ");
	 System.out.println("\n\n");
	 scanner.nextLine();
	 opcao=0;
}
	
if (opcao==0) {
	System.out.println("\n Sistema de agendamentos");
	System.out.println("\n Obrigado por utilizar nosso sistema de agendamentos!");
	scanner.close();
    System.exit(0);   
}	
	
switch(opcao) {
case 1:
	
	System.out.println("\nCadastrar Paciente");
	
	System.out.println("\nDigite o nome do paciente: ");
	scanner.skip("\\R?");
	nomePaciente=scanner.nextLine();
	
	System.out.println("\nDigite a idade do paciente: ");
	scanner.skip("\\R?");
	idadePaciente=scanner.nextInt();
	
	System.out.println("\nDigite o gênero que o paciente se identifica: ");
	scanner.skip("\\R?");
	generoPaciente=scanner.nextLine();
	
	System.out.println("\nDigite o endereço do paciente: ");
	scanner.skip("\\R?");
	enderecoPaciente=scanner.nextLine();
	
	System.out.println("\nDigite o email do paciente: ");
	scanner.skip("\\R?");
	emailPaciente=scanner.nextLine();
	
	System.out.println("\nDigite o CPF do paciente: ");
	scanner.skip("\\R?");
	cpfPaciente=scanner.nextLine();
	
	System.out.println("\nDigite o telefone do paciente: ");
	scanner.skip("\\R?");
	telefonePaciente=scanner.nextLine();
	
	System.out.println("\nDigite o convênio do paciente se houver, se não digite apenas 'Particular' ");
	scanner.skip("\\R?");
	convenioPaciente=scanner.nextLine();
	
	paciente.cadastrarPaciente(new Paciente_Sistema(paciente.gerarCodigoPaciente(),nomePaciente, 
	idadePaciente, generoPaciente, enderecoPaciente, emailPaciente, cpfPaciente, telefonePaciente, 
	convenioPaciente));
	
keyPress();
break;

case 2:
keyPress();
break;

case 3:
keyPress();
break;

case 4:
	
	System.out.println("\nListar todos os pacientes ");
	paciente.listarTodos();
	
keyPress();
break;

case 5:
	
	System.out.println("\nBuscar cadastro de paciente ");
	
	System.out.println("\nDigite o código do paciente : ");
	codigoPaciente=scanner.nextInt();
	
	paciente.procurarPorCodigoPaciente(codigoPaciente);
	
keyPress();
break;

case 6:
	
	System.out.println("\nDeletar paciente do sistema ");
	
	System.out.println("\nDigite o código do paciente : ");
	codigoPaciente=scanner.nextInt();
	
	paciente.deletarPaciente(codigoPaciente);
	
keyPress();
break;

case 7:
	
	System.out.println("\nAtualizar cadastro de paciente ");
	
	System.out.println("\nDigite o código do paciente : ");
	codigoPaciente=scanner.nextInt();
	
	if ( paciente.buscarNaCollection(codigoPaciente)!= null) {
		
		System.out.println("\nAtualize o nome do paciente: ");
		scanner.skip("\\R?");
		nomePaciente = scanner.nextLine();
		
		System.out.println("\nAtualize a idade do paciente: ");
		scanner.skip("\\R?");
		idadePaciente = scanner.nextInt();
		
		System.out.println("\nAtualize o endereço do paciente: ");
		scanner.skip("\\R?");
		enderecoPaciente = scanner.nextLine();
		
		System.out.println("\nAtualize o email do paciente: ");
		scanner.skip("\\R?");
		emailPaciente = scanner.nextLine();
		
		System.out.println("\nAtualize o telefone do paciente: ");
		scanner.skip("\\R?");
		telefonePaciente = scanner.nextLine();
		
		System.out.println("\nAtualize o convênio do paciente: ");
		scanner.skip("\\R?");
		convenioPaciente = scanner.nextLine();
		
		System.out.println("\nAtualize o gênero do paciente: ");
		scanner.skip("\\R?");
		generoPaciente = scanner.nextLine();
		
		System.out.println("\nAtualize o CPF do paciente: ");
		scanner.skip("\\R?");
		cpfPaciente = scanner.nextLine();
		
		paciente.atualizarCadastro(new Paciente_Sistema(codigoPaciente, nomePaciente, idadePaciente, generoPaciente, enderecoPaciente, emailPaciente, cpfPaciente, telefonePaciente, convenioPaciente));
		
	}
	
	
keyPress();
break;

default :
	
System.out.println("\nOpcão Invalida ");
keyPress();
}
}	
	}
public static void keyPress() {
		
	try {
		System.out.println("\n\nPressione Enter para Continuar ...");
		System.in.read();	
	}catch (IOException e) {
			
	System.out.println("\nVocê pressionou uma tecla diferente de Enter ! ");	
	}
		
}

}
