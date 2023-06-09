package Listas;

//librerias para la lectura del archivo csv
import MenuPrincipal.administracion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
        
public class Facturas extends javax.swing.JFrame {

    DefaultTableModel tab;//creacion de la tabla
    private TableRowSorter<TableModel> modeloOrdenado;//creacion de la nueva tabla que filtra el parametro a buscar
    
    public Facturas() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        tab = new DefaultTableModel();
        // Agrega nombre a cada columna 
        tab.addColumn("N°");
        tab.addColumn("Fecha");
        tab.addColumn("Vendedor");
        tab.addColumn("Cliente");
        tab.addColumn("Total");
        tab.addColumn("M de Pago");
                
        //agreda los nombres a la tabla
        tablafac.setModel(tab);
        
        ImportacionCSVfac();
    }

    public void ImportacionCSVfac(){
       
        //lee el archivo csv e ingresa los datos en columnas de la tabla
        String linea="";
        String datos[];

        File listafac = new File("C:\\Users\\Asus\\Desktop\\DUVAN\\OTROS\\SOFTWAREADM\\Facturacion.csv");//direccion donde se encuenta el archivo csv
        FileReader Lector;

        try{

            Lector = new FileReader(listafac);
            BufferedReader buffer = new BufferedReader(Lector);
            while(buffer.ready()){
                if(!(linea = buffer.readLine()).equals("/000")){//la fila se leer mientras no halla en ella una celda vacia de ser asi saltara a la siguiente fila
                    System.out.println(linea);
                    datos = linea.split(";");//separa cada dato con un ; para obtener cada columna por separado

                    String datostab[] = new String[7];//se guardan los datos obtenidos del archivo en cada fila de la tabla
                    datostab[0] = datos[0];
                    datostab[1] = datos[1];
                    datostab[2] = datos[2];
                    datostab[3] = datos[3];
                    datostab[4] = datos[4];
                    datostab[5] = datos[5];
                                                                                
                    tab.addRow(datostab);//se añaden todas las filas a la tabla
                }
            }
        }catch(IOException ex){}
    }
    
    public void Buscar(){//filtro que permite buscar un parametro ingresado en toda la tabla
       
        String parametro = t1.getText();
        modeloOrdenado = new TableRowSorter<>(tab);
        tablafac.setRowSorter(modeloOrdenado);
        modeloOrdenado.setRowFilter(RowFilter.regexFilter(parametro));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablafac = new javax.swing.JTable();
        b3 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setBackground(new java.awt.Color(255, 153, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Facturas");
        jLabel1.setOpaque(true);

        t1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                t1CaretUpdate(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/si (1).png"))); // NOI18N
        jLabel5.setText("Buscar ");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        tablafac = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tablafac.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tablafac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablafac.setSelectionBackground(new java.awt.Color(255, 153, 0));
        jScrollPane1.setViewportView(tablafac);

        b3.setBackground(new java.awt.Color(255, 255, 255));
        b3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        b3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-deshacer-20.png"))); // NOI18N
        b3.setBorder(null);
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });

        b2.setBackground(new java.awt.Color(255, 255, 255));
        b2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        b2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/detalles (1).png"))); // NOI18N
        b2.setBorder(null);
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE))
                .addGap(15, 15, 15))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel5)))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        administracion adm = new administracion();
        adm.setVisible(true);
        dispose();
    }//GEN-LAST:event_b3ActionPerformed

    private void t1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_t1CaretUpdate
        Buscar();
    }//GEN-LAST:event_t1CaretUpdate

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        
        if(tablafac.getSelectedRow() == -1){
           JOptionPane.showMessageDialog(null, "Porfavor selecciones la factura que desea detallar");//si el cuadro de total a pagar esta vacio  
        }else{
            DetallesFacturas det = new DetallesFacturas();
            det.setVisible(true);
            det.Borrarfilasindeseadas();
        }
    }//GEN-LAST:event_b2ActionPerformed

    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(() -> {
            new Facturas().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField t1;
    public static javax.swing.JTable tablafac;
    // End of variables declaration//GEN-END:variables
}
