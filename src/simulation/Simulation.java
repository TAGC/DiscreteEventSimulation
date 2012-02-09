package simulation;

import java.util.Queue;
import java.util.PriorityQueue;

public abstract class Simulation<S> {
	
	protected Queue<ScheduledEvent<S>> diary;
	protected double current_time;
	
	public Simulation() {
		diary = new PriorityQueue<ScheduledEvent<S>>();
		current_time = 0;
	}
	
	protected abstract boolean stop();
	
	protected abstract S getState();
	
	public double getCurrentTime() {
		return current_time;
	}
	
	public void schedule(Event<S> e, double offset) {
		ScheduledEvent<S> new_event;
		new_event = new ScheduledEvent<S>(e, offset);
		diary.add(new_event);
	}
	
	public void simulate() {
		ScheduledEvent<S> next_event;
		
		while (!diary.isEmpty()) {
			next_event = diary.poll();
			current_time = next_event.getOffset();
			if (stop()) {
				break;
			} else {
				next_event.getEvent().invoke(getState());
			}
		}
	}
}
