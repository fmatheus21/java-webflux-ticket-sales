package br.com.fmatheus.app.model.service.impl;

import br.com.fmatheus.app.controller.enumerable.EventTypeEnum;
import br.com.fmatheus.app.model.entity.Event;
import br.com.fmatheus.app.model.repository.EventRepository;
import br.com.fmatheus.app.model.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository repository;

    @Autowired
    public EventServiceImpl(EventRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<Event> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Mono<Event> save(Event event) {
        return this.repository.save(event);
    }

    @Override
    public Mono<Event> findById(UUID id) {
        return this.repository.findById(id);
    }

    @Override
    public Mono<Void> deleteById(UUID id) {
        return this.repository.deleteById(id);
    }

    @Override
    public Flux<Event> findByType(EventTypeEnum type) {
        return this.repository.findByType(type);
    }
}
