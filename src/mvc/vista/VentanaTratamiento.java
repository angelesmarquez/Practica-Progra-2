/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package mvc.vista;

/**
 *
 * @author ACER
 */
public class VentanaTratamiento extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaTratamiento.class.getName());

    /**
     * Creates new form VentanaTratamiendo
     */
    public VentanaTratamiento(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        construirVista();
    }
    
        
    private void construirVista() {
    setTitle("Asignar Tratamiento");
    setSize(600, 530);
    setLocationRelativeTo(null);
    setLayout(new java.awt.BorderLayout());

    // Panel título
    javax.swing.JPanel panelTitulo = new javax.swing.JPanel(new java.awt.BorderLayout());
    panelTitulo.setBackground(new java.awt.Color(255, 255, 255));

    javax.swing.JPanel panelTexto = new javax.swing.JPanel();
    panelTexto.setBackground(new java.awt.Color(255, 255, 255));
    panelTexto.setLayout(new javax.swing.BoxLayout(panelTexto, javax.swing.BoxLayout.Y_AXIS));
    panelTexto.setBorder(javax.swing.BorderFactory.createEmptyBorder(14, 91, 0, 0));

    javax.swing.JLabel lblTitulo = new javax.swing.JLabel("Asignar Tratamiento");
    lblTitulo.setFont(new java.awt.Font("Georgia", 2, 24));

    javax.swing.JPanel barraAzul = new javax.swing.JPanel();
    barraAzul.setBackground(new java.awt.Color(0, 0, 51));
    barraAzul.setPreferredSize(new java.awt.Dimension(600, 11));

    panelTexto.add(lblTitulo);
    panelTitulo.add(panelTexto, java.awt.BorderLayout.CENTER);
    panelTitulo.add(barraAzul, java.awt.BorderLayout.SOUTH);

    // Panel central
    javax.swing.JPanel panelCentral = new javax.swing.JPanel();
    panelCentral.setBackground(new java.awt.Color(102, 153, 255));
    panelCentral.setLayout(new java.awt.GridBagLayout());
    java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
    gbc.insets = new java.awt.Insets(8, 10, 8, 10);
    gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;

    // Paciente
    javax.swing.JLabel lblPaciente = new javax.swing.JLabel("Paciente:");
    lblPaciente.setFont(new java.awt.Font("Calisto MT", 1, 14));
    lblPaciente.setForeground(new java.awt.Color(0, 0, 51));
    comboPacientes = new javax.swing.JComboBox<>();
    comboPacientes.setFont(new java.awt.Font("Calisto MT", 0, 13));
    comboPacientes.setPreferredSize(new java.awt.Dimension(280, 35));

    // Tipo de tratamiento
    javax.swing.JLabel lblTipo = new javax.swing.JLabel("Tipo de Tratamiento:");
    lblTipo.setFont(new java.awt.Font("Calisto MT", 1, 14));
    lblTipo.setForeground(new java.awt.Color(0, 0, 51));
    comboTipo = new javax.swing.JComboBox<>(new String[]{"Cirugía", "Terapia", "Medicación"});
    comboTipo.setFont(new java.awt.Font("Calisto MT", 0, 13));
    comboTipo.setPreferredSize(new java.awt.Dimension(280, 35));

    // Costo base
    javax.swing.JLabel lblCosto = new javax.swing.JLabel("Costo Base:");
    lblCosto.setFont(new java.awt.Font("Calisto MT", 1, 14));
    lblCosto.setForeground(new java.awt.Color(0, 0, 51));
    campoCostoBase = new javax.swing.JTextField();
    campoCostoBase.setFont(new java.awt.Font("Calisto MT", 0, 13));
    campoCostoBase.setPreferredSize(new java.awt.Dimension(280, 35));

    // Campo dinámico 1
    lblDinamico1 = new javax.swing.JLabel("Tipo Cirugía:");
    lblDinamico1.setFont(new java.awt.Font("Calisto MT", 1, 14));
    lblDinamico1.setForeground(new java.awt.Color(0, 0, 51));
    campoDinamico1 = new javax.swing.JTextField();
    campoDinamico1.setFont(new java.awt.Font("Calisto MT", 0, 13));
    campoDinamico1.setPreferredSize(new java.awt.Dimension(280, 35));

    // Campo dinámico 2
    lblDinamico2 = new javax.swing.JLabel("Costo Complejidad:");
    lblDinamico2.setFont(new java.awt.Font("Calisto MT", 1, 14));
    lblDinamico2.setForeground(new java.awt.Color(0, 0, 51));
    campoDinamico2 = new javax.swing.JTextField();
    campoDinamico2.setFont(new java.awt.Font("Calisto MT", 0, 13));
    campoDinamico2.setPreferredSize(new java.awt.Dimension(280, 35));

    // Botón
    botonAsignar = new javax.swing.JButton("Asignar Tratamiento");
    botonAsignar.setBackground(new java.awt.Color(0, 0, 102));
    botonAsignar.setFont(new java.awt.Font("Calisto MT", 1, 16));
    botonAsignar.setForeground(new java.awt.Color(255, 204, 255));
    botonAsignar.setPreferredSize(new java.awt.Dimension(280, 50));

    // Agregar componentes
    gbc.gridx = 0; gbc.gridy = 0; panelCentral.add(lblPaciente, gbc);
    gbc.gridx = 1; gbc.gridy = 0; panelCentral.add(comboPacientes, gbc);
    gbc.gridx = 0; gbc.gridy = 1; panelCentral.add(lblTipo, gbc);
    gbc.gridx = 1; gbc.gridy = 1; panelCentral.add(comboTipo, gbc);
    gbc.gridx = 0; gbc.gridy = 3; panelCentral.add(lblCosto, gbc);
    gbc.gridx = 1; gbc.gridy = 3; panelCentral.add(campoCostoBase, gbc);
    gbc.gridx = 0; gbc.gridy = 4; panelCentral.add(lblDinamico1, gbc);
    gbc.gridx = 1; gbc.gridy = 4; panelCentral.add(campoDinamico1, gbc);
    gbc.gridx = 0; gbc.gridy = 5; panelCentral.add(lblDinamico2, gbc);
    gbc.gridx = 1; gbc.gridy = 5; panelCentral.add(campoDinamico2, gbc);
    gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2; panelCentral.add(botonAsignar, gbc);

    // Cambio dinámico según tipo
    comboTipo.addActionListener(e -> actualizarCampos());
    actualizarCampos();

    add(panelTitulo, java.awt.BorderLayout.NORTH);
    add(panelCentral, java.awt.BorderLayout.CENTER);
}

private void actualizarCampos() {
    String tipo = (String) comboTipo.getSelectedItem();
    switch (tipo) {
        case "Cirugía":
            lblDinamico1.setText("Tipo Cirugía:");
            lblDinamico2.setText("Costo Complejidad:");
            lblDinamico2.setVisible(true);
            campoDinamico2.setVisible(true);
            break;
        case "Terapia":
            lblDinamico1.setText("Sesiones Semanales:");
            lblDinamico2.setText("Cantidad Semanas:");
            lblDinamico2.setVisible(true);
            campoDinamico2.setVisible(true);
            break;
        case "Medicación":
            lblDinamico1.setText("Dosis Diaria:");
            lblDinamico2.setText("Días Tratamiento:");
            lblDinamico2.setVisible(true);
            campoDinamico2.setVisible(true);
            break;
    }
}
    

    public javax.swing.JComboBox<String> getComboPacientes() { return comboPacientes; }
    public javax.swing.JComboBox<String> getComboTipo() { return comboTipo; }
    public javax.swing.JTextField getCampoCostoBase() { return campoCostoBase; }
    public javax.swing.JTextField getCampoDinamico1() { return campoDinamico1; }
    public javax.swing.JTextField getCampoDinamico2() { return campoDinamico2; }
    public javax.swing.JButton getBotonAsignar() { return botonAsignar; }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                VentanaTratamiento dialog = new VentanaTratamiento(new javax.swing.JDialog(), true);
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

                          
private javax.swing.JComboBox<String> comboPacientes;
private javax.swing.JComboBox<String> comboTipo;
private javax.swing.JTextField campoCostoBase;
private javax.swing.JLabel lblDinamico1;
private javax.swing.JLabel lblDinamico2;
private javax.swing.JTextField campoDinamico1;
private javax.swing.JTextField campoDinamico2;
private javax.swing.JButton botonAsignar;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
