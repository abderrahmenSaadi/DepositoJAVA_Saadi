package facade;

public class SystemFacade {

    private final AuthenticationFacade authenticationFacade = new AuthenticationFacade();
    private final TicketFacade ticketFacade = new TicketFacade();

    public AuthenticationFacade getAuthenticationFacade() {
        return authenticationFacade;
    }

    public TicketFacade getTicketFacade() {
        return ticketFacade;
    }
}