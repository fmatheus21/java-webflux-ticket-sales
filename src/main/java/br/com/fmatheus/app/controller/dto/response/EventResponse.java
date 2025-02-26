package br.com.fmatheus.app.controller.dto.response;

import br.com.fmatheus.app.controller.enumerable.EventTypeEnum;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventResponse {
    private UUID id;
    private EventTypeEnum type;
    private String name;
    private String description;
    private LocalDate eventDate;
}
