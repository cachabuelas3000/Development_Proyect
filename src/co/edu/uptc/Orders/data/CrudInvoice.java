package co.edu.uptc.orders.data;

import javax.swing.JOptionPane;

import co.edu.uptc.orders.model.Invoice;
import co.edu.uptc.orders.model.Order;

import java.util.ArrayList;
import java.util.List;

public class CrudInvoice extends AbstractCrud<Invoice> {

    private List<Invoice> invoices;
    private List<Order> orders; // Era necesario vincular las facturas con los pedidos.

    public CrudInvoice(List<Order> orders) {
        super("Invoice");
        this.invoices = new ArrayList<>();
        this.orders = orders;
    }

    @Override
    protected Invoice createInstance() {
        if (orders.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay pedidos disponibles para generar una factura.");
            return null;
        }

        int orderId = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el ID del pedido:"));
        Order order = orders.stream().filter(o -> o.getId() == orderId).findAny().orElse(null);

        if (order == null) {
            JOptionPane.showMessageDialog(null, "Pedido no encontrado.");
            return null;
        }

        double amount = Double.parseDouble(JOptionPane.showInputDialog("Introduzca la cantidad:"));
        String date = JOptionPane.showInputDialog("Introduzca la fecha:");
        String paymentMethod = JOptionPane.showInputDialog("Introduzca el método de pago:");
        boolean paid = JOptionPane.showConfirmDialog(null, "¿Pagada?", "Pago", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

        return new Invoice(order, amount, date, paymentMethod, paid);
    }

    @Override
    protected boolean newRecord(Invoice record) {
        if (record == null) return false;
        if (this.findRecordById(record.getId()) == null) {
            invoices.add(record);
            return true;
        }
        return false;
    }

    @Override
    protected Invoice findRecordById(int id) {
        return invoices.stream().filter(i -> i.getId() == id).findAny().orElse(null);
    }

    @Override
    protected boolean updateRecord(Invoice i) {
        for (Invoice inv : invoices) {
            if (inv.getId() == i.getId()) {
                if (i.getOrder() != null) inv.setOrder(i.getOrder());
                inv.setAmount(i.getAmount());
                if (i.getDate() != null) inv.setDate(i.getDate());
                if (i.getPaymentMethod() != null) inv.setPaymentMethod(i.getPaymentMethod());
                inv.setPaid(i.isPaid());
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean deleteRecord(int id) {
        return invoices.removeIf(i -> i.getId() == id);
    }
}
