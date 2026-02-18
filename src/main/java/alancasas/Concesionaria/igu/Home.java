/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package alancasas.Concesionaria.igu;

import javax.swing.JOptionPane;

/**
 *
 * @author Zero
 */
public class Home extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Home.class.getName());


    public Home() {
        initComponents();
        this.setResizable(false); //No se puede cambiar de tamaño
        this.setFocusable(true); //Evita que ponga directamente el focus del teclado(el usuario debe hacer click en los campos)
        this.requestFocusInWindow(); //TODO revisar si esto va o no...
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_principal = new javax.swing.JPanel();
        label_titulo = new javax.swing.JLabel();
        label_icon = new javax.swing.JLabel();
        panel_btns = new javax.swing.JPanel();
        btn_alta = new javax.swing.JButton();
        btn_ver_editar_borrar = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_titulo.setFont(new java.awt.Font("Roboto Black", 1, 36)); // NOI18N
        label_titulo.setText("Catalogo Ventas");

        label_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/toyota3.png"))); // NOI18N
        label_icon.setText("jLabel2");

        btn_alta.setText("Alta de Vehiculos");
        btn_alta.addActionListener(this::btn_altaActionPerformed);

        btn_ver_editar_borrar.setText("Consulta, Edicion y Baja");
        btn_ver_editar_borrar.addActionListener(this::btn_ver_editar_borrarActionPerformed);

        btn_salir.setText("Salir");
        btn_salir.addActionListener(this::btn_salirActionPerformed);

        javax.swing.GroupLayout panel_btnsLayout = new javax.swing.GroupLayout(panel_btns);
        panel_btns.setLayout(panel_btnsLayout);
        panel_btnsLayout.setHorizontalGroup(
            panel_btnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_btnsLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panel_btnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_alta, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ver_editar_borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        panel_btnsLayout.setVerticalGroup(
            panel_btnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_btnsLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btn_alta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_ver_editar_borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel_principalLayout = new javax.swing.GroupLayout(panel_principal);
        panel_principal.setLayout(panel_principalLayout);
        panel_principalLayout.setHorizontalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_btns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(label_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_principalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_titulo)
                .addGap(170, 170, 170))
        );
        panel_principalLayout.setVerticalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_principalLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(label_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label_icon)
                    .addComponent(panel_btns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ver_editar_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ver_editar_borrarActionPerformed
        ConsultaVehiculo consult = new ConsultaVehiculo();
        consult.setVisible(true);
        consult.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btn_ver_editar_borrarActionPerformed

    private void btn_altaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_altaActionPerformed
        AltaVehiculo alta = new AltaVehiculo(); //Creo instancia de la ventana principal                
        alta.setVisible(true); //Hago la ventana principal visible
        alta.setLocationRelativeTo(null); //Que aparezca en el medio
        this.dispose();//Cierro la ventana actual y libero recursos
    }//GEN-LAST:event_btn_altaActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        if(!confirmarAccion("¿Desea salir?","Salir")){
            return;           
        }
        System.exit(0); //Cierra el programa        
    }//GEN-LAST:event_btn_salirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Home().setVisible(true));
    }
    
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
    private javax.swing.JButton btn_alta;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton btn_ver_editar_borrar;
    private javax.swing.JLabel label_icon;
    private javax.swing.JLabel label_titulo;
    private javax.swing.JPanel panel_btns;
    private javax.swing.JPanel panel_principal;
    // End of variables declaration//GEN-END:variables
}
