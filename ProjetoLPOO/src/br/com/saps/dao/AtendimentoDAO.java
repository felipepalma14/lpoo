package br.com.saps.dao;

import br.com.saps.modelo.Atendimento;

public class AtendimentoDAO {
	/*
	 * Metodo para inserir Atendimento no Array
	 * 
	 */
	public Atendimento[] inserirAtendimento(Atendimento[] atendimentos, Atendimento novoAtendimento)
			throws NullPointerException {
		Atendimento[] aux = null;
		// Verifica se o vetor está nulo
		if (atendimentos == null) {
			aux = new Atendimento[1];
			aux[0] = novoAtendimento;
		} else {
			// Copia todos os dados existentes para o novo vetor maior
			aux = new Atendimento[atendimentos.length + 1];
			for (int i = 0; i < atendimentos.length; i++) {
				aux[i] = atendimentos[i];
			}
			// adiciona o novo cliente no ultimo endereco do vetor
			aux[atendimentos.length] = novoAtendimento;
		}
		return aux;
	}

	/*
	 * Metodo Buscar Cliente Retorna um objeto do tipo Cliente de acordo com o
	 * codigo do cliente passado na assinatura do metodo
	 */
	public Atendimento buscarAtendimento(Atendimento[] atendimento, String protocolo) throws Exception {
		for (int i = 0; i < atendimento.length; i++) {
			if (atendimento[i].getProtocolo().equals(protocolo)) {
				return atendimento[i];
			}
		}
		return null;
	}

	/*
	 * Metodo mostrar Clientes mostrar todos os clientes cadastrados
	 */
	public void mostrarAtendimento(Atendimento[] atendimentos) {
		for (Atendimento atendimento : atendimentos) {
			System.out.println(atendimento);
			/*
			 * Verificar esse funcao para adequar a tela de apresentar todos
			 */
		}
	}

	public void editarAtendimento(Atendimento[] atendimentos, Atendimento atendimento) {
		/*
		 * 
		 * em desenvolvimento
		 */
	}

	public Atendimento[] excluirAtendimento(Atendimento[] atendimentos, String protocolo) throws NullPointerException {
		Atendimento[] novoArray = new Atendimento[atendimentos.length - 1];
		for (int i = 0; i < atendimentos.length; i++) {
			if (atendimentos[i].getMatricula().equals(protocolo)) {
				continue;// passa se cair aqui no if
			} else {
				novoArray[i] = atendimentos[i];
			}
		}
		return novoArray;
	}

	/*
	 * public Atendimento criarAtendimento(String nome, String matricula, String
	 * cpf, Data nasc, String sigla, String tipo, String registroProf) {
	 * Profissional novoProfissional = new Profissional();
	 * novoProfissional.setNome(nome); novoProfissional.setMatricula(matricula);
	 * novoProfissional.setCpf(cpf); novoProfissional.setSigla(sigla);
	 * novoProfissional.setTipo(tipo);
	 * novoProfissional.setNumeroRP(registroProf);
	 * novoProfissional.setData(nasc);
	 * 
	 * return novoProfissional; }
	 */
	public static String gerarProtocolo(Atendimento[] atendimentos) {
		if (atendimentos == null) {
			return "2015111";
		}
		int tamanho = atendimentos.length;
		return String.valueOf(Integer.parseInt(atendimentos[tamanho - 1].getProtocolo()) + 1);
	}
}
