package SistemaDeAgendamento.controller;

import java.util.ArrayList;

import SistemaDeAgendamento.model.Paciente;
import SistemaDeAgendamento.repository.SistemaDeAgendamentoRepository;

public class SistemaDeAgendamentoController implements SistemaDeAgendamentoRepository {

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
	}

	@Override
	public void marcarExame(int codigoPaciente) {

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
