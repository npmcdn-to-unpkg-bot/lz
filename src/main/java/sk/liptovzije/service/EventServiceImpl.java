package sk.liptovzije.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.liptovzije.model.Event;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by jan.husenica on 9/2/2016.
 */
@Service("eventService")
@Transactional
public class EventServiceImpl implements  IEventService {
    private static final AtomicLong counter = new AtomicLong();

    private static List<Event> events;

    static{
        events= populateDummyEvents();
    }

    public Event getEventById(long id) {
        for(Event event : events){
            if(event.getId() == id){
                return event;
            }
        }
        return null;
    }

    public void updateEvent(Event event) {
        int index = events.indexOf(event);
        events.set(index, event);
    }

    public void saveEvent(Event event) {
        event.setId(counter.incrementAndGet());
        events.add(event);
    }

    public List<Event> findAllEvents() {
        return events;
    }

    private static List<Event> populateDummyEvents() {
        List<Event> dummy = new ArrayList<Event>();

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        Date yesterday = cal.getTime();
        cal.add(Calendar.DATE, +2);
        Date tommorow = cal.getTime();

        dummy.add(new Event(counter.incrementAndGet(), yesterday, tommorow, "Hadzanie hrachu o stenu"));

        return dummy;
    }
}
