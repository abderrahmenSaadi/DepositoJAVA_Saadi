package controller;

import dao.TicketDAO;
import dao.impl.TicketDAOImpl;
import model.ticket.Ticket;
import model.ticket.TicketStatus;
import observer.AdminNotifier;
import observer.Subject;
import observer.UserNotifier;

public class TicketController {

    private final TicketDAO ticketDAO = new TicketDAOImpl();

    private final Subject subject = new Subject();

    public TicketController() {
        subject.addObserver(new AdminNotifier());
        subject.addObserver(new UserNotifier());
    }

    public void createTicket(String title, String description, int userId) {

        Ticket ticket = new Ticket(title, description, TicketStatus.OPEN, userId);

        ticketDAO.createTicket(ticket);

        subject.notifyObservers(
        "New ticket created by user ID " + userId + ": " + title
);
    }

    public void showAllTickets() {

        for (Ticket ticket : ticketDAO.getAllTickets()) {

            System.out.println("----------------------");
            System.out.println("ID: " + ticket.getId());
            System.out.println("Title: " + ticket.getTitle());
            System.out.println("Description: " + ticket.getDescription());
            System.out.println("Status: " + ticket.getStatus());
        }
    }

    public void showUserTickets(int userId) {

        for (Ticket ticket : ticketDAO.getTicketsByUser(userId)) {

            System.out.println("----------------------");
            System.out.println("ID: " + ticket.getId());
            System.out.println("Title: " + ticket.getTitle());
            System.out.println("Description: " + ticket.getDescription());
            System.out.println("Status: " + ticket.getStatus());
        }
    }

    public void resolveTicket(int ticketId) {

        ticketDAO.resolveTicket(ticketId);

        subject.notifyObservers("Ticket " + ticketId + " resolved.");
    }

    public void deleteTicket(int ticketId) {
        ticketDAO.deleteTicket(ticketId);
    }
}