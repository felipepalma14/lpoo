package br.com.saps.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import br.com.saps.utils.ToolBar;

public class TelaPrincipal extends JFrame {

	private JFrame frmSapsSistema;
	private ToolBar barraFerramentas;
	private JLabel lProfissional;
	private JTextField tfProfissional;
	private JTextField tfMatricula;
	private JTextField tfCpf;
	private JTextField tfRegisProf;
	private JLabel lRegisProf;
	private JLabel tSigla;
	private JTextField tfSigla;
	private JLabel lTipo;
	private JTextField tfTipo;
	private JFormattedTextField tfData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmSapsSistema.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
		Acesso acesso = new Acesso(frmSapsSistema, "TESTE", true, this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		barraFerramentas = new ToolBar();
		barraFerramentas.setBounds(1, 2, 619, 57);
		frmSapsSistema = new JFrame();
		frmSapsSistema.setFont(new Font("Adobe Kaiti Std R", Font.BOLD, 12));
		frmSapsSistema.setTitle("SAPS - Sistema de Atendimento ao Profissional de Sa\u00FAde");
		frmSapsSistema.setBounds(100, 100, 636, 383);
		frmSapsSistema.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSapsSistema.getContentPane().setLayout(null);
		frmSapsSistema.getContentPane().add(barraFerramentas);
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

		JLabel lMatricula = new JLabel("Matricula");
		lMatricula.setBounds(20, 31, 59, 14);
		panel.add(lMatricula);

		tfMatricula = new JTextField();
		tfMatricula.setBounds(124, 31, 86, 20);
		panel.add(tfMatricula);
		tfMatricula.setColumns(10);

		JLabel lCpf = new JLabel("CPF");
		lCpf.setBounds(20, 81, 46, 14);
		panel.add(lCpf);

		tfCpf = new JTextField();
		tfCpf.setBounds(124, 81, 86, 20);
		panel.add(tfCpf);
		tfCpf.setColumns(10);

		JLabel lData = new JLabel("Data");
		lData.setBounds(20, 106, 46, 14);
		panel.add(lData);

		tfRegisProf = new JTextField();
		tfRegisProf.setBounds(124, 134, 86, 20);
		panel.add(tfRegisProf);
		tfRegisProf.setColumns(10);

		JFormattedTextField formattedTextField = null;
		try {
			tfData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		tfData.setBounds(124, 106, 86, 20);
		panel.add(tfData);

		lRegisProf = new JLabel("Reg. Prof.");
		lRegisProf.setBounds(20, 137, 59, 14);
		panel.add(lRegisProf);

		tSigla = new JLabel("Sigla");
		tSigla.setBounds(20, 162, 59, 14);
		panel.add(tSigla);

		tfSigla = new JTextField();
		tfSigla.setBounds(124, 162, 86, 20);
		panel.add(tfSigla);
		tfSigla.setColumns(10);

		lTipo = new JLabel("Tipo");
		lTipo.setBounds(20, 185, 46, 14);
		panel.add(lTipo);

		tfTipo = new JTextField();
		tfTipo.setBounds(124, 185, 86, 20);
		panel.add(tfTipo);
		tfTipo.setColumns(10);
	}
}
