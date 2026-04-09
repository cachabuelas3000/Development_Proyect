package co.edu.uptc.orders.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.swing.JOptionPane;

import co.edu.uptc.orders.model.OrderByApp;

public class CrudOrderByApp extends AbstractCrud<OrderByApp> {

    private List<OrderByApp> orderList;
    private int counter = 1; // para asignar ID automático

    public CrudOrderByApp() {
        super("Pedido por App");
        this.orderList = new ArrayList<>();
    }

    @Override
    public OrderByApp createInstance() {

        String customer = JOptionPane.showInputDialog(
                null,
                "Ingrese el nombre del cliente:",
                "Crear Pedido",
                JOptionPane.INFORMATION_MESSAGE);

        double total = Double.parseDouble(JOptionPane.showInputDialog(
                null,
                "Ingrese el monto total del pedido:",
                "Crear Pedido",
                JOptionPane.INFORMATION_MESSAGE));

        String appName = JOptionPane.showInputDialog(
                null, "Ingrese el nombre de la aplicación:",
                "Crear Pedido", JOptionPane.INFORMATION_MESSAGE);

        String metodoPago = JOptionPane.showInputDialog(
                null, "Ingrese el método de pago (efectivo, tarjeta, etc.):",
                "Crear Pedido", JOptionPane.INFORMATION_MESSAGE);

        String tipoEntrega = JOptionPane.showInputDialog(
                null, "Ingrese el tipo de entrega (domicilio / local):",
                "Crear Pedido", JOptionPane.INFORMATION_MESSAGE);

        OrderByApp o = new OrderByApp(0, customer, new Date(), total, tipoEntrega, metodoPago, appName);
        o.setId(counter++); // asigna ID automático
        o.setCustomerName(customer);
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
        JOptionPane.showMessageDialog(null,
                "Hay " + this.orderList.size() + " pedido(s) registrado(s) en total.",
                "Información",
                JOptionPane.INFORMATION_MESSAGE);

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

    public List<OrderByApp> getOrderList() {
        return this.orderList;
    }
}