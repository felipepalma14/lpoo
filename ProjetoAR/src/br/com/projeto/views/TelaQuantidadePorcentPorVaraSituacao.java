package br.com.projeto.views;

import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class TelaQuantidadePorcentPorVaraSituacao extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaQuantidadePorcentPorVaraSituacao frame = new TelaQuantidadePorcentPorVaraSituacao();
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
	public TelaQuantidadePorcentPorVaraSituacao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblSituao = new JLabel("Situa\u00E7\u00E3o");
		lblSituao.setBounds(10, 22, 81, 22);
		panel.add(lblSituao);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(88, 23, 275, 20);
		panel.add(comboBox);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 76, 414, 174);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
