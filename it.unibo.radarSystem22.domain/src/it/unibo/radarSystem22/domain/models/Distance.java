package it.unibo.radarSystem22.domain.models;

import it.unibo.radarSystem22.domain.interfaces.IDistance;

public class Distance implements IDistance{

	private int value;
	
	public Distance(int v) {
		this.value=v;
	}
	
	@Override
	public int getVal() {
		// TODO Auto-generated method stub
		return this.value;
	}
	
	@Override
	public String toString() {
		return ""+ this.value;
	}

}
