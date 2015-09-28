package view.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Menu;
import view.PanelLogowania;

public class ClickOKInLogPanel implements ActionListener {

	PanelLogowania 	panelLogowania = null;
	String			nazwaGrupy;
	
	public ClickOKInLogPanel(PanelLogowania panelLogowania) {
		this.panelLogowania = panelLogowania;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(panelLogowania.getTextInTextArea().length()>5){
			panelLogowania.setVisibleError(false);
			nazwaGrupy = panelLogowania.getTextInTextArea();
			panelLogowania.zamknij();
			Menu menu = new Menu(panelLogowania,nazwaGrupy);
		}
		else
		{
			panelLogowania.setVisibleError(true);
		}
	}

}
