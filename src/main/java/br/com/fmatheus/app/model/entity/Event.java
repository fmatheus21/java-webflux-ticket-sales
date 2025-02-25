package br.com.fmatheus.app.model.entity;

import br.com.fmatheus.app.controller.enumerable.EventTypeEnum;
import lombok.*;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table("event")
public class Event {

    @Column("id")
    private UUID id;

    @Column("type")
    private EventTypeEnum type;

    @Column("name")
    private String name;

    @Column("event_date")
    private LocalDate eventDate;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event event)) return false;
        return Objects.equals(getId(), event.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
