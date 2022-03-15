package it.unibo.radarSystem22.domain.interfaces;


public interface ISonar {
	public void activate();
	public void deactivate();
	public IDistance getDistance() throws InterruptedException;
	public boolean isActive();
}
