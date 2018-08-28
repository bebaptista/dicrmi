package dicrmi;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DicionarioGrafico extends JFrame{
	
	private Verbete current;
	private JTextField palavra, significado;
	private JButton botaoConsultar, botaoAdd, botaoRemove, botaoLimpa;
	private JPanel panel;
	
	public DicionarioGrafico(){
		super("Dicionario");
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
		
		botaoConsultar.addActionListener((e)->processaConsultar());
		botaoAdd.addActionListener((e)->processaAdicionar());
		botaoRemove.addActionListener((e)->processaRemover());
		botaoLimpa.addActionListener((e)->processaLimpar());
	}

	private Object processaLimpar() {
		palavra.setText("");
		significado.setText("");
		setCurrent(null);
		return null;
	}

	private Verbete processaAdicionar() {
		Verbete v = new Verbete();
		v.setPalavra(palavra.getText());
		v.setSignificado(significado.getText());
		setCurrent(v);
		return null;
	}

	private Object processaRemover() {
		Verbete v = new Verbete();
		v.setPalavra(palavra.getText());
		setCurrent(v);
		return null;
	}

	private String processaConsultar() {
		Verbete v = new Verbete();
		v.setPalavra(palavra.getText());
		setCurrent(v);
		return null;
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
