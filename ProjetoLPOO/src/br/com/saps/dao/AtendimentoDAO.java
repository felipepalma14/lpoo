package br.com.saps.dao;

import java.util.ArrayList;

import br.com.saps.modelo.Atendimento;

public class AtendimentoDAO {
	/*
	 * Metodo para inserir Atendimento no Array
	 * 
	 */
	public ArrayList<Atendimento> inserirAtendimento(ArrayList<Atendimento> atendimentos, Atendimento novoAtendimento) {
		atendimentos.add(novoAtendimento);
		return atendimentos;
	}

	/*
	 * Metodo Buscar Cliente Retorna um objeto do tipo Cliente de acordo com o
	 * codigo do cliente passado na assinatura do metodo
	 */
	public Atendimento buscarAtendimento(ArrayList<Atendimento> atendimentos, String codigo) throws Exception {
		for (Atendimento atendimento : atendimentos) {
			if (atendimento.getProtocolo().equals(codigo)) {
				return atendimento;
			}
		}
		return null;
	}

	// Verificar , está igual ao metodo buscar

	public ArrayList<Atendimento> excluirAtendimento(ArrayList<Atendimento> atendimentos, String codigo)
			throws NullPointerException {
		for (Atendimento atendimento : atendimentos) {
			if (atendimento.getProtocolo().equals(codigo)) {
				atendimentos.remove(atendimento);
				return atendimentos;
			}
		}
		return null;

	}

	public static String gerarProtocolo(ArrayList<Atendimento> atendimentos) {
		if (atendimentos.isEmpty()) {
			return "1000";
		}
		int tamanho = atendimentos.size() - 1;
		int ultimo = Integer.parseInt(atendimentos.get(tamanho).getProtocolo() + 1);
		return String.valueOf(ultimo);
	}

}
