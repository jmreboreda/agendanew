package agendanew.events;

import javafx.event.Event;
import javafx.event.EventType;

public class RemovePersonStateEvent extends Event {

	public static final EventType<RemovePersonStateEvent> REMOVE_PERSON_STATE_EVENT = new EventType<>("REMOVE_PERSON_STATE_EVENT");
	public final Boolean remove;

	public RemovePersonStateEvent(Boolean remove) {
		super(REMOVE_PERSON_STATE_EVENT);
		this.remove = remove;
	}

	public Boolean getState() {
		return remove;
	}

}
