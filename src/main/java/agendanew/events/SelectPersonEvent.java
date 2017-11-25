package agendanew.events;

import agendanew.bussines.Person;
import javafx.event.Event;
import javafx.event.EventType;

public class SelectPersonEvent extends Event {

	public static final EventType<SelectPersonEvent> SELECT_PERSON_EVENT = new EventType<>("SELECT_PERSON_EVENT");
	private final Person person;

	public SelectPersonEvent(Person person) {
		super(SELECT_PERSON_EVENT);
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

}
