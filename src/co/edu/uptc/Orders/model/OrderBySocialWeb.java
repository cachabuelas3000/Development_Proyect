package co.edu.uptc.orders.model;

import java.util.Date;

public class OrderBySocialWeb extends Order {

    private String socialWebName;

    // public OrderBySocialWeb(int id, String numberOfOrder, String customerName, Date date, double totalCost,
    //         String methodOfDelivery, String paymentMethod, String socialWebName) {
    //     super(id, customerName, date, totalCost, methodOfDelivery, paymentMethod);
    //     this.socialWebName = socialWebName;
    //     ++Order.generalId;
    //     this.id = new Integer(Order.generalId);
    // }

    public OrderBySocialWeb(int id, String numberOfOrder, String customerName, Date date, double totalCost,
        String methodOfDelivery, String paymentMethod, String socialWebName) {
    super(id, customerName, date, totalCost, methodOfDelivery, paymentMethod);
    this.socialWebName = socialWebName;
}

    public String getSocialWebName() {
        return socialWebName;
    }

    public void setSocialWebName(String socialWebName) {
        this.socialWebName = socialWebName;
    }

}
