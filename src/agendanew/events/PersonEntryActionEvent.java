package agendanew.events;

import javafx.event.Event;
import javafx.event.EventType;

public class PersonEntryActionEvent extends Event {

	public static final EventType<PersonEntryActionEvent> REMOVE_PERSON_STATE_EVENT = new EventType<>("REMOVE_PERSON_STATE_EVENT");
	private final Boolean state;

	public PersonEntryActionEvent(Boolean state) {
		super(REMOVE_PERSON_STATE_EVENT);
		this.state = state;
	}

	public Boolean getState() {
		return state;
	}

}
