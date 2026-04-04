package co.edu.uptc.orders.model;

import java.util.Date;

public class OrderByApp extends Order {

    private String appName;
    private static int numberOrder;

    public OrderByApp() {
		super();
	}

    public OrderByApp(int id, String numberOfOrder, String customerName, Date date, double totalCost,
            String methodOfDelivery, String paymentMethod, String appName) {
        super(id, numberOfOrder, customerName, date, totalCost, methodOfDelivery, paymentMethod);
        this.appName = appName;
        this.id = ++numberOrder;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    
    

    

}
