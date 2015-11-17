package br.com.projeto.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 317, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Op\u00E7\u00F5es",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 22, 277, 156);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnQuantidadeAREmitidos = new JButton("Quantidade de AR Emitidos");
		btnQuantidadeAREmitidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaPorVaraTipo tela = new TelaPorVaraTipo();
				tela.mostrarTela();
			}
		});
		btnQuantidadeAREmitidos.setBounds(27, 26, 224, 23);
		panel.add(btnQuantidadeAREmitidos);

		JButton btnQuantidadeEPorcent = new JButton("Quantidade e Porcent de ARs");
		btnQuantidadeEPorcent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
		btnQuantidadeEPorcent.setBounds(27, 60, 224, 23);
		panel.add(btnQuantidadeEPorcent);

		JButton btnQuantidadeEPorcent_1 = new JButton("Qant e Porcent por Vara e Situacao");
		btnQuantidadeEPorcent_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnQuantidadeEPorcent_1.setBounds(27, 94, 224, 23);
		panel.add(btnQuantidadeEPorcent_1);

		JButton btnDiferencaEntreDatas = new JButton("Diferen\u00E7a entre Dev e Pos data");
		btnDiferencaEntreDatas.setBounds(27, 128, 224, 23);
		panel.add(btnDiferencaEntreDatas);
	}
}
