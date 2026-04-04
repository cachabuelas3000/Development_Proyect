package co.edu.uptc.Orders.data;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

import co.edu.uptc.Orders.model.Delivery;

public class CrudDelivery extends AbstractCrud<Delivery> {

    private List<Delivery> deliveries;

    public CrudDelivery() {
        super("Delivery");
        this.deliveries = new ArrayList<>();
    }

    @Override
    protected Delivery createInstance() {
        String courier = JOptionPane.showInputDialog("Enter courier name:");
        String vehicle = JOptionPane.showInputDialog("Enter vehicle:");
        String area = JOptionPane.showInputDialog("Enter delivery area:");
        double fee = Double.parseDouble(JOptionPane.showInputDialog("Enter fee:"));
        String status = JOptionPane.showInputDialog("Enter status:");

        return new Delivery(courier, vehicle, area, fee, status);
    }

    @Override
    protected boolean newRecord(Delivery record) {
        if (this.findRecordById(record.getId()) == null) {
            this.deliveries.add(record);
            return true;
        }
        return false;
    }

    @Override
    protected Delivery findRecordById(int id) {
        return this.deliveries.stream().filter(d -> d.getId() == id).findAny().orElse(null);
    }

    @Override
    protected boolean updateRecord(Delivery d) {
        for (Delivery delivery : deliveries) {
            if (delivery.getId() == d.getId()) {
                if (d.getCourier() != null) delivery.setCourier(d.getCourier());
                if (d.getVehicle() != null) delivery.setVehicle(d.getVehicle());
                if (d.getArea() != null) delivery.setArea(d.getArea());
                delivery.setFee(d.getFee());
                if (d.getStatus() != null) delivery.setStatus(d.getStatus());
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean deleteRecord(int id) {
        return deliveries.removeIf(d -> d.getId() == id);
    }
}