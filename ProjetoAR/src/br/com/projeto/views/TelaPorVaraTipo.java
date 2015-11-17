package br.com.projeto.views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import br.com.projeto.MontarJTable;
import br.com.projeto.dao.CorrespondenciaDAO;
import br.com.projeto.models.Correspondencia;

public class TelaPorVaraTipo extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private CorrespondenciaDAO dao;
	private MontarJTable modelo;
	private String[] colunas = new String[] { "VARA", "TIPO AR", "TOTAL" };
	private ArrayList<Correspondencia> varas, tiposAR;

	/**
	 * Launch the application.
	 */
	public static void mostrarTela() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPorVaraTipo frame = new TelaPorVaraTipo();
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
	public TelaPorVaraTipo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 486, 261);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 466, 183);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		dao = new CorrespondenciaDAO();
		varas = dao.listarVaras();
		tiposAR = dao.listarTiposAR();

		JComboBox comboVaras = new JComboBox();
		comboVaras.setBounds(10, 26, 269, 30);
		for (Correspondencia vara : varas) {
			comboVaras.addItem(vara.getNomeVara());

		}
		panel.add(comboVaras);

		JComboBox comboTipos = new JComboBox();
		comboTipos.setBounds(295, 26, 95, 30);
		for (Correspondencia tipo : tiposAR) {
			comboTipos.addItem(tipo.getTipoAR());
		}
		panel.add(comboTipos);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Correspondencia> dados = dao.listarPorVaraTipo(
						(varas.get(comboVaras.getSelectedIndex()).getNomeVara()),
						(tiposAR.get(comboTipos.getSelectedIndex()).getTipoAR()));
				modelo = new MontarJTable(dados, colunas);
				table.setModel(modelo);
				table.getColumnModel().getColumn(0).setPreferredWidth(90);
			}
		});
		btnNewButton.setBounds(400, 26, 76, 30);
		panel.add(btnNewButton);

	}
}
