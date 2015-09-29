package USART;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.TooManyListenersException;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;
import sun.usagetracker.UsageTrackerClient;
import view.Menu;
import view.PanelLogowania;

public class USART implements Runnable, SerialPortEventListener {
	static CommPortIdentifier portId;
    PanelLogowania 				view;
    InputStream		      inputStream;
    OutputStream		outputStream;
    SerialPort		      serialPort;
    Thread		      readThread;
	private double RESISTOR = 2.2;

   
    public USART(CommPortIdentifier portId, PanelLogowania menu) {
    	this.portId = portId;
    	this.view=menu;
	try {
	    serialPort = (SerialPort) portId.open("Com1", 20);
	} catch (PortInUseException e) {}

	try {
	    inputStream = serialPort.getInputStream();
	} catch (IOException e) {}

	try {
	    outputStream = serialPort.getOutputStream();
	} catch (IOException e) {}

	
	try {
	    serialPort.addEventListener(this);
	} catch (TooManyListenersException e) {}

	serialPort.notifyOnDataAvailable(true);

	try {
	    serialPort.setSerialPortParams(115200, SerialPort.DATABITS_8, 
					   SerialPort.STOPBITS_1, 
					   SerialPort.PARITY_NONE);
	} catch (UnsupportedCommOperationException e) {}

	readThread = new Thread(this);

	readThread.start();
    }


 
    public void serialEvent(SerialPortEvent event) {
	switch (event.getEventType()) {

	case SerialPortEvent.BI:

	case SerialPortEvent.OE:

	case SerialPortEvent.FE:

	case SerialPortEvent.PE:

	case SerialPortEvent.CD:

	case SerialPortEvent.CTS:

	case SerialPortEvent.DSR:

	case SerialPortEvent.RI:

	case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
	    break;

	case SerialPortEvent.DATA_AVAILABLE:
	    byte[] readBuffer = new byte[10];
	    int numBytes=0;
	    try {
		while (inputStream.available() > 0) 
		{
		    numBytes = inputStream.read(readBuffer);
		} 
	    } catch (IOException e) {}
	    String odczyt= new String(readBuffer);
	    odczyt=odczyt.substring(0, numBytes);
	    System.out.println(odczyt);
	    analizaOdczytu(odczyt);
	    break;
	}
    }

	@Override
	public void run() {
		try {
		    Thread.sleep(0);
		} catch (InterruptedException e) {}
		
	} 
	
	public void analizaOdczytu(String odczyt)
	{
		if(odczyt.contains("V-")){
			String value = odczyt.substring(2);
			Integer adc = Integer.parseInt(value);
			double wartosc = (double)(((double)adc/4096)*3.3*(11.5/1.5));
			napiecie(wartosc);
		}
		else if(odczyt.contains("A-")){
			String value = odczyt.substring(2);
			Integer adc = Integer.parseInt(value);
			double wartosc = (double)((((double)adc/4096)*3.3*(11.5/1.5))/RESISTOR);
			prad(wartosc);
		}
		else if(odczyt.contains("C-")){
			String value = odczyt.substring(2);
			Integer adc = Integer.parseInt(value);
			double wartosc = (double)((double)adc/10);
			czas(wartosc);
		}
		
		
	}
	
	public void napiecie(double wartosc){
		if(view.menu.podglad!=null){
			view.menu.podglad.setNapiecie(String.format("%.2f",wartosc)+" V");
		}
		
		if(view.menu.pomiarWidok!=null){
			view.menu.pomiarWidok.setNapiecie(String.format("%.2f",wartosc)+" V");
		}
	}
	
	public void prad(double wartosc){
		if(view.menu.podglad!=null){
			view.menu.podglad.setPrad(String.format("%.2f",wartosc)+" A");
		}
		
		if(view.menu.pomiarWidok!=null){
			view.menu.pomiarWidok.setPrad(String.format("%.2f",wartosc)+" A");
		}
	}

	public void czas(double wartosc){		
		if(view.menu.pomiarWidok!=null){
			view.menu.pomiarWidok.setCzas(wartosc+" ms");
		}
	}
	
	public void startPomiaru()
	{
		try {
			this.outputStream.write('n');
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
