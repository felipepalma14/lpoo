package br.com.saps.modelo;

public class Atendimento {
	private String protocolo;
	private Profissional profissional;
	private Cliente cliente;
	private String descrição;
	private Data dataCriacao;
	private String Especialidade;

	public String getEspecialidade() {
		return Especialidade;
	}

	public void setEspecialidade(String especialidade) {
		Especialidade = especialidade;
	}

	public Atendimento(String protocolo, Profissional profissional, Cliente cliente, String descrição, Data dataCriacao,
			String especialidade) {
		super();
		this.protocolo = protocolo;
		this.profissional = profissional;
		this.cliente = cliente;
		this.descrição = descrição;
		this.dataCriacao = dataCriacao;
		Especialidade = especialidade;
	}

	public String getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

	public Data getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Data dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
	public String toString() {
		return "Atendimento [protocolo=" + protocolo + ", profissional=" + profissional + ", cliente=" + cliente
				+ ", descrição=" + descrição + ", dataCriacao=" + dataCriacao + ", Especialidade=" + Especialidade
				+ "]";
	}

}
