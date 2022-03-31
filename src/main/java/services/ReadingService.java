package services;

import models.Ticket;

import java.util.Collection;

public interface ReadingService {
    Collection<Ticket> read();
}
