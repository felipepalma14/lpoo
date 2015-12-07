package br.com.saps.dao;

import java.util.ArrayList;

import br.com.saps.modelo.TipoProfissional;

public class TipoProfissionalDAO {
	public ArrayList<TipoProfissional> inserirTipo(ArrayList<TipoProfissional> tipos, TipoProfissional novoTipo) {
		tipos.add(novoTipo);
		return tipos;
	}

	/*
	 * Metodo Buscar Cliente Retorna um objeto do tipo Cliente de acordo com o
	 * codigo do cliente passado na assinatura do metodo
	 */
	public TipoProfissional buscarTipo(ArrayList<TipoProfissional> tipos, String codigo) throws Exception {
		for (TipoProfissional tipo : tipos) {
			if (tipo.getId() == Long.parseLong(codigo)) {
				return tipo;
			}
		}
		return null;
	}

	// Verificar , está igual ao metodo buscar

	public ArrayList<TipoProfissional> excluirTipo(ArrayList<TipoProfissional> tipos, String codigo)
			throws NullPointerException {
		for (TipoProfissional tipoProfissional : tipos) {
			if (tipoProfissional.getId() == Long.parseLong(codigo)) {
				tipos.remove(tipoProfissional);
				return tipos;
			}
		}
		return null;

	}

	public static String gerarCodigo(ArrayList<TipoProfissional> tipos) {
		if (tipos.isEmpty()) {
			return "200";
		}
		int tamanho = tipos.size() - 1;
		long ultimo = tipos.get(tamanho).getId() + 1;
		return String.valueOf(ultimo);
	}

}
