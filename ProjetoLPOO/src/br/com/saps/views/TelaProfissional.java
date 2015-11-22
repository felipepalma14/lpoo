package br.com.saps.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

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
import br.com.saps.utils.ToolBar;

public class TelaProfissional extends JFrame implements ActionListener {

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
	private ProfissionalDAO profissionalDAO;
	private Profissional[] arquivoProfissional;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProfissional window = new TelaProfissional();
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
	public TelaProfissional() {
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
		// tfMatricula.setEnabled(false);

		JLabel lCpf = new JLabel("CPF");
		lCpf.setBounds(20, 81, 46, 14);
		panel.add(lCpf);

		tfCpf = new JTextField();
		tfCpf.setBounds(124, 81, 86, 20);
		panel.add(tfCpf);
		tfCpf.setColumns(10);
		tfCpf.setEnabled(false);

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

		tfSigla = new JTextField();
		tfSigla.setBounds(124, 162, 86, 20);
		panel.add(tfSigla);
		tfSigla.setColumns(10);
		tfSigla.setEnabled(false);

		lTipo = new JLabel("Tipo");
		lTipo.setBounds(20, 185, 46, 14);
		panel.add(lTipo);

		tfTipo = new JTextField();
		tfTipo.setBounds(124, 185, 86, 20);
		panel.add(tfTipo);
		tfTipo.setColumns(10);
		tfTipo.setEnabled(false);

		barraFerramentas.bConfirmar.setEnabled(false);
		barraFerramentas.bCancelar.setEnabled(false);
		barraFerramentas.bIncluir.addActionListener(this);
		barraFerramentas.bConfirmar.addActionListener(this);
		barraFerramentas.bPesquisar.addActionListener(this);
		barraFerramentas.bLimpar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == barraFerramentas.bIncluir) {
			barraFerramentas.bConfirmar.setEnabled(true);
			barraFerramentas.bCancelar.setEnabled(true);

			tfMatricula.setEnabled(false);
			tfMatricula.setText(ProfissionalDAO.gerarMatricula(arquivoProfissional));
			tfProfissional.setEnabled(true);
			tfCpf.setEnabled(true);
			tfRegisProf.setEnabled(true);
			tfSigla.setEnabled(true);
			tfTipo.setEnabled(true);
			tfData.setEnabled(true);

		} else if (e.getSource() == barraFerramentas.bConfirmar) {
			try {
				Data data = Data.montaData(tfData.getText().substring(0, 2), tfData.getText().substring(3, 5),
						tfData.getText().substring(6, 10));
				Profissional novoProfissional = profissionalDAO.criarProfissional(tfProfissional.getText(),
						tfMatricula.getText(), tfCpf.getText(), data, tfSigla.getText(), tfTipo.getText(),
						tfRegisProf.getText());
				arquivoProfissional = profissionalDAO.inserirProfissional(arquivoProfissional, novoProfissional);
			} catch (Exception er) {

				JOptionPane.showMessageDialog(null, "Preencha todos os campos!!!", "Operação Invalida",
						JOptionPane.ERROR_MESSAGE);
			}
			// se tudo tiver ok, limpa os campos
			tfMatricula.setText("");
			tfProfissional.setText("");
			tfCpf.setText("");
			tfData.setText("");
			tfSigla.setText("");
			tfTipo.setText("");
			tfRegisProf.setText("");

			tfMatricula.setEnabled(true);
			tfProfissional.setEnabled(false);

			tfCpf.setEnabled(false);
			tfData.setEnabled(false);
			tfSigla.setEnabled(false);
			tfTipo.setEnabled(false);
			tfRegisProf.setEnabled(false);

		} else if (e.getSource() == barraFerramentas.bPesquisar) {
			/*
			 * Pensar melhor aqui
			 */
			Profissional profissional = null;
			try {
				profissional = profissionalDAO.buscarProfissional(arquivoProfissional,
						Integer.parseInt(tfMatricula.getText()));
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			tfMatricula.setText(profissional.getMatricula());
			tfProfissional.setText(profissional.getNome());
			tfCpf.setText(profissional.getCpf());
			tfData.setText(String.valueOf(profissional.getData()));
			System.out.println(String.valueOf(profissional.getData()));

			tfSigla.setText(profissional.getSigla());
			tfTipo.setText(profissional.getTipo());
			tfRegisProf.setText(profissional.getNumeroRP());

		} else if (e.getSource() == barraFerramentas.bLimpar)

		{
			tfProfissional.setText("");
			tfCpf.setText("");
			tfData.setText("");
			tfSigla.setText("");
			tfTipo.setText("");
			tfRegisProf.setText("");

		}

	}

}
