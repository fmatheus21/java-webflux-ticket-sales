package br.com.fmatheus.app.controller.converter;

import br.com.fmatheus.app.controller.enumerable.EventTypeEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

@WritingConverter
public class EventTypeEnumWritingConverter implements Converter<EventTypeEnum, String> {
    @Override
    public String convert(EventTypeEnum source) {
        return source.name();
    }
}