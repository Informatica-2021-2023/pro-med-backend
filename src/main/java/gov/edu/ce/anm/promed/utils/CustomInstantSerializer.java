package gov.edu.ce.anm.promed.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class CustomInstantSerializer extends JsonSerializer<Instant> {

    @Override
    public void serialize(Instant instant, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        jsonGenerator.writeString(localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}
