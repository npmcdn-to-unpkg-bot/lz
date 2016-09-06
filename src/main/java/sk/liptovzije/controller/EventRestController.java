package sk.liptovzije.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sk.liptovzije.model.Event;
import sk.liptovzije.service.IAuthenticator;
import sk.liptovzije.service.IEventService;

import java.util.List;

/**
 * Created by jan.husenica on 9/2/2016.
 */

@RestController
public class EventRestController {
    @Autowired
    IEventService eventService;

    @Autowired
    IAuthenticator authenticatorService;

    @RequestMapping(value = "/event", method = RequestMethod.GET)
    public ResponseEntity<List<Event>> listAllUsers(@RequestHeader("Authorization") String header)
    {


        List<Event> users = eventService.findAllEvents();
        if(users.isEmpty()){
            return new ResponseEntity<List<Event>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Event>>(users, HttpStatus.OK);
    }


}
