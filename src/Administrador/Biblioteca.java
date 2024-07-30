/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Administrador;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Biblioteca extends javax.swing.JFrame {

    public static final String url = "jdbc:mysql://localhost:3306/biblioteca";
    public static final String user = "root";
    public static final String password = "admin";
    
    DefaultTableModel modelo;
    
    public Biblioteca() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Titulo");
        modelo.addColumn("Artista");
        modelo.addColumn("Genero");
        
        mostrarDatos();
    }
    
    public void mostrarDatos(){
        
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        limpiarTabla();
        
        try {
            conexion = DriverManager.getConnection(url, user, password);
            
            String sql = "select id, titulo, artista, genero from artistas;";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String artista = rs.getString("artista");
                String genero = rs.getString("genero");
                
                modelo.addRow(new Object[]{id, titulo, artista, genero});
                
            }
            jtDatos.clearSelection();
            jtDatos.setModel(modelo);
            rs.close();
            ps.close();
            conexion.close();
            
        } catch (Exception ex){
            System.out.println("Error al conectarse a la base de datos"+ ex.getMessage());
        }
    
    }
    
    private void limpiarTabla(){
        int fila = this.jtDatos.getRowCount();
        for (int i = fila - 1; i >= 0 ; i--) {
            modelo.removeRow(i);
        }
    }

    public Connection getConnection(){
        Connection conexion = null;
        
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(url,user,password);
            JOptionPane.showInternalMessageDialog(null, "Conexion exitosa....");
            
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "Error de conexion...."+e);
        }
        return conexion;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Contenedor = new javax.swing.JPanel();
        fondo = new javax.swing.JLabel();
        vistaDatos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDatos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        vistaIngreso = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        jlId = new javax.swing.JLabel();
        jlTitulo = new javax.swing.JLabel();
        jlArtista = new javax.swing.JLabel();
        jlGenero = new javax.swing.JLabel();
        jtId = new javax.swing.JTextField();
        jtTitulo = new javax.swing.JTextField();
        jtArtista = new javax.swing.JTextField();
        jtGenero = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Contenedor.setBackground(new java.awt.Color(255, 255, 255));
        Contenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/music fondo.png"))); // NOI18N
        Contenedor.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 200, 80));

        vistaDatos.setBackground(new java.awt.Color(242, 103, 40));

        jtDatos.setFont(new java.awt.Font("SimSun", 0, 12)); // NOI18N
        jtDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Titulo", "Artista", "Genero"
            }
        ));
        jScrollPane1.setViewportView(jtDatos);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO DE DATOS");

        javax.swing.GroupLayout vistaDatosLayout = new javax.swing.GroupLayout(vistaDatos);
        vistaDatos.setLayout(vistaDatosLayout);
        vistaDatosLayout.setHorizontalGroup(
            vistaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vistaDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(vistaDatosLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        vistaDatosLayout.setVerticalGroup(
            vistaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vistaDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        Contenedor.add(vistaDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 270));

        vistaIngreso.setBackground(new Color(255, 255, 255, 1));

        titulo.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        titulo.setText("BIBLIOTECA MUSIC");

        jlId.setFont(new java.awt.Font("SimSun", 1, 12)); // NOI18N
        jlId.setText("Id:");

        jlTitulo.setFont(new java.awt.Font("SimSun", 1, 12)); // NOI18N
        jlTitulo.setText("Titulo:");

        jlArtista.setFont(new java.awt.Font("SimSun", 1, 12)); // NOI18N
        jlArtista.setText("Artista:");

        jlGenero.setFont(new java.awt.Font("SimSun", 1, 12)); // NOI18N
        jlGenero.setText("Genero:");

        jtId.setEnabled(false);
        jtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtIdActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(255, 105, 75));
        btnAgregar.setFont(new java.awt.Font("SimSun", 1, 12)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout vistaIngresoLayout = new javax.swing.GroupLayout(vistaIngreso);
        vistaIngreso.setLayout(vistaIngresoLayout);
        vistaIngresoLayout.setHorizontalGroup(
            vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vistaIngresoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(vistaIngresoLayout.createSequentialGroup()
                        .addComponent(jlTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtTitulo))
                    .addGroup(vistaIngresoLayout.createSequentialGroup()
                        .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlGenero)
                            .addComponent(jlArtista)
                            .addComponent(jlId))
                        .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(vistaIngresoLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(btnAgregar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(vistaIngresoLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jtId))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vistaIngresoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(vistaIngresoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtArtista)))))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vistaIngresoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titulo)
                .addGap(39, 39, 39))
        );
        vistaIngresoLayout.setVerticalGroup(
            vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vistaIngresoLayout.createSequentialGroup()
                .addContainerGap(116, Short.MAX_VALUE)
                .addComponent(titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTitulo)
                    .addComponent(jtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlArtista)
                    .addComponent(jtArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlGenero)
                    .addComponent(jtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(btnAgregar))
        );

        Contenedor.add(vistaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 200, 270));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtIdActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
        Connection conexion = getConnection();
        PreparedStatement ps = null;
        
        String sql = "insert into artistas(titulo, artista, genero) values (?,?,?);";
        
        try {
            ps = conexion.prepareStatement(sql);
            
            ps.setString(1, jtTitulo.getText());
            ps.setString(2, jtArtista.getText());
            ps.setString(3, jtGenero.getText());
            ps.executeUpdate();
            
            conexion.close();
            JOptionPane.showMessageDialog(null, "artista guardado con exito...");
            mostrarDatos();
            
        } catch (Exception e) {
            System.out.println("Error... "+e);
        }
        
    }//GEN-LAST:event_btnAgregarActionPerformed

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
            java.util.logging.Logger.getLogger(Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Biblioteca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Contenedor;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlArtista;
    private javax.swing.JLabel jlGenero;
    private javax.swing.JLabel jlId;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JTextField jtArtista;
    private javax.swing.JTable jtDatos;
    private javax.swing.JTextField jtGenero;
    private javax.swing.JTextField jtId;
    private javax.swing.JTextField jtTitulo;
    private javax.swing.JLabel titulo;
    private javax.swing.JPanel vistaDatos;
    private javax.swing.JPanel vistaIngreso;
    // End of variables declaration//GEN-END:variables
}
