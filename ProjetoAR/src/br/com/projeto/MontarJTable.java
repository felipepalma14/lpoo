package br.com.projeto;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import br.com.projeto.models.Correspondencia;

public class MontarJTable extends AbstractTableModel {

	private ArrayList dados;
	private String[] colunas;

	public MontarJTable(ArrayList linhas, String[] colunas) {
		this.dados = linhas;
		this.colunas = colunas;
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return dados.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int colIndex) {
		if (dados != null && rowIndex >= 0 && rowIndex < dados.size()) {
			Correspondencia correspondencia = (Correspondencia) dados.get(rowIndex);

			switch (colIndex) {
			case 0:
				return correspondencia.getNomeVara();
			case 1:
				return correspondencia.getTipoAR();
			case 2:
				return correspondencia.getTotalAR();
			}
		}
		return null;
	}

	@Override
	public String getColumnName(int colIndex) {
		return colunas[colIndex];
	}

}
