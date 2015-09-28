package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.handlers.ClickBackToMenu;



public class PodgladDanych {

	JFrame			menuFrame			= new JFrame("System pomiarowy | Podgl¹d wartoœci");
	JPanel			panelMain			= new JPanel();
	JLabel			labelNapiecie		= new JLabel("Wartosc napiêcia : ");
	JLabel			labelPrad			= new JLabel("Wartoœæ pr¹du : ");
	JTextField		textNapiecie		= new JTextField();
	JTextField		textPrad			= new JTextField();
	JButton			zamknij				= new JButton("Zamknij");
	Menu			parent;
	
	public PodgladDanych(Menu parent) {
		this.parent = parent;
		init();
	}

	public void init(){

		menuFrame.setLocationRelativeTo(null);
		menuFrame.setLayout(new FlowLayout());
		panelMain.setLayout(new GridLayout(4,1));
		menuFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		menuFrame.setSize(300, 150);
		panelMain.add(labelNapiecie);
		panelMain.add(textNapiecie);
		panelMain.add(labelPrad);
		panelMain.add(textPrad);
		menuFrame.add(panelMain);
		menuFrame.add(zamknij);
		menuFrame.setVisible(true);

		textNapiecie.setEditable(false);
		textPrad.setEditable(false);
		
		zamknij.addActionListener(new ClickBackToMenu(menuFrame));
	}
	
	public void setNapiecie(String napiecie){
		textNapiecie.setText(napiecie);
	}
	
	public void setPrad(String prad){
		textPrad.setText(prad);
	}
}
