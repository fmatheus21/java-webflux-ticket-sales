package br.com.fmatheus.app.controller.facade;


import br.com.fmatheus.app.controller.converter.EventConverter;
import br.com.fmatheus.app.controller.dto.request.EventRequest;
import br.com.fmatheus.app.controller.dto.response.EventResponse;
import br.com.fmatheus.app.model.entity.Event;
import br.com.fmatheus.app.model.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class EventFacade {

    private final EventService eventService;
    private final EventConverter eventConverter;

    @Autowired
    public EventFacade(EventService eventService, EventConverter eventConverter) {
        this.eventService = eventService;
        this.eventConverter = eventConverter;
    }

    public Flux<EventResponse> findAll() {
        var result = this.eventService.findAll();
        return result.map(this.eventConverter::converterToResponse);
    }

    public Mono<EventResponse> findById(UUID id) {
        var result = this.searchById(id);
        return result.map(this.eventConverter::converterToResponse);
    }

    public Mono<EventResponse> create(EventRequest request) {
        var converter = this.eventConverter.converterToEntity(request);
        var commit = this.eventService.save(converter);
        return commit.map(this.eventConverter::converterToResponse);
    }

    public Mono<Void> delete(UUID id) {
        this.searchById(id);
        return this.eventService.deleteById(id);
    }

    private Mono<Event> searchById(UUID id) {
        return this.eventService.findById(id).switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

}
