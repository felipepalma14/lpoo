package br.com.saps.utils;

import java.util.ArrayList;

import br.com.saps.modelo.Cliente;
import br.com.saps.modelo.Profissional;
import br.com.saps.modelo.RegistroProfissional;
import br.com.saps.modelo.TipoProfissional;

public class Conexao {
	/*
	 * Aplicando o padrao de projeto Singleton para gerenciar a conexao com
	 * array
	 */
	private ArrayList<Profissional> profissionais = new ArrayList<>();
	private ArrayList<RegistroProfissional> registros = new ArrayList<>();
	private ArrayList<TipoProfissional> tipos = new ArrayList<>();
	private ArrayList<Cliente> clientes = new ArrayList<>();

	private static Conexao instance;

	private Conexao() {

	}

	public static Conexao getInstance() {
		if (instance == null) {
			instance = new Conexao();
		}
		return instance;
	}

	public ArrayList<Profissional> getArrayListProfissional() {
		return profissionais;
	}

	public ArrayList<Cliente> getArrayListCliente() {
		return clientes;
	}

	public ArrayList<TipoProfissional> getArrayListTipoProfissional() {
		return tipos;
	}

	public ArrayList<RegistroProfissional> getArrayListRegistro() {
		return registros;
	}
}
