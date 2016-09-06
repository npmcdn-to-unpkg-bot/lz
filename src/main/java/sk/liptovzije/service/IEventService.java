package sk.liptovzije.service;

import sk.liptovzije.model.Event;

import java.util.List;

/**
 * Created by jan.husenica on 9/2/2016.
 */
public interface IEventService {
    public Event getEventById(long id);
    public void updateEvent(Event event);
    public void saveEvent(Event event);
    public List<Event> findAllEvents();
}
