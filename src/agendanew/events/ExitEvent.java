package agendanew.events;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventType;

import java.util.List;

public class ExitEvent extends Event {

	public static final EventType<ExitEvent> EXIT_EVENT = new EventType<>("EXIT_EVENT");
	private String EXIT_APPLICATION = "Platform.exit()";

	public ExitEvent(String string) {
		super(EXIT_EVENT);
		this.EXIT_APPLICATION = string;
	}

	public String exitApplication() {
		return EXIT_APPLICATION;
	}
}
