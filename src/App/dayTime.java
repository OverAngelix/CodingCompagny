package App;

import java.text.DecimalFormat;

import javafx.application.Platform;

public class dayTime implements Runnable {
	DecimalFormat format = new DecimalFormat("00");
	public void run() {
		Platform.runLater(()->{
		while(true) {
			for(int hour = 0;hour <24;hour++) {
				for(int min = 0;min <60;min++) {
					
						App.heure.setText(""+format.format(hour)+":"+format.format(min));
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
		});
	}

}
