package agendanew.events;

import agendanew.bussines.Person;
import agendanew.bussines.Phone;
import javafx.event.Event;
import javafx.event.EventType;

public class RemovePhoneEvent extends Event {

    public static final EventType<RemovePhoneEvent> REMOVE_PHONE_EVENT = new EventType<>("REMOVE_PHONE_EVENT");
    private final Phone phone;
    private final Person person;

    public RemovePhoneEvent(Phone phone, Person person) {
        super(REMOVE_PHONE_EVENT);
        this.phone = phone;
        this.person = person;
    }

    public Phone getPhone() {
        return phone;
    }

    public Person getPerson(){
        return person;
    }
}
