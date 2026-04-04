package co.edu.uptc.orders.model;

public class Invoice extends BaseClass {
    private static int autoId = 0;

    private Order order; // Composition: depends on Order
    private double amount;
    private String date;
    private String paymentMethod;
    private boolean paid;

    public Invoice() {
        this.id = ++autoId;
    }

    public Invoice(Order order, double amount, String date, String paymentMethod, boolean paid) {
        this.id = ++autoId;
        this.order = order;
        this.amount = amount;
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.paid = paid;
    }

    // ===== Getters & Setters =====
    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public boolean isPaid() { return paid; }
    public void setPaid(boolean paid) { this.paid = paid; }

    @Override
    public String toString() {
        return "Invoice [ID=" + id + ", OrderID=" + (order != null ? order.getId() : "null") +
                ", Amount=" + amount + ", Date=" + date + ", PaymentMethod=" + paymentMethod + ", Paid=" + paid + "]";
    }
}