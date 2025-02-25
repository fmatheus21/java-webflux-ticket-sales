package br.com.fmatheus.app.controller.resource;

import br.com.fmatheus.app.controller.dto.response.EventResponse;
import br.com.fmatheus.app.controller.facade.EventFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/events")
public class EventResource {

    private final EventFacade facade;

    @Autowired
    public EventResource(EventFacade facade) {
        this.facade = facade;
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<EventResponse> findAll() {
        return this.facade.findAll();
    }
}
