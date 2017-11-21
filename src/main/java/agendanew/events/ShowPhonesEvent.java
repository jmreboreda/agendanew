package agendanew.events;

import javafx.event.Event;
import javafx.event.EventType;

import java.util.List;

public class ShowPhonesEvent extends Event {

	public static final EventType<ShowPhonesEvent> SHOW_PHONES_EVENT = new EventType<>("SHOW_PHONES_EVENT");
	private final List<String> phones;

	public ShowPhonesEvent(List<String> phones) {
		super(SHOW_PHONES_EVENT);
		this.phones = phones;
	}

	public List<String> getPhones() {
		return phones;
	}

}
