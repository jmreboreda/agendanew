package agendanew.events;

import javafx.event.Event;
import javafx.event.EventType;

public class PhoneSelectedActionEvent extends Event {

	public static final EventType<PhoneSelectedActionEvent> REMOVE_PHONE_STATE_EVENT = new EventType<>("REMOVE_PHONE_STATE_EVENT");
	private final Boolean state;

	public PhoneSelectedActionEvent(Boolean state) {
		super(REMOVE_PHONE_STATE_EVENT);
		this.state = state;
	}

	public Boolean getState() {
		return state;
	}

}
