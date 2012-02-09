package ssq;

import simulation.Event;

class Arrival implements Event<SingleServerQueue> {
	
	@Override
	public void invoke(SingleServerQueue simulation) {
		double inter_service_interval, service_interval;
		
		inter_service_interval = SingleServerQueue.getInterServiceInterval();
		service_interval = SingleServerQueue.getServiceInterval();
		
		if (simulation.getPopulation() == 0) {
			simulation.schedule(new Departure(), simulation.getCurrentTime() + service_interval);
		}
		simulation.incrementPopulation();
		simulation.schedule(new Arrival(), simulation.getCurrentTime() + inter_service_interval);
		
		
		System.out.printf("Arrival at %s, new population = %s\n", simulation.getCurrentTime(), 
				                                                   simulation.getPopulation());
	}

}
