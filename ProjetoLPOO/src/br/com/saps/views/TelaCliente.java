package br.com.saps.views;

import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class TelaCliente extends JFrame {

	private JPanel contentPane;
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfEmail;
	private JTextField tfTelefone;
	private JTextField tfLogradouro;
	private JTextField tfNumero;
	private JTextField tfComplemento;
	private JTextField tfCep;
	private JTextField tfCidade;
	private JTextField tfBairro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCliente frame = new TelaCliente();
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
	public TelaCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Dados Cliente", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel.setBounds(0, 59, 574, 113);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lCodigo = new JLabel("Codigo");
		lCodigo.setBounds(29, 22, 46, 14);
		panel.add(lCodigo);

		tfCodigo = new JTextField();
		tfCodigo.setBounds(92, 19, 86, 20);
		panel.add(tfCodigo);
		tfCodigo.setColumns(10);

		JLabel lNome = new JLabel("Nome");
		lNome.setBounds(29, 47, 46, 14);
		panel.add(lNome);

		tfNome = new JTextField();
		tfNome.setBounds(92, 44, 190, 20);
		panel.add(tfNome);
		tfNome.setColumns(10);

		JLabel lEmail = new JLabel("Email");
		lEmail.setBounds(29, 72, 46, 14);
		panel.add(lEmail);

		tfEmail = new JTextField();
		tfEmail.setBounds(92, 69, 190, 20);
		panel.add(tfEmail);
		tfEmail.setColumns(10);

		JLabel lNascimento = new JLabel("Nascimento");
		lNascimento.setBounds(305, 72, 72, 14);
		panel.add(lNascimento);

		JFormattedTextField ftfNascimento = new JFormattedTextField();
		ftfNascimento.setBounds(375, 69, 86, 20);
		panel.add(ftfNascimento);

		JLabel lSexo = new JLabel("Sexo");
		lSexo.setBounds(319, 47, 46, 14);
		panel.add(lSexo);

		JComboBox comboBoxSexo = new JComboBox();
		comboBoxSexo.setBounds(375, 44, 86, 20);
		panel.add(comboBoxSexo);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Contato", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(0, 187, 574, 171);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lCelular = new JLabel("Celular");
		lCelular.setBounds(34, 28, 46, 14);
		panel_1.add(lCelular);

		JFormattedTextField ftfCelular = new JFormattedTextField();
		ftfCelular.setBounds(110, 25, 92, 20);
		panel_1.add(ftfCelular);

		JLabel lTelefone = new JLabel("Telefone");
		lTelefone.setBounds(249, 28, 46, 14);
		panel_1.add(lTelefone);

		tfTelefone = new JTextField();
		tfTelefone.setBounds(305, 25, 102, 20);
		panel_1.add(tfTelefone);
		tfTelefone.setColumns(10);

		JLabel lLogradouro = new JLabel("Logradouro");
		lLogradouro.setBounds(34, 53, 70, 14);
		panel_1.add(lLogradouro);

		tfLogradouro = new JTextField();
		tfLogradouro.setBounds(110, 50, 175, 20);
		panel_1.add(tfLogradouro);
		tfLogradouro.setColumns(10);

		JLabel lNumero = new JLabel("Numero");
		lNumero.setBounds(305, 56, 46, 14);
		panel_1.add(lNumero);

		tfNumero = new JTextField();
		tfNumero.setBounds(361, 50, 46, 20);
		panel_1.add(tfNumero);
		tfNumero.setColumns(10);

		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(34, 78, 70, 14);
		panel_1.add(lblComplemento);

		tfComplemento = new JTextField();
		tfComplemento.setBounds(110, 75, 117, 20);
		panel_1.add(tfComplemento);
		tfComplemento.setColumns(10);

		JLabel lCep = new JLabel("CEP");
		lCep.setBounds(249, 81, 46, 14);
		panel_1.add(lCep);

		tfCep = new JTextField();
		tfCep.setBounds(305, 75, 102, 20);
		panel_1.add(tfCep);
		tfCep.setColumns(10);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(34, 103, 46, 14);
		panel_1.add(lblEstado);

		JComboBox comboBoxEstado = new JComboBox();
		comboBoxEstado.setBounds(110, 100, 92, 20);
		panel_1.add(comboBoxEstado);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(249, 106, 46, 14);
		panel_1.add(lblCidade);

		tfCidade = new JTextField();
		tfCidade.setBounds(305, 100, 102, 20);
		panel_1.add(tfCidade);
		tfCidade.setColumns(10);

		JLabel lBairro = new JLabel("Bairro");
		lBairro.setBounds(417, 106, 46, 14);
		panel_1.add(lBairro);

		tfBairro = new JTextField();
		tfBairro.setBounds(473, 103, 86, 20);
		panel_1.add(tfBairro);
		tfBairro.setColumns(10);
	}
}
