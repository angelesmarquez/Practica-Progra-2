package mvc.vista;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import mvc.controlador.ControladorRegistrar;

public class AdminRegistrarPersonal extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AdminRegistrarPersonal.class.getName());

    public AdminRegistrarPersonal(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        cmbEspecialidad1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Medicina General", "Odontología", "Fisioterapia" }));
        
        cmbArea.setSelectedIndex(-1);
        desactivar();
        
        cmbArea.addActionListener(new java.awt.event.ActionListener (){
        @Override
        public void actionPerformed (java.awt.event.ActionEvent evt){
            if (cmbArea.getSelectedIndex()==-1){
                desactivar();
                return;
            }
            
            String areaSelecc = cmbArea.getSelectedItem().toString();
            int numSelecc;
            
            if(areaSelecc.equalsIgnoreCase("Médico")){
                numSelecc=1;
            }else if(areaSelecc.equalsIgnoreCase("Enfermero")){
                numSelecc=2;
            }else{
                numSelecc=3;
            }
            
            desactivar();
            
            switch(numSelecc){
                case 1:
                    cmbEspecialidad1.setEnabled(true);
                    cajaLic.setEnabled(true);
                    break;
                case 2:
                    cmbAreaEnf.setEnabled(true);
                    break;
                case 3:
                    cmbDepartamento.setEnabled(true);
                    break;
            }
        }
        });
    }
    
    private ControladorRegistrar controlador;
    
    public void conectControlador (ControladorRegistrar controlador){
        this.controlador= controlador;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cajaNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cajaTlf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cajaID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbArea = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cajaLic = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cmbDepartamento = new javax.swing.JComboBox<>();
        botonCancelar = new javax.swing.JButton();
        botonRegistrar = new javax.swing.JButton();
        cmbAreaEnf = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        cajaUsuario = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        cajaContraseña = new javax.swing.JTextField();
        cmbEspecialidad1 = new javax.swing.JComboBox<>();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(100, 100));

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Georgia", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Registrar Nuevo Personal");

        jPanel3.setBackground(new java.awt.Color(0, 0, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(200, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, -1));

        jLabel2.setFont(new java.awt.Font("Calisto MT", 2, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Ingrese los Datos");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 106, 224, -1));

        cajaNombre.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.add(cajaNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 159, 282, 39));

        jLabel3.setFont(new java.awt.Font("Calisto MT", 2, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Médico");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 430, 72, -1));

        jLabel4.setFont(new java.awt.Font("Calisto MT", 2, 19)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("Numero de Teléfono:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 228, -1, -1));

        cajaTlf.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.add(cajaTlf, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 224, 144, 34));

        jLabel5.setFont(new java.awt.Font("Calisto MT", 2, 19)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("I.D");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 228, -1, -1));

        cajaID.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.add(cajaID, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 224, 142, 34));

        jLabel6.setFont(new java.awt.Font("Calisto MT", 2, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("Nombre y Apellido");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 175, 152, -1));

        cmbArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Médico", "Enfermero", "Administrativo" }));
        jPanel1.add(cmbArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, 222, 41));

        jLabel7.setFont(new java.awt.Font("Calisto MT", 2, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 102));
        jLabel7.setText("Seleccione el Área de Trabajo:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 238, -1));

        jLabel8.setFont(new java.awt.Font("Calisto MT", 2, 19)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 102));
        jLabel8.setText("Especialidad");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, -1, -1));

        jLabel9.setFont(new java.awt.Font("Calisto MT", 2, 19)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 102));
        jLabel9.setText("Lic. Médica");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 470, -1, -1));

        cajaLic.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.add(cajaLic, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 470, 142, 34));

        jLabel10.setFont(new java.awt.Font("Calisto MT", 2, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Enfermero");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 540, 93, -1));

        jLabel12.setFont(new java.awt.Font("Calisto MT", 2, 19)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 102));
        jLabel12.setText("Área Asignada");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 580, -1, -1));

        jLabel11.setFont(new java.awt.Font("Calisto MT", 2, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Enfermero");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 540, 93, -1));

        jLabel13.setFont(new java.awt.Font("Calisto MT", 2, 19)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 102));
        jLabel13.setText("Área Asignada");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 580, -1, -1));

        jLabel14.setFont(new java.awt.Font("Calisto MT", 2, 19)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 102));
        jLabel14.setText("Departamento");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 690, -1, -1));

        jLabel15.setFont(new java.awt.Font("Calisto MT", 2, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Administrativo");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 650, 120, -1));

        cmbDepartamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contabilidad", "Administracios", "R.R.H.H", "Seguridad", "Limpieza" }));
        cmbDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDepartamentoActionPerformed(evt);
            }
        });
        jPanel1.add(cmbDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 680, 220, 40));

        botonCancelar.setBackground(new java.awt.Color(102, 0, 0));
        botonCancelar.setFont(new java.awt.Font("Calisto MT", 1, 22)); // NOI18N
        botonCancelar.setForeground(new java.awt.Color(255, 204, 255));
        botonCancelar.setText("Cancelar Registro");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(botonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 750, 240, 60));

        botonRegistrar.setBackground(new java.awt.Color(0, 0, 102));
        botonRegistrar.setFont(new java.awt.Font("Calisto MT", 1, 22)); // NOI18N
        botonRegistrar.setForeground(new java.awt.Color(255, 204, 255));
        botonRegistrar.setText("Registrar Personal");
        botonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(botonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 750, 240, 60));

        cmbAreaEnf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meidicina General", "Odontología", "Fioterapia" }));
        cmbAreaEnf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAreaEnfActionPerformed(evt);
            }
        });
        jPanel1.add(cmbAreaEnf, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 580, 160, 40));

        jLabel16.setFont(new java.awt.Font("Calisto MT", 2, 19)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 102));
        jLabel16.setText("Usuario");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, -1, -1));

        cajaUsuario.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.add(cajaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 144, 34));

        jLabel17.setFont(new java.awt.Font("Calisto MT", 2, 19)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 102));
        jLabel17.setText("Contraseña");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, -1, -1));

        cajaContraseña.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.add(cajaContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 142, 34));

        cmbEspecialidad1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Medicina General", "Odontología", "Fisioterapia" }));
        cmbEspecialidad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEspecialidad1ActionPerformed(evt);
            }
        });
        jPanel1.add(cmbEspecialidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, 160, 40));

        jScrollPane4.setViewportView(jPanel1);

        getContentPane().add(jScrollPane4, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbAreaEnfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAreaEnfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAreaEnfActionPerformed

    private void botonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarActionPerformed
        controlador.RegitrarPersonal();
    }//GEN-LAST:event_botonRegistrarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed

    dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void cmbDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDepartamentoActionPerformed

    private void cmbEspecialidad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEspecialidad1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEspecialidad1ActionPerformed

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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                AdminRegistrarPersonal dialog = new AdminRegistrarPersonal(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    //Getters de los TxtField y de todo
    public String getCajaContraseña() {
        return cajaContraseña.getText().trim();
    }

    public String getCajaID() {
        return cajaID.getText().trim();
    }

    public String getCajaLic() {
        return cajaLic.getText().trim();
    }

    public String getCajaNombre() {
        return cajaNombre.getText().trim();
    }

    public String getCajaTlf() {
        return cajaTlf.getText().trim();
    }

    public String getCajaUsuario() {
        return cajaUsuario.getText().trim();
    }

    public String getCmbArea() {
        return cmbArea.getSelectedItem().toString();
    }

    public String getCmbAreaEnf() {
        return cmbAreaEnf.getSelectedItem().toString();
    }

    public String getCmbDepartamento() {
        return cmbDepartamento.getSelectedItem().toString();
    }

    public String getCmbEspecialidad1() {
        return cmbEspecialidad1.getSelectedItem().toString();
    }
    

    private void desactivar(){
        //Botones Médico
       cmbEspecialidad1.setSelectedIndex(-1);
       cajaLic.setText("");
       cmbAreaEnf.setSelectedIndex(-1);
       cmbDepartamento.setSelectedIndex(-1);
        cmbEspecialidad1.setEnabled(false);
        cajaLic.setEnabled(false);
        //Botones Enfermero
        cmbAreaEnf.setEnabled(false);
        //Boton Administrativo
        cmbDepartamento.setEnabled(false);
    }
    
    public void limpiarCampos(){
        //Limpiamos todos los campos de texto primero
        cajaNombre.setText("");
        cajaID.setText("");
        cajaTlf.setText("");
        cajaUsuario.setText("");
        cajaContraseña.setText("");
      
        //Reiniciamos los JcOMBObOX AL PRIMER ELEMENTO (indice 0)
        cmbArea.setSelectedIndex(0);
        cmbAreaEnf.setSelectedIndex(0);
        cmbDepartamento.setSelectedIndex(0);
        cmbDepartamento.setSelectedIndex(0);
        
        //Devolvemos el foco al primer campo para que el usuario vuelva a escribir rápido
        cajaNombre.requestFocus();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JTextField cajaContraseña;
    private javax.swing.JTextField cajaID;
    private javax.swing.JTextField cajaLic;
    private javax.swing.JTextField cajaNombre;
    private javax.swing.JTextField cajaTlf;
    private javax.swing.JTextField cajaUsuario;
    private javax.swing.JComboBox<String> cmbArea;
    private javax.swing.JComboBox<String> cmbAreaEnf;
    private javax.swing.JComboBox<String> cmbDepartamento;
    private javax.swing.JComboBox<String> cmbEspecialidad1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
