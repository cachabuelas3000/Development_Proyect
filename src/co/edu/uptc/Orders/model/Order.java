package co.edu.uptc.orders.model;

import java.util.Date;

public class Order extends BaseClass {

    
    protected String numberOfOrder;
    protected String customerName;
    protected Date date;
    protected double totalCost;
    protected String methodOfDelivery;
    protected String paymentMethod;
    protected static int generalId = 0; 

    public Order(int id, String numberOfOrder, String customerName, Date date, double totalCost,
            String methodOfDelivery, String paymentMethod) {
        super(id);
        this.numberOfOrder = numberOfOrder;
        this.customerName = customerName;
        this.date = date;
        this.totalCost = totalCost;
        this.methodOfDelivery = methodOfDelivery;
        this.paymentMethod = paymentMethod;
    }

    public String getNumberOfOrder() {
        return numberOfOrder;
    }

    public void setNumberOfOrder(String numberOfOrder) {
        this.numberOfOrder = numberOfOrder;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getMethodOfDelivery() {
        return methodOfDelivery;
    }

    public void setMethodOfDelivery(String methodOfDelivery) {
        this.methodOfDelivery = methodOfDelivery;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return """
----Pedido [número de pedido=" + numberOfOrder + ", nombre del cliente=" + customerName + ", fecha=" + date
                + ", costo total=" + totalCost + ", método de entrega=" + methodOfDelivery + ", método de pago="
                + paymentMethod + "]
                """;
        
        /*"----Orden [número de=" + numberOfOrder + ", customerName=" + customerName + ", date=" + date
                + ", totalCost=" + totalCost + ", methodOfDelivery=" + methodOfDelivery + ", paymentMethod="
                + paymentMethod + "]";*/
    }


}
