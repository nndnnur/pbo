package Kasir;

import com.mysql.jdbc.Connection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginInfo extends javax.swing.JFrame 
{
    private Connection kon;
    private Statement stmt;
    private ResultSet rs;
    
    private static String ID_Login;
    private String Nama;
    private String Telepon;
    private String Email;
    private String Alamat;
    
    public static void setID(String ID)
    { ID_Login = ID; }
    public static String getID()
    { return ID_Login; }
    
    public void ShowData()
    {
        try
        {
            Statement stmt = kon.createStatement();
            String query = "SELECT*FROM login_info WHERE ID_Login = '"+getID()+"'";
            rs = stmt.executeQuery(query);
            
            if(rs.next())
            {
                Nama = rs.getString("Nama_Admin");
                Telepon = rs.getString("No_Telepon");
                Email = rs.getString("Email");
                Alamat = rs.getString("Alamat");
                
                TBX_Nama.setText(Nama);
                TBX_Telepon.setText(Telepon);
                TBX_Email.setText(Email);
                TBX_Alamat.setText(Alamat);
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public LoginInfo() 
    {
        initComponents();
        kon = Koneksi.getKoneksi("localhost", "3306", "root", "", "pbo_kasir");
        ShowData();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LBL_Info = new javax.swing.JLabel();
        LBL_Nama = new javax.swing.JLabel();
        LBL_Telepon = new javax.swing.JLabel();
        LBL_Email = new javax.swing.JLabel();
        LBL_Alamat = new javax.swing.JLabel();
        TBX_Telepon = new javax.swing.JTextField();
        TBX_Email = new javax.swing.JTextField();
        TBX_Nama = new javax.swing.JTextField();
        TBX_Alamat = new javax.swing.JTextField();
        BTN_Lanjut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LBL_Info.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LBL_Info.setText("Login Info");
        LBL_Info.setName("LBL_Info"); // NOI18N

        LBL_Nama.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        LBL_Nama.setText("Nama");
        LBL_Nama.setName("LBL_Nama"); // NOI18N

        LBL_Telepon.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        LBL_Telepon.setText("No Telepon");
        LBL_Telepon.setName("LBL_Telepon"); // NOI18N

        LBL_Email.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        LBL_Email.setText("Email");
        LBL_Email.setName("LBL_Email"); // NOI18N

        LBL_Alamat.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        LBL_Alamat.setText("Alamat");
        LBL_Alamat.setName("LBL_Alamat"); // NOI18N

        TBX_Telepon.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        TBX_Telepon.setEnabled(false);
        TBX_Telepon.setName("TBX_Telepon"); // NOI18N

        TBX_Email.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        TBX_Email.setEnabled(false);
        TBX_Email.setName("TBX_Email"); // NOI18N

        TBX_Nama.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        TBX_Nama.setEnabled(false);
        TBX_Nama.setName("TBX_Nama"); // NOI18N

        TBX_Alamat.setEnabled(false);
        TBX_Alamat.setName("TBX_Alamat"); // NOI18N
        TBX_Alamat.setPreferredSize(new java.awt.Dimension(6, 31));

        BTN_Lanjut.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        BTN_Lanjut.setText("Lanjutkan");
        BTN_Lanjut.setName("BTN_Lanjut"); // NOI18N
        BTN_Lanjut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_LanjutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LBL_Telepon)
                            .addComponent(LBL_Nama)
                            .addComponent(LBL_Email)
                            .addComponent(LBL_Alamat))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TBX_Telepon, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                            .addComponent(TBX_Email)
                            .addComponent(TBX_Nama)
                            .addComponent(TBX_Alamat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 134, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(LBL_Info)
                                .addGap(126, 126, 126))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(BTN_Lanjut)
                                .addGap(133, 133, 133))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(LBL_Info)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBL_Nama)
                    .addComponent(TBX_Nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBL_Telepon)
                    .addComponent(TBX_Telepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBL_Email)
                    .addComponent(TBX_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBL_Alamat)
                    .addComponent(TBX_Alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(BTN_Lanjut)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_LanjutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_LanjutActionPerformed
        dispose();
        InputData id = new InputData();
        id.setVisible(true);
    }//GEN-LAST:event_BTN_LanjutActionPerformed

    
    public static void main(String args[]) 
    {
        
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new LoginInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Lanjut;
    private javax.swing.JLabel LBL_Alamat;
    private javax.swing.JLabel LBL_Email;
    private javax.swing.JLabel LBL_Info;
    private javax.swing.JLabel LBL_Nama;
    private javax.swing.JLabel LBL_Telepon;
    private javax.swing.JTextField TBX_Alamat;
    private javax.swing.JTextField TBX_Email;
    private javax.swing.JTextField TBX_Nama;
    private javax.swing.JTextField TBX_Telepon;
    // End of variables declaration//GEN-END:variables
}
