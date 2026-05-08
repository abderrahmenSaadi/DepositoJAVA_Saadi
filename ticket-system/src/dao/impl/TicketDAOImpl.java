package dao.impl;

import config.DatabaseConnection;
import dao.TicketDAO;
import model.ticket.Ticket;
import model.ticket.TicketStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TicketDAOImpl implements TicketDAO {

    private final Connection connection = DatabaseConnection.getInstance().getConnection();

    @Override
    public void createTicket(Ticket ticket) {

        String sql = "INSERT INTO tickets(title,description,status,created_by) VALUES(?,?,?,?)";

        try {

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, ticket.getTitle());
            statement.setString(2, ticket.getDescription());
            statement.setString(3, ticket.getStatus().name());
            statement.setInt(4, ticket.getCreatedBy());

            statement.executeUpdate();

            System.out.println("Ticket created successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Ticket> getAllTickets() {

        List<Ticket> tickets = new ArrayList<>();

        String sql = """
                SELECT tickets.*, users.username
                FROM tickets
                JOIN users
                ON tickets.created_by = users.id
                """;

        try {

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                Ticket ticket = new Ticket();

                ticket.setId(rs.getInt("id"));
                ticket.setTitle(rs.getString("title"));
                ticket.setDescription(rs.getString("description"));
                ticket.setStatus(TicketStatus.valueOf(rs.getString("status")));
                ticket.setCreatedBy(rs.getInt("created_by"));
                ticket.setCreatedUsername(rs.getString("username"));

                tickets.add(ticket);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tickets;
    }

    @Override
    public List<Ticket> getTicketsByUser(int userId) {

        List<Ticket> tickets = new ArrayList<>();

        String sql = """
                SELECT tickets.*, users.username
                FROM tickets
                JOIN users
                ON tickets.created_by = users.id
                WHERE created_by=?
                """;

        try {

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, userId);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                Ticket ticket = new Ticket();

                ticket.setId(rs.getInt("id"));
                ticket.setTitle(rs.getString("title"));
                ticket.setDescription(rs.getString("description"));
                ticket.setStatus(TicketStatus.valueOf(rs.getString("status")));
                ticket.setCreatedBy(rs.getInt("created_by"));
                ticket.setCreatedUsername(rs.getString("username"));

                tickets.add(ticket);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tickets;
    }

    @Override
    public void resolveTicket(int ticketId) {

        String sql = "UPDATE tickets SET status='RESOLVED' WHERE id=?";

        try {

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, ticketId);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Ticket resolved.");
            } else {
                System.out.println("No ticket found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTicket(int ticketId) {

        String sql = "DELETE FROM tickets WHERE id=?";

        try {

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, ticketId);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Ticket deleted.");
            } else {
                System.out.println("No ticket found with this ID.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}