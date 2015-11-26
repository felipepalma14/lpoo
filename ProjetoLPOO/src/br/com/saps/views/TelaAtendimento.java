package br.com.saps.views;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.com.saps.modelo.Cliente;
import br.com.saps.modelo.Profissional;
import br.com.saps.utils.ToolBar;

public class TelaAtendimento extends JFrame {

	private JPanel contentPane;
	private Cliente[] listaCliente = null;
	private Profissional[] listaProfissional = null;
	private JTextField textField;
	private ToolBar barraFerramentas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtendimento frame = new TelaAtendimento();
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
	public TelaAtendimento() {
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

		String[] pacientes = { "Joao Almeida", "Carla Dias", "Julia Maria" };
		JComboBox comboxPaciente = new JComboBox(pacientes);

		comboxPaciente.setBounds(115, 60, 176, 20);
		panel.add(comboxPaciente);

		JLabel lProfissional = new JLabel("Profissional");
		lProfissional.setBounds(22, 114, 83, 14);
		panel.add(lProfissional);

		JLabel lEspecialidade = new JLabel("Especialidade");
		lEspecialidade.setBounds(22, 85, 83, 14);
		panel.add(lEspecialidade);

		JComboBox comboboxEspecialidade = new JComboBox();
		comboboxEspecialidade.setBounds(115, 85, 176, 20);
		panel.add(comboboxEspecialidade);

		JComboBox comboboxProfissional = new JComboBox();
		comboboxProfissional.setBounds(115, 114, 176, 20);
		panel.add(comboboxProfissional);

		JLabel lProtocolo = new JLabel("N. Protocolo");
		lProtocolo.setBounds(23, 30, 82, 14);
		panel.add(lProtocolo);

		textField = new JTextField();
		textField.setBounds(113, 27, 86, 20);
		panel.add(textField);
		textField.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Descri\u00E7ao", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 236, 590, 170);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JTextArea textAreaDescricao = new JTextArea();
		textAreaDescricao.setBounds(10, 21, 570, 138);
		panel_1.add(textAreaDescricao);
	}
}
