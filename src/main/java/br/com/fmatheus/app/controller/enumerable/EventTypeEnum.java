package br.com.fmatheus.app.controller.enumerable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EventTypeEnum {
    SHOW, TEATRO, CONCERTO, PALESTRA, WORKSHOP;

    @JsonValue
    public String getValue() {
        return this.name();
    }

    @JsonCreator
    public static EventTypeEnum fromString(String value) {
        for (EventTypeEnum type : EventTypeEnum.values()) {
            if (type.name().equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid EventTypeEnum: " + value);
    }
}
