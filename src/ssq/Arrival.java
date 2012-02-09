package ssq;

import simulation.Event;

class Arrival implements Event<SingleServerQueue> {
	
	@Override
	public void invoke(SingleServerQueue simulation) {
		double inter_service_interval, service_interval;
		double current_time;
		
		inter_service_interval = SingleServerQueue.getInterServiceInterval();
		service_interval = SingleServerQueue.getServiceInterval();
		
		//System.out.println("POPULATION: " + simulation.getPopulation() + "\n");
		if (simulation.getPopulation() == 0) {
			//System.out.printf("IN HERE: %f\n\n", (simulation.getCurrentTime() + service_interval));
			simulation.schedule(new Departure(), simulation.getCurrentTime() + service_interval);
		}
		simulation.incrementPopulation();
		simulation.schedule(new Arrival(), simulation.getCurrentTime() + inter_service_interval);
		
		
		System.out.printf("Arrival at: %s, new population = %s\n", simulation.getCurrentTime(), 
				                                                   simulation.getPopulation());
	}

}
