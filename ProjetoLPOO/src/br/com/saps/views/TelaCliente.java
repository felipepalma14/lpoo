package br.com.saps.views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import br.com.saps.dao.ClienteDAO;
import br.com.saps.modelo.Cliente;
import br.com.saps.modelo.Data;
import br.com.saps.modelo.Endereco;
import br.com.saps.utils.ToolBar;

public class TelaCliente extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfEmail;
	private JTextField tfLogradouro;
	private JTextField tfNumero;
	private JTextField tfComplemento;
	private JTextField tfCep;
	private JTextField tfCidade;
	private JTextField tfBairro;
	private JComboBox<Character> comboBoxSexo;
	private JComboBox<Character> comboBoxEstado;
	private JFormattedTextField ftfNascimento;
	private JFormattedTextField ftfCelular, ftfTelefone;
	private ToolBar barraFerramentas;
	private JButton bPesquisarCodigo;
	private ArrayList<Cliente> clientes;
	private ClienteDAO clienteDAO;
	private int temp;
	private Data data;

	/**
	 * Launch the application.
	 */
	public static void abrirTela(final ArrayList<Cliente> clientes) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCliente frame = new TelaCliente(clientes);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCliente(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 627, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		clienteDAO = new ClienteDAO();

		barraFerramentas = new ToolBar();
		barraFerramentas.setBounds(1, 2, 619, 57);
		contentPane.add(barraFerramentas);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Dados Cliente", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel.setBounds(11, 70, 574, 113);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lCodigo = new JLabel("Codigo");
		lCodigo.setBounds(29, 22, 46, 14);
		panel.add(lCodigo);

		tfCodigo = new JTextField();
		tfCodigo.setBounds(92, 19, 86, 20);
		panel.add(tfCodigo);
		tfCodigo.setColumns(10);
		tfCodigo.setEditable(false);

		JLabel lNome = new JLabel("Nome");
		lNome.setBounds(29, 47, 46, 14);
		panel.add(lNome);

		tfNome = new JTextField();
		tfNome.setBounds(92, 44, 190, 20);
		panel.add(tfNome);
		tfNome.setColumns(10);
		tfNome.setEditable(false);

		JLabel lEmail = new JLabel("Email");
		lEmail.setBounds(29, 72, 46, 14);
		panel.add(lEmail);

		tfEmail = new JTextField();
		tfEmail.setBounds(92, 69, 190, 20);
		panel.add(tfEmail);
		tfEmail.setColumns(10);
		tfEmail.setEditable(false);

		JLabel lNascimento = new JLabel("Nascimento");
		lNascimento.setBounds(305, 72, 72, 14);
		panel.add(lNascimento);

		JFormattedTextField formattedTextField = null;
		try {
			ftfNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ftfNascimento.setBounds(375, 69, 86, 20);
		panel.add(ftfNascimento);
		ftfNascimento.setEditable(false);

		JLabel lSexo = new JLabel("Sexo");
		lSexo.setBounds(319, 47, 46, 14);
		panel.add(lSexo);

		String sexos[] = { "M", "F" };
		comboBoxSexo = new JComboBox(sexos);
		comboBoxSexo.setBounds(375, 44, 86, 20);
		panel.add(comboBoxSexo);
		comboBoxSexo.setEditable(false);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Contato", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(11, 194, 574, 171);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lCelular = new JLabel("Celular");
		lCelular.setBounds(34, 28, 46, 14);
		panel_1.add(lCelular);

		try {
			ftfCelular = new JFormattedTextField(new MaskFormatter("#####-####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ftfCelular.setBounds(110, 25, 92, 20);
		panel_1.add(ftfCelular);
		ftfCelular.setEditable(false);

		JLabel lTelefone = new JLabel("Tel.");
		lTelefone.setBounds(249, 28, 46, 14);
		panel_1.add(lTelefone);

		try {
			ftfTelefone = new JFormattedTextField(new MaskFormatter("#####-####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ftfTelefone.setBounds(305, 25, 102, 20);
		panel_1.add(ftfTelefone);
		ftfTelefone.setColumns(10);
		ftfTelefone.setEditable(false);

		JLabel lLogradouro = new JLabel("Logradouro");
		lLogradouro.setBounds(34, 53, 70, 14);
		panel_1.add(lLogradouro);

		tfLogradouro = new JTextField();
		tfLogradouro.setBounds(110, 50, 175, 20);
		panel_1.add(tfLogradouro);
		tfLogradouro.setColumns(10);
		tfLogradouro.setEditable(false);

		JLabel lNumero = new JLabel("Numero");
		lNumero.setBounds(305, 56, 46, 14);
		panel_1.add(lNumero);

		tfNumero = new JTextField();
		tfNumero.setBounds(361, 50, 46, 20);
		panel_1.add(tfNumero);
		tfNumero.setColumns(10);
		tfNumero.setEditable(false);

		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(34, 78, 70, 14);
		panel_1.add(lblComplemento);

		tfComplemento = new JTextField();
		tfComplemento.setBounds(110, 75, 117, 20);
		panel_1.add(tfComplemento);
		tfComplemento.setColumns(10);
		tfComplemento.setEditable(false);

		JLabel lCep = new JLabel("CEP");
		lCep.setBounds(249, 81, 46, 14);
		panel_1.add(lCep);

		tfCep = new JTextField();
		tfCep.setBounds(305, 75, 102, 20);
		panel_1.add(tfCep);
		tfCep.setColumns(10);
		tfCep.setEditable(false);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(34, 103, 46, 14);
		panel_1.add(lblEstado);

		String estados[] = { "AM", "MA", "RR", "CE" };
		comboBoxEstado = new JComboBox(estados);
		comboBoxEstado.setBounds(110, 100, 92, 20);
		panel_1.add(comboBoxEstado);
		comboBoxEstado.setEditable(false);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(249, 106, 46, 14);
		panel_1.add(lblCidade);

		tfCidade = new JTextField();
		tfCidade.setBounds(305, 100, 102, 20);
		panel_1.add(tfCidade);
		tfCidade.setColumns(10);
		tfCidade.setEditable(false);

		JLabel lBairro = new JLabel("Bairro");
		lBairro.setBounds(417, 106, 46, 14);
		panel_1.add(lBairro);

		tfBairro = new JTextField();
		tfBairro.setBounds(473, 103, 86, 20);
		panel_1.add(tfBairro);
		tfBairro.setColumns(10);
		tfBairro.setEditable(false);

		ImageIcon iPesquisar = new ImageIcon("imagem/pesquisa.gif");
		bPesquisarCodigo = new JButton(iPesquisar);
		panel.add(bPesquisarCodigo);
		bPesquisarCodigo.setBounds(200, 10, 30, 30);
		bPesquisarCodigo.setEnabled(false);

		barraFerramentas.bConfirmar.setEnabled(false);
		barraFerramentas.bCancelar.setEnabled(false);

		barraFerramentas.bIncluir.addActionListener(this);
		barraFerramentas.bConfirmar.addActionListener(this);
		barraFerramentas.bPesquisar.addActionListener(this);
		barraFerramentas.bLimpar.addActionListener(this);
		barraFerramentas.bCancelar.addActionListener(this);
		barraFerramentas.bExcluir.addActionListener(this);
		bPesquisarCodigo.addActionListener(this);
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
			tfCodigo.setText(clienteDAO.gerarCodigo(clientes));
			tfNome.setEditable(true);
			tfBairro.setEditable(true);
			tfCep.setEditable(true);
			tfCidade.setEditable(true);
			tfComplemento.setEditable(true);
			tfEmail.setEditable(true);
			tfLogradouro.setEditable(true);
			tfNumero.setEditable(true);
			ftfTelefone.setEditable(true);
			ftfCelular.setEditable(true);
			ftfNascimento.setEditable(true);

		} else if (e.getSource() == barraFerramentas.bConfirmar) {
			switch (temp) {
			case 1:
				try {
					Data data = Data.montaData(ftfNascimento.getText().substring(0, 2),
							ftfNascimento.getText().substring(3, 5), ftfNascimento.getText().substring(6, 10));
					String[] componentes = { tfNome.getText(), tfBairro.getText(), tfCep.getText(), tfCidade.getText(),
							tfEmail.getText(), tfLogradouro.getText(), tfNumero.getText(), ftfTelefone.getText(),
							ftfCelular.getText(), ftfNascimento.getText() };
					for (String componente : componentes) {
						if (componente.equals("")) {
							JOptionPane.showMessageDialog(null, "Preencha todos os campos!!!", "Operação Invalida",
									JOptionPane.ERROR_MESSAGE);
							break;
						}
					}
					Endereco endereco = new Endereco(tfLogradouro.getText(), tfCep.getText(), tfNumero.getText(),
							tfComplemento.getText(), tfBairro.getText(), tfCidade.getText(),
							(String) comboBoxEstado.getSelectedItem());
					System.out.println(comboBoxSexo.getSelectedItem());
					int ano = Integer.parseInt(ftfNascimento.getText().substring(6, 10));
					Cliente novoCliente = new Cliente(Integer.parseInt(tfCodigo.getText()), tfNome.getText(),
							tfEmail.getText(), ftfTelefone.getText(), ftfCelular.getText(), data, 2015 - ano,
							(String) comboBoxSexo.getSelectedItem(), endereco);

					this.clientes = clienteDAO.inserirCliente(clientes, novoCliente);
				} catch (NumberFormatException er) {
					JOptionPane.showMessageDialog(null, "Campo **Nascimento invalidos!!!", "Operação Invalida",
							JOptionPane.ERROR_MESSAGE);
					er.printStackTrace();
				} finally {
					temp = 0;
				}
				break;

			case 3:
				tfCodigo.setEditable(false);
				if (!tfCodigo.getText().equals("")) {
					try {

						if (clienteDAO.buscarCliente(clientes, tfCodigo.getText()) != null) {
							int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "Alerta",
									JOptionPane.YES_NO_OPTION);
							System.out.println(resposta);

							if (resposta == 0) {
								try {
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
			limparCamposCliente();

			tfCodigo.setEditable(false);
			barraFerramentas.bConfirmar.setEnabled(false);
			barraFerramentas.bCancelar.setEnabled(false);
			desativarCamposCliente();
			temp = 0;

		} else if (e.getSource() == bPesquisarCodigo)

		{
			try {
				Cliente cliente = null;
				try {

					cliente = clienteDAO.buscarCliente(clientes, tfCodigo.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (cliente == null) {
					JOptionPane.showMessageDialog(null, "Matricula não exite2!!!", "Operação Invalida",
							JOptionPane.WARNING_MESSAGE);
				} else {

					tfNome.setText(cliente.getNome());
					tfBairro.setText(cliente.getEndereco().getBairro());
					tfCep.setText(cliente.getEndereco().getCep());
					tfCidade.setText(cliente.getEndereco().getCidade());
					tfEmail.setText(cliente.getEmail());
					tfLogradouro.setText(cliente.getEndereco().getLogradouro());
					tfNumero.setText(cliente.getEndereco().getNumero());
					ftfTelefone.setText(cliente.getTelefone());
					ftfCelular.setText(cliente.getCelular());
					ftfNascimento.setText(cliente.getData());
					tfComplemento.setText(cliente.getEndereco().getComplemento());
					tfCidade.setText(cliente.getEndereco().getCidade());

					comboBoxEstado.setSelectedItem(cliente.getEndereco().getEstado());
					comboBoxSexo.setSelectedItem(cliente.getSexo());

				}

			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Por favor,insira um valor valido no campo **Matricula!!!",
						"Operação Invalida", JOptionPane.WARNING_MESSAGE);
			} catch (NullPointerException e1) {
				JOptionPane.showMessageDialog(null, "Matricula nao existe!!!", "Operação Invalida",
						JOptionPane.WARNING_MESSAGE);
			}
			bPesquisarCodigo.setEnabled(false);

		} else if (e.getSource() == barraFerramentas.bPesquisar)

		{
			tfCodigo.setEditable(true);
			bPesquisarCodigo.setEnabled(true);
			desativarCamposCliente();

		} else if (e.getSource() == barraFerramentas.bExcluir)

		{
			temp = 3;
			tfCodigo.setEnabled(true);
			barraFerramentas.bConfirmar.setEnabled(true);
			barraFerramentas.bCancelar.setEnabled(true);

		}

		else if (e.getSource() == barraFerramentas.bLimpar)

		{
			limparCamposCliente();

		} else if (e.getSource() == barraFerramentas.bCancelar)

		{
			tfCodigo.setEnabled(true);
			tfCodigo.setText("");

			JOptionPane.showMessageDialog(null, "Operação Cancelada!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);

			barraFerramentas.bConfirmar.setEnabled(false);
			barraFerramentas.bCancelar.setEnabled(false);

		}
	}

	private void desativarCamposCliente() {
		tfNome.setEditable(false);
		tfBairro.setEditable(false);
		tfCep.setEditable(false);
		tfCidade.setEditable(false);
		tfEmail.setEditable(false);
		tfLogradouro.setEditable(false);
		tfNumero.setEditable(false);
		ftfTelefone.setEditable(false);
		ftfCelular.setEditable(false);
		ftfNascimento.setEditable(false);
		tfComplemento.setEditable(false);
	}

	private void limparCamposCliente() {
		tfNome.setText("");
		tfBairro.setText("");
		tfCep.setText("");
		tfCidade.setText("");
		tfEmail.setText("");
		tfLogradouro.setText("");
		tfNumero.setText("");
		ftfTelefone.setText("");
		ftfCelular.setText("");
		ftfNascimento.setText("");
		tfComplemento.setText("");
	}

}
