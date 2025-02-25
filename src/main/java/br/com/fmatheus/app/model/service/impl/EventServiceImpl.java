package br.com.fmatheus.app.model.service.impl;

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
    public Mono<Event> findById(UUID uuid) {
        return this.repository.findById(uuid);
    }

    @Override
    public Mono<Void> deleteById(UUID uuid) {
        return this.repository.deleteById(uuid);
    }
}
