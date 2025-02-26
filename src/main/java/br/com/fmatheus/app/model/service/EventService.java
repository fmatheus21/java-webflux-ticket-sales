package br.com.fmatheus.app.model.service;

import br.com.fmatheus.app.controller.enumerable.EventTypeEnum;
import br.com.fmatheus.app.model.entity.Event;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface EventService extends GenericService<Event, UUID> {
    Flux<Event> findByType(EventTypeEnum type);
}
