package co.edu.uptc.orders.model;

import java.util.Date;

public class OrderBySocialWeb extends Order {

    private String socialWebName;
    private static int numOrder;

    public OrderBySocialWeb(){
        super();
    }

    public OrderBySocialWeb(int id, String numberOfOrder, String customerName, Date date, double totalCost,
            String methodOfDelivery, String paymentMethod, String socialWebName) {
        super(id, numberOfOrder, customerName, date, totalCost, methodOfDelivery, paymentMethod);
        this.socialWebName = socialWebName;
        this.id = ++numOrder;
    }

    public String getSocialWebName() {
        return socialWebName;
    }

    public void setSocialWebName(String socialWebName) {
        this.socialWebName = socialWebName;
    }


}
