package SistemaDeAgendamento.repository;

import SistemaDeAgendamento.model.Paciente;

public interface SistemaDeAgendamentoRepository {
	
//CRUD SISTEMA DE AGENDAMENTO // CRIAR, LER, ATUALIZAR, DELETAR
	
	public void cadastrarPaciente(Paciente paciente);
	public void listarTodos ();
	public void deletarPaciente(int codigoPaciente);
	public void atualizarCadastro(Paciente paciente);
	
// METODOS DO SISTEMA
	
	public void marcarConsulta ();
	public void marcarExame();
}
