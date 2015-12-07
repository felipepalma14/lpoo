package br.com.saps.modelo;

public class TipoProfissional {
	private long id;
	private String descricao;

	public TipoProfissional(long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return id + " - " + descricao;
	}

}
