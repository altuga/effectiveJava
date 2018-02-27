
package com.kodcu.examples.pluton.madde166.kodcu.questions;

import java.util.concurrent.TimeUnit;

public class StopThread {
	private static volatile boolean stopRequested;


	// Bu uygulama nasıl calisir ?
	public static void main(String[] args) throws InterruptedException {
		Thread backgroundThread = new Thread(new Runnable() {
			public void run() {
				int i = 0;
				while (!stopRequested) {
					i++;
				}

				System.out.println(i);
			}
		});
		backgroundThread.start();

		TimeUnit.SECONDS.sleep(1);
		stopRequested = true;
	}
}
