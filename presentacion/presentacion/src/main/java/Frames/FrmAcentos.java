package Frames;

import controles.ControlMicroMedio;
import entidades.Microciclo;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * HU8
 *
 * @author Gabriel
 */
public class FrmAcentos extends javax.swing.JFrame {

    int semEtGen = 0;
    int semEtEsp = 0;
    int semEtCom = 0;
    int contadorMesos = 0;
    int cantidad = 0;
    
    ControlMicroMedio controlAcentos = new ControlMicroMedio();
    
    /**
     * Creates new form p
     */
    public FrmAcentos(int eG, int eE, int eC, int cantidad, int inEmpezar) {
        initComponents();
        int filas = tblAcentos.getRowCount();
        
        semEtGen = eG;
        semEtEsp = eE;
        semEtCom = eC;
        contadorMesos = cantidad;
        this.cantidad = cantidad;
        
        List<Microciclo> listaMicros = controlAcentos.consultarUltimosMicrosAgregados(semEtGen+semEtEsp+semEtCom);
        
        //Se establecen las columnas
        acentos(controlAcentos.consultarCiclicidad(listaMicros, inEmpezar));
        Date inicio = controlAcentos.consultarInicioMeso(listaMicros, inEmpezar);
        Date fin = controlAcentos.consultarFinMeso(listaMicros, inEmpezar);
        inicio.setDate(inicio.getDate() + 1);
        fin.setDate(fin.getDate() + 1);
        int idEtapa = controlAcentos.consultarIdEtapa(listaMicros, inEmpezar);

        List<String> medios = controlAcentos.consultarMedios(idEtapa);
        DefaultTableModel model = (DefaultTableModel) tblAcentos.getModel();

        
        if(medios!= null){
            for (String medio : medios) {
                Object[] fila = {medio};
                model.addRow(fila);
            }
        }
        
        calcularVolumen(idEtapa);
        
        //Se llenan los textField
        txtNoMesociclo.setText(inEmpezar+"");
        txtInicioMesociclo.setText(inicio.toString());
        txtFinMesociclo.setText(fin.toString());
        
        //Recorriendo los renglones de la tabla para saber si hay renglones vacíos
        //tablaTieneDatos();
        //validacionVacios();
        //validacionPositivos();
    }
    
    public void calcularVolumen(int idEtapa){
        int rowCount = tblAcentos.getRowCount();
        int colCount = tblAcentos.getColumnCount();
        for (int i = 0; i < rowCount; i++) {
            String nombreMedio = tblAcentos.getValueAt(i, 0).toString();
            double volumen = controlAcentos.consultaVolumenMedio(nombreMedio, idEtapa);
            
        }
        List<Integer> acentos = controlAcentos.consultarPorcentaje(tblAcentos.getColumnCount()-1);
        for (int i = 0; i < rowCount; i++) {
            String nombreMedio = tblAcentos.getValueAt(i, 0).toString();
            double volumen = controlAcentos.consultaVolumenMedio(nombreMedio, idEtapa);

            for(int j = 1; j<colCount; j++){
                if (i < acentos.size()) {
                    int porcentaje = acentos.get(j-1);
                    double porcentajeCalculado = (volumen * porcentaje) / 100.0;
                    tblAcentos.setValueAt(porcentajeCalculado, i, j);
                } else {
                    System.out.println("No hay porcentaje definido para esta fila");
                }
            }
        }
    }
    
    private void validacionPositivos() {
        int NoMesociclos = Integer.parseInt(txtNoMesociclo.getText());
        if (NoMesociclos <= 0 || txtInicioMesociclo.toString().equals("00/00/0000") || txtFinMesociclo.toString().equals("00/00/0000")) {
            //ERROR
            JOptionPane.showMessageDialog(this, "Error!!!");
        }
    }

    private void validacionVacios() {
        if (txtNoMesociclo.toString().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error mesociclos vacíos");
        } else {
            //Todo correcto
            if (txtInicioMesociclo.toString().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Error Inicio mesociclo vacío");
            } else {
                if (txtFinMesociclo.toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Error Fin mesociclo vacío");

                }
            }
        }
    }

    private boolean tablaTieneDatos() {
        //Se tiene que validar que la tabla tenga datos
        DefaultTableModel model = (DefaultTableModel) tblAcentos.getModel();

        for (int fila = 0; fila < model.getRowCount(); fila++) {
            for (int columna = 0; columna < 10; columna++) {
                Object valor = model.getValueAt(fila, columna);
                if (valor == null || valor.toString().isBlank() || valor.toString().isEmpty()) {
                    return false; //La tabla no tiene datos 
                }
            }
        }
        return true; //La tabla tiene datos
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        lblLogoCabecera = new javax.swing.JLabel();
        lblApartado = new javax.swing.JLabel();
        FondoTitulo = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreCategoria = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCategorias = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnListarCategorias = new javax.swing.JButton();
        btnBuscarCategoria = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnAgregar2 = new javax.swing.JButton();
        lblLogoCabecera1 = new javax.swing.JLabel();
        FondoTitulo1 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtFinMesociclo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNoMesociclo = new javax.swing.JTextField();
        txtInicioMesociclo = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAcentos = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCategorias1 = new javax.swing.JTable();

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jFrame1.setBackground(new java.awt.Color(255, 255, 255));
        jFrame1.setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        lblLogoCabecera.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel2.add(lblLogoCabecera);
        lblLogoCabecera.setBounds(120, 0, 220, 30);

        lblApartado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblApartado.setForeground(new java.awt.Color(255, 255, 255));
        lblApartado.setText("Categorias");
        jPanel2.add(lblApartado);
        lblApartado.setBounds(10, 0, 200, 30);

        FondoTitulo.setEditable(false);
        FondoTitulo.setBackground(new java.awt.Color(110, 88, 68));
        FondoTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FondoTituloActionPerformed(evt);
            }
        });
        jPanel2.add(FondoTitulo);
        FondoTitulo.setBounds(0, 0, 474, 30);

        jPanel3.setBackground(new java.awt.Color(0, 145, 155));
        jPanel3.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre de la categoría");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(10, 10, 140, 16);

        txtNombreCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreCategoriaKeyTyped(evt);
            }
        });
        jPanel3.add(txtNombreCategoria);
        txtNombreCategoria.setBounds(20, 30, 180, 30);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(20, 50, 220, 80);

        tblCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCategorias.setShowGrid(true);
        tblCategorias.getTableHeader().setReorderingAllowed(false);
        tblCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCategoriasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCategorias);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(20, 140, 340, 260);

        btnModificar.setBackground(new java.awt.Color(255, 145, 77));
        btnModificar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel2.add(btnModificar);
        btnModificar.setBounds(370, 140, 90, 80);

        btnAgregar.setBackground(new java.awt.Color(255, 145, 77));
        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregar);
        btnAgregar.setBounds(370, 50, 90, 80);

        btnSalir.setBackground(new java.awt.Color(255, 145, 77));
        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalir);
        btnSalir.setBounds(370, 320, 90, 80);

        btnEliminar.setBackground(new java.awt.Color(255, 145, 77));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminar);
        btnEliminar.setBounds(370, 230, 90, 80);

        btnListarCategorias.setBackground(new java.awt.Color(255, 145, 77));
        btnListarCategorias.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        btnListarCategorias.setText("Listar");
        btnListarCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarCategoriasActionPerformed(evt);
            }
        });
        jPanel2.add(btnListarCategorias);
        btnListarCategorias.setBounds(250, 95, 110, 35);

        btnBuscarCategoria.setBackground(new java.awt.Color(255, 145, 77));
        btnBuscarCategoria.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        btnBuscarCategoria.setText("Buscar");
        btnBuscarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCategoriaActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscarCategoria);
        btnBuscarCategoria.setBounds(250, 50, 110, 35);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(null);

        btnAgregar2.setBackground(new java.awt.Color(56, 133, 185));
        btnAgregar2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregar2.setText("Continuar");
        btnAgregar2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregar2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar2ActionPerformed(evt);
            }
        });
        jPanel4.add(btnAgregar2);
        btnAgregar2.setBounds(294, 450, 100, 40);

        lblLogoCabecera1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel4.add(lblLogoCabecera1);
        lblLogoCabecera1.setBounds(120, 0, 220, 30);

        FondoTitulo1.setEditable(false);
        FondoTitulo1.setBackground(new java.awt.Color(156, 164, 175));
        FondoTitulo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FondoTitulo1ActionPerformed(evt);
            }
        });
        jPanel4.add(FondoTitulo1);
        FondoTitulo1.setBounds(0, 0, 970, 30);

        jPanel5.setBackground(new java.awt.Color(56, 133, 185));
        jPanel5.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Fin mesociclo");
        jPanel5.add(jLabel2);
        jLabel2.setBounds(590, 40, 140, 16);

        txtFinMesociclo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFinMesocicloKeyTyped(evt);
            }
        });
        jPanel5.add(txtFinMesociclo);
        txtFinMesociclo.setBounds(680, 30, 160, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("No. mesociclo");
        jPanel5.add(jLabel3);
        jLabel3.setBounds(20, 40, 140, 16);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Inicio Mesociclo");
        jPanel5.add(jLabel4);
        jLabel4.setBounds(240, 40, 140, 16);

        txtNoMesociclo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNoMesocicloKeyTyped(evt);
            }
        });
        jPanel5.add(txtNoMesociclo);
        txtNoMesociclo.setBounds(110, 30, 60, 30);

        txtInicioMesociclo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtInicioMesocicloKeyTyped(evt);
            }
        });
        jPanel5.add(txtInicioMesociclo);
        txtInicioMesociclo.setBounds(340, 30, 160, 30);

        tblAcentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medio", "1"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblAcentos);

        jPanel5.add(jScrollPane3);
        jScrollPane3.setBounds(70, 120, 800, 220);

        jPanel4.add(jPanel5);
        jPanel5.setBounds(20, 50, 920, 380);

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
        jPanel4.add(btnCancelar);
        btnCancelar.setBounds(520, 450, 90, 40);

        tblCategorias1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Acentos", "%", "%", "%", "%", "%", "%"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCategorias1.setShowGrid(true);
        tblCategorias1.getTableHeader().setReorderingAllowed(false);
        tblCategorias1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCategorias1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCategorias1);

        jPanel4.add(jScrollPane2);
        jScrollPane2.setBounds(50, 140, 850, 260);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void FondoTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FondoTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FondoTituloActionPerformed

    private void txtNombreCategoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreCategoriaKeyTyped
        char c = evt.getKeyChar();
        // Verificar si el carácter ingresado es una letra
        if (!Character.isLetter(c) && c != ' ') {
            evt.consume(); // Eliminar el carácter ingresado si no es una letra o espacio
        }
    }//GEN-LAST:event_txtNombreCategoriaKeyTyped

    private void tblCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCategoriasMouseClicked
        int seleccionar = tblCategorias.rowAtPoint(evt.getPoint());
        this.txtNombreCategoria.setText(String.valueOf(tblCategorias.getValueAt(seleccionar, 0)));
    }//GEN-LAST:event_tblCategoriasMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnListarCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarCategoriasActionPerformed
//        listarCategorias();
    }//GEN-LAST:event_btnListarCategoriasActionPerformed

    private void btnBuscarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCategoriaActionPerformed
        if (txtNombreCategoria.getText().isEmpty() || txtNombreCategoria.getText().isBlank()) {
//            JOptionPane.showMessageDialog(null, "Ingrese el nombre de la categoria", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String nombre = txtNombreCategoria.getText();
//            consultarPorNombre(nombre);
        }
    }//GEN-LAST:event_btnBuscarCategoriaActionPerformed

    private void FondoTitulo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FondoTitulo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FondoTitulo1ActionPerformed

    private void tblCategorias1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCategorias1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblCategorias1MouseClicked

    private void btnAgregar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar2ActionPerformed
        controlAcentos.
        if(contadorMesos<cantidad){
            
        }
    }//GEN-LAST:event_btnAgregar2ActionPerformed

    private void txtFinMesocicloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFinMesocicloKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFinMesocicloKeyTyped

    private void txtNoMesocicloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoMesocicloKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoMesocicloKeyTyped

    private void txtInicioMesocicloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInicioMesocicloKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInicioMesocicloKeyTyped

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Menu calculadora = new Menu();
        this.dispose();
        calculadora.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    public void acentos(String ciclicidad){
        int numeroCiclicidad = sumarNumerosPorComa(ciclicidad);
        DefaultTableModel model =  (DefaultTableModel) tblAcentos.getModel();
        for (int i = 2; i <= numeroCiclicidad; i++) {
            model.addColumn(String.valueOf(i));
        }
        
        
    }
    
    public static int sumarNumerosPorComa(String cadena) {
        String[] numerosComoString = cadena.split(",");
        int suma = 0;

        for (String numero : numerosComoString) {
            suma += Integer.parseInt(numero);
        }

        return suma;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FondoTitulo;
    private javax.swing.JTextField FondoTitulo1;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregar2;
    private javax.swing.JButton btnBuscarCategoria;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnListarCategorias;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblApartado;
    private javax.swing.JLabel lblLogoCabecera;
    private javax.swing.JLabel lblLogoCabecera1;
    private javax.swing.JTable tblAcentos;
    private javax.swing.JTable tblCategorias;
    private javax.swing.JTable tblCategorias1;
    private javax.swing.JTextField txtFinMesociclo;
    private javax.swing.JTextField txtInicioMesociclo;
    private javax.swing.JTextField txtNoMesociclo;
    private javax.swing.JTextField txtNombreCategoria;
    // End of variables declaration//GEN-END:variables
}
