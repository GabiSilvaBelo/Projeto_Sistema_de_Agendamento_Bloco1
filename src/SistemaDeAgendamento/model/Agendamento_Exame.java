package SistemaDeAgendamento.model;

public class Agendamento_Exame extends Paciente {
	
	private String dataAgendamentoExame;
	private String tipoExame;
	
	public Agendamento_Exame(int codigoPaciente, String nomePaciente, int idadePaciente, String generoPaciente,
			String enderecoPaciente, String emailPaciente, String cpfPaciente, String telefonePaciente,
			String convenioPaciente, String dataAgendamentoExame, String tipoExame) {
		super(codigoPaciente, nomePaciente, idadePaciente, generoPaciente, enderecoPaciente, emailPaciente, cpfPaciente,
				telefonePaciente, convenioPaciente);
		this.dataAgendamentoExame = dataAgendamentoExame;
		this.tipoExame = tipoExame;
	}

	public String getDataAgendamentoExame() {
		return dataAgendamentoExame;
	}

	public void setDataAgendamentoExame(String dataAgendamentoExame) {
		this.dataAgendamentoExame = dataAgendamentoExame;
	}

	public String getTipoExame() {
		return tipoExame;
	}

	public void setTipoExame(String tipoExame) {
		this.tipoExame = tipoExame;
	}

  // CRIAR MÉTODO MARCAR EXAME
}
