package br.com.saps.dao;

import br.com.saps.modelo.Cliente;

public class ClienteDAO {

	/*
	 * Metodo para Inserção
	 */
	public Cliente[] inserir(Cliente[] clientes, Cliente novoCliente) {
		Cliente[] aux = null;
		// Verifica se o vetor está nulo
		if (clientes == null) {
			aux = new Cliente[1];
			aux[0] = novoCliente;

		} else {
			// Copia todos os dados existentes para o novo vetor maior
			aux = new Cliente[clientes.length + 1];
			for (int i = 0; i < clientes.length; i++) {
				aux[i] = clientes[i];
				// System.out.println(aux[i] + " " + i);
			}
			// adiciona o novo cliente no ultimo endereco do vetor
			aux[clientes.length] = novoCliente;
		}
		return aux;
	}

	/*
	 * Metodo Buscar Cliente Retorna um objeto do tipo Cliente de acordo com o
	 * codigo do cliente passado na assinatura do metodo
	 */
	public Cliente buscarCliente(Cliente[] clientes, int codigo) {
		for (int i = 0; i < clientes.length; i++) {
			if (clientes[i].getCodigo() == codigo) {
				return clientes[i];
			}
		}
		return null;
	}

	/*
	 * Metodo mostrar Clientes mostrar todos os clientes cadastrados
	 */
	public void mostrarClientes(Cliente[] clientes) {
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
	}

	public void editarCliente(Cliente[] clientes, Cliente cliente) {
		/*
		 * 
		 * em desenvolvimento
		 */
	}
}
