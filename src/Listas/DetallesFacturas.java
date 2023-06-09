package Listas;

import static Listas.Facturas.tablafac;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;

public class DetallesFacturas extends javax.swing.JFrame {

    static DefaultTableModel modelo;//se genera la tabla
    static DefaultTableModel modelo2;//se genera la tabla
    
    public DetallesFacturas() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        modelo = new DefaultTableModel();
        modelo2 = new DefaultTableModel();
        // Agrega nombre a cada columna 
        modelo.addColumn("Referencia");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio Unitario");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Total");
        
        //agreda los nombres a la tabla
        tabladet.setModel(modelo);
        
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

                    String datostabdet[] = new String[6];//se guardan los datos obtenidos del archivo en cada fila de la tabla
                    datostabdet[0] = datos[6];
                    datostabdet[1] = datos[7];
                    datostabdet[2] = datos[8];
                    datostabdet[3] = datos[9];
                    datostabdet[4] = datos[10];
                                                                 
                    modelo.addRow(datostabdet);//se añaden todas las filas a la tabla
                    
                }
            }
        }catch(IOException ex){}
    }
    
    public void Borrarfilasindeseadas(){
        
        int n = tablafac.getSelectedRow();
        
        String ref = (String) tabladet.getValueAt(n, 0);
        String [] vect1 = ref.split(", ");
        
        String art = (String) tabladet.getValueAt(n, 1);
        String [] vect2 = art.split(", ");
        
        String pru = (String) tabladet.getValueAt(n, 2);
        String [] vect3 = pru.split(", ");
        
        String can = (String) tabladet.getValueAt(n, 3);
        String [] vect4 = can.split(", ");
        
        String tot = (String) tabladet.getValueAt(n, 4);
        String [] vect5 = tot.split(", ");
                
        modelo2.addColumn("Referencia", vect1);
        modelo2.addColumn("Nombre", vect2);
        modelo2.addColumn("Precio Unitario", vect3);
        modelo2.addColumn("Cantidad", vect4);
        modelo2.addColumn("Total", vect5);
        
        this.tabladet.setModel(modelo2); 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabladet = new javax.swing.JTable();
        b3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setBackground(new java.awt.Color(255, 153, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Detalles");
        jLabel1.setOpaque(true);

        tabladet = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tabladet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabladet.setModel(new javax.swing.table.DefaultTableModel(
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
        tabladet.setSelectionBackground(new java.awt.Color(255, 153, 0));
        jScrollPane1.setViewportView(tabladet);

        b3.setBackground(new java.awt.Color(255, 255, 255));
        b3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        b3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-deshacer-20.png"))); // NOI18N
        b3.setBorder(null);
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        dispose();
    }//GEN-LAST:event_b3ActionPerformed

    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(() -> {
            new DetallesFacturas().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabladet;
    // End of variables declaration//GEN-END:variables
}
