import java.util.UUID;

class PackageDelivery {
    private String trackingCode;
    private String destination;
    private String status;
    private DeliveryVehicle vehicle;

    public PackageDelivery(String destination, DeliveryVehicle vehicle) {
        this.trackingCode = generateCode();
        this.destination = destination;
        this.vehicle = vehicle;
        this.status = "CREATED";
    }

    private String generateCode() {
        return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    public void printTracking() {
        System.out.println("Tracking Code: " + trackingCode);
        System.out.println("Destination: " + destination);
        System.out.println("Vehicle: " + vehicle.getLicensePlate());
        System.out.println("Status: " + status);
    }
}