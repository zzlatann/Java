// Dentro del JFrame
GestorUsuarios gestor = new GestorUsuarios();

private void actualizarLista() {
    DefaultListModel modelo = new DefaultListModel();
    for (Persona p : gestor.obtenerUsuarios()) {
        modelo.addElement(p);
    }
    lstUsuarios.setModel(modelo);
}

private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {
    int id = Integer.parseInt(txtId.getText());
    String nombre = txtNombre.getText();
    String correo = txtCorreo.getText();
    gestor.agregarUsuario(new Persona(id, nombre, correo));
    actualizarLista();
}

private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
    int id = Integer.parseInt(txtId.getText());
    String nombre = txtNombre.getText();
    String correo = txtCorreo.getText();
    gestor.editarUsuario(id, nombre, correo);
    actualizarLista();
}

private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {
    int id = Integer.parseInt(txtId.getText());
    gestor.eliminarUsuario(id);
    actualizarLista();
}

private void lstUsuariosValueChanged(javax.swing.event.ListSelectionEvent evt) {
    Persona seleccionado = (Persona) lstUsuarios.getSelectedValue();
    if (seleccionado != null) {
        txtId.setText(String.valueOf(seleccionado.getId()));
        txtNombre.setText(seleccionado.getNombre());
        txtCorreo.setText(seleccionado.getCorreo());
    }
}
