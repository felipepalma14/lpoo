package br.com.saps.dao;

import java.util.ArrayList;

import br.com.saps.modelo.Data;
import br.com.saps.modelo.Profissional;

public class ProfissionalDAO {
	public ArrayList<Profissional> inserirProfissional(ArrayList<Profissional> profissionais,
			Profissional novoProfissional) {
		profissionais.add(novoProfissional);
		return profissionais;
	}

	/*
	 * Metodo Buscar Cliente Retorna um objeto do tipo Cliente de acordo com o
	 * codigo do cliente passado na assinatura do metodo
	 */
	public Profissional buscarProfissional(ArrayList<Profissional> profissionais, String matricula) throws Exception {
		for (Profissional profissional : profissionais) {
			if (profissional.getMatricula().equals(matricula)) {
				return profissional;
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

	// Verificar , está igual ao metodo buscar
	public Profissional editarProfissioanal(Profissional[] profissionais, String matricula) {
		for (Profissional profissional : profissionais) {
			// Verifica se matricula existe no vetor de profissionais
			if (profissional.getMatricula().equals(matricula)) {
				return profissional;
			}
		}
		return null;
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

	public static String gerarMatricula(ArrayList<Profissional> profissionais) {
		if (profissionais.isEmpty()) {
			return "20151";
		}
		int tamanho = profissionais.size() - 1;
		int ultimo = Integer.parseInt(profissionais.get(tamanho).getMatricula()) + 1;
		return String.valueOf(ultimo);
	}
}
