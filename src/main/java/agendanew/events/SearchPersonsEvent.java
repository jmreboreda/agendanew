package agendanew.events;

import agendanew.bussines.Person;
import javafx.event.Event;
import javafx.event.EventType;

import java.util.List;

public class SearchPersonsEvent extends Event {

	public static final EventType<SearchPersonsEvent> SEARCH_PERSONS_EVENT = new EventType<>("SEARCH_PERSONS_EVENT");
	private final List<Person> persons;

	public SearchPersonsEvent(List<Person> persons) {
		super(SEARCH_PERSONS_EVENT);
		this.persons = persons;
	}

	public List<Person> getPersons() {
		return persons;
	}

}
