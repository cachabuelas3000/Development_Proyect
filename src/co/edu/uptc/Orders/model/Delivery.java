package co.edu.uptc.orders.model;

public class Delivery extends BaseClass {
    private static int autoId = 0;

    private String courier;
    private String vehicle;
    private String area;
    private double fee;
    private String status;

    public Delivery() {
        this.id = ++autoId;
    }

    public Delivery(String courier, String vehicle, String area, double fee, String status) {
        this.id = ++autoId;
        this.courier = courier;
        this.vehicle = vehicle;
        this.area = area;
        this.fee = fee;
        this.status = status;
    }

    // ===== Getters & Setters =====
    public String getCourier() { return courier; }
    public void setCourier(String courier) { this.courier = courier; }

    public String getVehicle() { return vehicle; }
    public void setVehicle(String vehicle) { this.vehicle = vehicle; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }

    public double getFee() { return fee; }
    public void setFee(double fee) { this.fee = fee; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Delivery [ID=" + id + ", Courier=" + courier + ", Vehicle=" + vehicle +
                ", Area=" + area + ", Fee=" + fee + ", Status=" + status + "]";
    }
}