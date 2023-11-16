package Frames;

import entidades.Deporte;
import controles.ControlDeporte;
import controles.ControlEntrenador;
import controles.ControlJefe;
import controles.ControlMetodologo;
import controles.ControlRama;
import entidades.Jefe;
import entidades.Metodologo;
import entidades.Rama;
import entidades.Usuario;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


/**
 *
 * @author gabri
 */
public class FrmMesociclo extends javax.swing.JFrame {
private int id;
ControlDeporte controlDeporte = new ControlDeporte();
ControlRama controlRama = new ControlRama();
ControlJefe controlJefe = new ControlJefe();
ControlEntrenador controlEntrenador = new ControlEntrenador();
ControlMetodologo controlMetodologo = new ControlMetodologo();
    
    /**
     * Creates new form FrmMesociclo
     */
    public FrmMesociclo() {
        initComponents();
        List<Deporte> listDeportes = controlDeporte.consultarDeportes();
        List<Rama> listRamas = controlRama.consultarRamas();
        List<Jefe> listJefes = controlJefe.consultarJefes();
        List<Usuario> listEntrenadores = controlEntrenador.consultarDeportes();
        List<Metodologo> listMetodologos = controlMetodologo.consultarMetodologos();
        
        
        DefaultComboBoxModel<String> comboBoxModelDeporte = new DefaultComboBoxModel();
        DefaultComboBoxModel<String> comboBoxModelRama = new DefaultComboBoxModel();
        DefaultComboBoxModel<String> comboBoxModelJefe = new DefaultComboBoxModel();
        DefaultComboBoxModel<String> comboBoxModelEntrenador = new DefaultComboBoxModel();
        DefaultComboBoxModel<String> comboBoxModelMetodologo = new DefaultComboBoxModel();
        
        
        comboBoxModelDeporte = controlDeporte.convertComboBoxModel(listDeportes);
        comboBoxModelRama = controlRama.convertComboBoxModel(listRamas);
        comboBoxModelJefe = controlJefe.convertComboBoxModel(listJefes);
        comboBoxModelEntrenador = controlEntrenador.convertComboBoxModel(listEntrenadores);
        comboBoxModelMetodologo = controlMetodologo.convertComboBoxModel(listMetodologos);
        
        //Para Deporte
        if(comboBoxModelDeporte == null || comboBoxModelRama == null || comboBoxModelJefe == null || comboBoxModelEntrenador == null || comboBoxModelMetodologo == null){
            JOptionPane.showMessageDialog(null, "No hay jefes agregados", "Error", JOptionPane.ERROR_MESSAGE);
            mandarMenu();
            
        }else{
            comboBoxDeporte.setModel(comboBoxModelDeporte);
            comboBoxRama.setModel(comboBoxModelRama);
            comboBoxJefeRama.setModel(comboBoxModelJefe);
            comboBoxEntAuxPrepFis.setModel(comboBoxModelEntrenador);
            comboBoxMetodologo.setModel(comboBoxModelMetodologo);
        }
        
    }
    
    public void recopilaInfo(){
        id=0;
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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        comboBoxDeporte = new javax.swing.JComboBox<>();
        comboBoxRama = new javax.swing.JComboBox<>();
        comboBoxJefeRama = new javax.swing.JComboBox<>();
        comboBoxEntAuxPrepFis = new javax.swing.JComboBox<>();
        comboBoxMetodologo = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JButton();
        btnContinuar = new javax.swing.JButton();
        lblCriterioBusqueda = new javax.swing.JLabel();
        btnEliminar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setUndecorated(true);
        setResizable(false);

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

        jLabel1.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jLabel1.setText("Metodólogo");

        jLabel2.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jLabel2.setText("Deporte");

        jLabel3.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jLabel3.setText("Rama");

        jLabel4.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jLabel4.setText("Jefe de rama ");

        jLabel5.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jLabel5.setText("Entrenador aux/Prep fís");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel2.add(jPanel3);
        jPanel3.setBounds(60, 70, 250, 210);

        comboBoxDeporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Seleccionar -", "Judo", "Ajedrez", "Tenis de mesa", "Tenis", "Basketball" }));
        comboBoxDeporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxDeporteActionPerformed(evt);
            }
        });

        comboBoxRama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Seleccionar -", "Mixto ", "Masculino", "Femenino", "Libre" }));
        comboBoxRama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxRamaActionPerformed(evt);
            }
        });

        comboBoxJefeRama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Seleccionar -", "Ana Nayeli León", "Por determinar" }));
        comboBoxJefeRama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxJefeRamaActionPerformed(evt);
            }
        });

        comboBoxEntAuxPrepFis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Seleccionar -", "Luis G. Miranda", "Por determinar" }));
        comboBoxEntAuxPrepFis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxEntAuxPrepFisActionPerformed(evt);
            }
        });

        comboBoxMetodologo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Seleccionar -", "Benjamín Murrieta", "Por determinar" }));
        comboBoxMetodologo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxMetodologoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboBoxMetodologo, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxEntAuxPrepFis, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxJefeRama, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxRama, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxDeporte, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(comboBoxDeporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxRama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxJefeRama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxEntAuxPrepFis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboBoxMetodologo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4);
        jPanel4.setBounds(400, 70, 250, 210);

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

        btnEliminar1.setBackground(new java.awt.Color(56, 133, 185));
        btnEliminar1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminar1.setText("Restablecer");
        btnEliminar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(374, 374, 374)
                .addComponent(lblCriterioBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(FondoTitulo)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(FondoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCriterioBusqueda)
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
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
//        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        System.exit(0);

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        this.recopilaInfo();
        this.dispose();
        FrmDuracionMesociclos frmDM = new FrmDuracionMesociclos(id);
        frmDM.setVisible(true);
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void comboBoxDeporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxDeporteActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_comboBoxDeporteActionPerformed

    private void comboBoxRamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxRamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxRamaActionPerformed

    private void comboBoxJefeRamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxJefeRamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxJefeRamaActionPerformed

    private void comboBoxEntAuxPrepFisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEntAuxPrepFisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxEntAuxPrepFisActionPerformed

    private void comboBoxMetodologoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxMetodologoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxMetodologoActionPerformed

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed
        // TODO add your handling code here:
        comboBoxDeporte.setSelectedIndex(0);
        comboBoxRama.setSelectedIndex(0);
        comboBoxJefeRama.setSelectedIndex(0);
        comboBoxEntAuxPrepFis.setSelectedIndex(0);
        comboBoxMetodologo.setSelectedIndex(0);
    }//GEN-LAST:event_btnEliminar1ActionPerformed

    
    public void mandarMenu(){
        Menu menu = new Menu();
        menu.setVisible(true);
        this.setVisible(false);
    }
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMesociclo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMesociclo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMesociclo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMesociclo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMesociclo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FondoTitulo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JComboBox<String> comboBoxDeporte;
    private javax.swing.JComboBox<String> comboBoxEntAuxPrepFis;
    private javax.swing.JComboBox<String> comboBoxJefeRama;
    private javax.swing.JComboBox<String> comboBoxMetodologo;
    private javax.swing.JComboBox<String> comboBoxRama;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblCriterioBusqueda;
    // End of variables declaration//GEN-END:variables
}
