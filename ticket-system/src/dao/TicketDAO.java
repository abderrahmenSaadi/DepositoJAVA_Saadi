package dao;

import model.ticket.Ticket;

import java.util.List;

public interface TicketDAO {

    void createTicket(Ticket ticket);

    List<Ticket> getAllTickets();

    List<Ticket> getTicketsByUser(int userId);

    void resolveTicket(int ticketId);

    void deleteTicket(int ticketId);
}