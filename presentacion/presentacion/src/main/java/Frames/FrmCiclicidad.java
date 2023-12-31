/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import controles.ControlCiclicidad;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author velas
 */
public class FrmCiclicidad extends javax.swing.JFrame {

    private final Pattern pattern = Pattern.compile("[0-9]*");
    private final Pattern pattern2 = Pattern.compile("[0-9,]*");
    int semEtGen = 0;
    int semEtEsp = 0;
    int semEtCom = 0;

    /**
     * Creates new form FrmCiclicidad
     */
    public FrmCiclicidad(int eG, int eE, int eC) {
        initComponents();
        DefaultTableModel model = (DefaultTableModel) tblCiclicidad.getModel();
        semEtGen = eG;
        semEtEsp = eE;
        semEtCom = eC;

    }

    public void funcionalidad() {
        DefaultTableModel model = (DefaultTableModel) tblCiclicidad.getModel();

        // Obtener el número de filas y columnas
        int numCols = model.getColumnCount();

        // Ignorar la primera columna y mostrar el contenido de las otras columnas
        for (int col = 1; col < numCols; col++) {
            String mesociclo = (String) model.getValueAt(0, col);
            String ciclicidad = (String) model.getValueAt(1, col);
            if (mesociclo == null || ciclicidad == null || mesociclo.isBlank() || ciclicidad.isBlank()) {
                if (col == 1 && mesociclo == null || col == 1 && ciclicidad == null
                        || col == 1 && mesociclo.isBlank() || col == 1 && ciclicidad.isBlank()) {
                    JOptionPane.showMessageDialog(null, "Debes completar los datos requeridos.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                break;
            }
            if (!pattern.matcher(String.valueOf(mesociclo)).matches()
                    || !pattern2.matcher(String.valueOf(ciclicidad)).matches()) {
                JOptionPane.showMessageDialog(null, "Solo puedes ingresar numeros en microcilos, o numeros y comas para indicar la ciclicidad. Intentalo otra vez.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validar la suma de los números en ciclicidad
            String[] numerosCiclicidad = ciclicidad.split(",");
            if (numerosCiclicidad.length == 2) {
                try {
                    int num1 = Integer.parseInt(numerosCiclicidad[0].trim());
                    int num2 = Integer.parseInt(numerosCiclicidad[1].trim());
                    int sumaCiclicidad = num1 + num2;

                    if (sumaCiclicidad != Integer.parseInt(mesociclo)) {
                        JOptionPane.showMessageDialog(null, "La suma de los dos números en ciclicidad no es igual al número en mesociclo.", "Error", JOptionPane.ERROR_MESSAGE);
                        return; // Salir de la función si se encuentra un error
                    }
                    else{
                        ControlCiclicidad controlCicli = new ControlCiclicidad();
                        int columnas = tblCiclicidad.getColumnCount();
                        tblCiclicidad.clearSelection();
                        int contEtGen = semEtGen;
                        int contEtEsp = semEtEsp;
                        int contEtCom = semEtCom;
                        
                        for (int j = 1; j < columnas; j++) {
                            Object cantMicros = tblCiclicidad.getValueAt(0, j);
                            Object ciclicidadTabla = tblCiclicidad.getValueAt(1, j);
                            if(cantMicros != null){
                                for(int c = 0; c < Integer.parseInt(cantMicros.toString()); c++){
                                    for (int i = 0; i <=(contEtGen + contEtEsp + contEtCom) ; i++) {
                                        if(contEtGen>0){
                                            controlCicli.agregarMicrociclo(i, ciclicidadTabla.toString(), j, "General");
                                            contEtGen = contEtGen - 1;
                                            break;
                                        }else{
                                            if(contEtEsp >0){
                                                controlCicli.agregarMicrociclo(i, ciclicidadTabla.toString(), j, "Especial");
                                                contEtEsp = contEtEsp -1;
                                                break;
                                            }
                                            else{
                                                if(contEtCom > 0 ){
                                                    controlCicli.agregarMicrociclo(i, ciclicidadTabla.toString(), j, "Competitiva");
                                                    contEtCom = contEtCom -1;
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if(contEtCom == 0){
                                break;
                            }
                        }
                        
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error al convertir los números en ciclicidad.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Salir de la función si se encuentra un error
                }
            } else {
                JOptionPane.showMessageDialog(null, "Formato incorrecto para ciclicidad. Debe ser 'n1,n2'.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Salir de la función si se encuentra un error
            }

            guardar(mesociclo, ciclicidad);
        }
        int columNoVacias = contarColumnasNoVacias();
        JOptionPane.showMessageDialog(null, "Datos guardados", "Listo", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
        FrmAcentos frmAcentos = new FrmAcentos(semEtGen, semEtEsp, semEtCom, columNoVacias, 1);
        frmAcentos.setVisible(true);

    }
    
    public int contarColumnasNoVacias() {
    int columnasNoVacias = 0;
    int columnCount = tblCiclicidad.getColumnCount();

    for (int i = 0; i < columnCount; i++) {
        boolean columnaVacia = true;
        for (int j = 0; j < tblCiclicidad.getRowCount(); j++) {
            if (tblCiclicidad.getValueAt(j, i) != null && !tblCiclicidad.getValueAt(j, i).toString().isEmpty()) {
                columnaVacia = false;
                break;
            }
        }
        if (!columnaVacia) {
            columnasNoVacias++;
        }
    }

    return columnasNoVacias;
}
    
    public boolean validarSemanas(){
        double suma = 0.0;

        tblCiclicidad.clearSelection();
        int columnas = tblCiclicidad.getColumnCount();
        for (int i = 1; i < columnas; i++) {
            Object valorCelda = tblCiclicidad.getValueAt(0, i);

            
            if (valorCelda != null && valorCelda != "") {
                suma += Double.parseDouble(valorCelda.toString());
            }
        }

        if(suma == (semEtGen + semEtEsp + semEtCom)){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean validarSemanasCantidad(){
        tblCiclicidad.clearSelection();
        int columnas = tblCiclicidad.getColumnCount();
        for (int i = 1; i < columnas; i++) {
            Object valorCelda = tblCiclicidad.getValueAt(0, i);
            if (valorCelda != null) {
                if(Integer.parseInt(valorCelda.toString())>6 || Integer.parseInt(valorCelda.toString())<2){
                    return false;
                }
                
            }
        }
        return true;

    }

    public void guardar(String mesociclo, String ciclicidad) {

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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCiclicidad = new javax.swing.JTable();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1500, 308));

        jPanel1.setBackground(new java.awt.Color(56, 133, 185));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 287));

        tblCiclicidad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Microciclos", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"Ciclicidad", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mesociclo", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblCiclicidad.setAutoscrolls(false);
        tblCiclicidad.setPreferredSize(new java.awt.Dimension(1600, 80));
        tblCiclicidad.setShowGrid(false);
        tblCiclicidad.setShowHorizontalLines(true);
        tblCiclicidad.setShowVerticalLines(true);
        tblCiclicidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblCiclicidadKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblCiclicidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tblCiclicidadKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tblCiclicidad);
        tblCiclicidad.getAccessibleContext().setAccessibleParent(jPanel1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addGap(64, 64, 64))
        );

        btnAceptar.setBackground(new java.awt.Color(56, 133, 185));
        btnAceptar.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(56, 133, 185));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(449, 449, 449)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(167, 167, 167)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(485, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1321, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        if(validarSemanas()){
            if(validarSemanasCantidad()){
                this.funcionalidad();
            }
            else{
            JOptionPane.showMessageDialog(null, "El número de semana por mesociclo debe ser mayor a 1 y menor o igual a 6", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debe coincidir con el número de semanas antes determinado. " + (semEtGen + semEtEsp + semEtCom), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void tblCiclicidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblCiclicidadKeyTyped
        // TODO add your handling code here:
        Pattern pattern = Pattern.compile("[0-9,]*");
        char c = evt.getKeyChar();
        // Validar si el carácter es un número o una coma
        if (!pattern.matcher(String.valueOf(c)).matches()) {
            evt.consume();  // Consumir el evento para evitar que se ingrese el carácter no válido
        }


    }//GEN-LAST:event_tblCiclicidadKeyTyped

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblCiclicidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblCiclicidadKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        // Validar si el carácter es un número o una coma
        if (!pattern.matcher(String.valueOf(c)).matches()) {
            evt.consume();  // Consumir el evento para evitar que se ingrese el carácter no válido
        }
    }//GEN-LAST:event_tblCiclicidadKeyPressed

    private void tblCiclicidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblCiclicidadKeyReleased
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        // Validar si el carácter es un número o una coma
        if (!pattern.matcher(String.valueOf(c)).matches()) {
            evt.consume();  // Consumir el evento para evitar que se ingrese el carácter no válido
        }
    }//GEN-LAST:event_tblCiclicidadKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCiclicidad;
    // End of variables declaration//GEN-END:variables
}
