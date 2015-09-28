package view.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ClickBackToMenu implements ActionListener {

	JFrame okno;
	
	public ClickBackToMenu(JFrame okno) {
		this.okno = okno;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		okno.setVisible(false);
		okno.dispose();
	}

}
