package MenuPrincipal;

//librerias para generar las graficas y leer el archivo csv
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Balances extends javax.swing.JFrame {

    DefaultTableModel tab;//creacion de la tabla
    
    public Balances() {
        initComponents();    
        this.setLocationRelativeTo(null);
        
        tab = new DefaultTableModel();
        // Agrega nombre a cada columna 
        tab.addColumn("N°");
        tab.addColumn("Fecha");
        tab.addColumn("Mesero");
        tab.addColumn("Cliente");
        tab.addColumn("Ingresos");
        //agreda los nombres a la tabla
        this.tablabal.setModel(tab);
        
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

                    String datostab[] = new String[5];//se guardan los datos obtenidos del archivo en cada fila de la tabla
                    datostab[0] = datos[0];
                    datostab[1] = datos[1];
                    datostab[2] = datos[2];
                    datostab[3] = datos[3];
                    datostab[4] = datos[4];
                                                      
                    tab.addRow(datostab);//se añaden todas las filas a la tabla
                }
            }
        }catch(IOException ex){} 
    }
    
    public void GraficaFactura(){
        
        XYSeries Grafica= new XYSeries("Activos");//se crea el tipo de grafica en este caso XY el nombre de la curva es activos
      
       for(int i=0;i<tablabal.getRowCount();i++){//se obtiene el numero de filas de la tabla
           
              int valorx=Integer.parseInt(String.valueOf(tablabal.getValueAt(i, 0)));//estamos guardando todos los datos de la columna 0 convertidos a entero para añadirlos a un entero llamado valorx
              int valory=Integer.parseInt(String.valueOf(tablabal.getValueAt(i, 4)));//estamos guardando todos los datos de la columna 4 convertidos a entero para añadirlos a un entero llamado valory
              Grafica.add(valorx,valory);
       }
       
            XYSeriesCollection dataset = new XYSeriesCollection();
            dataset.addSeries(Grafica);//se genera la ventana de la frafica

            JFreeChart chart = ChartFactory.createXYLineChart(
                "Facturas" ,//titulo de la grafica
                "N°",//nombre de los datos horizontales
                "Ingresos",//nombre de los datos verticales
                dataset,//grafica generada
                PlotOrientation.VERTICAL,//posicin de los datos de la grafica
                true,
                false,
                false
            );
            
            ChartFrame frame = new ChartFrame(null, chart);//ventana donde se visualiza la grafica
            frame.setVisible(false);
            frame.pack();
            frame.setLocation(0, 200);//posicion en la pantalla de la ventana
            frame.setVisible(true);
    }
    
    public void GraficaComprayVenta(){
        
        DefaultCategoryDataset datos = new DefaultCategoryDataset();//se crea la grafica en este caso es de barras
       
        for(int i=0;i<tablabal.getRowCount();i++){//se obtiene el numero de filas de la tabla
            
            String valor1=(String) (tablabal.getValueAt(i, 4));//estamos guardando todos los datos de la columna 4 en string para añadirlos a un atributo llamado valor1
            String valor2=(String) (tablabal.getValueAt(i, 2));//estamos guardando todos los datos de la columna 2 en string para añadirlos a un atributo llamado valor2
            String valor3=(String) (tablabal.getValueAt(i, 3));//estamos guardando todos los datos de la columna 3 en string para añadirlos a un atributo llamado valor3
            
            datos.setValue(Long.parseLong(valor1), valor2, valor3);//comparamos entre los datos añadidos como valor1, valor2 y valor3
        }
        JFreeChart chart = ChartFactory.createBarChart(
                "Ventas VS Compras",//titulo de la grafica
                "Clientes",//nombre de los datos horizontales 
                "Ingresos",//nombre de los datos verticales
                datos, 
                PlotOrientation.VERTICAL,//posicin de los datos de la grafica
                true, 
                false, 
                false
        );
        
        ChartFrame frame = new ChartFrame(null, chart);//ventana donde se visualiza la grafica
        frame.pack();
        frame.setLocation(0, 200);//posicion en la pantalla de la ventana
        frame.setVisible(true);

    }
    
    public void GraficaFecha(){
        
        DefaultCategoryDataset datos = new DefaultCategoryDataset();//se crea la grafica en este caso es de barras
       
        for(int i=0;i<tablabal.getRowCount();i++){//se obtiene el numero de filas de la tabla
            
            String valor1=(String) (tablabal.getValueAt(i, 4));//estamos guardando todos los datos de la columna 4 en string para añadirlos a un atributo llamado valor1
            String valor2=(String) (tablabal.getValueAt(i, 1));//estamos guardando todos los datos de la columna 1 en string para añadirlos a un atributo llamado valor2
            String valor3=(String) (tablabal.getValueAt(i, 0));//estamos guardando todos los datos de la columna 0 en string para añadirlos a un atributo llamado valor3
            
            datos.setValue(Long.parseLong(valor1), valor2, valor3);
        }
        JFreeChart chart = ChartFactory.createBarChart(
                "Fecha",//titulo de la grafica
                "Facturas",//nombre de los datos horizontales 
                "Ingresos",//nombre de los datos verticales
                datos, 
                PlotOrientation.VERTICAL,//posicin de los datos de la grafica
                true, 
                false, 
                false
        );
        
        ChartFrame frame = new ChartFrame(null, chart);//ventana donde se visualiza la grafica
        frame.pack();
        frame.setLocation(0, 200);//posicion en la pantalla de la ventana
        frame.setVisible(true);
        
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablabal = new javax.swing.JTable();
        Box = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setBackground(new java.awt.Color(255, 153, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Balances");
        jLabel1.setOpaque(true);

        b1.setBackground(new java.awt.Color(255, 255, 255));
        b1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-en-alza-25.png"))); // NOI18N
        b1.setText("Generar");
        b1.setBorder(null);
        b1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        b2.setBackground(new java.awt.Color(255, 255, 255));
        b2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-deshacer-20.png"))); // NOI18N
        b2.setText("Volver");
        b2.setBorder(null);
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        tablabal.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablabal);

        Box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Facturas", "Compras y Ventas", "Fecha" }));
        Box.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(212, 212, 212)
                            .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(15, 15, 15))
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b1)
                    .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        administracion adm = new administracion();
        adm.setVisible(true);
        dispose();
    }//GEN-LAST:event_b2ActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        switch (Box.getSelectedIndex()) {
            case 0:
                //si se selecciona el primer item del comboBox
                GraficaFactura();//se ejecuta el metodo
                break;
            case 1:
                //si se selecciona el segundo item del comboBox
                GraficaComprayVenta();//se ejecuta el metodo
                break;
            case 2:
                //si se selecciona el tercer item del comboBox
                GraficaFecha();//se ejecuta el metodo
                break;
            default:
                break;
        }
    }//GEN-LAST:event_b1ActionPerformed

    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(() -> {
            new Balances().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Box;
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablabal;
    // End of variables declaration//GEN-END:variables
}
