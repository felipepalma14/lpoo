package br.com.saps.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.com.saps.dao.AtendimentoDAO;
import br.com.saps.dao.ClienteDAO;
import br.com.saps.dao.ProfissionalDAO;
import br.com.saps.modelo.Atendimento;
import br.com.saps.modelo.Cliente;
import br.com.saps.modelo.Data;
import br.com.saps.modelo.Profissional;
import br.com.saps.utils.ToolBar;

public class TelaAtendimento extends JFrame implements ActionListener {

	private JPanel contentPane;
	private Cliente[] listaCliente = null;
	private ArrayList<Profissional> listaProfissional;
	private JTextField tfProtocolo;
	private ToolBar barraFerramentas;
	private Atendimento[] arquivoAtendimento = null;
	private AtendimentoDAO atendimentoDAO;
	private ClienteDAO pacienteDAO;
	private ProfissionalDAO profissionalDAO;
	private JComboBox<Profissional> comboboxProfissional;
	private JComboBox<Cliente> comboboxPaciente;
	private JComboBox comboboxEspecialidade;
	private JTextArea textAreaDescricao;
	private int temp;

	/**
	 * Launch the application.
	 */
	public static void abrirTela(final ArrayList<Profissional> profissionais) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtendimento frame = new TelaAtendimento(profissionais);
					frame.setVisible(true);
					frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaAtendimento(ArrayList<Profissional> profissionais) {
		// recebendo lista de profissionais
		this.listaProfissional = profissionais;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		barraFerramentas = new ToolBar();
		barraFerramentas.setBounds(1, 2, 619, 57);

		contentPane.add(barraFerramentas);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Atendimento", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.setBounds(11, 70, 589, 162);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lPaciente = new JLabel("Paciente");
		lPaciente.setBounds(23, 60, 66, 14);
		panel.add(lPaciente);

		Cliente p1 = new Cliente("Joao Almeida");
		Cliente p2 = new Cliente("Carla Dias");

		// listaCliente = pacienteDAO.inserir(listaCliente, p1);
		// listaCliente = pacienteDAO.inserir(listaCliente, p2);

		JComboBox<Cliente> comboboxPaciente = new JComboBox();

		comboboxPaciente.setBounds(115, 60, 176, 20);
		panel.add(comboboxPaciente);

		JLabel lProfissional = new JLabel("Profissional");
		lProfissional.setBounds(22, 114, 83, 14);
		panel.add(lProfissional);

		JLabel lEspecialidade = new JLabel("Especialidade");
		lEspecialidade.setBounds(22, 85, 83, 14);
		panel.add(lEspecialidade);

		String[] especialidades = { "Dentista", "Clinico Geral", "Pediatra" };
		JComboBox comboboxEspecialidade = new JComboBox(especialidades);
		comboboxEspecialidade.setBounds(115, 85, 176, 20);
		panel.add(comboboxEspecialidade);

		for (Profissional prof : listaProfissional) {
			System.out.println(prof);
		}
		JComboBox<Profissional> comboboxProfissional = new JComboBox();
		for (Profissional profissional : listaProfissional) {
			comboboxProfissional.addItem(profissional);
		}
		comboboxProfissional.setBounds(115, 114, 176, 20);
		panel.add(comboboxProfissional);

		JLabel lProtocolo = new JLabel("N. Protocolo");
		lProtocolo.setBounds(23, 30, 82, 14);
		panel.add(lProtocolo);

		tfProtocolo = new JTextField();
		tfProtocolo.setBounds(113, 27, 86, 20);
		panel.add(tfProtocolo);
		tfProtocolo.setColumns(10);
		tfProtocolo.setEditable(false);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Descri\u00E7ao", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 236, 590, 170);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JTextArea textAreaDescricao = new JTextArea();
		textAreaDescricao.setBounds(10, 21, 570, 138);
		panel_1.add(textAreaDescricao);

		barraFerramentas.bConfirmar.setEnabled(false);
		barraFerramentas.bCancelar.setEnabled(false);

		barraFerramentas.bIncluir.addActionListener(this);
		barraFerramentas.bConfirmar.addActionListener(this);
		barraFerramentas.bPesquisar.addActionListener(this);
		barraFerramentas.bLimpar.addActionListener(this);
		barraFerramentas.bCancelar.addActionListener(this);
		barraFerramentas.bExcluir.addActionListener(this);
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

			tfProtocolo.setEditable(false);
			tfProtocolo.setText(AtendimentoDAO.gerarProtocolo(arquivoAtendimento));
			/*
			 * comboboxEspecialidade.setEnabled(false);
			 * comboboxPaciente.setEnabled(false);
			 * comboboxProfissional.setEnabled(false);
			 */
		} else if (e.getSource() == barraFerramentas.bConfirmar) {
			switch (temp) {
			case 1: // incluir

				Calendar calendar = Calendar.getInstance();
				Data dataCriacao = new Data(calendar.DAY_OF_MONTH, calendar.MONTH + 1, calendar.YEAR);

				Atendimento novoAtendimento = new Atendimento(tfProtocolo.getText(),
						(Profissional) comboboxProfissional.getSelectedItem(),
						(Cliente) comboboxPaciente.getSelectedItem(), textAreaDescricao.getText(), dataCriacao,
						(String) comboboxEspecialidade.getSelectedItem());
				arquivoAtendimento = atendimentoDAO.inserirAtendimento(arquivoAtendimento, novoAtendimento);

				break;

			case 2:// Buscar

				Atendimento atendimento = null;
				try {
					atendimento = atendimentoDAO.buscarAtendimento(arquivoAtendimento, tfProtocolo.getText());
					tfProtocolo.setText(atendimento.getProtocolo());
					comboboxProfissional.setSelectedItem(atendimento.getProfissional());
					comboboxEspecialidade.setSelectedItem(atendimento.getEspecialidade());
					// tfData.setText(String.valueOf(profissional.getData()));
					comboboxPaciente.setSelectedItem(atendimento.getCliente());
					textAreaDescricao.setText(atendimento.getDescrição());

				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "Sem dados cadastrados!!!", "Aviso", JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Por favor,insira um valor valido no campo **Protocolo!!!",
							"Operação Invalida", JOptionPane.WARNING_MESSAGE);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					tfProtocolo.setText("");

				}
				break;
			case 3:
				tfProtocolo.setEnabled(true);
				if (!tfProtocolo.getText().equals("")) {
					try {
						if (atendimentoDAO.buscarAtendimento(arquivoAtendimento, tfProtocolo.getText()) != null) {
							int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "Alerta",
									JOptionPane.YES_NO_OPTION);
							System.out.println(resposta);

							if (resposta == 0) {
								try {
									arquivoAtendimento = atendimentoDAO.excluirAtendimento(arquivoAtendimento,
											tfProtocolo.getText());
									JOptionPane.showMessageDialog(null, "Dado excluido com sucesso!!!", "Informação",
											JOptionPane.INFORMATION_MESSAGE);
								} catch (NullPointerException err) {
									JOptionPane.showMessageDialog(null,
											"Por favor,insira um valor valido no campo **Protocolo!!!",
											"Operação Invalida", JOptionPane.WARNING_MESSAGE);
								}
							} else {
								tfProtocolo.setEnabled(false);
								barraFerramentas.bConfirmar.setEnabled(false);
								barraFerramentas.bCancelar.setEnabled(false);
							}
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Procolo nao existente!!!", "Operação Invalida",
								JOptionPane.WARNING_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(null, "Por favor,insira um valor valido no campo **Protocolo!!!",
							"Operação Invalida", JOptionPane.WARNING_MESSAGE);
				}
				temp = 0;

				break;
			default:
				break;
			}
			// se tudo tiver ok, limpa os campos
			tfProtocolo.setText("");
			limparCamposAtendimento();

			tfProtocolo.setEnabled(true);
			barraFerramentas.bConfirmar.setEnabled(false);
			barraFerramentas.bCancelar.setEnabled(false);
			desativarCamposAtendimento();
			temp = 0;

		} else if (e.getSource() == barraFerramentas.bPesquisar) {
			/*
			 * Pensar melhor aqui
			 */
			temp = 2;

		} else if (e.getSource() == barraFerramentas.bExcluir) {
			temp = 3;
			tfProtocolo.setEnabled(true);
			barraFerramentas.bConfirmar.setEnabled(true);
			barraFerramentas.bCancelar.setEnabled(true);

		}

		else if (e.getSource() == barraFerramentas.bLimpar)

		{

		} else if (e.getSource() == barraFerramentas.bCancelar) {

			limparCamposAtendimento();

			desativarCamposAtendimento();

			JOptionPane.showMessageDialog(null, "Operação Cancelada!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);

			barraFerramentas.bConfirmar.setEnabled(false);
			barraFerramentas.bCancelar.setEnabled(false);

		}
	}

	private void desativarCamposAtendimento() {
		tfProtocolo.setEnabled(false);
		textAreaDescricao.setEnabled(false);

	}

	private void limparCamposAtendimento() {
		tfProtocolo.setText("");
		textAreaDescricao.setText("");

	}

}
