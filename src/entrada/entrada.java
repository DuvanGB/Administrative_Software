package entrada;

import MenuPrincipal.administracion;
import java.awt.*;
import javax.swing.*;

public class entrada extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();
    
    private Component confirmation;
    private String usuario,contraseña;
    
    public entrada() {
        
        this.setContentPane(fondo);
        initComponents();
        setLocationRelativeTo(null);
        t2.setBackground(new java.awt.Color(0,0,0,1));
        t3.setBackground(new java.awt.Color(0,0,0,1));
        txt1.setBackground(new java.awt.Color(0,0,0,1));
        txt2.setBackground(new java.awt.Color(0,0,0,1));
    }

    public void datos(String us, String con){
     usuario = "1"; 
     contraseña = "1";
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new FondoPanel();
        t2 = new javax.swing.JTextField();
        txt2 = new javax.swing.JLabel();
        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        t3 = new javax.swing.JPasswordField();
        txt1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        t2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        t2.setForeground(new java.awt.Color(255, 255, 255));
        t2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t2.setBorder(null);

        txt2.setBackground(new java.awt.Color(255, 255, 255));
        txt2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-orientación-de-bloqueo-40.png"))); // NOI18N
        txt2.setOpaque(true);

        b1.setBackground(new java.awt.Color(255, 255, 255));
        b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iniciar-sesion.png"))); // NOI18N
        b1.setBorder(null);
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        b2.setBackground(new java.awt.Color(255, 255, 255));
        b2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrar-sesion.png"))); // NOI18N
        b2.setBorder(null);
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        t3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        t3.setForeground(new java.awt.Color(255, 255, 255));
        t3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t3.setBorder(null);
        t3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t3ActionPerformed(evt);
            }
        });

        txt1.setBackground(new java.awt.Color(255, 255, 255));
        txt1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-cambiar-usuario-masculino-40.png"))); // NOI18N
        txt1.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(b2)
                        .addGap(201, 201, 201)
                        .addComponent(b1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt1)
                            .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(t2, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(t3))
                        .addGap(39, 39, 39)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(157, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(t3)
                    .addComponent(txt2))
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(b2)
                    .addComponent(b1))
                .addGap(120, 120, 120))
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
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        dispose();
    }//GEN-LAST:event_b2ActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        
    datos(usuario, contraseña);
    if(usuario.equals(t2.getText()) && contraseña.equals(t3.getText())){
         administracion adm = new administracion();
         adm.setVisible(true);
         this.dispose();
    }else if(t2.getText().equals("") && t3.getText().equals("")){
        JOptionPane.showMessageDialog(this,"Usuario y Contraseña estan vacios\nIngreselos por favor.");
        t2.setFocusable(true);
    }else if(t2.getText().equals("")){
        JOptionPane.showMessageDialog(this,"Usuario está vacio\nIngreselo por favor.");
        t2.setFocusable(true);
    }else if(t3.getText().equals("")){
        JOptionPane.showMessageDialog(this,"Contraseña está vacio\nIngreselo por favor.");
        t3.setFocusable(true);
    }
    else if(t2.getText().compareTo(usuario)!=0 && t3.getText().compareTo(contraseña)!=0){
        JOptionPane.showMessageDialog(this,"Usuario y Contraseña no válidos\nIngrese nuevamente.");
         t2.setFocusable(true);
    }
    else if(t2.getText().compareTo(usuario)!=0){
        JOptionPane.showMessageDialog(this,"Usuario no válido\nIngrese nuevamente.");
        t2.setFocusable(true);
    }else if(t3.getText().compareTo(contraseña)!=0){
        JOptionPane.showMessageDialog(this,"Contraseña no válida\nIngrese nuevamente.");
        t3.setFocusable(true);
    }
    }//GEN-LAST:event_b1ActionPerformed

    private void t3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t3ActionPerformed

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
            java.util.logging.Logger.getLogger(entrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(entrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(entrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(entrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new entrada().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField t2;
    private javax.swing.JPasswordField t3;
    private javax.swing.JLabel txt1;
    private javax.swing.JLabel txt2;
    // End of variables declaration//GEN-END:variables

    class FondoPanel extends JPanel{
        private Image imagen;
        @Override
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("/Imagenes/1.jpg")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }
}
