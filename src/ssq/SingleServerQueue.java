package ssq;

import java.util.Random;
import simulation.Simulation;

public class SingleServerQueue extends Simulation<SingleServerQueue> {
	
	private static long seed;
	private static double runtime;
	private static Random r;
	private static final double SERVICE_TIME = 0.25;
	private static int population;
	
	@Override
	protected SingleServerQueue getState() {
		return this;
	}

	@Override
	protected boolean stop() {
		if (getCurrentTime() >= runtime) {
			System.out.println("SIMULATION COMPLETE");
			return true;
		}
		return false;
	}
	
	public static double getInterServiceInterval() {
		return r.nextDouble();
	}
	
	public static double getServiceInterval() {
		return SERVICE_TIME;
	}
	
	public void incrementPopulation() {
		population ++;
	}
	
	public void decrementPopulation() {
		population--;
	}
	
	public int getPopulation() {
		return population;
	}

	public static void main(String[] args) {
		SingleServerQueue ssq = new SingleServerQueue();
		seed = Long.parseLong(args[0]);
		runtime = Double.parseDouble(args[1]);
		
		population = 0;
		r = new Random(seed);
		
		ssq.schedule(new Arrival(), getInterServiceInterval());
		ssq.simulate();
	}

}
