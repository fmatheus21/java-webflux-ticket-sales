package br.com.fmatheus.app.model.repository;

import br.com.fmatheus.app.controller.enumerable.EventTypeEnum;
import br.com.fmatheus.app.model.entity.Event;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface EventRepository extends ReactiveCrudRepository<Event, UUID> {

    Flux<Event> findByType(EventTypeEnum type);
}
