package br.com.saps.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import br.com.saps.dao.ProfissionalDAO;
import br.com.saps.modelo.Data;
import br.com.saps.modelo.Profissional;
import br.com.saps.modelo.RegistroProfissional;
import br.com.saps.modelo.TipoProfissional;
import br.com.saps.utils.ToolBar;

public class TelaProfissional extends JFrame implements ActionListener {

	private JFrame frmSapsSistema;
	private ToolBar barraFerramentas;
	private JLabel lProfissional;
	private JTextField tfProfissional;
	private JTextField tfMatricula;
	private JTextField tfRegisProf;
	private JLabel lRegisProf;
	private JLabel tSigla;
	private JComboBox<RegistroProfissional> comboBoxSigla;
	private JLabel lTipo;
	private JComboBox<TipoProfissional> comboBoxTipo;
	private JFormattedTextField tfData, tfCpf;
	private ProfissionalDAO profissionalDAO;
	private ArrayList<Profissional> arquivoProfissional;// =
	private ArrayList<RegistroProfissional> registros;
	private ArrayList<TipoProfissional> tipos;
	private JButton bPesquisarMatricula;

	private int temp = 0;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public TelaProfissional(ArrayList<Profissional> arquivo, ArrayList<RegistroProfissional> registros,
			ArrayList<TipoProfissional> tipos) {
		this.arquivoProfissional = arquivo;
		this.registros = registros;
		this.tipos = tipos;
		initialize();
		frmSapsSistema.setVisible(true);
		frmSapsSistema.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmSapsSistema = new JFrame();
		frmSapsSistema.setFont(new Font("Adobe Kaiti Std R", Font.BOLD, 12));
		frmSapsSistema.setTitle("SAPS - Sistema de Atendimento ao Profissional de Sa\u00FAde");
		frmSapsSistema.setBounds(100, 100, 636, 383);
		frmSapsSistema.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSapsSistema.getContentPane().setLayout(null);

		barraFerramentas = new ToolBar();
		barraFerramentas.setBounds(1, 2, 619, 57);
		frmSapsSistema.getContentPane().add(barraFerramentas);

		profissionalDAO = new ProfissionalDAO();
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new TitledBorder(
						new TitledBorder(new LineBorder(new Color(0, 0, 0), 3), "Profissional", TitledBorder.LEADING,
								TitledBorder.TOP, null, new Color(0, 0, 0)),
						"Profissional", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
				"Profissional", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(1, 70, 620, 223);
		frmSapsSistema.getContentPane().add(panel);
		panel.setLayout(null);

		lProfissional = new JLabel("Profissional");
		lProfissional.setBounds(20, 56, 70, 14);
		panel.add(lProfissional);

		tfProfissional = new JTextField();
		tfProfissional.setBounds(124, 56, 282, 20);
		panel.add(tfProfissional);
		tfProfissional.setColumns(10);
		tfProfissional.setEnabled(false);

		JLabel lMatricula = new JLabel("Matricula");
		lMatricula.setBounds(20, 31, 59, 14);
		panel.add(lMatricula);

		tfMatricula = new JTextField();
		tfMatricula.setBounds(124, 31, 86, 20);
		panel.add(tfMatricula);
		tfMatricula.setColumns(10);
		tfMatricula.setEnabled(false);

		ImageIcon iPesquisar = new ImageIcon("imagem/pesquisa.gif");
		bPesquisarMatricula = new JButton(iPesquisar);
		// bPesquisarMatricula.addActionListener(this);
		panel.add(bPesquisarMatricula);
		bPesquisarMatricula.setBounds(220, 20, 30, 30);
		bPesquisarMatricula.setEnabled(false);

		JLabel lCpf = new JLabel("CPF");
		lCpf.setBounds(20, 81, 46, 14);
		panel.add(lCpf);

		JFormattedTextField format = null;
		try {
			tfCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			tfCpf.setBounds(124, 81, 96, 20);
			panel.add(tfCpf);
			tfCpf.setColumns(10);
			tfCpf.setEnabled(false);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		JLabel lData = new JLabel("Data");
		lData.setBounds(20, 106, 46, 14);
		panel.add(lData);

		tfRegisProf = new JTextField();
		tfRegisProf.setBounds(124, 134, 86, 20);
		panel.add(tfRegisProf);
		tfRegisProf.setColumns(10);
		tfRegisProf.setEnabled(false);

		JFormattedTextField formattedTextField = null;
		try {
			tfData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		tfData.setBounds(124, 106, 86, 20);
		panel.add(tfData);
		tfData.setEnabled(false);

		lRegisProf = new JLabel("Reg. Prof.");
		lRegisProf.setBounds(20, 137, 59, 14);
		panel.add(lRegisProf);

		tSigla = new JLabel("Sigla");
		tSigla.setBounds(20, 162, 59, 14);
		panel.add(tSigla);

		comboBoxSigla = new JComboBox();
		for (RegistroProfissional registro : registros) {
			comboBoxSigla.addItem(registro);
		}
		comboBoxSigla.setBounds(124, 162, 150, 20);
		panel.add(comboBoxSigla);
		comboBoxSigla.setEnabled(false);

		lTipo = new JLabel("Tipo");
		lTipo.setBounds(20, 185, 46, 14);
		panel.add(lTipo);

		comboBoxTipo = new JComboBox();
		for (TipoProfissional tipoProfissional : tipos) {
			comboBoxTipo.addItem(tipoProfissional);
		}
		comboBoxTipo.setBounds(124, 185, 150, 20);
		panel.add(comboBoxTipo);
		comboBoxTipo.setEnabled(false);

		barraFerramentas.bConfirmar.setEnabled(false);
		barraFerramentas.bCancelar.setEnabled(false);

		barraFerramentas.bIncluir.addActionListener(this);
		barraFerramentas.bConfirmar.addActionListener(this);
		barraFerramentas.bPesquisar.addActionListener(this);
		barraFerramentas.bLimpar.addActionListener(this);
		barraFerramentas.bCancelar.addActionListener(this);
		barraFerramentas.bExcluir.addActionListener(this);
		bPesquisarMatricula.addActionListener(this);
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

			/*
			 * Verifica se existe sigla e especialidade se nao houver , fecha a
			 * tela de cadastro
			 */
			if (comboBoxSigla.getSelectedItem() == null) {
				JOptionPane.showMessageDialog(null, "Nenhuma Sigla cadastrada!!!", "Operação Invalida",
						JOptionPane.INFORMATION_MESSAGE);
				frmSapsSistema.dispose();
			} else if (comboBoxTipo.getSelectedItem() == null) {
				JOptionPane.showMessageDialog(null, "Nenhuma Especialidade cadastrada!!!", "Operação Invalida",
						JOptionPane.INFORMATION_MESSAGE);
				frmSapsSistema.dispose();
			}

			tfMatricula.setEnabled(false);
			tfMatricula.setText(ProfissionalDAO.gerarMatricula(arquivoProfissional));
			tfProfissional.setEnabled(true);
			tfCpf.setEnabled(true);
			tfRegisProf.setEnabled(true);
			comboBoxSigla.setEnabled(true);
			comboBoxTipo.setEnabled(true);
			tfData.setEnabled(true);

		} else if (e.getSource() == barraFerramentas.bConfirmar) {
			switch (temp) {
			case 1:
				try {
					Data data = Data.montaData(tfData.getText().substring(0, 2), tfData.getText().substring(3, 5),
							tfData.getText().substring(6, 10));
					String[] componentes = { tfProfissional.getText(), tfMatricula.getText(), tfRegisProf.getText() };
					for (String componente : componentes) {
						if (componente.equals("")) {
							JOptionPane.showMessageDialog(null, "Preencha todos os campos!!!", "Operação Invalida",
									JOptionPane.ERROR_MESSAGE);
							break;
						}
					}
					Profissional novoProfissional = profissionalDAO.criarProfissional(tfProfissional.getText(),
							tfMatricula.getText(), tfCpf.getText(), data,
							(RegistroProfissional) comboBoxSigla.getSelectedItem(),
							(TipoProfissional) comboBoxTipo.getSelectedItem(), tfRegisProf.getText());
					arquivoProfissional = profissionalDAO.inserirProfissional(arquivoProfissional, novoProfissional);

				} catch (NumberFormatException er) {
					JOptionPane.showMessageDialog(null, "Campo **Data ou **CPF invalidos!!!", "Operação Invalida",
							JOptionPane.ERROR_MESSAGE);
				} finally {
					temp = 0;
				}
				break;

			case 3:
				tfMatricula.setEditable(false);
				if (!tfMatricula.getText().equals("")) {
					try {
						if (profissionalDAO.buscarProfissional(arquivoProfissional, tfMatricula.getText()) != null) {
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
								tfMatricula.setEditable(false);
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
			tfMatricula.setText("");
			limparCamposProfissional();

			tfMatricula.setEnabled(false);
			barraFerramentas.bConfirmar.setEnabled(false);
			barraFerramentas.bCancelar.setEnabled(false);
			desativarCamposProfissional();
			temp = 0;

		} else if (e.getSource() == bPesquisarMatricula) {
			try {
				Profissional profissional = null;
				try {
					profissional = profissionalDAO.buscarProfissional(arquivoProfissional, tfMatricula.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (profissional == null) {
					JOptionPane.showMessageDialog(null, "Matricula não exite2!!!", "Operação Invalida",
							JOptionPane.WARNING_MESSAGE);
				} else {
					// tfMatricula.setText(profissional.getMatricula());
					tfProfissional.setText(profissional.getNome());
					tfCpf.setText(profissional.getCpf());
					tfData.setText(String.valueOf(profissional.getData()));
					comboBoxSigla.setSelectedItem(profissional.getSigla());
					comboBoxTipo.setSelectedItem(profissional.getTipo());
					tfRegisProf.setText(profissional.getNumeroRP());

				}

			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Por favor,insira um valor valido no campo **Matricula!!!",
						"Operação Invalida", JOptionPane.WARNING_MESSAGE);
			} catch (NullPointerException e1) {
				JOptionPane.showMessageDialog(null, "Matricula nao existe!!!", "Operação Invalida",
						JOptionPane.WARNING_MESSAGE);
			}
			bPesquisarMatricula.setEnabled(false);

		} else if (e.getSource() == barraFerramentas.bPesquisar) {
			tfMatricula.setEnabled(true);
			bPesquisarMatricula.setEnabled(true);

		} else if (e.getSource() == barraFerramentas.bExcluir) {
			temp = 3;
			tfMatricula.setEnabled(true);
			barraFerramentas.bConfirmar.setEnabled(true);
			barraFerramentas.bCancelar.setEnabled(true);

		}

		else if (e.getSource() == barraFerramentas.bLimpar)

		{
			limparCamposProfissional();

		} else if (e.getSource() == barraFerramentas.bCancelar) {
			tfMatricula.setEnabled(true);
			tfMatricula.setText("");

			limparCamposProfissional();

			desativarCamposProfissional();

			JOptionPane.showMessageDialog(null, "Operação Cancelada!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);

			barraFerramentas.bConfirmar.setEnabled(false);
			barraFerramentas.bCancelar.setEnabled(false);

		}
	}

	private void desativarCamposProfissional() {
		tfProfissional.setEnabled(false);
		tfCpf.setEnabled(false);
		tfData.setEnabled(false);
		tfRegisProf.setEnabled(false);
	}

	private void limparCamposProfissional() {
		tfProfissional.setText("");
		tfCpf.setText("");
		tfData.setText("");
		tfRegisProf.setText("");
	}
}
