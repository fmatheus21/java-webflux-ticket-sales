package br.com.fmatheus.app.model.repository;

import br.com.fmatheus.app.model.entity.Event;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventRepository extends ReactiveCrudRepository<Event, UUID> {
}
