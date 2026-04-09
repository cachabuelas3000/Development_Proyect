package co.edu.uptc.orders.run;

import javax.swing.JOptionPane;

import co.edu.uptc.orders.data.CrudOrderByApp;
import co.edu.uptc.orders.data.CrudOrderBySocialWeb;
import co.edu.uptc.orders.data.CrudDelivery;
import co.edu.uptc.orders.data.CrudInvoice;

public class App {
    public static void main(String[] args) {
        CrudOrderByApp orderByAppRepository = new CrudOrderByApp();
        CrudOrderBySocialWeb orderBySocialWebRepository = new CrudOrderBySocialWeb();
        CrudDelivery deliveryRepository = new CrudDelivery();
        CrudInvoice invoiceRepository = new CrudInvoice(orderByAppRepository.getOrderList());

        boolean flag = true;
        while (flag) {

            int numberCrud = Integer.parseInt(JOptionPane.showInputDialog(
                    null,
                    "[1] Pedidos por Aplicación\n[2] Pedidos por Redes Sociales\n[3] Entregas\n[4] Facturas\n[5] Salir",
                    "MENÚ PRINCIPAL",
                    JOptionPane.INFORMATION_MESSAGE));

            switch (numberCrud) {
                case 1:
                    orderByAppRepository.menu();
                    break;
                case 2:
                    orderBySocialWebRepository.menu();
                    break;
                case 3:
                    deliveryRepository.menu();
                    break;
                case 4:
                    invoiceRepository.menu();
                    break;
                case 5:
                    flag = false;
                    JOptionPane.showMessageDialog(null,
                            "Saliendo del programa",
                            "Salida del programa",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null,
                            "Opción " + numberCrud + "no válida, por favor intente de nuevo.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }
}
