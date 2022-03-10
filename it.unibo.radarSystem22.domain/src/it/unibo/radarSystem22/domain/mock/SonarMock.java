package it.unibo.radarSystem22.domain.mock;

import it.unibo.radarSystem22.domain.interfaces.IDistance;
import it.unibo.radarSystem22.domain.interfaces.ISonar;
import it.unibo.radarSystem22.domain.models.Distance;

public class SonarMock implements ISonar{

	//simulo il comportamento, non con valori casuali 
	//ma una serie di valori interi
	//geenero 1 valore partendo da 90 ogni 250 millisec
	//dopo 1 secondo sono a 86
	//utilizzare thread
	//accessi concorrenti nel mock ?? Necessario semaforo?
	
	private Distance currVal;
	private boolean state;
	
	public SonarMock() {
		this.state= false;
		this.currVal= new Distance(90);
	}
	
	@Override
	public void activate() {
		// TODO Auto-generated method stub
		this.state=true;
	}

	@Override
	public void deacrivate() {
		// TODO Auto-generated method stub
		this.state=false;
	}

	@Override
	public IDistance getDistance() throws InterruptedException {
		// TODO Auto-generated method stub
		while(this.currVal.getVal() >= 40) {
			System.out.println(this.currVal.toString());
			this.currVal = new Distance(this.currVal.getVal()-1);
			Thread.sleep(250);
		}
		return null;
	}

	@Override
	public boolean isActive() {
		// TODO Auto-generated method stub
		return this.state;
	}

	
}
