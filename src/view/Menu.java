package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.handlers.ClickExit;
import view.handlers.OpenPodgladDanych;
import dataBase.DataBase;

public class Menu {

	String 			nazwaGrupy;
	JFrame			menuFrame			= new JFrame("System pomiarowy | Menu");
	JPanel			panelInfo			= new JPanel();
	JPanel			panelMain			= new JPanel();
	JPanel			panelNotification	= new JPanel();
	JLabel			infoGroup			= new JLabel();
	JLabel			error				= new JLabel();
	JButton			nowyPomiar			= new JButton("Nowy pomiar");
	JButton			podgladWartosci		= new JButton("Podgl¹d wartoœci");
	JButton			analizaDanych		= new JButton("Analiza danych");
	JButton			ustawienia			= new JButton("Ustawienia");
	JButton			wyjscie				= new JButton("Wyjœcie");
	
	PanelLogowania	parent;
	public DataBase dataBase;
	
	public Menu(PanelLogowania parent, String nazwaGrupy) {
		this.dataBase = parent.parent.dataBase;
		dataBase.funkcja.dodajGrupe(nazwaGrupy);
		this.parent = parent;
		this.nazwaGrupy = nazwaGrupy;
		infoGroup.setText("Grupa pomiarów : "+nazwaGrupy);
		init();
	}

	public void init(){
		addElement();
		addHandler();
	}
	
	public void addElement(){
		panelInfo.add(infoGroup);
		panelNotification.add(error);
		menuFrame.setLocationRelativeTo(null);
		menuFrame.setLayout(new FlowLayout());
		panelMain.setLayout(new GridLayout(5,1));
		menuFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		menuFrame.setSize(300, 250);
		panelMain.add(nowyPomiar);
		panelMain.add(podgladWartosci);
		panelMain.add(analizaDanych);
		panelMain.add(ustawienia);
		panelMain.add(wyjscie);
		menuFrame.add(panelInfo);
		menuFrame.add(panelMain);	
		setVisibleError(true);
		menuFrame.add(panelNotification);
		menuFrame.setVisible(true);
	}

	public void addHandler(){
		wyjscie.addActionListener(new ClickExit());
		podgladWartosci.addActionListener(new OpenPodgladDanych(this));
	}
	public void setVisibleError(boolean isVisible){
		panelNotification.setVisible(isVisible);
	}
}
