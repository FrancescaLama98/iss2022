package it.unibo.radarSystem22.domain.concrete;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import it.unibo.radarSystem22.domain.interfaces.ISonar;
import it.unibo.radarSystem22.domain.models.Distance;
import it.unibo.radarSystem22.domain.models.SonarModel;

public class SonarConcrete extends SonarModel implements ISonar{

	private BufferedReader reader ;
	private Process p ;
	
	@Override
	protected void sonarSetUp() {
		// TODO Auto-generated method stub
		curVal = new Distance(90);	
	}

	@Override
	public void activate() {
		//ColorsOut.out("SonarConcrete | activate ");
 		if( p == null ) { 
 	 		try {
 				p       = Runtime.getRuntime().exec("sudo ./SonarAlone");
 		        reader  = new BufferedReader( new InputStreamReader(p.getInputStream()));
 		        //ColorsOut.out("SonarConcrete | sonarSetUp done");
 	       	}catch( Exception e) {
 	       		//ColorsOut.outerr("SonarConcrete | sonarSetUp ERROR " + e.getMessage() );
 	    	}
 		}
 		super.activate();
 	}
	
	@Override
	protected void sonarProduce() {
		// TODO Auto-generated method stub
		
	}

}
