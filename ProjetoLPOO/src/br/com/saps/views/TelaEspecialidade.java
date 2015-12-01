package br.com.saps.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class TelaEspecialidade extends JFrame {

	private JPanel contentPane;
	private JTextField tfCodigo;
	private JTextField tfDescricao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEspecialidade frame = new TelaEspecialidade();
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
	public TelaEspecialidade() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Especialidade", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 66, 434, 195);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lCodigo = new JLabel("Codigo");
		lCodigo.setBounds(27, 46, 46, 14);
		panel.add(lCodigo);

		tfCodigo = new JTextField();
		tfCodigo.setBounds(108, 43, 65, 20);
		panel.add(tfCodigo);
		tfCodigo.setColumns(10);

		JLabel lDescricao = new JLabel("Descri\u00E7\u00E3o");
		lDescricao.setBounds(27, 84, 46, 14);
		panel.add(lDescricao);

		tfDescricao = new JTextField();
		tfDescricao.setBounds(108, 81, 126, 20);
		panel.add(tfDescricao);
		tfDescricao.setColumns(10);
	}

}
