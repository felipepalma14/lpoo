package br.com.saps.modelo;

public class Data {
	private int dia, mes, ano;

	public Data(int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public static Data montaData(String dia, String mes, String ano) throws NumberFormatException {
		return new Data(Integer.parseInt(dia), Integer.parseInt(mes), Integer.parseInt(ano));
	}

	@Override
	public String toString() {
		String diaAcrescimo = "", mesAcrecimo = "";
		for (int i = 1; i < 10; i++) {
			if (dia == i) {
				diaAcrescimo = "0";
			}
			if (mes == i) {
				mesAcrecimo = "0";
			}
		}
		return "" + diaAcrescimo + dia + mesAcrecimo + mes + ano;
	}

}
