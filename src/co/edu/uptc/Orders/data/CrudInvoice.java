package co.edu.uptc.Orders.data;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

import co.edu.uptc.Orders.model.Invoice;
import co.edu.uptc.Orders.model.Order;

public class CrudInvoice extends AbstractCrud<Invoice> {

    private List<Invoice> invoices;
    private List<Order> orders; // Needed to link invoices to orders

    public CrudInvoice(List<Order> orders) {
        super("Invoice");
        this.invoices = new ArrayList<>();
        this.orders = orders;
    }

    @Override
    protected Invoice createInstance() {
        if (orders.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No orders available to create an invoice.");
            return null;
        }

        int orderId = Integer.parseInt(JOptionPane.showInputDialog("Enter Order ID:"));
        Order order = orders.stream().filter(o -> o.getId() == orderId).findAny().orElse(null);

        if (order == null) {
            JOptionPane.showMessageDialog(null, "Order not found.");
            return null;
        }

        double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter amount:"));
        String date = JOptionPane.showInputDialog("Enter date:");
        String paymentMethod = JOptionPane.showInputDialog("Enter payment method:");
        boolean paid = JOptionPane.showConfirmDialog(null, "Paid?", "Payment", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

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
