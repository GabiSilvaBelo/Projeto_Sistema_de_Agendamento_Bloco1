package SistemaDeAgendamento.model;

public abstract class Paciente {
	
	private int codigoPaciente;
	private String nomePaciente;
	private int idadePaciente;
	private String generoPaciente;
	private String enderecoPaciente;
	private String emailPaciente;
	private String cpfPaciente;
	private String telefonePaciente;
	private String convenioPaciente;
	
	public Paciente(int codigoPaciente, String nomePaciente, int idadePaciente, String generoPaciente,
			String enderecoPaciente, String emailPaciente, String cpfPaciente, String telefonePaciente,
			String convenioPaciente) {
		super();
		this.codigoPaciente = codigoPaciente;
		this.nomePaciente = nomePaciente;
		this.idadePaciente = idadePaciente;
		this.generoPaciente = generoPaciente;
		this.enderecoPaciente = enderecoPaciente;
		this.emailPaciente = emailPaciente;
		this.cpfPaciente = cpfPaciente;
		this.telefonePaciente = telefonePaciente;
		this.convenioPaciente = convenioPaciente;
	}

	public int getCodigoPaciente() {
		return codigoPaciente;
	}

	public void setCodigoPaciente(int codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public int getIdadePaciente() {
		return idadePaciente;
	}

	public void setIdadePaciente(int idadePaciente) {
		this.idadePaciente = idadePaciente;
	}

	public String getGeneroPaciente() {
		return generoPaciente;
	}

	public void setGeneroPaciente(String generoPaciente) {
		this.generoPaciente = generoPaciente;
	}

	public String getEnderecoPaciente() {
		return enderecoPaciente;
	}

	public void setEnderecoPaciente(String enderecoPaciente) {
		this.enderecoPaciente = enderecoPaciente;
	}

	public String getEmailPaciente() {
		return emailPaciente;
	}

	public void setEmailPaciente(String emailPaciente) {
		this.emailPaciente = emailPaciente;
	}

	public String getCpfPaciente() {
		return cpfPaciente;
	}

	public void setCpfPaciente(String cpfPaciente) {
		this.cpfPaciente = cpfPaciente;
	}

	public String getTelefonePaciente() {
		return telefonePaciente;
	}

	public void setTelefonePaciente(String telefonePaciente) {
		this.telefonePaciente = telefonePaciente;
	}

	public String getConvenioPaciente() {
		return convenioPaciente;
	}

	public void setConvenioPaciente(String convenioPaciente) {
		this.convenioPaciente = convenioPaciente;
	}
	
	public void visualizarDados() {
		System.out.println("\nDados do paciente:");
		System.out.println("\nNome: "+this.nomePaciente);
		System.out.println("\nIdade: "+this.idadePaciente);
		System.out.println("\nGênero: "+this.generoPaciente);
		System.out.println("\nEndereço: "+this.emailPaciente);
		System.out.println("\nCPF: "+this.cpfPaciente);
		System.out.println("\nTelefone: "+this.telefonePaciente);
		System.out.println("\nConvênio: "+this.convenioPaciente);
		System.out.println("\nCódigo do Paciente: "+this.codigoPaciente);
		System.out.println("\n");
	}
	
}
