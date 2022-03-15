package it.unibo.radarSystem22.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.unibo.radarSystem22.domain.interfaces.ILed;
import it.unibo.radarSystem22.domain.mock.LedMock;

public class TestLedMock {

	
	@Before
	public void up() {
		System.out.println("Up");
	}
	
	@After
	public void down() {
		System.out.println("down");
	}
	
	
	ILed led = new LedMock();
	
	@Test
	public void testLedMockOn() {
		System.out.println("Test accensione");
		assertTrue( ! led.getState() );
		led.turnOn();
		assertTrue( led.getState() );
		
	}
	
	@Test
	public void testLedMockOff() {
		System.out.println("Test spegnimento");
		led.turnOff();
		assertTrue( ! led.getState() );
	}

	@Test
	public void testLedMockOffFail() {
		System.out.println("Test spegnimento errato");
		led.turnOff();
		assertTrue( led.getState() );
	}
	
}
