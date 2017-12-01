package agendanew.components.phoneinput.events;

import agendanew.domain.Phone;
import javafx.event.Event;
import javafx.event.EventType;

public class RemovePhoneEvent extends Event {

    public static final EventType<RemovePhoneEvent> REMOVE_PHONE_EVENT = new EventType<>("REMOVE_PHONE_EVENT");
    private final Phone phone;

    public RemovePhoneEvent(Phone phone) {
        super(REMOVE_PHONE_EVENT);
        this.phone = phone;
    }

    public Phone getPhone() {
        return phone;
    }
}
