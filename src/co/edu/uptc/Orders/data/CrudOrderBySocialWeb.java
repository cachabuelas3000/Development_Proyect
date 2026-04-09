package co.edu.uptc.orders.data;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import co.edu.uptc.orders.model.OrderBySocialWeb;

public class CrudOrderBySocialWeb extends AbstractCrud<OrderBySocialWeb> {

    private List<OrderBySocialWeb> listaPedidos;
    private int contador = 1;

    public CrudOrderBySocialWeb() {
        super("Pedido por Redes sociales");
        this.listaPedidos = new ArrayList<>();
    }

    @Override
    protected boolean newRecord(OrderBySocialWeb record) {
        if (this.findRecordById(record.getId()) == null) {
            this.listaPedidos.add(record);
            return true;
        }
        return false;
    }

    @Override
    protected OrderBySocialWeb findRecordById(int id) {
        JOptionPane.showMessageDialog(null,
                "Hay " + this.listaPedidos.size() + " pedido(s) registrado(s) en total.",
                "Información",
                JOptionPane.INFORMATION_MESSAGE);

        for (OrderBySocialWeb p : listaPedidos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    protected boolean updateRecord(OrderBySocialWeb nuevo) {
        for (OrderBySocialWeb p : listaPedidos) {
            if (p.getId() == nuevo.getId()) {

                if (nuevo.getCustomerName() != null) {
                    p.setCustomerName(nuevo.getCustomerName());
                }

                if (nuevo.getNumberOfOrder() != null) {
                    p.setNumberOfOrder(nuevo.getNumberOfOrder());
                }

                if (nuevo.getTotalCost() != 0) {
                    p.setTotalCost(nuevo.getTotalCost());
                }

                if (nuevo.getSocialWebName() != null) {
                    p.setSocialWebName(nuevo.getSocialWebName());
                }

                return true;
            }
        }
        return false;
    }

    @Override
    protected OrderBySocialWeb createInstance() {

        String cliente = JOptionPane.showInputDialog(
                null,
                "Ingrese el nombre del cliente:",
                "Crear Pedido",
                JOptionPane.INFORMATION_MESSAGE);

        double total = Double.parseDouble(JOptionPane.showInputDialog(
                null,
                "Ingrese el total del pedido:",
                "Crear Pedido",
                JOptionPane.INFORMATION_MESSAGE));

        String redSocial = JOptionPane.showInputDialog(
                null,
                "Ingrese el nombre de la red social:",
                "Crear Pedido",
                JOptionPane.INFORMATION_MESSAGE);

        String metodoPago = JOptionPane.showInputDialog(
                null,
                "Ingrese el método de pago (efectivo, tarjeta, etc.):",
                "Crear Pedido",
                JOptionPane.INFORMATION_MESSAGE);

        String tipoEntrega = JOptionPane.showInputDialog(
                null,
                "Ingrese el tipo de entrega (domicilio / local):",
                "Crear Pedido",
                JOptionPane.INFORMATION_MESSAGE);

        OrderBySocialWeb pedido = new OrderBySocialWeb(0, null, cliente, null, total, tipoEntrega, metodoPago, redSocial);
        pedido.setId(contador++); // ID automático
        pedido.setCustomerName(cliente);
        pedido.setNumberOfOrder(String.valueOf(pedido.getId())); // ID como número de pedido
        pedido.setTotalCost(total);
        pedido.setSocialWebName(redSocial);

        return pedido;
    }

    @Override
    protected boolean deleteRecord(int id) {
        return this.listaPedidos.removeIf(p -> p.getId() == id);
    }
}