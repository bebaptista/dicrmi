package br.com.puc.dicrmi.client;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.puc.dicrmi.server.model.Verbete;
import br.com.puc.dicrmi.server.remote.Dicionario;

public class DicionarioGrafico extends JFrame{
	
	private Verbete current;
	private JTextField palavra, significado;
	private JButton botaoConsultar, botaoAdd, botaoRemove, botaoLimpa;
	private JPanel panel;
	private Dicionario dicionario;
	
	public DicionarioGrafico(Dicionario dicionario){
		super("Dicionario");
		this.dicionario = dicionario;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		palavra = new JTextField(20);
		significado = new JTextField(200);
		
		botaoConsultar = new JButton("Consultar");
		botaoAdd = new JButton("Adicionar");
		botaoRemove = new JButton("Remover");
		botaoLimpa = new JButton("Limpar");
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(2,2));
		
		panel.add(palavra);
		panel.add(significado);
		panel.add(botaoConsultar);
		panel.add(botaoAdd);
		panel.add(botaoRemove);
		panel.add(botaoLimpa);
		
		Container c = getContentPane();
		c.add(panel);
		pack();
		
		botaoConsultar.addActionListener((e)->processaConsultar(dicionario));
		botaoAdd.addActionListener(e->processaAdicionar(dicionario));
		botaoRemove.addActionListener((e)->processaRemover(dicionario));
		botaoLimpa.addActionListener((e)->processaLimpar());
	}

	private void processaLimpar() {
		palavra.setText("");
		significado.setText("");
	}

	private void processaAdicionar(Dicionario dicionario) {
		Verbete v = new Verbete();
		v.setPalavra(palavra.getText());
		v.setSignificado(significado.getText());
		significado.setText(dicionario.adicionar(v));
	}

	private void processaRemover(Dicionario dicionario) {
		String s = palavra.getText();
		significado.setText(dicionario.remover(s));
	}

	private void processaConsultar(Dicionario dicionario) {
		significado.setText(dicionario.consultar(palavra.getText()));
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

	public Verbete getCurrent() {
		return current;
	}

	public void setCurrent(Verbete current) {
		this.current = current;
	}
}
