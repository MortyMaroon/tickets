package services;

import models.Ticket;

import java.util.Collection;

public interface CalculationService {
    void calculate(Collection<Ticket> tickets);
}
