package agendanew.components.phone.phoneinput.events;

import agendanew.domain.Phone;
import javafx.event.Event;
import javafx.event.EventType;

public class SavePhoneEvent extends Event {

	public static final EventType<SavePhoneEvent> SAVE_PHONE_EVENT = new EventType<>("SAVE_PHONE_EVENT");
	private final Phone phone;

	public SavePhoneEvent(Phone phone) {
		super(SAVE_PHONE_EVENT);
		this.phone = phone;
	}

	public Phone getPhone() {
		return phone;
	}

}
