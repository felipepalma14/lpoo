package br.com.saps.modelo;

import br.com.saps.dao.ClienteDAO;

public class teste {

	public static void main(String[] args) {
		Cliente[] arquivoCliente = null;
		ClienteDAO clienteDAO = new ClienteDAO();

		Data nasc = new Data(4, 10, 1993);
		Cliente felipe = new Cliente(1, "Felipe Cunha", nasc, 'M');
		Cliente eliezer = new Cliente(2, "Eliezer Silva", nasc, 'M');

		arquivoCliente = clienteDAO.inserir(arquivoCliente, felipe);

		arquivoCliente = clienteDAO.inserir(arquivoCliente, eliezer);

		Profissional sidney = new Profissional("123", "00000-0000", "Sidney", "24", "YMCA", "Dentista", nasc);

		Atendimento ficha = new Atendimento("222", sidney, felipe, "Eu tava Doente", nasc);

		clienteDAO.mostrarClientes(arquivoCliente);

		System.out.println("Resultado: " + clienteDAO.buscarCliente(arquivoCliente, felipe.getCodigo()));

	}

}
