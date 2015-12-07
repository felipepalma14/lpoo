package br.com.saps.views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import br.com.saps.dao.RegistroProfissionalDAO;
import br.com.saps.modelo.RegistroProfissional;
import br.com.saps.utils.Conexao;
import br.com.saps.utils.ToolBar;

public class TelaRegistroProfissional extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfCodigo;
	private JTextField tfDescricao;
	private Conexao conexao;
	private ArrayList<RegistroProfissional> registros;
	private JButton bPesquisarId;
	private RegistroProfissionalDAO registroDAO;
	private ToolBar barraFerramentas;
	private int temp = 0;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TelaRegistroProfissional(ArrayList<RegistroProfissional> registros) {
		this.registros = registros;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 630, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Registro Profissional",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(28, 70, 549, 164);
		contentPane.add(panel);
		panel.setLayout(null);

		barraFerramentas = new ToolBar();
		barraFerramentas.setBounds(1, 2, 619, 57);
		contentPane.add(barraFerramentas);

		JLabel lCodigo = new JLabel("Codigo");
		lCodigo.setBounds(25, 32, 46, 14);
		panel.add(lCodigo);

		tfCodigo = new JTextField();
		tfCodigo.setBounds(117, 29, 65, 20);
		panel.add(tfCodigo);
		tfCodigo.setColumns(10);
		tfCodigo.setEditable(false);

		JLabel lDescricao = new JLabel("Descri\u00E7\u00E3o");
		lDescricao.setBounds(25, 71, 65, 14);
		panel.add(lDescricao);

		tfDescricao = new JTextField();
		tfDescricao.setBounds(117, 68, 160, 20);
		panel.add(tfDescricao);
		tfDescricao.setColumns(10);
		tfDescricao.setEditable(false);

		ImageIcon iPesquisar = new ImageIcon("imagem/pesquisa.gif");
		bPesquisarId = new JButton(iPesquisar);
		bPesquisarId.addActionListener(this);
		panel.add(bPesquisarId);
		bPesquisarId.setBounds(220, 20, 30, 30);
		bPesquisarId.setEnabled(false);

		barraFerramentas.bConfirmar.setEnabled(false);
		barraFerramentas.bCancelar.setEnabled(false);

		barraFerramentas.bIncluir.addActionListener(this);
		barraFerramentas.bConfirmar.addActionListener(this);
		barraFerramentas.bPesquisar.addActionListener(this);
		barraFerramentas.bLimpar.addActionListener(this);
		barraFerramentas.bCancelar.addActionListener(this);
		barraFerramentas.bExcluir.addActionListener(this);

		bPesquisarId.addActionListener(this);

		registroDAO = new RegistroProfissionalDAO();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		/*
		 * 1 - incluir 2 - pesquisar 3 - excluir
		 */

		if (e.getSource() == barraFerramentas.bIncluir) {
			temp = 1;
			barraFerramentas.bConfirmar.setEnabled(true);
			barraFerramentas.bCancelar.setEnabled(true);

			tfCodigo.setEditable(false);
			tfCodigo.setText(RegistroProfissionalDAO.gerarId(registros));
			tfDescricao.setEditable(true);

		} else if (e.getSource() == barraFerramentas.bConfirmar) {
			switch (temp) {
			case 1:
				try {

					if (tfDescricao.equals("")) {
						JOptionPane.showMessageDialog(null, "Preencha todos os campos!!!", "Operação Invalida",
								JOptionPane.ERROR_MESSAGE);

					}
					RegistroProfissional novoRegistro = new RegistroProfissional(Long.parseLong(tfCodigo.getText()),
							tfDescricao.getText());
					this.registros.add(novoRegistro);

					this.registros = registroDAO.inserirRegistroProfissional(registros, novoRegistro);
				} catch (NumberFormatException er) {
					JOptionPane.showMessageDialog(null, "Campo **Descrção invalidos!!!", "Operação Invalida",
							JOptionPane.ERROR_MESSAGE);
				} finally {
					temp = 0;
				}
				break;

			case 3:
				tfCodigo.setEditable(false);
				if (!tfCodigo.getText().equals("")) {
					try {

						if (registroDAO.buscaRegistro(this.registros, tfCodigo.getText()) != null) {
							int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "Alerta",
									JOptionPane.YES_NO_OPTION);
							System.out.println(resposta);

							if (resposta == 0) {
								try {
									// arquivoProfissional =
									// profissionalDAO.excluirProfissional(arquivoProfissional,
									// tfMatricula.getText());
									JOptionPane.showMessageDialog(null, "Dado excluido com sucesso!!!", "Informação",
											JOptionPane.INFORMATION_MESSAGE);
								} catch (NullPointerException err) {
									JOptionPane.showMessageDialog(null,
											"Por favor,insira um valor valido no campo **Matricula!!!",
											"Operação Invalida", JOptionPane.WARNING_MESSAGE);
								}
							} else {
								tfCodigo.setEditable(false);
								barraFerramentas.bConfirmar.setEnabled(false);
								barraFerramentas.bCancelar.setEnabled(false);
							}
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Matricula nao cadastrada!!!", "Operação Invalida",
								JOptionPane.WARNING_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(null, "Por favor,insira um valor valido no campo **Matricula!!!",
							"Operação Invalida", JOptionPane.WARNING_MESSAGE);
				}
				temp = 0;

				barraFerramentas.bConfirmar.setEnabled(true);
				barraFerramentas.bCancelar.setEnabled(true);

				break;
			default:
				break;
			}
			// se tudo tiver ok, limpa os campos
			tfCodigo.setText("");
			limparCamposRegistrosProfissional();

			tfCodigo.setEditable(false);
			barraFerramentas.bConfirmar.setEnabled(false);
			barraFerramentas.bCancelar.setEnabled(false);
			desativarCamposRegistrosProfissional();
			temp = 0;

		} else if (e.getSource() == bPesquisarId)

		{
			try {
				RegistroProfissional registro = null;
				try {

					registro = registroDAO.buscaRegistro(registros, tfCodigo.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (registro == null) {
					JOptionPane.showMessageDialog(null, "Matricula não exite2!!!", "Operação Invalida",
							JOptionPane.WARNING_MESSAGE);
				} else {
					// tfMatricula.setText(profissional.getMatricula());
					tfDescricao.setText(registro.getDescricao());

				}

			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Por favor,insira um valor valido no campo **Matricula!!!",
						"Operação Invalida", JOptionPane.WARNING_MESSAGE);
			} catch (NullPointerException e1) {
				JOptionPane.showMessageDialog(null, "Matricula nao existe!!!", "Operação Invalida",
						JOptionPane.WARNING_MESSAGE);
			}
			bPesquisarId.setEnabled(false);

		} else if (e.getSource() == barraFerramentas.bPesquisar)

		{
			tfCodigo.setEditable(true);
			bPesquisarId.setEnabled(true);

		} else if (e.getSource() == barraFerramentas.bExcluir)

		{
			temp = 3;
			tfCodigo.setEnabled(true);
			barraFerramentas.bConfirmar.setEnabled(true);
			barraFerramentas.bCancelar.setEnabled(true);

		}

		else if (e.getSource() == barraFerramentas.bLimpar)

		{
			limparCamposRegistrosProfissional();

		} else if (e.getSource() == barraFerramentas.bCancelar)

		{
			tfCodigo.setEnabled(true);
			tfCodigo.setText("");

			JOptionPane.showMessageDialog(null, "Operação Cancelada!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);

			barraFerramentas.bConfirmar.setEnabled(false);
			barraFerramentas.bCancelar.setEnabled(false);

		}
	}

	private void desativarCamposRegistrosProfissional() {
		tfCodigo.setEditable(false);
		tfDescricao.setEditable(false);
	}

	private void limparCamposRegistrosProfissional() {
		tfCodigo.setText("");
		tfDescricao.setText("");
	}

}
