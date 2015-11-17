package br.com.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.projeto.models.Correspondencia;

public class CorrespondenciaDAO {
	private Connection conexao;
	private Statement stmt;
	private ResultSet resultSet;

	private PreparedStatement pstmt;

	/*
	 * Metodo que lista todos os dados
	 */
	public ArrayList listarCorrespondencias() {
		conexao = ConnectionFactory.getConnection();
		ArrayList correspondencias = new ArrayList();
		String sql = "SELECT AR,FORUM FROM projetoteste.aviso_recebimento";

		try {
			stmt = conexao.prepareStatement(sql);
			resultSet = stmt.executeQuery(sql);
			while (resultSet.next()) {
				Correspondencia correspondencia = new Correspondencia();
				correspondencia.setCodigoAR(resultSet.getString("AR"));
				correspondencia.setNomeForum(resultSet.getString("FORUM"));
				correspondencias.add(correspondencia);
			}
			ConnectionFactory.close(conexao, stmt, resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return correspondencias;
	}

	public ArrayList<Correspondencia> listarVaras() {
		conexao = ConnectionFactory.getConnection();
		ArrayList varas = new ArrayList();
		String sql = "SELECT DISTINCT VARA FROM projetoteste.aviso_recebimento";

		try {
			stmt = conexao.prepareStatement(sql);
			resultSet = stmt.executeQuery(sql);
			while (resultSet.next()) {
				Correspondencia vara = new Correspondencia();
				vara.setNomeVara(resultSet.getString("VARA"));
				varas.add(vara);
			}
			ConnectionFactory.close(conexao, stmt, resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return varas;
	}

	public ArrayList<Correspondencia> listarTiposAR() {
		conexao = ConnectionFactory.getConnection();
		ArrayList tipos = new ArrayList();
		String sql = "select distinct tipo_de_ar from projetoteste.aviso_recebimento limit 2";

		try {
			stmt = conexao.prepareStatement(sql);
			resultSet = stmt.executeQuery(sql);
			while (resultSet.next()) {
				Correspondencia tipo = new Correspondencia();
				tipo.setTipoAR(resultSet.getString("TIPO_DE_AR"));
				tipos.add(tipo);
			}
			ConnectionFactory.close(conexao, stmt, resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tipos;
	}

	public ArrayList<Correspondencia> listarPorVaraTipo(String vara, String tipo) {
		conexao = ConnectionFactory.getConnection();
		ArrayList retorno = new ArrayList();
		String sql = "select VARA, TIPO_DE_AR,count(*) as total from projetoteste.aviso_recebimento where VARA = '"
				+ vara + "' and tipo_de_ar = '" + tipo + "' group by vara";
		try {
			stmt = conexao.prepareStatement(sql);
			resultSet = stmt.executeQuery(sql);
			while (resultSet.next()) {
				Correspondencia linha = new Correspondencia();
				linha.setTipoAR(resultSet.getString("TIPO_DE_AR"));
				linha.setNomeVara(resultSet.getString("VARA"));
				linha.setTotalAR(resultSet.getInt("total"));
				retorno.add(linha);
			}
			ConnectionFactory.close(conexao, stmt, resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return retorno;
	}

	public ArrayList<Correspondencia> listarSituacao() {
		conexao = ConnectionFactory.getConnection();
		ArrayList retorno = new ArrayList();
		String sql = "select VARA, TIPO_DE_AR,count(*) as total from projetoteste.aviso_recebimento";
		try {
			stmt = conexao.prepareStatement(sql);
			resultSet = stmt.executeQuery(sql);
			while (resultSet.next()) {
				Correspondencia linha = new Correspondencia();
				linha.setTipoAR(resultSet.getString("TIPO_DE_AR"));
				linha.setNomeVara(resultSet.getString("VARA"));
				linha.setTotalAR(resultSet.getInt("total"));
				retorno.add(linha);
			}
			ConnectionFactory.close(conexao, stmt, resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return retorno;
	}
}
