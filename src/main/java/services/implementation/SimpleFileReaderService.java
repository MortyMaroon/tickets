package services.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;
import models.RetrieveListTickets;
import models.Ticket;
import services.ReadingService;

import java.io.File;
import java.util.Collection;

public class SimpleFileReaderService implements ReadingService {

    @SneakyThrows
    @Override
    public Collection<Ticket> read() {
        File file = new File("src/main/resources/tickets.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        RetrieveListTickets retrieveListTickets = objectMapper.readValue(file, RetrieveListTickets.class);
        return retrieveListTickets.getTickets();
    }
}
