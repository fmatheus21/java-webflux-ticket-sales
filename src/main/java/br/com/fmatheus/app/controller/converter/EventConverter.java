package br.com.fmatheus.app.controller.converter;

import br.com.fmatheus.app.controller.dto.request.EventRequest;
import br.com.fmatheus.app.controller.dto.response.EventResponse;
import br.com.fmatheus.app.model.entity.Event;

public interface EventConverter extends MapperConverter<Event, EventRequest, EventResponse> {
}
