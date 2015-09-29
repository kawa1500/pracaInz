package view.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Menu;
import view.PodgladDanych;

public class OpenPodgladDanych implements ActionListener{

	
	Menu 			parent;
	
	public OpenPodgladDanych(Menu parent) {
		this.parent = parent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		parent.podglad = new PodgladDanych(parent);
	}

}
