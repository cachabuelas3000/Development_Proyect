package co.edu.uptc.orders.model;

public class BaseClass {

    protected static int id;

    public BaseClass() {

        super();

    }



    public BaseClass(int id) {
        super();
        this.id = id;
    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }

    

}
