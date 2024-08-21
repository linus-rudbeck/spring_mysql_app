package se.distansakademin.running_for_environment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Autowired
    EventService service;

    @GetMapping("/api/events")
    public Iterable<Event> getAllEvents(){
        return service.getAllEvents();
    }

    @PostMapping("/api/events")
    public boolean createEvent(@RequestBody Event event){
        return service.createEvent(event);
    }
}
