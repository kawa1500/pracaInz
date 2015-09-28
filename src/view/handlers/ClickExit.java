package view.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickExit implements ActionListener {

	public ClickExit() {
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.exit(0);
		
	}

}
