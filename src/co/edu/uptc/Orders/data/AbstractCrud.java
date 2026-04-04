package co.edu.uptc.Orders.data;

import javax.swing.*;
import java.awt.*;
import co.edu.uptc.Orders.model.BaseClass;

public abstract class AbstractCrud <T extends BaseClass>{

    private String nameEntitiy;

    public AbstractCrud(String nameEntitiy) {
        this.nameEntitiy = nameEntitiy;
    }

    public void menu (){

        boolean flag = true;

        while (flag) {
            
            //opciones comboBox
            String [] menuOptions = {"1. Crear: " + this.nameEntitiy, "2. Buscar: " + this.nameEntitiy,
             "3. Actualizar" + this.nameEntitiy, "4. Eliminar" + this.nameEntitiy};
            JComboBox<String> optionComboBox = new JComboBox<>(menuOptions);

            int option = JOptionPane.showConfirmDialog(
                null,
                optionComboBox,
                "¿Qué desea hacer?",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );

            //capturo la elección del usuario
            String selection = (String) optionComboBox.getSelectedItem();
            
            // Extraer el número de la opción (primer carácter)
            String caseNumber = selection.substring(0, 1);

            switch (caseNumber) {
                case "1":
                    // Caso 1: Crear
                    this.create();
                    break;
                case "2":
                    // Caso 2: Buscar
                    // this.read();
                    break;
                case "3":
                    // Caso 3: Actualizar
                    // this.update();
                    break;
                case "4":
                    // Caso 4: Eliminar
                    // this.delete();
                    break;
                default:
                    flag = false;
                    break;
            }
            
        }
    }

}
