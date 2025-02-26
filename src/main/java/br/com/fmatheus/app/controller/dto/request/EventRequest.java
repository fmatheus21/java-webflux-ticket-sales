package br.com.fmatheus.app.controller.dto.request;

import br.com.fmatheus.app.controller.enumerable.EventTypeEnum;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest {
    private EventTypeEnum type;
    private String name;
    private String description;
    private LocalDate eventDate;
}
