package co.edu.uptc.orders.model;

import java.util.Date;

public class OrderBySocialWeb extends Order {

    private String socialWebName;
    private static int numOrder;

    public OrderBySocialWeb(int id, String numberOfOrder, String customerName, Date date, double totalCost,
            String methodOfDelivery, String paymentMethod, String socialWebName) {
        super(id, customerName, date, totalCost, methodOfDelivery, paymentMethod);
        this.socialWebName = socialWebName;
        ++Order.generalId;
        this.id = new Integer(Order.generalId);
    }

    public String getSocialWebName() {
        return socialWebName;
    }

    public void setSocialWebName(String socialWebName) {
        this.socialWebName = socialWebName;
    }

    public static int getNumOrder() {
        return numOrder;
    }

    public static void setNumOrder(int numOrder) {
        OrderBySocialWeb.numOrder = numOrder;
    }


}
