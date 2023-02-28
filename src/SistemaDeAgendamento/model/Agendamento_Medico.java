package SistemaDeAgendamento.model;

public class Agendamento_Medico extends Paciente {
	
	private String dataAgendamentoMedico; 
	private int especialidade;

	public Agendamento_Medico(int codigoPaciente, String nomePaciente, int idadePaciente, String generoPaciente,
			String enderecoPaciente, String emailPaciente, String cpfPaciente, String telefonePaciente,
			String convenioPaciente, String dataAgendamentoMedico, int especialidade) {
		super(codigoPaciente, nomePaciente, idadePaciente, generoPaciente, enderecoPaciente, emailPaciente, cpfPaciente,
				telefonePaciente, convenioPaciente);
		this.dataAgendamentoMedico = dataAgendamentoMedico;
		this.especialidade = especialidade;
	}

	public String getDataAgendamentoMedico() {
		return dataAgendamentoMedico;
	}

	public void setDataAgendamentoMedico(String dataAgendamentoMedico) {
		this.dataAgendamentoMedico = dataAgendamentoMedico;
	}

	public int getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(int especialidade) {
		this.especialidade = especialidade;
	}

	// CRIAR M�TODO MARCAR CONSULTA
	/*public boolean marcarDataConsulta (String dataAgendamentoMedico) {
		if(this.getDataAgendamentoMedico() == null) {
			System.out.println("\nInsira uma data do tipo DD/MM/AA");
			return false;
		}
		this.setDataAgendamentoMedico(dataAgendamentoMedico);
		return true;
	}*/
}
