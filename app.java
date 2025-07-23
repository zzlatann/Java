package com.mycompany.examen_final;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane; 

public class software extends javax.swing.JFrame {
    public software() {
        initComponents();
        modelo = (DefaultTableModel) tablaUsuarios.getModel();
    }
    private DefaultTableModel modelo;
    private int ID = 1;

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if (nombre.getText().isEmpty() || apellido.getText().isEmpty() || correo.getText().isEmpty() || telefono.getText().isEmpty() || comentario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete los campos faltantes");
        } else {
            modelo.addRow(new Object[]{ID++, nombre.getText(), apellido.getText(), correo.getText(), telefono.getText(), comentario.getText()});
            nombre.setText("");
            apellido.setText("");
            correo.setText("");
            telefono.setText("");
            comentario.setText("");
        }
    }                                           

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        int fila = tablaUsuarios.getSelectedRow();
        
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Elija algun fila para eliminar");
        }
        
        int confirmar = JOptionPane.showConfirmDialog(this, "¿Quieres eliminar esta fila?", "¿Menú de confirmacion?", JOptionPane.YES_NO_OPTION);
        
        if (confirmar == fila) {
            modelo.removeRow(fila);
        }
        
    }                                            

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        int fila = tablaUsuarios.getSelectedRow();
        
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Elija alguna fila para editar");
        }
        
        if (nombre.getText().isEmpty() || apellido.getText().isEmpty() || correo.getText().isEmpty() || telefono.getText().isEmpty() || comentario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete los campos faltantes");
        }
        
        modelo.setValueAt(nombre.getText(), fila, 1);
        modelo.setValueAt(apellido.getText(), fila, 2);
        modelo.setValueAt(correo.getText(), fila, 3);
        modelo.setValueAt(telefono.getText(), fila, 4);
        modelo.setValueAt(comentario.getText(), fila, 5);
        
        nombre.setText("");
        apellido.setText("");
        correo.setText("");
        telefono.setText("");
        comentario.setText("");
    }                                          

    private void tablaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {                                           
        int fila = tablaUsuarios.getSelectedRow();
        if (fila != -1) {
            DefaultTableModel Modelo = (DefaultTableModel) tablaUsuarios.getModel();
            nombre.setText(Modelo.getValueAt(fila, 1).toString());
            apellido.setText(Modelo.getValueAt(fila, 2).toString());
            correo.setText(Modelo.getValueAt(fila, 3).toString());
            telefono.setText(Modelo.getValueAt(fila, 4).toString());
            comentario.setText(Modelo.getValueAt(fila, 5).toString());
        }
    }                                                     
}
