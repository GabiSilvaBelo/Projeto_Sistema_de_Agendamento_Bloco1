package SistemaDeAgendamento.controller;

import java.util.ArrayList;
import java.util.Scanner;

import SistemaDeAgendamento.model.Paciente;
import SistemaDeAgendamento.repository.SistemaDeAgendamentoRepository;

public class SistemaDeAgendamentoController implements SistemaDeAgendamentoRepository {

	Scanner scanner = new Scanner(System.in);
	private ArrayList<Paciente> ListaPacientes = new ArrayList<Paciente>();

	@Override
	public void cadastrarPaciente(Paciente paciente) {
		ListaPacientes.add(paciente);
		System.out.println("\nO paciente foi criado com o c�digo : " + paciente.getCodigoPaciente());
	}

	@Override
	public void listarTodos() {
		for (var paciente : ListaPacientes) {
			paciente.visualizarDados();
		}

	}

	@Override
	public void atualizarCadastro(Paciente paciente) {
		var buscarCadastro = buscarNaCollection(paciente.getCodigoPaciente());

		if (buscarCadastro != null) {
			ListaPacientes.set(ListaPacientes.indexOf(buscarCadastro), paciente);
			System.out.println("\nO cadastro do paciente com o c�digo " + paciente.getCodigoPaciente()
					+ " foi atualizado com sucesso ! ");
		} else

			System.out.println(
					"\nO cadastro do paciente com o c�digo " + paciente.getCodigoPaciente() + " n�o foi encontrado !!");
	}

	@Override
	public void marcarConsulta() {
		int codigoPaciente, especialidade;
		String data;
		System.out.println("Insira o código do paciente:");
		codigoPaciente = scanner.nextInt();

		var pacienteConsulta = buscarNaCollection(codigoPaciente);

		if (pacienteConsulta != null) {
			do {
				System.out.println("Insira a especialidade da consulta:");
				System.out.println("1 - Clínico Geral");
				System.out.println("2 - Ortopedista");
				especialidade = scanner.nextInt();

				if (especialidade != 1 && especialidade != 2) {
					System.out.println("Opção inválida. Tente novamente.");
				}
			} while (especialidade != 1 && especialidade != 2);

			switch (especialidade) {
			case 1:
				do {
					System.out.println("Data de preferência:");
					System.out.println("01/03");
					System.out.println("05/03");
					System.out.println("10/03");
					System.out.println("15/03");
					data = scanner.next();

					if (!data.equals("01/03") && !data.equals("05/03") && !data.equals("10/03")
							&& !data.equals("15/03")) {
						System.out.println("Data inválida. Tente novamente.");
					}
				} while (!data.equals("01/03") && !data.equals("05/03") && !data.equals("10/03")
						&& !data.equals("15/03"));

				System.out.println("Consulta agendada!");
				System.out.println("Paciente " + pacienteConsulta.getNomePaciente() + " agendado para " + data);
				break;

			case 2:
				do {
					System.out.println("Data de preferência:");
					System.out.println("01/03");
					System.out.println("05/03");
					System.out.println("10/03");
					System.out.println("15/03");
					data = scanner.next();

					if (!data.equals("01/03") && !data.equals("05/03") && !data.equals("10/03")
							&& !data.equals("15/03")) {
						System.out.println("Data inválida. Tente novamente.");
					}
				} while (!data.equals("01/03") && !data.equals("05/03") && !data.equals("10/03")
						&& !data.equals("15/03"));

				System.out.println("Consulta agendada!");
				System.out.println("Paciente " + pacienteConsulta.getNomePaciente() + " agendado para " + data);
				break;
			}
		} else {
			System.out.println("O código inserido não foi encontrado!");
		}

	}

	@Override
	public void marcarExame(int codigoPaciente) {

		String dataAgendamentoExame;
		var pacienteExame = buscarNaCollection(codigoPaciente);

		if (pacienteExame != null) {
			/*
			 * System.out.println("Informe a data do agendamento do exame (dd/mm):"); String
			 * dataAgendamentoExame = scanner.next();
			 */

			System.out.println("Selecione o tipo de exame:");
			System.out.println("1 - Hemograma");
			System.out.println("2 - Glicemia");
			System.out.println("3 - Raio-X");
			System.out.println("4 - Ultrassonografia");
			System.out.println("5 - Tomografia");
			int tipoExameSelecionado = scanner.nextInt();

			String tipoExame = "";

			switch (tipoExameSelecionado) {
			case 1:
				tipoExame = "Hemograma";
				break;
			case 2:
				tipoExame = "Glicemia";
				break;
			case 3:
				tipoExame = "Raio-X";
				break;
			case 4:
				tipoExame = "Ultrassonografia";
				break;
			case 5:
				tipoExame = "Tomografia";
				break;
			default:
				System.out.println("Opção inválida!");
				return;
			}

			do {
				System.out.println("Data de preferência:");
				System.out.println("07/03");
				System.out.println("14/03");
				System.out.println("21/03");
				System.out.println("28/03");
				dataAgendamentoExame = scanner.next();

				if (!dataAgendamentoExame.equals("07/03") && !dataAgendamentoExame.equals("14/03")
						&& !dataAgendamentoExame.equals("21/03") && !dataAgendamentoExame.equals("28/03")) {
					System.out.println("Data inválida. Tente novamente.");
				}
			} while (!dataAgendamentoExame.equals("07/03") && !dataAgendamentoExame.equals("14/03")
					&& !dataAgendamentoExame.equals("21/03") && !dataAgendamentoExame.equals("28/03"));

			System.out.println("\nAgendamento do exame realizado com sucesso para o/a paciente "
					+ pacienteExame.getNomePaciente() + "!");
			System.out.println("Data do agendamento: " + dataAgendamentoExame);
			System.out.println("Tipo de exame: " + tipoExame);
		}
	}

	@Override
	public void deletarPaciente(int codigoPaciente) {
		var paciente = buscarNaCollection(codigoPaciente);

		if (paciente != null) {
			if (ListaPacientes.remove(paciente) == true)
				System.out.println("\nO paciente com o c�digo " + codigoPaciente
						+ " foi deletado com sucesso da base de dados ! ");

		} else
			System.out.println("\nO paciente com o c�digo " + codigoPaciente + " nao foi encontrado ! ");

	}

	// METODOS AUXILIARES

	public int gerarCodigoPaciente() {
		return ListaPacientes.size() + 1;
	}

	public Paciente buscarNaCollection(int codigoPaciente) {

		for (var paciente : ListaPacientes) {
			if (paciente.getCodigoPaciente() == codigoPaciente) {
				return paciente;
			}

		}
		return null;
	}

	public void procurarPorCodigoPaciente(int codigoPaciente) {
		var paciente = buscarNaCollection(codigoPaciente);

		if (paciente != null)
			paciente.visualizarDados();

		else
			System.out.println("\nO paciente com o c�digo " + codigoPaciente + " n�o foi encontrado ! ");
	}

}
