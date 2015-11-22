package br.com.saps.utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

/**
 * @Panel of Tool Bar
 */
public class ToolBar extends JPanel {

	int qtdeBotoes = 7;
	public JScrollPane pCad;
	public JButton bIncluir, bAtualizar, bExcluir, bConfirmar, bCancelar, bLimpar, bPesquisar; // bInitialization,
																								// bVisualization,
																								// bConfiguration,
																								// bSegmentation;
	private Dimension dimension = new Dimension(20, 0);

	public ToolBar() {

		BorderLayout blBarra = new BorderLayout();
		setLayout(blBarra);

		Color color = new Color(30, 130, 200, 230);

		// Configura��es para a barra de ferramenta
		ImageIcon[] vectorImageToolBar = new ImageIcon[qtdeBotoes]; // vetor de
																	// imagens
																	// da barra
																	// de
																	// ferramenta
																	// de
																	// cadastro
		String iconesToolBar[] = { "imagem/incluir.png", "imagem/atualizar.png", "imagem/excluir.png",
				"imagem/confirmar.png", "imagem/cancelar.png", "imagem/limpar.png", "imagem/novo.png" };
		for (int i = 0; i < iconesToolBar.length; i++) {
			vectorImageToolBar[i] = new ImageIcon(iconesToolBar[i]);
		}

		JPanel pBotoes = new JPanel();
		pBotoes.setLayout(new FlowLayout(FlowLayout.LEFT));

		bIncluir = new JButton(vectorImageToolBar[0]);
		bIncluir.setFont(new Font("TimesRoman", Font.PLAIN, 18));
		// bIncluir.addActionListener(this);
		bIncluir.setToolTipText("Inclui um novo registro");
		bIncluir.setVerticalTextPosition(SwingConstants.BOTTOM);
		bIncluir.setHorizontalTextPosition(SwingConstants.CENTER);
		bIncluir.setOpaque(false);

		bAtualizar = new JButton(vectorImageToolBar[1]);
		bAtualizar.setFont(new Font("TimesRoman", Font.PLAIN, 18));
		// bAtualizar.addActionListener(this);
		bAtualizar.setToolTipText("Atualiza registro");
		bAtualizar.setVerticalTextPosition(SwingConstants.BOTTOM);
		bAtualizar.setHorizontalTextPosition(SwingConstants.CENTER);
		bAtualizar.setOpaque(false);
		bAtualizar.setBackground(color);

		bExcluir = new JButton(vectorImageToolBar[2]);
		bExcluir.setFont(new Font("TimesRoman", Font.PLAIN, 18));
		// bExcluir.addActionListener(this);
		bExcluir.setToolTipText("Exclui registro");
		bExcluir.setVerticalTextPosition(SwingConstants.BOTTOM);
		bExcluir.setHorizontalTextPosition(SwingConstants.CENTER);
		bExcluir.setOpaque(false);
		bExcluir.setBackground(color);

		bConfirmar = new JButton(vectorImageToolBar[3]);
		bConfirmar.setFont(new Font("TimesRoman", Font.PLAIN, 18));
		// bConfirmar.addActionListener(this);
		bConfirmar.setToolTipText("Confirma opera��o");
		bConfirmar.setVerticalTextPosition(SwingConstants.BOTTOM);
		bConfirmar.setHorizontalTextPosition(SwingConstants.CENTER);
		bConfirmar.setOpaque(false);
		bConfirmar.setBackground(color);

		bCancelar = new JButton(vectorImageToolBar[4]);
		bCancelar.setFont(new Font("TimesRoman", Font.PLAIN, 18));
		// bCancelar.addActionListener(this);
		bCancelar.setToolTipText("Cancelar opera��o");
		bCancelar.setVerticalTextPosition(SwingConstants.BOTTOM);
		bCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		bCancelar.setOpaque(false);
		bCancelar.setBackground(color);

		bLimpar = new JButton(vectorImageToolBar[5]);
		bLimpar.setFont(new Font("TimesRoman", Font.PLAIN, 18));
		// bLimpar.addActionListener(this);
		bLimpar.setToolTipText("Limpa os campos");
		bLimpar.setVerticalTextPosition(SwingConstants.BOTTOM);
		bLimpar.setHorizontalTextPosition(SwingConstants.CENTER);
		bLimpar.setOpaque(false);
		bLimpar.setBackground(color);

		bPesquisar = new JButton(vectorImageToolBar[6]);
		bPesquisar.setFont(new Font("TimesRoman", Font.PLAIN, 18));
		// bPesquisar.addActionListener(this);
		bPesquisar.setToolTipText("Pesquisa de registros");
		bPesquisar.setVerticalTextPosition(SwingConstants.BOTTOM);
		bPesquisar.setHorizontalTextPosition(SwingConstants.CENTER);
		bPesquisar.setOpaque(false);
		bPesquisar.setBackground(color);

		setOpaque(false);
		setBackground(null);

		JToolBar BarraFer = new JToolBar(0);
		BarraFer.setFloatable(false);
		BarraFer.setRollover(true);
		BarraFer.add(bIncluir);
		BarraFer.addSeparator(dimension);
		BarraFer.add(bAtualizar);
		BarraFer.addSeparator(dimension);
		BarraFer.add(bExcluir);
		BarraFer.addSeparator(dimension);
		BarraFer.add(bConfirmar);
		BarraFer.addSeparator(dimension);
		BarraFer.add(bCancelar);
		BarraFer.addSeparator(dimension);
		BarraFer.addSeparator(dimension);
		BarraFer.addSeparator(dimension);
		BarraFer.addSeparator(dimension);
		BarraFer.add(bLimpar);
		BarraFer.addSeparator(dimension);
		BarraFer.add(bPesquisar);
		BarraFer.setOpaque(false);
		BarraFer.setBackground(null);
		add(BarraFer);

	}

	public void bloquearBotoes() {
		bIncluir.setEnabled(false);
		bAtualizar.setEnabled(false);
		bExcluir.setEnabled(false);
		bConfirmar.setEnabled(true);
		bCancelar.setEnabled(true);
		bLimpar.setEnabled(true);
		bPesquisar.setEnabled(true);

	}

	public void desbloquearBotoes() {
		bIncluir.setEnabled(true);
		bAtualizar.setEnabled(true);
		bExcluir.setEnabled(true);
		bConfirmar.setEnabled(false);
		bCancelar.setEnabled(false);
		bLimpar.setEnabled(false);
		bPesquisar.setEnabled(false);

	}

	/*
	 * public void incluir(){ bloquearBotoes(); operacao = '1'; }
	 * 
	 * public void atualizar(){ bloquearBotoes(); operacao = '2';
	 * 
	 * } public void excluir(){ bloquearBotoes(); operacao = '3';
	 * 
	 * } public void confirmar(){ desbloquearBotoes(); }
	 * 
	 * 
	 * public void pesquisar(){ desbloquearBotoes(); }
	 */
	public void paint(Graphics g) {
		super.paint(g);
		// Graphics2D g2d = (Graphics2D) g;

	}

}