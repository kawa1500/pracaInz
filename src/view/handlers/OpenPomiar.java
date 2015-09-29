package view.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Menu;
import view.PodgladDanych;
import view.PomiarWidok;

public class OpenPomiar implements ActionListener{

	PomiarWidok		pomiarWidok;
	Menu 			parent;
	
	public OpenPomiar(Menu parent) {
		this.parent = parent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		pomiarWidok = new PomiarWidok();
	}

}
