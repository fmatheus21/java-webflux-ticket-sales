package br.com.fmatheus.app.controller.facade;


import br.com.fmatheus.app.controller.converter.EventConverter;
import br.com.fmatheus.app.controller.dto.response.EventResponse;
import br.com.fmatheus.app.model.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

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

}
