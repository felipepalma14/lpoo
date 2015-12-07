package br.com.saps.dao;

import java.util.ArrayList;

import br.com.saps.modelo.Cliente;

public class ClienteDAO {

	public ArrayList<Cliente> inserirCliente(ArrayList<Cliente> clientes, Cliente novoCliente) {
		clientes.add(novoCliente);
		return clientes;
	}

	/*
	 * Metodo Buscar Cliente Retorna um objeto do tipo Cliente de acordo com o
	 * codigo do cliente passado na assinatura do metodo
	 */
	public Cliente buscarCliente(ArrayList<Cliente> clientes, String codigo) throws Exception {
		for (Cliente cliente : clientes) {
			if (cliente.getCodigo() == Integer.parseInt(codigo)) {
				return cliente;
			}
		}
		return null;
	}

	// Verificar , está igual ao metodo buscar

	public ArrayList<Cliente> excluirCliente(ArrayList<Cliente> clientes, String codigo) throws NullPointerException {
		for (Cliente cliente : clientes) {
			if (cliente.getCodigo() == Integer.parseInt(codigo)) {
				clientes.remove(cliente);
				return clientes;
			}
		}
		return null;

	}

	public static String gerarCodigo(ArrayList<Cliente> clientes) {
		if (clientes.isEmpty()) {
			return "1000";
		}
		int tamanho = clientes.size() - 1;
		long ultimo = clientes.get(tamanho).getCodigo() + 1;
		return String.valueOf(ultimo);
	}

}
