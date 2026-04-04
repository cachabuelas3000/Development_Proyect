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
                    //caso crear
                    T recordCreate = this.createInstance();

                    if(this.newRecord(recordCreate)) {
					JOptionPane.showMessageDialog(null, "Se agregó el registro",//recordar que es para un pedido o un delivery 
							"Creación del registro", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "No se agregó el registro", 
							"Creación del registro", JOptionPane.ERROR_MESSAGE);
				}
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

    //metodos de la clase
	protected abstract boolean newRecord(T record);
	protected abstract T findRecordById(int id);
	protected abstract boolean updateRecord(T t);
	protected abstract T createInstance();
	protected abstract boolean deleteRecord(int id);

}
