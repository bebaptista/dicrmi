package br.com.puc.dicrmi.client;

import java.awt.Container;
import java.awt.GridLayout;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.puc.dicrmi.server.model.Verbete;
import br.com.puc.dicrmi.server.remote.Dicionario;

public class DicionarioGrafico extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField palavra, significado;
	private JLabel labelPalavra;
	private JButton botaoConsultar, botaoAdd, botaoRemove, botaoLimpa;
	private JPanel panelLeft, panelRight;

	public DicionarioGrafico(Dicionario dicionario) {
		super("Dicionario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		palavra = new JTextField(20);
		significado = new JTextField(200);
		
		labelPalavra = new JLabel("Palavra",JLabel.CENTER);

		botaoConsultar = new JButton("Consultar");
		botaoAdd = new JButton("Adicionar");
		botaoRemove = new JButton("Remover");
		botaoLimpa = new JButton("Limpar");

		panelLeft = new JPanel();
		panelRight = new JPanel();
		panelLeft.setLayout(new GridLayout(5, 0));
		panelRight.setLayout(new GridLayout(4, 0));

		panelLeft.add(palavra);
		panelLeft.add(labelPalavra);
		panelLeft.add(significado);
		panelRight.add(botaoConsultar);
		panelRight.add(botaoAdd);
		panelRight.add(botaoRemove);
		panelRight.add(botaoLimpa);

		Container c = getContentPane();
		c.setLayout(new GridLayout(0,2));
		c.add(panelLeft);
		c.add(panelRight);
		pack();

		botaoConsultar.addActionListener(e -> processaConsultar(dicionario));
		botaoAdd.addActionListener(e -> processaAdicionar(dicionario));
		botaoRemove.addActionListener(e -> processaRemover(dicionario));
		botaoLimpa.addActionListener(e -> processaLimpar());
	}

	private void processaLimpar() {
		palavra.setText("");
		significado.setText("");
	}

	private boolean isPalavraEmpty() {
		return palavra.getText().isEmpty();
	}

	private void processaAdicionar(Dicionario dicionario) {
		try {
			if (!isPalavraEmpty() && !significado.getText().isEmpty()) {
				Verbete verbete = new Verbete();
				verbete.setPalavra(palavra.getText());
				verbete.setSignificado(significado.getText());
				significado.setText(dicionario.adicionar(verbete));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	private void processaRemover(Dicionario dicionario) {
		try {
			if (!isPalavraEmpty()) {
				String s = palavra.getText();
				significado.setText(dicionario.remover(s));
			}
		} catch (RemoteException e) {
			// TODO: handle exception
		}
	}

	private void processaConsultar(Dicionario dicionario) {
		try {
			if (!isPalavraEmpty()) {
				significado.setText(dicionario.consultar(palavra.getText()));
			}
		} catch (RemoteException e) {
			// TODO: handle exception
		}
	}

	public JTextField getPalavra() {
		return palavra;
	}

	public void setInput(JTextField palavra) {
		this.palavra = palavra;
	}

	public JTextField getSignificado() {
		return significado;
	}

	public void setOutput(JTextField significado) {
		this.significado = significado;
	}

	public JButton getBotaoConsultar() {
		return botaoConsultar;
	}

	public void setBotaoConsultar(JButton botaoConsultar) {
		this.botaoConsultar = botaoConsultar;
	}

	public JButton getBotaoAdd() {
		return botaoAdd;
	}

	public void setBotaoAdd(JButton botaoAdd) {
		this.botaoAdd = botaoAdd;
	}

	public JButton getBotaoRemove() {
		return botaoRemove;
	}

	public void setBotaoRemove(JButton botaoRemove) {
		this.botaoRemove = botaoRemove;
	}

	public JButton getBotaoLimpa() {
		return botaoLimpa;
	}

	public void setBotaoLimpa(JButton botaoLimpa) {
		this.botaoLimpa = botaoLimpa;
	}

	public JPanel getPanelLeft() {
		return panelLeft;
	}

	public void setPanelLeft(JPanel panelLeft) {
		this.panelLeft = panelLeft;
	}
	
	public JPanel getPanelRight() {
		return panelRight;
	}

	public void setPanelRight(JPanel panelRight) {
		this.panelRight = panelRight;
	}
}
