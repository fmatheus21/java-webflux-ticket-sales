package br.com.fmatheus.app.controller.converter.impl;

import br.com.fmatheus.app.controller.converter.EventConverter;
import br.com.fmatheus.app.controller.dto.request.EventRequest;
import br.com.fmatheus.app.controller.dto.response.EventResponse;
import br.com.fmatheus.app.model.entity.Event;
import org.springframework.stereotype.Component;

@Component
public class EventConverterImpl implements EventConverter {
    @Override
    public Event converterToEntity(EventRequest request) {
        return Event.builder()
                .type(request.getType())
                .name(request.getName())
                .description(request.getDescription())
                .eventDate(request.getEventDate())
                .build();
    }

    @Override
    public EventResponse converterToResponse(Event event) {
        return EventResponse.builder()
                .id(event.getId())
                .type(event.getType())
                .name(event.getName())
                .description(event.getDescription())
                .eventDate(event.getEventDate())
                .build();
    }
}
