package Frames;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author gabri
 */
public class FrmCalculadora extends javax.swing.JFrame {

    List<String> listaJCB = new ArrayList<>();

    /**
     * Creates new form FrmEntrenadores2
     * @param listaJCB
     */
    public FrmCalculadora(List<String> listaJCB) {
        initComponents();
        DefaultTableModel model = (DefaultTableModel) tblCalculadora.getModel();
        int semEtGen = 20;
        int semEtEsp = 10;
        int semEtCom = 5;

        //Comprobando que llegan los medios
//        for (String string : listaJCB) {
//            System.out.println("elementos: ");
//            System.out.println(string);
//        }
//        for (int i = 0; i < listaJCB.size(); i++) {
//            var valor = listaJCB.get(i);
////            tblCalculadora.addColumn(valor.ge);
////            model.addColumn("valor agregado" );
//            System.out.println("VALOR : " + valor);
////            System.out.println("Entra al for");
//            model.addRow(new Object[]{valor.indexOf(i)});
//
//        }
        
        //Se agregan filas por cada medio seleccionado
        for (int i = 0; i < listaJCB.size(); i++) {
            model.addRow(new Object[] {listaJCB.get(i).toString()});
        }
        
        //Se establece la semana
        int rowCount = tblCalculadora.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            tblCalculadora.setValueAt(semEtGen, i, 5);
            tblCalculadora.setValueAt(semEtEsp, i, 11);
            tblCalculadora.setValueAt(semEtCom, i, 17);
        }
        
        tblCalculadora.setModel(model);

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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCalculadora = new javax.swing.JTable();
        macro = new javax.swing.JLabel();
        medios = new javax.swing.JLabel();
        general = new javax.swing.JLabel();
        especial = new javax.swing.JLabel();
        competitiva = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        lblCriterioBusqueda = new javax.swing.JLabel();

        setTitle("Calculadora de volumen");

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

        tblCalculadora.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblCalculadora.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"RAG (KM)", null, null, null, null, "20", null, null, null, null, null, "10", null, null, null, null, null, "5", null, null}
            },
            new String [] {
                "Nombre", "min", "max", "prom", "ins", "semanas", "v. etapa", "min", "max", "prom", "ins", "semanas", "v. etapa", "min", "max", "prom", "ins", "semanas", "v. etapa", "Vol. total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, false, true, false, false, true, true, false, true, false, false, true, true, false, true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCalculadora.setShowGrid(true);
        tblCalculadora.getTableHeader().setReorderingAllowed(false);
        tblCalculadora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCalculadoraMouseClicked(evt);
            }
        });
        tblCalculadora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblCalculadoraKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tblCalculadoraKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tblCalculadora);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(20, 60, 940, 260);

        macro.setBackground(new java.awt.Color(255, 255, 255));
        macro.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        macro.setText("Macro");
        jPanel2.add(macro);
        macro.setBounds(900, 20, 70, 30);

        medios.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        medios.setText("Medios");
        jPanel2.add(medios);
        medios.setBounds(10, 20, 70, 30);

        general.setBackground(new java.awt.Color(255, 255, 255));
        general.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        general.setText("Etapa general");
        general.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(general);
        general.setBounds(130, 20, 130, 30);

        especial.setBackground(new java.awt.Color(255, 255, 255));
        especial.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        especial.setText("Etapa especial");
        jPanel2.add(especial);
        especial.setBounds(370, 20, 162, 30);

        competitiva.setBackground(new java.awt.Color(255, 255, 255));
        competitiva.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        competitiva.setText("Etapa competitiva");
        jPanel2.add(competitiva);
        competitiva.setBounds(640, 20, 162, 30);

        btnEliminar.setBackground(new java.awt.Color(56, 133, 185));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminar.setText("Cancelar");
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(56, 133, 185));
        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregar.setText("Continuar");
        btnAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
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
                        .addGap(394, 394, 394)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(FondoTitulo)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 984, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
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
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void FondoTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FondoTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FondoTituloActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        this.dispose();
        FrmElecMedios frmEleccionMedios = new FrmElecMedios();
        frmEleccionMedios.setVisible(true);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        int rowCount = tblCalculadora.getRowCount();
        DefaultTableModel model = (DefaultTableModel) tblCalculadora.getModel();
        for (int i = 0; i < rowCount; i++) {
            Object colmFinal = model.getValueAt(i, 19);
            if(colmFinal == null){
                JOptionPane.showMessageDialog(null, "Datos vacíos. No es posible continuar", "Error", JOptionPane.ERROR_MESSAGE);
                break;
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tblCalculadoraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblCalculadoraKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tblCalculadoraKeyReleased

    private void tblCalculadoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCalculadoraMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tblCalculadoraMouseClicked

    private void tblCalculadoraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblCalculadoraKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
                if (c == '.' || c == ',' || c == '-') {
                    evt.consume(); 
                }
                
        int row = tblCalculadora.getSelectedRow();
        int col = tblCalculadora.getSelectedColumn();

        if (col == 3) {
            updateAverage(col);
        }
        if (col == 9) {
            updateAverage(col);
        }
        if (col == 15) {
            updateAverage(col);
        }
        if (col == 6) {
            updateVolumen(col);
        }
        if (col == 12) {
            updateVolumen(col);
        }
        if (col == 18) {
            updateVolumen(col);
        } else {
            updateVolumenTotal();
        }
    }//GEN-LAST:event_tblCalculadoraKeyTyped

    //Metodo para calcular el promedio del min y max
    private void updateAverage(int colNum2) {
        int rowCount = tblCalculadora.getRowCount();
        int colCount = tblCalculadora.getColumnCount();
        DefaultTableModel model = (DefaultTableModel) tblCalculadora.getModel();
        for (int i = 0; i < rowCount; i++) {
            
            //Condición para que se haga el calculo si las columnas no están vacias
            if (model.getValueAt(i, colNum2 - 1) != null && model.getValueAt(i, colNum2-2) != null) {
                
                //Condición para que el min y max sean numeros enteros
                if(esNumero(model.getValueAt(i, colNum2 - 1).toString()) && esNumero(model.getValueAt(i, colNum2-2).toString()))  {
                    
                    //Se agarra el valor de las columnas
                    String dato1 = model.getValueAt(i, colNum2 - 1).toString();
                    String dato2 = model.getValueAt(i, colNum2-2).toString();
                    double dato1I = Double.parseDouble(dato1);
                    double dato2I = Double.parseDouble(dato2);
                    
                    //Se calcula el promedio
                    double promedio = (dato1I + dato2I) / 2;
                    
                    //Se muestra en la tabla
                    tblCalculadora.setValueAt(promedio, i, colNum2);
                }
                else{
                    JOptionPane.showMessageDialog(null, "No es un número válido. Por favor, ingresa un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        }
    }

    //Método para calcular el volumen de cada etapa
    private void updateVolumen(int colNum2) {
        int rowCount = tblCalculadora.getRowCount();
        int colCount = tblCalculadora.getColumnCount();
        DefaultTableModel model = (DefaultTableModel) tblCalculadora.getModel();
        
        //Ciclo para recorrer todas las filas
        for (int i = 0; i < rowCount; i++) {
            
            //Condición para que se haga el calculo si las columnas no están vacias
            if (model.getValueAt(i, colNum2 - 2) != null && model.getValueAt(i, colNum2 - 3) != null) {
                
                //Condición para que el ins sea numero entero
                if(esNumero(model.getValueAt(i, colNum2 - 2).toString()))  {
                    
                    //Se agarra el valor de las columnas
                    String dato1 = model.getValueAt(i, colNum2 - 3).toString();
                    String dato2 = model.getValueAt(i, colNum2 - 2).toString();
                    String dato3 = model.getValueAt(i, colNum2 - 1 ).toString();
                    
                    //Se parsea el valor a double
                    double dato1I = Double.parseDouble(dato1);
                    double dato2I = Double.parseDouble(dato2);
                    double dato3I = Double.parseDouble(dato3);
                    
                    //Se calcula el volumen de la etapa
                    double volEtapa = dato1I * dato2I * dato3I;
                    
                    //Se muestra en la tabla
                    tblCalculadora.setValueAt(volEtapa, i, colNum2);
                }
                else{
                    JOptionPane.showMessageDialog(null, "No es un número válido. Por favor, ingresa un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    //Método para calcular el volumen total
    private void updateVolumenTotal() {
        int rowCount = tblCalculadora.getRowCount();
        int colCount = tblCalculadora.getColumnCount();
        DefaultTableModel model = (DefaultTableModel) tblCalculadora.getModel();
        for (int i = 0; i < rowCount; i++) {
            
            //Condición para que si el volumen de cada etapa no está vacio haga el calculo total
            if (model.getValueAt(i, 6) != null && model.getValueAt(i, 12) != null && model.getValueAt(i, 18) != null) {

                //Se agarra el valor de las columnas
                String dato1 = model.getValueAt(i, 6).toString();
                String dato2 = model.getValueAt(i, 12).toString();
                String dato3 = model.getValueAt(i, 18).toString();
                
                //Se parsea el valor a double
                double dato1I = Double.parseDouble(dato1);
                double dato2I = Double.parseDouble(dato2);
                double dato3I = Double.parseDouble(dato3);
                
                //Se realiza calculo del columen de todo el macrociclo
                double volTotal = dato1I + dato2I + dato3I;
                
                //Se muestra en la tabla
                tblCalculadora.setValueAt(volTotal, i, 19);
                
            }
        }
    }
    
    //Método para ver si una cadena es un int
    public static boolean esNumero(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FondoTitulo;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel competitiva;
    private javax.swing.JLabel especial;
    private javax.swing.JLabel general;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCriterioBusqueda;
    private javax.swing.JLabel macro;
    private javax.swing.JLabel medios;
    private javax.swing.JTable tblCalculadora;
    // End of variables declaration//GEN-END:variables
}
