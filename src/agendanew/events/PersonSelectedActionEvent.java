package agendanew.events;

import javafx.event.Event;
import javafx.event.EventType;

public class PersonSelectedActionEvent extends Event {

	public static final EventType<PersonSelectedActionEvent> REMOVE_PERSON_STATE_EVENT = new EventType<>("REMOVE_PERSON_STATE_EVENT");
	private final Boolean state;

	public PersonSelectedActionEvent(Boolean state) {
		super(REMOVE_PERSON_STATE_EVENT);
		this.state = state;
	}

	public Boolean getState() {
		return state;
	}

}
