package br.com.saps.dao;

import br.com.saps.modelo.Data;
import br.com.saps.modelo.Profissional;

public class ProfissionalDAO {
	public Profissional[] inserirProfissional(Profissional[] profissionais, Profissional novoProfissional) {
		Profissional[] aux = null;
		// Verifica se o vetor está nulo
		if (profissionais == null) {
			aux = new Profissional[1];
			aux[0] = novoProfissional;

		} else {
			// Copia todos os dados existentes para o novo vetor maior
			aux = new Profissional[profissionais.length + 1];
			for (int i = 0; i < profissionais.length; i++) {
				aux[i] = profissionais[i];
				// System.out.println(aux[i] + " " + i);
			}
			// adiciona o novo cliente no ultimo endereco do vetor
			aux[profissionais.length] = novoProfissional;
		}
		return aux;
	}

	/*
	 * Metodo Buscar Cliente Retorna um objeto do tipo Cliente de acordo com o
	 * codigo do cliente passado na assinatura do metodo
	 */
	public Profissional buscarProfissional(Profissional[] profissionais, String matricula) throws Exception {
		for (int i = 0; i < profissionais.length; i++) {
			if (profissionais[i].getMatricula().equals(matricula)) {
				return profissionais[i];
			}
		}
		return null;
	}

	/*
	 * Metodo mostrar Clientes mostrar todos os clientes cadastrados
	 */
	public void mostrarProfissional(Profissional[] profissionais) {
		for (Profissional profissinal : profissionais) {
			System.out.println(profissinal);
		}
	}

	public void editarProfissioanal(Profissional[] profissionais, Profissional profissional) {
		/*
		 * 
		 * em desenvolvimento
		 */
	}

	public Profissional[] excluirProfissional(Profissional[] profissionais, String matricula)
			throws NullPointerException {
		Profissional[] novoArray = new Profissional[profissionais.length - 1];
		for (int i = 0; i < profissionais.length; i++) {
			if (profissionais[i].getMatricula().equals(matricula)) {
				continue;
			} else {
				novoArray[i] = profissionais[i];
			}
		}
		return novoArray;
	}

	public Profissional criarProfissional(String nome, String matricula, String cpf, Data nasc, String sigla,
			String tipo, String registroProf) {
		Profissional novoProfissional = new Profissional();
		novoProfissional.setNome(nome);
		novoProfissional.setMatricula(matricula);
		novoProfissional.setCpf(cpf);
		novoProfissional.setSigla(sigla);
		novoProfissional.setTipo(tipo);
		novoProfissional.setNumeroRP(registroProf);
		novoProfissional.setData(nasc);

		return novoProfissional;
	}

	public static String gerarMatricula(Profissional[] profissionais) {
		if (profissionais == null) {
			return "20151";
		}
		int tamanho = profissionais.length;
		return String.valueOf(Integer.parseInt(profissionais[tamanho - 1].getMatricula()) + 1);
	}
}
