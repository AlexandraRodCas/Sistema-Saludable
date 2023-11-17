package Frames;

import controles.ControlMedio;
import entidades.Medio;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;

/**
 *
 * @author Alexandra c:
 */
public class FrmElecMedios extends javax.swing.JFrame {

    List<String> listaJCB = new ArrayList<>();
    List<Medio> listaMedios = new ArrayList<>();
    List<JCheckBox> checkboxes = new ArrayList<>();
    ControlMedio controlMedio = new ControlMedio();
    int eG = 0, eE = 0, eC = 0;

    /**
     * Creates new form FrmElecMedios
     */
    public FrmElecMedios() {
        initComponents();
    }
    
    public FrmElecMedios(int eG, int eE, int eC) {
        initComponents();
        this.eG = eG;
        this.eE = eE;
        this.eC = eC;
        jPanel2.setLayout(new GridLayout(0, 1)); 
        listaMedios = controlMedio.consultarRamas();

        for (Medio elemento : listaMedios) {
            JCheckBox checkBox = new JCheckBox(elemento.toString());
            jPanel2.add(checkBox); 
            checkboxes.add(checkBox);
        }
    }

    public FrmElecMedios(String[] arreglo) {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        FondoTitulo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lblApartado = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnContinuar = new javax.swing.JButton();
        lblCriterioBusqueda = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Medios a practicar");
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        FondoTitulo.setEditable(false);
        FondoTitulo.setBackground(new java.awt.Color(156, 164, 175));
        FondoTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FondoTituloActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(56, 133, 185));
        jPanel2.setLayout(null);

        lblApartado.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblApartado.setText("Medios Físicos a practicar");
        jPanel2.add(lblApartado);
        lblApartado.setBounds(350, 20, 310, 30);

        btnCancelar.setBackground(new java.awt.Color(56, 133, 185));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnContinuar.setBackground(new java.awt.Color(56, 133, 185));
        btnContinuar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnContinuar.setText("Continuar");
        btnContinuar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnContinuar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        lblCriterioBusqueda.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblCriterioBusqueda.setForeground(new java.awt.Color(255, 255, 255));
        lblCriterioBusqueda.setText("Criterios de Búsqueda");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(374, 374, 374)
                        .addComponent(lblCriterioBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(357, 357, 357)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(161, 161, 161)
                        .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(FondoTitulo)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 984, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(FondoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCriterioBusqueda)
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void FondoTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FondoTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FondoTituloActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Menu calculadora = new Menu();
        this.dispose();
        calculadora.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed

        revisarCheckedBox();
        FrmCalculadora calculadora = new FrmCalculadora(listaJCB, eG, eE, eC);
        this.dispose();
        calculadora.setVisible(true);
    }//GEN-LAST:event_btnContinuarActionPerformed

    public void revisarCheckedBox() {
        listaJCB = new ArrayList<>();
        // Para verificar qué checkboxes están seleccionados
        for (JCheckBox checkBox : checkboxes) {
            if (checkBox.isSelected()) {
                listaJCB.add(checkBox.getText());
            }
        }
        
    }
    
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FondoTitulo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblApartado;
    private javax.swing.JLabel lblCriterioBusqueda;
    // End of variables declaration//GEN-END:variables
}
