package se.distansakademin.running_for_environment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    EventRepository repository;

    public Iterable<Event> getAllEvents(){
        return repository.findAll();
    }

    public boolean createEvent(Event event) {
        try {
            repository.save(event);
            return true;
        }catch (Exception e){
            // Gör nåt med felet
            return false;
        }
    }
}
