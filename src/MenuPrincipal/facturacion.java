package MenuPrincipal;

//librerias para la escritura del archivo csv
import Listas.Clientes;
import Listas.Inventario;
import Listas.Vendedores;
import com.csvreader.CsvWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//librerias para la creacion de la factura
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class facturacion extends javax.swing.JFrame {

    int n = 0;
    long totals = 0;
    int ID = 0 ;
    
    DefaultTableModel modelo;//se genera la tabla
    
    //datos del archivo csv facturacion
    private String Numero;
    private String Fecha;
    private String Vendedor;
    private String Cliente;
    private String TotalPago;
    private String mdp;
        
    //datos del archivo csv clientes
    private String id;
    private String Nombre;
    private String Apellido;
    private String Cedula;
    
    //datos del archivo csv vendedores
    private String iD;
    private String nombrE;
    private String apelliDO;
    private String cedulA;
    
    //datos de los articulos comprados
    private String referencia;
    private String articulo;
    private String preunit;
    private String cantidad;
    private String total;
        
    //contructor
    public facturacion(String Numero, String Fecha, String Vendedor, String Cliente, String TotalPago, String id, String Nombre, String Apellido, String Cedula, String iD, String nombrE,String apelliDO, String cedulA, String referencia, String articulo, String preunit, String cantidad, String total, String mdp) {
        this.Numero = Numero;
        this.Fecha = Fecha;
        this.Vendedor = Vendedor;
        this.Cliente = Cliente;
        this.TotalPago = TotalPago;
        this.id = id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Cedula = Cedula;
        this.iD = iD;
        this.nombrE = nombrE;
        this.cedulA = cedulA;
        this.referencia = referencia;
        this.articulo = articulo;
        this.preunit = preunit;
        this.cantidad = cantidad;
        this.total = total;
        this.mdp = mdp;
        this.apelliDO = apelliDO;
        
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getVendedor() {
        return Vendedor;
    }

    public void setVendedor(String Vendedor) {
        this.Vendedor = Vendedor;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public String getTotalPago() {
        return TotalPago;
    }

    public void setTotalPago(String TotalPago) {
        this.TotalPago = TotalPago;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getnombrE() {
        return nombrE;
    }

    public void setnombrE(String nombrE) {
        this.nombrE = nombrE;
    }

    public String getcedulA() {
        return cedulA;
    }

    public void setcedulA(String cedulA) {
        this.cedulA = cedulA;
    }

    public String getreferencia() {
        return referencia;
    }

    public void setreferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getarticulo() {
        return articulo;
    }

    public void setarticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getpreunit() {
        return preunit;
    }

    public void setpreunit(String preunit) {
        this.preunit = preunit;
    }

    public String getcantidad() {
        return cantidad;
    }

    public void setcantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String gettotal() {
        return total;
    }

    public void settotal(String total) {
        this.total = total;
    }

    public String getmdp() {
        return mdp;
    }

    public void setmdp(String mdp) {
        this.mdp = mdp;
    }

    public String getapelliDO() {
        return apelliDO;
    }

    public void setapelliDO(String deuda) {
        this.apelliDO = apelliDO;
    }
    
    public facturacion() {
        initComponents();
                
        this.setLocationRelativeTo(null);
                      
        modelo = new DefaultTableModel();
        // Agrega nombre a cada columna 
        modelo.addColumn("Referencia");
        modelo.addColumn("Articulo");
        modelo.addColumn("Precio Unitario");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Total");
        //agreda los nombres a la tabla
        tabla.setModel(modelo);
        
        //Para metodo leer la fecha de computador y colocarlo el cuadro de fecha
        fecha_actual();
        //escribe dentro de los cuadros de texto lo que esta dentro de los metodos
        t1.setText(String.valueOf(id_cliente_auto()));
        t2.setText(String.valueOf(id_factura_auto())); 
        t14.setText(String.valueOf(id_Vendedor_auto()));
        t2.setBackground(new java.awt.Color(0,0,0,1));
        t3.setBackground(new java.awt.Color(0,0,0,1));
    }

    public void fecha_actual(){//para capturar la fecha de la pc
        Date fechaActual = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");//formato en que queremos escribir la fecha
        String fecha = formateador.format(fechaActual);
        t3.setText(fecha);
    }
    
    public int id_cliente_auto(){
        
        //recorrer la base de datos de los clientes y escoge el valor entero mas alto guardado en la columna ID y le suma 1 para poner ese resultado en el cuadro de texto t1
        int id_max1 = 1;
        
        //lee el archivo csv e ingresa los datos en columnas de la tabla
        String linea="";
        String datos[];
        
        File listacli = new File("C:\\Users\\Asus\\Desktop\\DUVAN\\OTROS\\SOFTWAREADM\\Clientes.csv");//direccion donde se encuenta el archivo csv
        FileReader Lector;

        try{

            Lector = new FileReader(listacli);
            BufferedReader buffer = new BufferedReader(Lector);
            while(buffer.ready()){
                if(!(linea = buffer.readLine()).equals("/000")){//la fila se leer mientras no halla en ella una celda vacia de ser asi saltara a la siguiente fila
                    System.out.println(linea);
            
                    datos = linea.split(";");//separa cada dato con un ; para obtener cada columna por separado
                    ID = Integer.parseInt(datos[0]);
                    id_max1 = 1 + ID;//al numero entero de mayor valor dentro de la columna 0 le sumara un 1
                }
            }
        }catch(IOException | NumberFormatException ex){}
        
        return id_max1;//retorna el ID automatic del nuevo cliente
    }
    
    public int id_Vendedor_auto(){
        
        //recorrer la base de datos de los vendedor y escoge el valor entero mas alto guardado en la columna ID y le suma 1 para poner ese resultado en el cuadro de texto t1
        int id_max2 = 1;
        
        String linea="";
        String datos[];
        
        File listaven = new File("C:\\Users\\Asus\\Desktop\\DUVAN\\OTROS\\SOFTWAREADM\\Meseros.csv");//direccion donde se encuenta el archivo csv
        FileReader Lector;

        try{

            Lector = new FileReader(listaven);
            BufferedReader buffer = new BufferedReader(Lector);
            while(buffer.ready()){
                if(!(linea = buffer.readLine()).equals("/000")){//la fila se leer mientras no halla en ella una celda vacia de ser asi saltara a la siguiente fila
                    System.out.println(linea);
            
                    datos = linea.split(";");//separa cada dato con un ; para obtener cada columna por separado
                    ID = Integer.parseInt(datos[0]);
                    id_max2 = 1 + ID;//al numero entero de mayor valor dentro de la columna 0 le sumara un 1
                }
            }
        }catch(IOException | NumberFormatException ex){}
        
        return id_max2;//retorna el Id automatico del nuevo vendedor
    }
    
    public int id_factura_auto(){
        
        //recorrer la base de datos de los clientes y escoge el valor entero mas alto guardado en la columna ID y le suma 1 para poner ese resultado en el cuadro de texto t1
        int id_max3 = 1;
        
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
                    ID = Integer.parseInt(datos[0]);
                    id_max3 = 1 + ID;//al numero entero de mayor valor dentro de la columna 0 le sumara un 1
                }
            }
        }catch(IOException | NumberFormatException ex){}
        
        return id_max3;//retorna el nuevo numero de factura automatico
    }
   
    public static void ExportarCSV(List<facturacion> facturas) {
       
        String salidaArchivo = "Facturacion.csv"; // Nombre del archivo donde se reescribiran los datos
                                
        try {
            // Crea el archivo
            CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ';');
           
            // Recorremos la lista creada y escibimos en ella los datos guardados en cada atributo
            for(facturacion fac : facturas) {
                salidaCSV.write(fac.getNumero());
                salidaCSV.write(fac.getFecha());
                salidaCSV.write(fac.getVendedor());
                salidaCSV.write(fac.getCliente());
                salidaCSV.write(fac.getTotalPago());
                salidaCSV.write(fac.getmdp());//efectivo o consignacion

                //escribe los articulos comprados
                salidaCSV.write(fac.getreferencia());
                salidaCSV.write(fac.getarticulo());
                salidaCSV.write(fac.getpreunit());
                salidaCSV.write(fac.getcantidad());
                salidaCSV.write(fac.gettotal());
            }
            salidaCSV.endRecord(); // Deja de escribir en el archivo
            salidaCSV.close(); // Cierra el archivo
        } catch(IOException ex) {}
    }
    
    public static void ExportarCSV_CLientes(List<facturacion> Clientes){
                
        String salidaArchivo = "Clientes.csv"; // Nombre del archivo
               
        try {
            // Crea el archivo
            CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ';');
            
            // Recorremos la lista y escribimos en ella los datos guardados en cada atributo
            for(facturacion fac : Clientes) {
                salidaCSV.write(fac.getid());
                salidaCSV.write(fac.getNombre());
                salidaCSV.write(fac.getApellido());
                salidaCSV.write(fac.getCedula());
                salidaCSV.endRecord(); // Deja de escribir en el archivo
            }
            salidaCSV.close(); // Cierra el archivo
        } catch(IOException ex) {}

    }
    
    public static void ExportarCSV_Vendedores(List<facturacion> Vendedores){
                
        String salidaArchivo = "Meseros.csv"; // Nombre del archivo
               
        try {
            // Crea el archivo
            CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ';');
            
            // Recorremos la lista y escribimos en ella los datos guardados en cada atributo
            for(facturacion fac : Vendedores) {
                salidaCSV.write(fac.getiD());
                salidaCSV.write(fac.getnombrE());
                salidaCSV.write(fac.getapelliDO());
                salidaCSV.write(fac.getcedulA());
                salidaCSV.endRecord(); // Deja de escribir en el archivo
            }
            salidaCSV.close(); // Cierra el archivo
        } catch(IOException ex) {}

    }
    
    public void GenerarPDf() throws FileNotFoundException, DocumentException {
                
        if(!(t2.getText().isEmpty() || t1.getText().isEmpty() || t14.getText().isEmpty() || tabla.getRowCount()==0)){
            
            FileOutputStream archivo = new FileOutputStream("C:\\Users\\Asus\\Desktop\\DUVAN\\OTROS\\SOFTWAREADM\\FacturasPDF" + t2.getText() +".pdf");
            Document documento = new Document();
            PdfWriter.getInstance(documento, archivo);
            documento.open();
            
            //texto del documento
            Paragraph parrafo = new Paragraph("Factura" + " " + t2.getText());
            parrafo.setAlignment(1);
            documento.add(parrafo);
            
            //texto proporcionado en la factura
            documento.add(new Paragraph("Cliente:" + " " + t4.getText() + " " + t5.getText()));
            documento.add(new Paragraph("Mesero:" + " " + t7.getText()));
            documento.add(new Paragraph("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°"));
            documento.add(new Paragraph("Platos:"));
            
            for (int row = 0; row < tabla.getRowCount(); row++) {
                documento.add(new Paragraph((String) tabla.getValueAt(row, 1) + " " + (String) tabla.getValueAt(row, 4)));
            }  
            documento.close();
        }
    }
    
    public void AbrirPDF(){
        try{
            File path = new File("C:\\Users\\Asus\\Desktop\\DUVAN\\OTROS\\SOFTWAREADM\\FacturasPDF" + t2.getText() + ".pdf"); 
            Desktop.getDesktop().open(path);
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, ex, "Atencion",2);
        }
    }
    
    public void Limpiar(){//borra todo lo ingresado en los cuadros de texto y la tabla, a demas agraga los numeros automaticos generados en los metodos
        t1.setText(String.valueOf(id_cliente_auto()));
        t2.setText(String.valueOf(id_factura_auto())); 
        fecha_actual();
        t4.setText("");
        t5.setText("");
        t6.setText("");
        t7.setText("");
        t8.setText("");
        t9.setText("");
        t10.setText("");
        t11.setText("");
        t12.setText("");
        t13.setText("");
        t14.setText(String.valueOf(id_Vendedor_auto()));
        t15.setText("");
        t20.setText("");
        
        for (int i=0; i <=tabla.getRowCount(); i++) {
            modelo.removeRow(i);
        }    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        t1 = new javax.swing.JTextField();
        t4 = new javax.swing.JTextField();
        t6 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        b1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        t5 = new javax.swing.JTextField();
        b8 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        t7 = new javax.swing.JTextField();
        b2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        t14 = new javax.swing.JTextField();
        t15 = new javax.swing.JTextField();
        b9 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        t20 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        t8 = new javax.swing.JTextField();
        t9 = new javax.swing.JTextField();
        t10 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        t12 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        b3 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        t11 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        b7 = new javax.swing.JButton();
        b6 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();
        t13 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        t2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        t3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rb1 = new javax.swing.JRadioButton();
        rb2 = new javax.swing.JRadioButton();
        jLabel19 = new javax.swing.JLabel();
        t21 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setRequestFocusEnabled(false);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Informacion", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI Semibold", 1, 12))); // NOI18N
        jPanel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cliente", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI Semibold", 1, 12))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N

        t1.setEditable(false);
        t1.setBackground(new java.awt.Color(255, 255, 255));
        t1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 10)); // NOI18N
        t1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        t1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        t1.setMinimumSize(new java.awt.Dimension(10, 40));
        t1.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        t1.setSelectionColor(new java.awt.Color(255, 153, 0));
        t1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t14ActionPerformed(evt);
            }
        });

        t4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 10)); // NOI18N
        t4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        t4.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        t4.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        t4.setSelectionColor(new java.awt.Color(255, 153, 0));
        t4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t14ActionPerformed(evt);
            }
        });

        t6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 10)); // NOI18N
        t6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        t6.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        t6.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        t6.setSelectionColor(new java.awt.Color(255, 153, 0));
        t6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t14ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 10)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 10)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Apellido");

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 10)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("ID");

        b1.setBackground(new java.awt.Color(255, 255, 255));
        b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registro.png"))); // NOI18N
        b1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        b1.setBorderPainted(false);
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 10)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Cedula");

        t5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 10)); // NOI18N
        t5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        t5.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        t5.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        t5.setSelectionColor(new java.awt.Color(255, 153, 0));

        b8.setBackground(new java.awt.Color(255, 255, 255));
        b8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/refresh.png"))); // NOI18N
        b8.setToolTipText("");
        b8.setBorder(null);
        b8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        b8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t4)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(t5, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addGap(15, 15, 15)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(t6, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(b1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Mesero", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI Semibold", 1, 12))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 10)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Nombre");

        t7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 10)); // NOI18N
        t7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t7.setActionCommand("<Not Set>");
        t7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        t7.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        t7.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        t7.setSelectionColor(new java.awt.Color(255, 153, 0));
        t7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t14ActionPerformed(evt);
            }
        });

        b2.setBackground(new java.awt.Color(255, 255, 255));
        b2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registro.png"))); // NOI18N
        b2.setBorderPainted(false);
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 10)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cedula");

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 10)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("ID");

        t14.setEditable(false);
        t14.setBackground(new java.awt.Color(255, 255, 255));
        t14.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 10)); // NOI18N
        t14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        t14.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        t14.setSelectionColor(new java.awt.Color(255, 153, 0));

        t15.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 10)); // NOI18N
        t15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        t15.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        t15.setSelectionColor(new java.awt.Color(255, 153, 0));
        t15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t14ActionPerformed(evt);
            }
        });

        b9.setBackground(new java.awt.Color(255, 255, 255));
        b9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/refresh.png"))); // NOI18N
        b9.setToolTipText("");
        b9.setBorder(null);
        b9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        b9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b9ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 10)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Apellido");

        t20.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 10)); // NOI18N
        t20.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t20.setActionCommand("<Not Set>");
        t20.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        t20.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        t20.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        t20.setSelectionColor(new java.awt.Color(255, 153, 0));
        t20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t20t14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(t14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(t7, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t20, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(t15, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))))
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(t14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(b9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Menú", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 10)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Referencia");

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 10)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Plato");

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 10)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Valor");

        t8.setEditable(false);
        t8.setBackground(new java.awt.Color(255, 255, 255));
        t8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        t8.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        t8.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        t8.setSelectionColor(new java.awt.Color(255, 153, 0));
        t8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t14ActionPerformed(evt);
            }
        });

        t9.setEditable(false);
        t9.setBackground(new java.awt.Color(255, 255, 255));
        t9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        t9.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        t9.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        t9.setSelectionColor(new java.awt.Color(255, 153, 0));
        t9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t14ActionPerformed(evt);
            }
        });

        t10.setEditable(false);
        t10.setBackground(new java.awt.Color(255, 255, 255));
        t10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        t10.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        t10.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        t10.setSelectionColor(new java.awt.Color(255, 153, 0));
        t10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t14ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 10)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Cantidad");

        t12.setEditable(false);
        t12.setBackground(new java.awt.Color(255, 255, 255));
        t12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        t12.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        t12.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        t12.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        t12.setSelectionColor(new java.awt.Color(255, 153, 0));
        t12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t14ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("$");

        b3.setBackground(new java.awt.Color(255, 255, 255));
        b3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registro.png"))); // NOI18N
        b3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        b3.setBorderPainted(false);
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });

        b4.setBackground(new java.awt.Color(255, 255, 255));
        b4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-añadir-lista-25.png"))); // NOI18N
        b4.setBorderPainted(false);
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });

        t11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        t11.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        t11.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        t11.setSelectionColor(new java.awt.Color(255, 153, 0));
        t11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t14ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 10)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Total");
        jLabel15.setToolTipText("");

        jLabel20.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("$");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(t8)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(t9))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(t10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(t12)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(t8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(t9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(t12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(t11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(t10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jScrollPane2.setBackground(new java.awt.Color(0, 102, 0));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Detalles", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI Semibold", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        tabla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabla = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tabla.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 10)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla.setAutoscrolls(false);
        tabla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabla.setDragEnabled(true);
        tabla.setGridColor(new java.awt.Color(0, 0, 0));
        tabla.setSelectionBackground(new java.awt.Color(255, 153, 0));
        tabla.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tabla);

        jScrollPane2.setViewportView(jScrollPane1);

        b7.setBackground(new java.awt.Color(255, 255, 255));
        b7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-deshacer-20.png"))); // NOI18N
        b7.setBorder(null);
        b7.setOpaque(false);
        b7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b7ActionPerformed(evt);
            }
        });

        b6.setBackground(new java.awt.Color(255, 255, 255));
        b6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        b6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-checkout-25.png"))); // NOI18N
        b6.setText("Generar ");
        b6.setBorder(null);
        b6.setBorderPainted(false);
        b6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b6ActionPerformed(evt);
            }
        });

        b5.setBackground(new java.awt.Color(255, 255, 255));
        b5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        b5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-eliminar-20.png"))); // NOI18N
        b5.setText("Eliminar Articulo");
        b5.setBorder(null);
        b5.setBorderPainted(false);
        b5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b5ActionPerformed(evt);
            }
        });

        t13.setEditable(false);
        t13.setBackground(new java.awt.Color(255, 255, 255));
        t13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        t13.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        t13.setSelectionColor(new java.awt.Color(255, 153, 0));
        t13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t14ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Total a Pagar   $");

        jPanel6.setBackground(new java.awt.Color(0, 102, 0));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Facturacion");

        t2.setEditable(false);
        t2.setBackground(new java.awt.Color(255, 255, 255));
        t2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        t2.setForeground(new java.awt.Color(255, 255, 255));
        t2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t2.setActionCommand("<Not Set>");
        t2.setBorder(null);
        t2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        t2.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        t2.setSelectionColor(new java.awt.Color(255, 153, 0));
        t2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t14ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("N°");

        t3.setEditable(false);
        t3.setBackground(new java.awt.Color(255, 255, 255));
        t3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        t3.setForeground(new java.awt.Color(255, 255, 255));
        t3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t3.setActionCommand("<Not Set>");
        t3.setBorder(null);
        t3.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        t3.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        t3.setSelectionColor(new java.awt.Color(255, 153, 0));
        t3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t14ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Fecha");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(t3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(t3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        rb1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rb1);
        rb1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/dinero.png"))); // NOI18N
        rb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb1ActionPerformed(evt);
            }
        });

        rb2.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rb2);
        rb2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tarjeta-de-debito.png"))); // NOI18N
        rb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb2ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("¿Metodo de pago?");

        t21.setEditable(false);
        t21.setBackground(new java.awt.Color(255, 255, 255));
        t21.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t21.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        t21.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        t21.setSelectionColor(new java.awt.Color(255, 153, 0));
        t21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t21t14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(b5)
                                .addGap(64, 64, 64)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(t13, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(63, 63, 63)
                                .addComponent(rb1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(t21)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rb2)
                                .addGap(64, 64, 64)
                                .addComponent(b6)
                                .addGap(39, 39, 39)
                                .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rb2)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(t13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(t21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(rb1))))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b6ActionPerformed
        
        if(t13.getText().equals("") || t13.getText().equals("0") || t21.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Posibles fallas:" + "\n" + "1. No dilingencio toda la informacion de la factura" + "\n" + "2. No selecciono un metodo de pago (Efectivo - Consignacion)" ); 
        }else{
            
            //se capturan los datos ingresados del cliente, vendedor y dineros para guardarlos en los atributos creados
            Numero=t2.getText();
            Fecha=t3.getText();
            Vendedor=t7.getText();
            Cliente=t4.getText();
            TotalPago=t13.getText();
            mdp=t21.getText();
            //se crean los arreglo donde se guararan los datos del menú
            ArrayList ref = new ArrayList();
            ArrayList art = new ArrayList();
            ArrayList pnt = new ArrayList();
            ArrayList can = new ArrayList();
            ArrayList tot = new ArrayList();
        
            for (int i = 0; i < tabla.getRowCount(); i++) {
                //captura de todos los datos de cada columna en un arreglo y se elimina de el los corchetes
                ref.add(tabla.getValueAt(i, 0));
                String aux1 = String.valueOf(ref).replace("[", "");
                referencia = aux1.replace("]", "");
                
                art.add(tabla.getValueAt(i, 1));
                String aux2 = String.valueOf(art).replace("[", "");
                articulo = aux2.replace("]", "");
                
                pnt.add(tabla.getValueAt(i, 2));
                String aux3 = String.valueOf(pnt).replace("[", "");
                preunit = aux3.replace("]", "");
                
                can.add(tabla.getValueAt(i, 3));
                String aux4 = String.valueOf(can).replace("[", "");
                cantidad = aux4.replace("]", "");
                
                tot.add(tabla.getValueAt(i, 4));
                String aux5 = String.valueOf(tot).replace("[", "");
                total = aux5.replace("]", "");
                
            }                      
            
            //se agregan las variables a la lista facturas para enviar los datos al archivo Facturacion.csv
            List<facturacion> facturas = new ArrayList<>();
            facturas.add(new facturacion(Numero,Fecha,Vendedor,Cliente,TotalPago,id,Nombre,Apellido,Cedula,iD,nombrE,apelliDO,cedulA,referencia,articulo,preunit,cantidad,total,mdp));
            ExportarCSV(facturas);
            
            if(Integer.parseInt(t1.getText())==id_cliente_auto()){//si el ID del cliente es el mismo al generado automaticamente quiere decir que es un cliente nuevo y se guarda en la base de datos
                //se capturan los datos ingresados del cliente en el caso que sea un cliente nuevo que no esta registrado en la base de datos
                id=t1.getText();
                Nombre=t4.getText();
                Apellido=t5.getText();
                Cedula=t6.getText();
                                
                //se agregan las variables a la lista Clientes para enviar los datos al archivo Clientes.csv
                List<facturacion> Clientes = new ArrayList<>();
                Clientes.add(new facturacion(Numero,Fecha,Vendedor,Cliente,TotalPago,id,Nombre,Apellido,Cedula,iD,nombrE,apelliDO,cedulA,referencia,articulo,preunit,cantidad,total,mdp));
                ExportarCSV_CLientes(Clientes);
            }
            
            if(Integer.parseInt(t14.getText())==id_Vendedor_auto()){//si el ID del mesero es el mismo al generado automaticamente quiere decir que es un vendedor nuevo y se guarda en la base de datos
                //se capturan los datos ingresados del vendedor en el caso que sea un vendedor nuevo que no esta registrado en la base de datos
                iD=t14.getText();
                nombrE=t7.getText();
                apelliDO=t20.getText();
                cedulA=t15.getText();
                
                //se agregan las variables a la lista Clientes para enviar los datos al archivo Clientes csv
                List<facturacion> Vendedores = new ArrayList<>();
                Vendedores.add(new facturacion(Numero,Fecha,Vendedor,Cliente,TotalPago,id,Nombre,Apellido,Cedula,iD,nombrE,apelliDO,cedulA,referencia,articulo,preunit,cantidad,total,mdp));
                ExportarCSV_Vendedores(Vendedores);
            }
                  
            try {
                GenerarPDf();
            } catch (FileNotFoundException | DocumentException ex) {
                Logger.getLogger(facturacion.class.getName()).log(Level.SEVERE, null, ex);
            }
            AbrirPDF();
            Limpiar();
            JOptionPane.showMessageDialog(null, "Factura guardada exitosamente");
        }
    }//GEN-LAST:event_b6ActionPerformed

    private void b7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b7ActionPerformed
        administracion adm = new administracion();
        adm.setVisible(true);
        dispose();
    }//GEN-LAST:event_b7ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed

        if (t8.getText().equals("") || t9.getText().equals("") || t10.getText().equals("") || t11.getText().equals("")) {//no se agrega el articulo si no tiene toda su informacion escrita en los cuadros de texto
            JOptionPane.showMessageDialog(null, "Porfavor ingrese todos los datos del menú");
        } else {

            long a = Long.valueOf(t10.getText());
            int b = Integer.parseInt(t11.getText());
            // Calcular el total de cada articulo
            long ttotal = a * b;
            t12.setText(String.valueOf(ttotal));

            //Agregar datos a la tabla
            String datos[] = new String[5];
            datos[0] = t8.getText();
            datos[1] = t9.getText();
            datos[2] = t10.getText();
            datos[3] = t11.getText();
            datos[4] = t12.getText();
            
            modelo.addRow(datos);//se añaden las filas a la tabla
            totals = totals + ttotal;//calculo del total de la factura
            t13.setText(String.valueOf(totals));//se pasa el valor a un cuadro de texto
            //cada que se agregra un nuevo articulo se limpian los cuadros de texto
            t8.setText("");
            t9.setText("");
            t10.setText("");
            t11.setText("");
        }
    }//GEN-LAST:event_b4ActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        Inventario inv = new Inventario();
        inv.setVisible(true);
    }//GEN-LAST:event_b3ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        Vendedores ven = new Vendedores();
        ven.setVisible(true);
    }//GEN-LAST:event_b2ActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        Clientes cli = new Clientes();
        cli.setVisible(true);
    }//GEN-LAST:event_b1ActionPerformed

    private void b5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b5ActionPerformed

        int i = tabla.getSelectedRow();
        if (i == -1) {//si no se selecciona nada
            JOptionPane.showMessageDialog(null, "Porfavor seleccione el articulo que desea eliminar de la factura");
        } else//si selecciona una fila
        {
            // coje el valor total por articulo que elimino y lo resta al total a pagar de la factura
            String nums = (String) tabla.getValueAt(i, 4);
            int entero = Integer.parseInt(nums);

            totals = totals - entero;
            t13.setText(String.valueOf(totals));

            // eliminar fila
            this.modelo.removeRow(i);
            // restar un aticulo
            n = n - 1;
            // poner nuevo ciclo
            int num = 1;
            for (int w = 0; w < n; w = w + 1) {
                //agregado de nuevo
                tabla.setValueAt(num, w, 0);
                num = num + 1;
            }
        }

    }//GEN-LAST:event_b5ActionPerformed

    private void t14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t14ActionPerformed

    private void b8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b8ActionPerformed
        t1.setText(String.valueOf(id_cliente_auto()));
        t4.setText("");
        t5.setText("");
        t6.setText("");
    }//GEN-LAST:event_b8ActionPerformed

    private void b9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b9ActionPerformed
        t14.setText(String.valueOf(id_Vendedor_auto()));
        t7.setText("");
        t15.setText("");
        t20.setText("");        
    }//GEN-LAST:event_b9ActionPerformed

    private void t20t14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t20t14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t20t14ActionPerformed

    private void rb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb1ActionPerformed
        if (rb1.isSelected()) {
            t21.setText("Efectivo");
        }
    }//GEN-LAST:event_rb1ActionPerformed

    private void rb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb2ActionPerformed
        if (rb2.isSelected()) {
            t21.setText("Consignacion");
        }
    }//GEN-LAST:event_rb2ActionPerformed

    private void t21t14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t21t14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t21t14ActionPerformed
    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(() -> {
            new facturacion().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JButton b5;
    private javax.swing.JButton b6;
    private javax.swing.JButton b7;
    private javax.swing.JButton b8;
    private javax.swing.JButton b9;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rb1;
    private javax.swing.JRadioButton rb2;
    public static javax.swing.JTextField t1;
    public static javax.swing.JTextField t10;
    private javax.swing.JTextField t11;
    private javax.swing.JTextField t12;
    private javax.swing.JTextField t13;
    public static javax.swing.JTextField t14;
    public static javax.swing.JTextField t15;
    private javax.swing.JTextField t2;
    public static javax.swing.JTextField t20;
    private javax.swing.JTextField t21;
    private javax.swing.JTextField t3;
    public static javax.swing.JTextField t4;
    public static javax.swing.JTextField t5;
    public static javax.swing.JTextField t6;
    public static javax.swing.JTextField t7;
    public static javax.swing.JTextField t8;
    public static javax.swing.JTextField t9;
    public static javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
