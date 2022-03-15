package it.unibo.radarSystem22.domain.mock;

import it.unibo.radarSystem22.domain.interfaces.IDistance;
import it.unibo.radarSystem22.domain.interfaces.ISonar;
import it.unibo.radarSystem22.domain.models.Distance;
import it.unibo.radarSystem22.domain.models.SonarModel;
import it.unibo.radarSystem22.domain.utils.BasicUtils;
import it.unibo.radarSystem22.domain.utils.DomainSystemConfig;

	//simulo il comportamento, non con valori casuali 
	//ma una serie di valori interi
	//geenero 1 valore partendo da 90 ogni 250 millisec
	//dopo 1 secondo sono a 86
	//utilizzare thread
	//accessi concorrenti nel mock ?? Necessario semaforo?
	

public class SonarMock extends SonarModel implements ISonar{
private int delta = 1;
	@Override
	protected void sonarSetUp() {
		curVal = new Distance(90);		
		//ColorsOut.out("SonarMock | sonarSetUp curVal="+curVal);
	}
	
	@Override
	public IDistance getDistance() {
		return curVal;
	}	
	@Override
	protected void sonarProduce( ) {
		if( DomainSystemConfig.testing ) {	//produces always the same value
			updateDistance( DomainSystemConfig.testingDistance );			      
		}else {
			int v = curVal.getVal() - delta;
			updateDistance( v );			    
			stopped = ( v <= 0 );
		}
		BasicUtils.delay(DomainSystemConfig.sonarDelay);  //avoid fast generation
 	}
}