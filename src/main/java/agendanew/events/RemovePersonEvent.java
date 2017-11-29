package agendanew.events;

import agendanew.bussines.Person;
import agendanew.bussines.Phone;
import javafx.event.Event;
import javafx.event.EventType;

public class RemovePersonEvent extends Event {

    public static final EventType<RemovePersonEvent> REMOVE_PERSON_EVENT = new EventType<>("REMOVE_PERSON_EVENT");
    private final Person person;

    public RemovePersonEvent(Person person) {
        super(REMOVE_PERSON_EVENT);
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }
}
