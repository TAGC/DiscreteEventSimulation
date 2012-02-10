package simulation;

public class ScheduledEvent<S> implements Comparable<S> {

	private Event<S> event;
	private double offset;
	
	public ScheduledEvent (Event<S> event, double offset) {
		this.event = event;
		this.offset = offset;
	}
	
	public double getOffset() {
		return offset;
	}

	public Event<S> getEvent() {
		return event;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public int compareTo(Object o) {
		ScheduledEvent<S> other_event;
		int comparison;
		
		other_event = (ScheduledEvent<S>) o;
		comparison = (Double.compare(this.getOffset(), other_event.getOffset()));
		return comparison;
	}
}
