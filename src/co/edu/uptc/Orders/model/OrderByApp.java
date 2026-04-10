package co.edu.uptc.orders.model;

import java.util.Date;

public class OrderByApp extends Order {

    private String appName;

    public OrderByApp(int id, String customerName, Date date, double totalCost,
            String methodOfDelivery, String paymentMethod, String appName) {
        super(++Order.generalId, customerName, date, totalCost, methodOfDelivery, paymentMethod);
        this.appName = appName; 
        this.id = Order.generalId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

}
