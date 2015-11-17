package br.com.projeto.models;

/*
 *Classe modelo 
 * */
public class Correspondencia {
	private int codigoForum;
	private String nomeForum;
	private int codigoVara;
	private String nomeVara;
	private String dataPost;
	private String dataDevol;
	private String situacaoAR;
	private String tipoAR;
	private String codigoAR;
	private int totalAR;

	public int getTotalAR() {
		return totalAR;
	}

	public void setTotalAR(int totalAR) {
		this.totalAR = totalAR;
	}

	public int getCodigoForum() {
		return codigoForum;
	}

	public void setCodigoForum(int codigoForum) {
		this.codigoForum = codigoForum;
	}

	public String getNomeForum() {
		return nomeForum;
	}

	public void setNomeForum(String nomeForum) {
		this.nomeForum = nomeForum;
	}

	public int getCodigoVara() {
		return codigoVara;
	}

	public void setCodigoVara(int codigoVara) {
		this.codigoVara = codigoVara;
	}

	public String getNomeVara() {
		return nomeVara;
	}

	public void setNomeVara(String nomeVara) {
		this.nomeVara = nomeVara;
	}

	public String getDataPost() {
		return dataPost;
	}

	public void setDataPost(String dataPost) {
		this.dataPost = dataPost;
	}

	public String getDataDevol() {
		return dataDevol;
	}

	public void setDataDevol(String dataDevol) {
		this.dataDevol = dataDevol;
	}

	public String getSituacaoAR() {
		return situacaoAR;
	}

	public void setSituacaoAR(String situacaoAR) {
		this.situacaoAR = situacaoAR;
	}

	public String getTipoAR() {
		return tipoAR;
	}

	public void setTipoAR(String tipoAR) {
		this.tipoAR = tipoAR;
	}

	public String getCodigoAR() {
		return codigoAR;
	}

	public void setCodigoAR(String codigoAR) {
		this.codigoAR = codigoAR;
	}

}
