package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PomiarWidok {

	JFrame			frame		= new JFrame("System pomiarowy | Pomiar");
	JPanel			mainPanel	= new JPanel();
	JPanel			leftPanel	= new JPanel();
	//panel informacyjny
	JPanel			infoPanel	= new JPanel();
	JLabel			infoLabel	= new JLabel("InfoPanel");
	//panel z danymi
	JPanel			wartosciPanel 	=new JPanel();
	JLabel			labelCzas		= new JLabel("Czas zadzia³ania wyl¹cznika");
	JTextField		wartoscCzas		= new JTextField();
	JLabel			labelNapiecei	= new JLabel("Napiecie uk³adu");
	JTextField		wartoscNapiecie	= new JTextField();
	JLabel			labelPrad		= new JLabel("Pr¹d uk³adu");
	JTextField		wartoscPrad		= new JTextField();
	//panel sterowania
	JPanel			sterowaniePanel	= new JPanel();
	JButton			startButton		= new JButton("Start");
	JButton			resetButton		= new JButton("Reset");
	JButton			stopButton		= new JButton("Stop");
	//panel b³êdów uk³adu
	JPanel			errorPanel		= new JPanel();
	JLabel			opisError		= new JLabel("B³edy w ukladzie");
	JTextArea		LogError		= new JTextArea();
	//panel logow
	JPanel			logPanel		= new JPanel();
	JLabel			opisLog		= new JLabel("Informacje w uk³adzie");
	JTextArea		LogArea			= new JTextArea();
	//panel statusu
	JPanel 			statusPanel		= new JPanel();
	JCheckBox		statusWylacznika	= new JCheckBox("Status wy³¹cznika");
	JCheckBox		statusPolaczenia	= new JCheckBox("Status po³¹czenia");
	JCheckBox		statusUkladu		= new JCheckBox("Status uk³adu");
	JCheckBox		statusPomiaru		= new JCheckBox("Status pomiaru");
	
	public PomiarWidok() {
		init();
	}

	public void initInfoPanel(){
		infoPanel.setLayout(new FlowLayout());
		infoPanel.add(infoLabel);
		//frame.add(infoPanel);
	}
	
	public void initDanePanel(){
		wartosciPanel.setLayout(new GridLayout(6, 1));
		wartosciPanel.add(labelCzas);
		wartosciPanel.add(wartoscCzas);
		wartosciPanel.add(labelNapiecei);
		wartosciPanel.add(wartoscNapiecie);
		wartosciPanel.add(labelPrad);
		wartosciPanel.add(wartoscPrad);
		//frame.add(wartosciPanel);
	}
	
	public void initSterowaniePanel(){
		sterowaniePanel.setLayout(new GridLayout(3, 1));
		sterowaniePanel.add(startButton);
		sterowaniePanel.add(resetButton);
		sterowaniePanel.add(stopButton);
		//frame.add(sterowaniePanel);
	}
	
	public void initErrorAndLogPanel(){
		errorPanel.setLayout(new GridLayout(2, 1));
		logPanel.setLayout(new GridLayout(2, 1));
		errorPanel.add(opisError);
		errorPanel.add(LogError);
		logPanel.add(opisLog);
		logPanel.add(LogArea);
		//frame.add(errorPanel);
		//frame.add(logPanel);
	}
	
	public void initstatuspanel(){
		statusPanel.setLayout(new GridLayout(4, 1));
		statusPanel.add(statusPolaczenia);
		statusPanel.add(statusUkladu);
		statusPanel.add(statusWylacznika);
		statusPanel.add(statusPomiaru);
		//frame.add(statusPanel);
	}
	
	public void init(){
		initInfoPanel();
		initDanePanel();
		initSterowaniePanel();
		initErrorAndLogPanel();
		initstatuspanel();
		leftPanel.setLayout(new GridLayout(2, 1));
		leftPanel.add(sterowaniePanel);
		leftPanel.add(statusPanel);
		mainPanel.setLayout(new GridLayout(1, 2));
		mainPanel.add(wartosciPanel);
		mainPanel.add(leftPanel);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new FlowLayout());
		frame.add(infoPanel);
		frame.add(mainPanel);
		frame.add(logPanel);
		frame.add(errorPanel);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setVisible(true);
	}
}
