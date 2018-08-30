package br.com.puc.dicrmi.client;

import java.awt.Container;
import java.awt.GridLayout;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.puc.dicrmi.server.model.Verbete;
import br.com.puc.dicrmi.server.remote.Dicionario;

public class DicionarioGrafico extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField palavra, significado, retorno;
	private JButton botaoConsultar, botaoAdd, botaoRemove, botaoLimpa;
	private JPanel panelleft, panelright;

	public DicionarioGrafico(Dicionario dicionario) {
		super("Dicionario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		palavra = new JTextField(20);
		significado = new JTextField(200);
		retorno = new JTextField(200);

		botaoConsultar = new JButton("Consultar");
		botaoAdd = new JButton("Adicionar");
		botaoRemove = new JButton("Remover");
		botaoLimpa = new JButton("Limpar");

		panelleft = new JPanel();
		panelright = new JPanel();
		panelleft.setLayout(new GridLayout(3, 1));
		panelright.setLayout(new GridLayout(4, 1));

		panelleft.add(palavra);
		panelleft.add(significado);
		panelleft.add(retorno);
		panelright.add(botaoConsultar);
		panelright.add(botaoAdd);
		panelright.add(botaoRemove);
		panelright.add(botaoLimpa);

		Container c = getContentPane();
		c.add(panelleft);
		c.add(panelright);
		pack();

		botaoConsultar.addActionListener(e -> processaConsultar(dicionario));
		botaoAdd.addActionListener(e -> processaAdicionar(dicionario));
		botaoRemove.addActionListener(e -> processaRemover(dicionario));
		botaoLimpa.addActionListener(e -> processaLimpar());
	}

	private void processaLimpar() {
		palavra.setText("");
		significado.setText("");
		retorno.setText("");
	}

	private boolean isPalavraEmpty() {
		return palavra.getText().isEmpty();
	}

	private void processaAdicionar(Dicionario dicionario) {
		try {
			if (!isPalavraEmpty() || significado.getText().isEmpty()) {
				Verbete verbete = new Verbete();
				verbete.setPalavra(palavra.getText());
				verbete.setSignificado(significado.getText());
				retorno.setText(dicionario.adicionar(verbete));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	private void processaRemover(Dicionario dicionario) {
		try {
			if (!isPalavraEmpty()) {
				String s = palavra.getText();
				retorno.setText(dicionario.remover(s));
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

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
}
