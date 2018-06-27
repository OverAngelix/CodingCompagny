package App;

import java.text.DecimalFormat;

import javafx.application.Platform;

public class dayTime implements Runnable {
	DecimalFormat format = new DecimalFormat("00");
	private int hour;
	private int min;
	public void run() {
		
		while(true) {
			for(hour = 0;hour <24;hour++) {
				for(min = 0;min <60;min++) {
					
					Platform.runLater(() -> App.heure.setText(""+format.format(hour)+":"+format.format(min)));
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		
		}
	}
	
}