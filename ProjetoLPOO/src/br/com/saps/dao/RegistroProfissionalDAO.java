package br.com.saps.dao;

import java.util.ArrayList;

import br.com.saps.modelo.Profissional;
import br.com.saps.modelo.RegistroProfissional;

public class RegistroProfissionalDAO {

	public ArrayList<RegistroProfissional> inserirRegistroProfissional(ArrayList<RegistroProfissional> registros,
			RegistroProfissional novoRegistro) {
		registros.add(novoRegistro);
		return registros;

	}

	/*
	 * Metodo Buscar Cliente Retorna um objeto do tipo Cliente de acordo com o
	 * codigo do cliente passado na assinatura do metodo
	 */
	public RegistroProfissional buscaRegistro(ArrayList<RegistroProfissional> registros, String id) {
		for (RegistroProfissional registroProfissional : registros) {
			if (registroProfissional.getId() == Long.parseLong(id)) {
				return registroProfissional;
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

	public ArrayList<RegistroProfissional> excluirProfissional(ArrayList<RegistroProfissional> registros, String id)
			throws NullPointerException {
		for (RegistroProfissional registroProfissional : registros) {
			if (registroProfissional.getId() == Long.parseLong(id)) {
				registros.remove(registroProfissional);
			}
		}
		return registros;
	}

	public static String gerarId(ArrayList<RegistroProfissional> registros) {
		if (registros.isEmpty()) {
			return "100";
		}
		int tamanho = registros.size() - 1;
		long ultimo = (registros.get(tamanho).getId()) + 1;
		return String.valueOf(ultimo);
	}

}
