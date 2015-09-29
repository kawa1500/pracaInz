package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.Main;
import view.handlers.ClickOKInLogPanel;

public class PanelLogowania {

	JFrame			logFrame			= new JFrame("System pomiarowy");
	JPanel			logPanel			= new JPanel();
	JLabel			labelTitle  		= new JLabel("Wpisz nazwe grupy pomiarów");
	JTextField		textAreaNameGroup	= new JTextField();
	JButton			przyciskOK			= new JButton("Zapisz");
	JPanel			notification		= new JPanel();
	JLabel			error				= new JLabel("Nazwa musi byc d³u¿sza ni¿ 5znaków");
	public Main			parent;
	public Menu menu = null;
	public PanelLogowania(Main parent) {
		this.parent = parent;
		init();
	}
	
	public void init(){
		notification.add(error);
		logFrame.setLocationRelativeTo(null);
		logFrame.setLayout(new FlowLayout());
		logPanel.setLayout(new GridLayout(3,1));
		logFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		logFrame.setSize(300, 150);
		logPanel.add(labelTitle);
		logPanel.add(textAreaNameGroup);
		logPanel.add(przyciskOK);
		logFrame.add(logPanel);	
		setVisibleError(false);
		logFrame.add(notification);
		logFrame.setVisible(true);
		textAreaNameGroup.addActionListener(new ClickOKInLogPanel(this));
		przyciskOK.addActionListener(new ClickOKInLogPanel(this));
	}

	public String getTextInTextArea(){
		return textAreaNameGroup.getText();
	}
	
	public void setVisibleError(boolean isVisible){
		notification.setVisible(isVisible);
	}
	
	public void zamknij(){
		logFrame.dispose();
	}
}
