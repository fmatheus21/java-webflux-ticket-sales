package br.com.fmatheus.app.controller.converter;

import br.com.fmatheus.app.controller.enumerable.EventTypeEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@ReadingConverter
public class EventTypeEnumReadingConverter implements Converter<String, EventTypeEnum> {
    @Override
    public EventTypeEnum convert(String source) {
        return EventTypeEnum.valueOf(source.trim().toUpperCase());
    }
}
