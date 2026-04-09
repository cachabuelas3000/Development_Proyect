package co.edu.uptc.orders.model;

public class BaseClass {

    
    protected int id;

    public BaseClass() {
    }

    public BaseClass(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
