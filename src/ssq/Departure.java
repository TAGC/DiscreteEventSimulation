package ssq;

import simulation.Event;

class Departure implements Event<SingleServerQueue> {

	@Override
	public void invoke(SingleServerQueue simulation) {
		double service_interval;
		
		service_interval = SingleServerQueue.getServiceInterval();
		
		simulation.decrementPopulation();
		
		if (simulation.getPopulation() > 0) {
			simulation.schedule(new Departure(), simulation.getCurrentTime() + service_interval);
		}
		
		System.out.printf("Departure at %s, new population = %s\n", simulation.getCurrentTime(), 
				                                                     simulation.getPopulation());
	}

}