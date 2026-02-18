/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package alancasas.Concesionaria.igu;

import alancasas.Concesionaria.logica.ControladoraLogica;
import alancasas.Concesionaria.logica.entidades.Vehiculo;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ConsultaVehiculo extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ConsultaVehiculo.class.getName());

    ControladoraLogica control = null;

    public ConsultaVehiculo() {
        initComponents();
        control = new ControladoraLogica();
        this.setResizable(false); //Hace que no sea reescalable (evita romper le diseño)
        this.setFocusable(true); //Evita que ponga directamente el focus del teclado(el usuario debe hacer click en los campos)
        this.requestFocusInWindow();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_principal = new javax.swing.JPanel();
        label_titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_principal = new javax.swing.JTable();
        btn_editar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        label_titulo.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        label_titulo.setText("Consulta de Vehiculos");

        tabla_principal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabla_principal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_principal);

        btn_editar.setText("Editar");
        btn_editar.addActionListener(this::btn_editarActionPerformed);

        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(this::btn_eliminarActionPerformed);

        btn_volver.setText("Volver");
        btn_volver.addActionListener(this::btn_volverActionPerformed);

        javax.swing.GroupLayout panel_principalLayout = new javax.swing.GroupLayout(panel_principal);
        panel_principal.setLayout(panel_principalLayout);
        panel_principalLayout.setHorizontalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_principalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_titulo)
                .addGap(263, 263, 263))
            .addGroup(panel_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_editar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(btn_volver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_principalLayout.setVerticalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_principalLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(label_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_principalLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(16, Short.MAX_VALUE))
                    .addGroup(panel_principalLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        //Controlar que exista al menos un registro
        if(tabla_principal.getRowCount()>0){            
            //Controlar que haya un registro (fila) seleccionado
            if(tabla_principal.getSelectedRow()!=-1){
                
                int id = Integer.parseInt(String.valueOf((tabla_principal.getValueAt(tabla_principal.getSelectedRow(), 0))));
                EditarVehiculo editar = new EditarVehiculo(id);
                editar.setVisible(true);
                editar.setLocationRelativeTo(null);
                this.dispose();

            }else{
                mostrarMensaje("No hay ningun registro seleccionado","error","Editar");
            }            
        }else{
            mostrarMensaje("No hay ningun registro para modificar","error","Editar");
        }
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        Home home = new Home();
        home.setVisible(true);
        home.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btn_volverActionPerformed

    // Evento de (JFrame)para que cuando se abra cargue la tabla con la base de datos TODO
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.cargarTabla();
    }//GEN-LAST:event_formWindowOpened

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        if(tabla_principal.getRowCount()>0){ //Que haya al menos 1 registro
            if(tabla_principal.getSelectedRow() != -1){ //Que se haya seleccionado al menos 1 registro
                //obtengo la id
                int id = Integer.parseInt(String.valueOf(tabla_principal.getValueAt(tabla_principal.getSelectedRow(),0)));
                
                /*Aviso de confiamacion*/
                if (!confirmarAccion("¿Desea borrar el registro con id: "+id+"?"
                        + "\nModelo: " +tabla_principal.getValueAt(tabla_principal.getSelectedRow(),1)
                        + "\nMarca: " +tabla_principal.getValueAt(tabla_principal.getSelectedRow(),2)
                        + "\nPatente: "+tabla_principal.getValueAt(tabla_principal.getSelectedRow(),3)
                        , "Confirmación")) {
                    return;
                }
                
                if(control.borrarVehiculo(id)){
                    mostrarMensaje("Se borro un registro", "info", "Borrado de vehiculo"); //JOpane
                    cargarTabla(); //Se vuelve a cargar la tabla para actualizar los cambios
                    tabla_principal.clearSelection(); //OPCIONAL Evita que quede una fila “fantasma” seleccionada
                }else{
                    mostrarMensaje("Error: No se pudo borrar el registro ", "error", "Borrado de vehiculo");
                    tabla_principal.clearSelection(); //OPCIONAL Evita que quede una fila “fantasma” seleccionada
                }; 

                
            } else {
                mostrarMensaje("No se ha seleccionado ningun registro","error","Error al seleccionar");
            }
        } else {
            mostrarMensaje("No hay nada que eliminar en la tabla", "error", "Error al eliminar");
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed



    private void cargarTabla() {
        //definir el modelo que queremos para la tabla
        DefaultTableModel model_tabla = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int fila, int colum) {
                return false; //La tabla NO ES MODIFICABLE
            }
        };

        //Nombre de los titulos de las columnas
        String titulos[] = {"ID", "Modelo", "Marca", "Patente", "Color", "Cant.Puertas"};
        model_tabla.setColumnIdentifiers(titulos); //Crea las columnas con los nombres del array

        //Seteamos el modelo al elemento tabla. (Configuramos como sera la tabla)
        tabla_principal.setModel(model_tabla);

        // Centrar contenido
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < tabla_principal.getColumnCount(); i++) {
            tabla_principal.getColumnModel().getColumn(i).setCellRenderer(centrado);
        } //Fin del centrado de contenido        

        //Carga de los datos desde la BD a la tabla
        //Trae desde la BD a una lista
        List<Vehiculo> listaVehiculos = control.traerVehiculos();
        //Si la lista no esta vacia, pasa cada mascota a un objeto
        if (listaVehiculos != null) {
            for (Vehiculo vehiculo : listaVehiculos) {
                Object[] objeto = {
                    vehiculo.getId(),
                    vehiculo.getModelo(),
                    vehiculo.getMarca(),
                    vehiculo.getPatente(),
                    vehiculo.getColor().getDescription(),
                    vehiculo.getCantPuertas().getDescription()

                };
                //agrega el objeto a la fila de la tabla en el mismo orden de atributos que se fijo arriba
                model_tabla.addRow(objeto);
            }
        }
    }

    /*Metodo para mensajes de JOptionPane*/
    private void mostrarMensaje(String mensaje, String tipo, String titulo) {
        JOptionPane optionPane = new JOptionPane(mensaje);
        if (tipo.equals("info")) {
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        } else if (tipo.equals("error")) {
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }

        JDialog dialog = optionPane.createDialog(titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }

    /*AVISO DE CONFIRMACION (usando en boton guardar -modificar-)*/
    private boolean confirmarAccion(String mensaje, String titulo) {
        int opcion = JOptionPane.showConfirmDialog(
                this,
                mensaje,
                titulo,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        return opcion == JOptionPane.YES_OPTION;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_titulo;
    private javax.swing.JPanel panel_principal;
    private javax.swing.JTable tabla_principal;
    // End of variables declaration//GEN-END:variables
}
