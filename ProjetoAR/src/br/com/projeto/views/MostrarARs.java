package br.com.projeto.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import br.com.projeto.MontarJTable;
import br.com.projeto.dao.CorrespondenciaDAO;

public class MostrarARs extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private MontarJTable modelo;

	private CorrespondenciaDAO dao;
	private String[] colunas = new String[] { "ID", "FORUM" };

	/**
	 * Launch the application.
	 */
	public static void mostrarTela() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarARs frame = new MostrarARs();
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
	public MostrarARs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 214);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(10, 11, 394, 192);
		panel.add(scrollPane);

		dao = new CorrespondenciaDAO();
		modelo = new MontarJTable(dao.listarCorrespondencias(), colunas);
		table = new JTable();
		table.setModel(modelo);
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		scrollPane.setViewportView(table);
	}

}
