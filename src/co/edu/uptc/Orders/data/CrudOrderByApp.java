package co.edu.uptc.orders.data;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import co.edu.uptc.orders.model.OrderByApp;

public class CrudOrderByApp extends AbstractCrud<OrderByApp> {

    private List<OrderByApp> orderList;
    private int counter = 1; // para asignar ID automático

    public CrudOrderByApp() {
        super("Pedido");
        this.orderList = new ArrayList<>();
    }

    @Override
    public OrderByApp createInstance() {

        String customer = JOptionPane.showInputDialog(
                null,
                "Ingrese el nombre del cliente:",
                "Crear Pedido",
                JOptionPane.INFORMATION_MESSAGE
        );

        String orderNumber = JOptionPane.showInputDialog(
                null,
                "Ingrese el número del pedido:",
                "Crear Pedido",
                JOptionPane.INFORMATION_MESSAGE
        );

        double total = Double.parseDouble(JOptionPane.showInputDialog(
                null,
                "Ingrese el total del pedido:",
                "Crear Pedido",
                JOptionPane.INFORMATION_MESSAGE
        ));

        String appName = JOptionPane.showInputDialog(
                null,
                "Ingrese el nombre de la aplicación:",
                "Crear Pedido",
                JOptionPane.INFORMATION_MESSAGE
        );

        OrderByApp o = new OrderByApp();
        o.setId(counter++); // asigna ID automático
        o.setCustomerName(customer);
        o.setNumberOfOrder(orderNumber);
        o.setTotalCost(total);
        o.setAppName(appName);

        return o;
    }

    @Override
    public boolean newRecord(OrderByApp record) {
        if (this.findRecordById(record.getId()) == null) {
            this.orderList.add(record);
            return true;
        }
        return false;
    }

    @Override
    public OrderByApp findRecordById(int id) {
        return this.orderList.stream()
                .filter(o -> o.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public boolean updateRecord(OrderByApp o) {
        for (OrderByApp order : this.orderList) {
            if (order.getId() == o.getId()) {

                if (o.getCustomerName() != null) {
                    order.setCustomerName(o.getCustomerName());
                }

                if (o.getNumberOfOrder() != null) {
                    order.setNumberOfOrder(o.getNumberOfOrder());
                }

                if (o.getTotalCost() != 0) {
                    order.setTotalCost(o.getTotalCost());
                }

                if (o.getAppName() != null) {
                    order.setAppName(o.getAppName());
                }

                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteRecord(int id) {
        return this.orderList.removeIf(o -> o.getId() == id);
    }
}