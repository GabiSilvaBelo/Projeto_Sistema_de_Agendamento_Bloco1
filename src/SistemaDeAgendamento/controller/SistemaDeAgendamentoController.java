package SistemaDeAgendamento.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import SistemaDeAgendamento.model.Agendamento_Exame;
import SistemaDeAgendamento.model.Agendamento_Medico;
import SistemaDeAgendamento.model.Paciente;
import SistemaDeAgendamento.repository.SistemaDeAgendamentoRepository;

public class SistemaDeAgendamentoController implements SistemaDeAgendamentoRepository {

	Scanner scanner = new Scanner(System.in);
	private List<Agendamento_Exame> listaAgendamentosExames = new ArrayList<>();
	private List<Agendamento_Medico> listaAgendamentosMedicos = new ArrayList<>();
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
		String dataAgendamentoMedico;
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
					dataAgendamentoMedico = scanner.next();

					if (!dataAgendamentoMedico.equals("01/03") && !dataAgendamentoMedico.equals("05/03")
							&& !dataAgendamentoMedico.equals("10/03") && !dataAgendamentoMedico.equals("15/03")) {
						System.out.println("Data inválida. Tente novamente.");
					}
				} while (!dataAgendamentoMedico.equals("01/03") && !dataAgendamentoMedico.equals("05/03")
						&& !dataAgendamentoMedico.equals("10/03") && !dataAgendamentoMedico.equals("15/03"));

				System.out.println("Consulta agendada!");
				System.out.println("Paciente " + codigoPaciente + " agendado para " + dataAgendamentoMedico);
				
				Agendamento_Medico agendamentoConsultaOrtopedista = new Agendamento_Medico(pacienteConsulta.getCodigoPaciente(),
						pacienteConsulta.getNomePaciente(), pacienteConsulta.getIdadePaciente(),
						pacienteConsulta.getGeneroPaciente(), pacienteConsulta.getEnderecoPaciente(),
						pacienteConsulta.getEmailPaciente(), pacienteConsulta.getCpfPaciente(),
						pacienteConsulta.getTelefonePaciente(), pacienteConsulta.getConvenioPaciente(),
						dataAgendamentoMedico, especialidade);
				listaAgendamentosMedicos.add(agendamentoConsultaOrtopedista);
				break;

			case 2:
				do {
					System.out.println("Data de preferência:");
					System.out.println("01/03");
					System.out.println("05/03");
					System.out.println("10/03");
					System.out.println("15/03");
					dataAgendamentoMedico = scanner.next();

					if (!dataAgendamentoMedico.equals("01/03") && !dataAgendamentoMedico.equals("05/03")
							&& !dataAgendamentoMedico.equals("10/03") && !dataAgendamentoMedico.equals("15/03")) {
						System.out.println("Data inválida. Tente novamente.");
					}
				} while (!dataAgendamentoMedico.equals("01/03") && !dataAgendamentoMedico.equals("05/03")
						&& !dataAgendamentoMedico.equals("10/03") && !dataAgendamentoMedico.equals("15/03"));

				Agendamento_Medico agendamentoConsultaGeral = new Agendamento_Medico(pacienteConsulta.getCodigoPaciente(),
						pacienteConsulta.getNomePaciente(), pacienteConsulta.getIdadePaciente(),
						pacienteConsulta.getGeneroPaciente(), pacienteConsulta.getEnderecoPaciente(),
						pacienteConsulta.getEmailPaciente(), pacienteConsulta.getCpfPaciente(),
						pacienteConsulta.getTelefonePaciente(), pacienteConsulta.getConvenioPaciente(),
						dataAgendamentoMedico, especialidade);
				listaAgendamentosMedicos.add(agendamentoConsultaGeral);
				
				System.out.println(listaAgendamentosMedicos.isEmpty());

				System.out.println("Consulta agendada!");
				System.out.println("Paciente " + codigoPaciente + " agendado para " + dataAgendamentoMedico);
				break;
			}

		}
	}

	@Override
	public void marcarExame(int codigoPaciente) {

		String dataAgendamentoExame;
		var pacienteExame = buscarNaCollection(codigoPaciente);

		if (pacienteExame != null) {

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

			Agendamento_Exame agendamentoExame = new Agendamento_Exame(pacienteExame.getCodigoPaciente(),
					pacienteExame.getNomePaciente(), pacienteExame.getIdadePaciente(),
					pacienteExame.getGeneroPaciente(), pacienteExame.getEnderecoPaciente(),
					pacienteExame.getEmailPaciente(), pacienteExame.getCpfPaciente(),
					pacienteExame.getTelefonePaciente(), pacienteExame.getConvenioPaciente(), dataAgendamentoExame,
					tipoExame);
			listaAgendamentosExames.add(agendamentoExame);

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

	public void mostrarAgendamentos() {
	    System.out.println("Agendamentos de exames:");
	    for (Agendamento_Exame agendamento : listaAgendamentosExames) {
	        System.out.println(
	        		agendamento.getNomePaciente() + " - "
	        + agendamento.getDataAgendamentoExame() +
	                " - " + agendamento.getTipoExame());
	    }

	    System.out.println("Agendamentos de consultas:");
	    for (Agendamento_Medico agendamento : listaAgendamentosMedicos) {
	        System.out.println(agendamento.getNomePaciente() + " - " + agendamento.getDataAgendamentoMedico() +
	                " - " + (agendamento.getEspecialidade() == 1 ? "Clínico Geral" : "Ortopedista"));
	    }
	}

}
