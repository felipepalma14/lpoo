package br.com.saps.utils;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import br.com.saps.modelo.Atendimento;
import br.com.saps.modelo.Cliente;
import br.com.saps.modelo.Profissional;
import br.com.saps.modelo.RegistroProfissional;
import br.com.saps.modelo.TipoProfissional;
import br.com.saps.views.TelaAtendimento;
import br.com.saps.views.TelaCliente;
import br.com.saps.views.TelaEspecialidade;
import br.com.saps.views.TelaProfissional;
import br.com.saps.views.TelaRegistroProfissional;

public class SAPS extends JFrame implements ActionListener {
	// Declaração globa
	private JLabel lTitulo, lHabilitar, lDesabilitar, lCliente, lProfissional, lAtendimento, lRegistroProf,
			lEspecialidade, lRelatorios, lSair;
	private Acesso fAcesso;
	private JButton bHabilitar, bCliente, bProfissional, bAtendimento, bRegistroProf, bEspecialidade, bRelatorios,
			bSair;
	private Cliente[] arquivoCliente;
	private Atendimento[] arquivoAtendimento;
	private Conexao conexao;
	private ArrayList<Profissional> profissionais = Conexao.getInstance().getArrayListProfissional();
	private ArrayList<RegistroProfissional> registros = Conexao.getInstance().getArrayListRegistro();
	private ArrayList<Cliente> clientes = Conexao.getInstance().getArrayListCliente();
	private ArrayList<TipoProfissional> tipos = Conexao.getInstance().getArrayListTipoProfissional();

	private ArrayList<Atendimento> atendimentos = Conexao.getInstance().getArrayListAtendimento();

	private SAPS() {
		setTitle("SAPS: Sistema de Atendimento Profissional de Saúde");
		setExtendedState(MAXIMIZED_BOTH);

		// Cria o container (box, caixa) para a
		// agrupamento dos objetos
		Container areaTrabalho = getContentPane();
		areaTrabalho.setLayout(null);

		lTitulo = new JLabel("Sistema de Atendimento Profissional de Saúde");

		lTitulo.setFont(new Font("TimesRoman", Font.BOLD, 30));
		lTitulo.setBounds(20, 20, 2000, 100);
		// lHabilitar.addActionListener(this);
		areaTrabalho.add(lTitulo);

		ImageIcon iHabilitar = new ImageIcon("imagem/habilitar.png");
		bHabilitar = new JButton(iHabilitar);
		bHabilitar.addActionListener(this);
		areaTrabalho.add(bHabilitar);
		bHabilitar.setBounds(20, 200, 50, 50);

		lHabilitar = new JLabel("Habilitar...");
		lHabilitar.setFont(new Font("TimesRoman", Font.ITALIC, 30));
		lHabilitar.setBounds(100, 200, 400, 50);
		areaTrabalho.add(lHabilitar);

		ImageIcon iCliente = new ImageIcon("imagem/cliente.png");
		bCliente = new JButton(iCliente);
		bCliente.addActionListener(this);
		areaTrabalho.add(bCliente);
		bCliente.setBounds(20, 270, 50, 50);
		bCliente.setEnabled(false);

		lCliente = new JLabel("Cliente");
		lCliente.setFont(new Font("TimesRoman", Font.ITALIC, 30));
		lCliente.setBounds(100, 270, 400, 50);
		areaTrabalho.add(lCliente);

		ImageIcon iRegistroProf = new ImageIcon("imagem/cliente.png");
		bRegistroProf = new JButton(iRegistroProf);
		bRegistroProf.addActionListener(this);
		areaTrabalho.add(bRegistroProf);
		bRegistroProf.setBounds(500, 270, 50, 50);
		bRegistroProf.setEnabled(false);

		lRegistroProf = new JLabel("Registro Profissional");
		lRegistroProf.setFont(new Font("TimesRoman", Font.ITALIC, 30));
		lRegistroProf.setBounds(580, 270, 400, 50);
		areaTrabalho.add(lRegistroProf);

		ImageIcon iRelatorio = new ImageIcon("imagem/relatorio.png");
		bRelatorios = new JButton(iRelatorio);
		bRelatorios.addActionListener(this);
		areaTrabalho.add(bRelatorios);
		bRelatorios.setBounds(980, 270, 50, 50);
		bRelatorios.setEnabled(false);

		lRelatorios = new JLabel("Relatorios");
		lRelatorios.setFont(new Font("TimesRoman", Font.ITALIC, 30));
		lRelatorios.setBounds(1040, 270, 400, 50);
		areaTrabalho.add(lRelatorios);

		ImageIcon iProfissional = new ImageIcon("imagem/profissional.png");
		bProfissional = new JButton(iProfissional);
		bProfissional.addActionListener(this);
		areaTrabalho.add(bProfissional);
		bProfissional.setBounds(20, 340, 50, 50);
		bProfissional.setEnabled(false);

		lProfissional = new JLabel("Profissional");
		lProfissional.setFont(new Font("TimesRoman", Font.ITALIC, 30));
		lProfissional.setBounds(100, 340, 400, 50);
		areaTrabalho.add(lProfissional);

		ImageIcon iEspecialidade = new ImageIcon("imagem/cliente.png");
		bEspecialidade = new JButton(iEspecialidade);
		bEspecialidade.addActionListener(this);
		areaTrabalho.add(bEspecialidade);
		bEspecialidade.setBounds(500, 340, 50, 50);
		bEspecialidade.setEnabled(false);

		lEspecialidade = new JLabel("Especialidades");
		lEspecialidade.setFont(new Font("TimesRoman", Font.ITALIC, 30));
		lEspecialidade.setBounds(580, 340, 400, 50);
		areaTrabalho.add(lEspecialidade);

		ImageIcon iAtendimento = new ImageIcon("imagem/atendimento.png");
		bAtendimento = new JButton(iAtendimento);
		bAtendimento.addActionListener(this);
		areaTrabalho.add(bAtendimento);
		bAtendimento.setBounds(20, 400, 50, 50);
		bAtendimento.setEnabled(false);

		lAtendimento = new JLabel("Atendimento");
		lAtendimento.setFont(new Font("TimesRoman", Font.ITALIC, 30));
		lAtendimento.setBounds(100, 400, 400, 50);
		areaTrabalho.add(lAtendimento);

		ImageIcon iSair = new ImageIcon("imagem/sair.png");
		bSair = new JButton(iSair);
		bSair.addActionListener(this);
		areaTrabalho.add(bSair);
		bSair.setBounds(20, 480, 50, 50);
		bSair.setEnabled(true);

		lSair = new JLabel("Sair do Sistema");
		lSair.setFont(new Font("TimesRoman", Font.ITALIC, 30));
		lSair.setBounds(100, 480, 400, 50);
		areaTrabalho.add(lSair);

		// Criação da Tabela de clientes com espaço para 20 registros

		setVisible(true);
	}

	public void contectar() {
		bCliente.setEnabled(true);
		bProfissional.setEnabled(true);
		bAtendimento.setEnabled(true);
		bSair.setEnabled(true);
		fAcesso.setVisible(false);
		bHabilitar.setEnabled(false);
		bRegistroProf.setEnabled(true);
		bEspecialidade.setEnabled(true);
		bCliente.setEnabled(true);
		bRelatorios.setEnabled(true);

	}

	public void actionPerformed(ActionEvent e) {
		int temp = 0;
		if (e.getSource() == bHabilitar) {
			fAcesso = new Acesso(null, "SAPS: Habilitação de usuário.", true, this);
			fAcesso.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			fAcesso.setVisible(true);

		} else if (e.getSource() == bProfissional) {
			for (RegistroProfissional item : registros) {
				System.out.println(item);
			}
			TelaProfissional tela = new TelaProfissional(profissionais, registros, tipos);

		} else if (e.getSource() == bAtendimento) {
			TelaAtendimento tela = new TelaAtendimento(atendimentos, profissionais, clientes);
			tela.abrirTela(atendimentos, profissionais, clientes);

		} else if (e.getSource() == bRegistroProf) {
			TelaRegistroProfissional tela = new TelaRegistroProfissional(registros);

		} else if (e.getSource() == bEspecialidade) {
			TelaEspecialidade tela = new TelaEspecialidade(tipos);
			tela.abrirTela(tipos);
		} else if (e.getSource() == bCliente) {
			TelaCliente tela = new TelaCliente(clientes);
			tela.abrirTela(clientes);
		}

		else if (e.getSource() == bSair)
			System.exit(0);

		else
			temp = 0;
	}

	public void msg(String usuario, String senha) {
		if (usuario.equals("aluno") && senha.equals("123")) {
			contectar();
			JOptionPane.showMessageDialog(null, "Acesso Autorizado!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			bCliente.requestFocus();
		} else
			JOptionPane.showMessageDialog(null, "Acesso Não Autorizado!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void main(String args[]) {
		SAPS saps = new SAPS();
		saps.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}