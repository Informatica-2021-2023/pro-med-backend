package gov.edu.ce.anm.promed.api.common;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomInstantDeserializer extends JsonDeserializer<LocalDate> {

    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return LocalDate.parse(jsonParser.getValueAsString(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
