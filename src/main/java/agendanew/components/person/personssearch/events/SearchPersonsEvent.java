package agendanew.components.person.personssearch.events;

import javafx.event.Event;
import javafx.event.EventType;

public class SearchPersonsEvent extends Event {

	public static final EventType<SearchPersonsEvent> SEARCH_PERSONS_EVENT = new EventType<>("SEARCH_PERSONS_EVENT");
	private final String pattern;

	public SearchPersonsEvent(String pattern) {
		super(SEARCH_PERSONS_EVENT);
		this.pattern = pattern;
	}

	public String getPattern() {
		return pattern;
	}

}
