package ticks;

import simulation.Event;

class Tick implements Event<Ticks> {

	@Override
	public void invoke(Ticks simulation) {
		System.out.println("Tick at: " + simulation.getCurrentTime());	
	}

}
