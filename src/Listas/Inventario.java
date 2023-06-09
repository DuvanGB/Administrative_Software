package Listas;

//librerias para la lectura del archivo csv
import MenuPrincipal.facturacion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Inventario extends javax.swing.JFrame {

    DefaultTableModel tab;//creacion de la tabla
    private TableRowSorter<TableModel> modeloOrdenado;//creacion de la nueva tabla que filtra el parametro a buscar
    
    public Inventario() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        tab = new DefaultTableModel();
        // Agrega nombre a cada columna 
        tab.addColumn("Referencia");
        tab.addColumn("Nombre");
        tab.addColumn("Precio");
        //agreda los nombres a la tabla
        this.tablainv.setModel(tab);
        
        //lee el archivo csv e ingresa los datos en columnas de la tabla
        String linea="";
        String datos[];
 
        File listaven = new File("C:\\Users\\Asus\\Desktop\\DUVAN\\OTROS\\SOFTWAREADM\\Menú.csv");//direccion donde se encuenta el archivo csv
        FileReader Lector;

        try{

            Lector = new FileReader(listaven);
            BufferedReader buffer = new BufferedReader(Lector);
            while(buffer.ready()){
                if(!(linea = buffer.readLine()).equals("/000")){//la fila se leer mientras no halla en ella una celda vacia de ser asi saltara a la siguiente fila
                    System.out.println(linea);
                    datos = linea.split(";");//separa cada dato con un ; para obtener cada columna por separado

                    String datostab[] = new String[3];//se guardan los datos obtenidos del archivo en cada fila de la tabla
                    datostab[0] = datos[0].toString();
                    datostab[1] = datos[1].toString();
                    datostab[2] = datos[2].toString();
                    tab.addRow(datostab);//se añaden todas las filas a la tabla
                }
            }
        }catch(Exception ex){}
    }

    public void Buscar(){//filtro que permite buscar un parametro ingresado en toda la tabla
       
        String parametro = t1.getText();
        modeloOrdenado = new TableRowSorter<TableModel>(tab);
        tablainv.setRowSorter(modeloOrdenado);
        modeloOrdenado.setRowFilter(RowFilter.regexFilter(parametro));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablainv = new javax.swing.JTable();
        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setBackground(new java.awt.Color(255, 153, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Inventario");
        jLabel1.setOpaque(true);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/si (1).png"))); // NOI18N
        jLabel5.setText("Buscar ");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        t1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        t1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t1.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        t1.setSelectionColor(new java.awt.Color(255, 153, 0));
        t1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                t1CaretUpdate(evt);
            }
        });

        tablainv = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tablainv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tablainv.setModel(new javax.swing.table.DefaultTableModel(
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
        tablainv.setSelectionBackground(new java.awt.Color(255, 153, 0));
        jScrollPane1.setViewportView(tablainv);

        b1.setBackground(new java.awt.Color(255, 255, 255));
        b1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-añadir-lista-25.png"))); // NOI18N
        b1.setBorder(null);
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        b2.setBackground(new java.awt.Color(255, 255, 255));
        b2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        b2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-deshacer-20.png"))); // NOI18N
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
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        
        int i = tablainv.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(null, "Porfavor seleccione una fila");
        } else//si se selecciono una fila 
        {
            //obtiene el dato de la tabla para enviarlo a un cuadro de texto en facturacion
            
            facturacion.t8.setText(String.valueOf(tablainv.getValueAt(i,0)));  
            facturacion.t9.setText(String.valueOf(tablainv.getValueAt(i,1)));  
            facturacion.t10.setText(String.valueOf(tablainv.getValueAt(i,2)));
        }
        
        dispose();
    }//GEN-LAST:event_b1ActionPerformed

    private void t1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_t1CaretUpdate
        Buscar();         
    }//GEN-LAST:event_t1CaretUpdate

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        dispose();
    }//GEN-LAST:event_b2ActionPerformed

    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField t1;
    private javax.swing.JTable tablainv;
    // End of variables declaration//GEN-END:variables
}
