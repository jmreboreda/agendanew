package agendanew.components.phonesoutput.events;

import agendanew.domain.Phone;
import javafx.event.Event;
import javafx.event.EventType;

import java.util.List;

public class ShowPhonesEvent extends Event {

	public static final EventType<ShowPhonesEvent> SHOW_PHONES_EVENT = new EventType<>("SAVE_PHONE_EVENT");
	private final List<Phone> phones;

	public ShowPhonesEvent(List<Phone> phones) {
		super(SHOW_PHONES_EVENT);
		this.phones = phones;
	}

	public List<Phone> getPhones() {
		return phones;
	}

}
