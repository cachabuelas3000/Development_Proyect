package co.edu.uptc.orders.data;

import javax.swing.*;
import java.awt.*;
import co.edu.uptc.orders.model.BaseClass;

public abstract class AbstractCrud<T extends BaseClass> {

    private String nameEntity;

    public AbstractCrud(String nameEntity) {
        this.nameEntity = nameEntity;
    }

    public void menu() {

        boolean flag = true;

        while (flag) {

            // opciones comboBox
            String[] menuOptions = { "1. Crear: " + this.nameEntity, "2. Buscar: " + this.nameEntity,
                    "3. Actualizar" + this.nameEntity, "4. Eliminar" + this.nameEntity, "5. Salir." };
            JComboBox<String> optionComboBox = new JComboBox<>(menuOptions);

            int option = JOptionPane.showConfirmDialog(
                    null,
                    optionComboBox,
                    "¿Qué desea hacer?",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            // capturo la elección del usuario
            String selection = (String) optionComboBox.getSelectedItem();

            // Extraer el número de la opción (primer carácter)
            String caseNumber = selection.substring(0, 1);

            switch (caseNumber) {
                case "1":
                    // caso crear
                    T recordCreate = this.createInstance();

                    if (this.newRecord(recordCreate)) {
                        JOptionPane.showMessageDialog(null, "Se agregó el registro", // recordar que es para un pedido o
                                                                                     // un delivery
                                "Creación del registro", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se agregó el registro",
                                "Creación del registro", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case "2":
                    // caso buscar
                    int idfind = Integer.parseInt(JOptionPane.showInputDialog(
                            null,
                            "Digite el identificador a buscar: ",
                            String.format("Búsqueda de %s", this.nameEntity),
                            JOptionPane.INFORMATION_MESSAGE));
                    T record = this.findRecordById(idfind);

                    // valido que el record
                    if (record != null) {
                        JOptionPane.showMessageDialog(null,
                                "El resultado encontrado fue: " + record,
                                String.format("Búsqueda de %s", this.nameEntity),
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(
                                null,
                                "No se encuentra resultado: ",
                                String.format("Busqueda de %s", this.nameEntity),
                                JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case "3":
                    // Caso actualizar
                    int idupdate = Integer.parseInt(JOptionPane.showInputDialog(
                            null,
                            "Digite el identificafor a buscar: ",
                            String.format("Actualización de: %s" + this.nameEntity),
                            JOptionPane.INFORMATION_MESSAGE));
                    T recordUpDate = this.findRecordById(idupdate);
                    if (recordUpDate != null) {
                        T newRecord = createInstance();
                        newRecord.setId(idupdate);
                        if (this.updateRecord(newRecord)) {
                            JOptionPane.showMessageDialog(null,
                                    "Busqueda actualizada",
                                    String.format("Actualización de %s", this.nameEntity),
                                    JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "No se actualizó su busqueda",
                                    String.format("Actualización de %s", this.nameEntity),
                                    JOptionPane.INFORMATION_MESSAGE);

                        }
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Su busqueda no existe",
                                String.format("Actualización de %s", this.nameEntity),
                                JOptionPane.ERROR_MESSAGE);
                    }

                    break;
                case "4":
                    // Caso eliminar
                    int idDelete = Integer.parseInt(JOptionPane.showInputDialog(
                            null,
                            "¿Qué desea eliminar? ",
                            String.format("Eliminación de %s", this.nameEntity),
                            JOptionPane.INFORMATION_MESSAGE));
                    if (this.deleteRecord(idDelete)) {
                        JOptionPane.showMessageDialog(null,
                                "Eliminación realizada con exito.",
                                String.format("Eliminación de %s", this.nameEntity), JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "No se hizo la eliminación, porque no existe registro.",
                                String.format("Eliminación de %s", this.nameEntity),
                                JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case "5":
                    flag = false;
                    break;
            }

        }
    }

    // metodos de la clase
    protected abstract boolean newRecord(T record);

    protected abstract T findRecordById(int id);

    protected abstract boolean updateRecord(T t);

    protected abstract T createInstance();

    protected abstract boolean deleteRecord(int id);

}
