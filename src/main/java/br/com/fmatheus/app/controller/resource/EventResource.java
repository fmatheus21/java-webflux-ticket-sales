package br.com.fmatheus.app.controller.resource;

import br.com.fmatheus.app.controller.dto.request.EventRequest;
import br.com.fmatheus.app.controller.dto.response.EventResponse;
import br.com.fmatheus.app.controller.facade.EventFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

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

    @Transactional(readOnly = true)
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Mono<EventResponse> findById(@PathVariable UUID id) {
        return this.facade.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Mono<EventResponse> create(@RequestBody EventRequest request) {
        return this.facade.create(request);
    }
}
