package facade;

import controller.TicketController;

public class TicketFacade {

    private final TicketController ticketController = new TicketController();

    public void createTicket(String title, String description, int userId) {
        ticketController.createTicket(title, description, userId);
    }

    public void showAllTickets() {
        ticketController.showAllTickets();
    }

    public void showUserTickets(int userId) {
        ticketController.showUserTickets(userId);
    }

    public void resolveTicket(int ticketId) {
        ticketController.resolveTicket(ticketId);
    }

    public void deleteTicket(int ticketId) {
        ticketController.deleteTicket(ticketId);
    }
}