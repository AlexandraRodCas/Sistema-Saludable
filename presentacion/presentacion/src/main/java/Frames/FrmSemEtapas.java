package Frames;

import controles.ControlEtapa;
import entidades.Plan;
import java.awt.Color;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.swing.JOptionPane;

/**
 *
 * @author elisa
 */
public class FrmSemEtapas extends javax.swing.JFrame {

    private Date inicio, fin;
    private int semanas, id_mesociclo;
    ControlEtapa controlEtapa = new ControlEtapa();
    Plan plan = null;

    /**
     * Creates new form FrmSemEtapas
     */
    public FrmSemEtapas() {
        initComponents();
    }

    public FrmSemEtapas(Date inicio, Date fin, int semanas) {
        initComponents();
        this.inicio = inicio;
        this.fin = fin;
        this.semanas = semanas;
        this.plan = plan;
    }

    public void calcularPeriodos() {

        int eG = Integer.parseInt(txtEtapaG.getText());
        int eE = Integer.parseInt(txtEtapaE.getText());
        int eP = Integer.parseInt(txtEtapaP.getText());
        int eC = Integer.parseInt(txtEtapaC.getText());

        int pP = eG + eE;
        int pC = eP + eC;

        //Validacion semanas macrociclo = semanas repartidas
        if (!((pP + pC) == semanas)) {
            // Manejar el caso en el que las semanas repartidas no sean igual a las del mesociclo
            JOptionPane.showMessageDialog(this, "La cantidad de semanas del macrociclo son: " + semanas + ". Debe repartirlas todas entre las etapas disponibles.", "Error", JOptionPane.ERROR_MESSAGE);
            txtFieldPeriodoPrep.setText(String.valueOf(pP));
            txtFieldPeriodoCom.setText(String.valueOf(pC));
            txtFieldTotal.setText(String.valueOf(pC + pP));
            return; // No continuar con el proceso
        }

        // Convert java.sql.Date to LocalDate
        LocalDate inicioLocalDate = inicio.toLocalDate();

        // Calculate fin2 as inicio + 2 weeks
        LocalDate fin1LocalDate = inicioLocalDate.plus(eG, ChronoUnit.WEEKS);

        // Convert LocalDate back to java.sql.Date
        Date fin1 = Date.valueOf(fin1LocalDate);

        LocalDate fin2LocalDate = fin1LocalDate.plus(eE, ChronoUnit.WEEKS);
        Date fin2 = Date.valueOf(fin2LocalDate);

        LocalDate fin3LocalDate = fin2LocalDate.plus(eP, ChronoUnit.WEEKS);
        Date fin3 = Date.valueOf(fin3LocalDate);

        txtFieldPeriodoPrep.setText(String.valueOf(pP));
        txtFieldPeriodoCom.setText(String.valueOf(pC));
        txtFieldTotal.setText(String.valueOf(pC + pP));

        int confirmar = JOptionPane.showConfirmDialog(null, "Periodo preparatorio: " + pP + ". Periodo competitivo: " + pC, "Total de semanas", JOptionPane.YES_NO_OPTION);
        if (confirmar == JOptionPane.YES_OPTION) {
            boolean et = controlEtapa.agregarEtapa(inicio, fin1, eG, "General");
            boolean et2 = controlEtapa.agregarEtapa(fin1, fin2, eE, "Especial");
            boolean et3 = controlEtapa.agregarEtapa(fin2, fin3, eP, "Precompetitiva");
            boolean et4 = controlEtapa.agregarEtapa(fin3, fin, eC, "Competitiva");

            this.dispose();
            FrmElecMedios medios = new FrmElecMedios(eG, eE, eC + eP);
            medios.setVisible(true);
        }
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtEtapaG = new javax.swing.JTextField();
        txtEtapaP = new javax.swing.JTextField();
        txtEtapaE = new javax.swing.JTextField();
        txtEtapaC = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtFieldPeriodoPrep = new javax.swing.JTextField();
        txtFieldPeriodoCom = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtFieldTotal = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JToggleButton();
        btnContinuar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(56, 133, 185));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Etapa general");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 27, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Etapa especial");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 71, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Precompetitivo");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 124, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Competitivo");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        txtEtapaG.setForeground(new java.awt.Color(204, 204, 204));
        txtEtapaG.setText("0");
        txtEtapaG.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEtapaGFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEtapaGFocusLost(evt);
            }
        });
        txtEtapaG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEtapaGKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEtapaGKeyTyped(evt);
            }
        });
        jPanel1.add(txtEtapaG, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 34, -1));

        txtEtapaP.setText("0");
        txtEtapaP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEtapaPFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEtapaPFocusLost(evt);
            }
        });
        txtEtapaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEtapaPActionPerformed(evt);
            }
        });
        txtEtapaP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEtapaPKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEtapaPKeyTyped(evt);
            }
        });
        jPanel1.add(txtEtapaP, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 34, -1));

        txtEtapaE.setText("0");
        txtEtapaE.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEtapaEFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEtapaEFocusLost(evt);
            }
        });
        txtEtapaE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEtapaEActionPerformed(evt);
            }
        });
        txtEtapaE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEtapaEKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEtapaEKeyTyped(evt);
            }
        });
        jPanel1.add(txtEtapaE, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 34, -1));

        txtEtapaC.setText("0");
        txtEtapaC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEtapaCFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEtapaCFocusLost(evt);
            }
        });
        txtEtapaC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEtapaCActionPerformed(evt);
            }
        });
        txtEtapaC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEtapaCKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEtapaCKeyTyped(evt);
            }
        });
        jPanel1.add(txtEtapaC, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 34, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Periodo competitivo");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Periodo preparatorio");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, -1));

        txtFieldPeriodoPrep.setText("0");
        txtFieldPeriodoPrep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFieldPeriodoPrepFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFieldPeriodoPrepFocusLost(evt);
            }
        });
        txtFieldPeriodoPrep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFieldPeriodoPrepKeyTyped(evt);
            }
        });
        jPanel1.add(txtFieldPeriodoPrep, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 34, -1));

        txtFieldPeriodoCom.setText("0");
        txtFieldPeriodoCom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFieldPeriodoComFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFieldPeriodoComFocusLost(evt);
            }
        });
        txtFieldPeriodoCom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFieldPeriodoComKeyTyped(evt);
            }
        });
        jPanel1.add(txtFieldPeriodoCom, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 34, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Total semanas");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, -1, -1));

        txtFieldTotal.setText("0");
        txtFieldTotal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFieldTotalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFieldTotalFocusLost(evt);
            }
        });
        txtFieldTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFieldTotalKeyTyped(evt);
            }
        });
        jPanel1.add(txtFieldTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 34, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 44, 470, 230));

        btnCancelar.setBackground(new java.awt.Color(56, 133, 185));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 340, 90, 34));

        btnContinuar.setBackground(new java.awt.Color(56, 133, 185));
        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });
        getContentPane().add(btnContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(317, 340, 100, 34));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 430));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtEtapaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEtapaPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEtapaPActionPerformed

    private void txtEtapaEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEtapaEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEtapaEActionPerformed

    private void txtEtapaCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEtapaCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEtapaCActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // Cambiar mas tarde paa regresar al menu o algo asi.
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtEtapaGKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEtapaGKeyTyped
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (txtEtapaG.getText().trim().length() == 3) {
            evt.consume();
        }
    }//GEN-LAST:event_txtEtapaGKeyTyped

    private void txtEtapaEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEtapaEKeyTyped
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (txtEtapaE.getText().trim().length() == 3) {
            evt.consume();
        }
    }//GEN-LAST:event_txtEtapaEKeyTyped

    private void txtEtapaPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEtapaPKeyTyped
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (txtEtapaP.getText().trim().length() == 3) {
            evt.consume();
        }
    }//GEN-LAST:event_txtEtapaPKeyTyped

    private void txtEtapaCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEtapaCKeyTyped
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (txtEtapaC.getText().trim().length() == 3) {
            evt.consume();
        }
    }//GEN-LAST:event_txtEtapaCKeyTyped

    private void txtEtapaCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEtapaCKeyReleased

    }//GEN-LAST:event_txtEtapaCKeyReleased

    private void txtEtapaPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEtapaPKeyReleased

    }//GEN-LAST:event_txtEtapaPKeyReleased

    private void txtEtapaEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEtapaEKeyReleased

    }//GEN-LAST:event_txtEtapaEKeyReleased

    private void txtEtapaGKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEtapaGKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txtEtapaGKeyReleased
    /*
    * Método que funciona para quitar el "placeholder"
     */
    private void txtEtapaGFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEtapaGFocusGained
        // TODO add your handling code here:
        if (txtEtapaG.getText().equals("0")) {
            txtEtapaG.setText("");
            txtEtapaG.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_txtEtapaGFocusGained

    private void txtEtapaGFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEtapaGFocusLost
        // TODO add your handling code here:
        if (txtEtapaG.getText().equals("")) {
            txtEtapaG.setText("0");
            txtEtapaG.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtEtapaGFocusLost

    private void txtEtapaEFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEtapaEFocusGained
        // TODO add your handling code here:
        if (txtEtapaE.getText().equals("0")) {
            txtEtapaE.setText("");
            txtEtapaE.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_txtEtapaEFocusGained

    private void txtEtapaEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEtapaEFocusLost
        // TODO add your handling code here:
        if (txtEtapaE.getText().equals("")) {
            txtEtapaE.setText("0");
            txtEtapaE.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtEtapaEFocusLost

    private void txtEtapaPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEtapaPFocusGained
        // TODO add your handling code here:
        if (txtEtapaP.getText().equals("0")) {
            txtEtapaP.setText("");
            txtEtapaP.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_txtEtapaPFocusGained

    private void txtEtapaPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEtapaPFocusLost
        // TODO add your handling code here:
        if (txtEtapaP.getText().equals("")) {
            txtEtapaP.setText("0");
            txtEtapaP.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtEtapaPFocusLost

    private void txtEtapaCFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEtapaCFocusGained
        // TODO add your handling code here:
        if (txtEtapaC.getText().equals("0")) {
            txtEtapaC.setText("");
            txtEtapaC.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_txtEtapaCFocusGained

    private void txtEtapaCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEtapaCFocusLost
        // TODO add your handling code here:
        if (txtEtapaC.getText().equals("")) {
            txtEtapaC.setText("0");
            txtEtapaC.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtEtapaCFocusLost

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        // TODO add your handling code here:
        //|| txtEtapaE.getText().isBlank() || txtEtapaP.getText().isBlank() || txtEtapaC.getText().isBlank() || txtFieldPeriodoCom.getText().isBlank() || txtFieldPeriodoPrep.getText().isBlank()
        if (txtEtapaG.getText().equals("0") || txtEtapaE.getText().equals("0") || txtEtapaC.getText().equals("0")) {
            JOptionPane.showMessageDialog(null,
                    "Es necesario llenar todos los campos requeridos",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            this.calcularPeriodos();
        }
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void txtFieldPeriodoPrepFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldPeriodoPrepFocusGained
        // TODO add your handling code here:
        if (txtFieldPeriodoPrep.getText().equals("0")) {
            txtFieldPeriodoPrep.setText("");
            txtFieldPeriodoPrep.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_txtFieldPeriodoPrepFocusGained

    private void txtFieldPeriodoPrepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldPeriodoPrepFocusLost
        // TODO add your handling code here:
        if (txtFieldPeriodoPrep.getText().equals("")) {
            txtFieldPeriodoPrep.setText("0");
            txtFieldPeriodoPrep.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtFieldPeriodoPrepFocusLost

    private void txtFieldPeriodoPrepKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldPeriodoPrepKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (txtFieldPeriodoPrep.getText().trim().length() == 3) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFieldPeriodoPrepKeyTyped

    private void txtFieldPeriodoComFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldPeriodoComFocusGained
        // TODO add your handling code here:
        if (txtFieldPeriodoCom.getText().equals("")) {
            txtFieldPeriodoCom.setText("0");
            txtFieldPeriodoCom.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtFieldPeriodoComFocusGained

    private void txtFieldPeriodoComFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldPeriodoComFocusLost
        // TODO add your handling code here:
        if (txtFieldPeriodoPrep.getText().equals("")) {
            txtFieldPeriodoPrep.setText("0");
            txtFieldPeriodoPrep.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtFieldPeriodoComFocusLost

    private void txtFieldPeriodoComKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldPeriodoComKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (txtFieldPeriodoCom.getText().trim().length() == 3) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFieldPeriodoComKeyTyped

    private void txtFieldTotalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldTotalFocusGained
        // TODO add your handling code here:
        if (txtFieldPeriodoCom.getText().equals("")) {
            txtFieldPeriodoCom.setText("0");
            txtFieldPeriodoCom.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtFieldTotalFocusGained

    private void txtFieldTotalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldTotalFocusLost
        // TODO add your handling code here:
        if (txtFieldPeriodoPrep.getText().equals("")) {
            txtFieldPeriodoPrep.setText("0");
            txtFieldPeriodoPrep.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtFieldTotalFocusLost

    private void txtFieldTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldTotalKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (txtFieldPeriodoCom.getText().trim().length() == 3) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFieldTotalKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnCancelar;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtEtapaC;
    private javax.swing.JTextField txtEtapaE;
    private javax.swing.JTextField txtEtapaG;
    private javax.swing.JTextField txtEtapaP;
    private javax.swing.JTextField txtFieldPeriodoCom;
    private javax.swing.JTextField txtFieldPeriodoPrep;
    private javax.swing.JTextField txtFieldTotal;
    // End of variables declaration//GEN-END:variables
}
