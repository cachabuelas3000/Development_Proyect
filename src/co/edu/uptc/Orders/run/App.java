package co.edu.uptc.orders.run;

import co.edu.uptc.orders.model.Order;
import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {

        // Crear un objeto Order para prueba
        Order order = new Order(0, "ORD-001", "Juan García", new Date(), 150.50, "Express", "Tarjeta de Crédito");
        
        // Mostrar los datos del pedido
        System.out.println("=== Prueba de Objeto Order ===");
        System.out.println("ID: " + order.getId());
        System.out.println("Número de Pedido: " + order.getNumberOfOrder());
        System.out.println("Cliente: " + order.getCustomerName());
        System.out.println("Fecha: " + order.getDate());
        System.out.println("Costo Total: $" + order.getTotalCost());
        System.out.println("Método de Entrega: " + order.getMethodOfDelivery());
        System.out.println("Método de Pago: " + order.getPaymentMethod());
    }
}
