package simulation;

import map.MapLayer;
import device.DeviceList;

public class EnergyConsumption extends Thread {

	private boolean loop = true; 
	
	@Override
	public void run() {
		int n = DeviceList.sensorListSize();
		double p ;
		while(loop) {
			for (int i = 0; i < n; i++) {
				p=Math.random();				
				if(p<0.0005) {
					DeviceList.sensors.get(i).setDead(true);
					MapLayer.repaint();
				}
			}
			try {
				sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void stopInjection() {
		loop = false;
	}
	
}
