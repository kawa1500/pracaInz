package view.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.PomiarWidok;

public class ClickStarPomiar implements ActionListener {

	PomiarWidok parent;
	
	public ClickStarPomiar(PomiarWidok parent) {
		this.parent = parent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		parent.parent.parent.parent.reader.startPomiaru();
	}

}
