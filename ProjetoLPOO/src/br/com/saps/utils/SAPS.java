package br.com.saps.utils;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import br.com.saps.views.TelaProfissional;

public class SAPS extends JFrame implements ActionListener {
	// Declaração globa
	private JLabel lTitulo, lHabilitar, lDesabilitar, lCliente, lProfissional, lAtendimento, lSair;
	private Acesso fAcesso;

	private JButton bHabilitar, bCliente, bProfissional, bAtendimento, bSair;

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
		bSair.setEnabled(true);
		fAcesso.setVisible(false);
		bHabilitar.setEnabled(false);

	}

	public void actionPerformed(ActionEvent e) {
		int temp = 0;
		if (e.getSource() == bHabilitar) {
			fAcesso = new Acesso(null, "SAPS: Habilitação de usuário.", true, this);
			fAcesso.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			fAcesso.setVisible(true);

		} else if (e.getSource() == bProfissional) {
			TelaProfissional tela = new TelaProfissional();
			tela.abrirTela();
		} else if (e.getSource() == bSair)
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