package ticks;

import simulation.Simulation;

public class Ticks extends Simulation<Ticks> {
	
	private static int runtime;
	
	@Override
	protected Ticks getState() {
		return this;
	}

	@Override
	protected boolean stop() {
		return false;
	}
	
	public static void main(String[] args) {
		Ticks t = new Ticks();
		runtime = Integer.parseInt(args[0]);
		
		for(int i=1; i < runtime; i++) {
			t.schedule(new Tick(), i);
		}
		t.simulate();
	}

}
