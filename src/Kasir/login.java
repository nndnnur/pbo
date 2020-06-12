package Kasir;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class login extends javax.swing.JFrame 
{
    
    private Connection koneksi;
    private ResultSet rs;
    private Statement stmt;
    
    public login() 
    {
        initComponents();
        koneksi = Koneksi.getKoneksi("localhost", "3306", "root", "", "pbo_kasir");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LBL_Login = new javax.swing.JLabel();
        LBL_Username = new javax.swing.JLabel();
        LBL_Password = new javax.swing.JLabel();
        BTN_OK = new javax.swing.JButton();
        BTN_EXIT = new javax.swing.JButton();
        TBX_Username = new javax.swing.JTextField();
        PBX_Password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        LBL_Login.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LBL_Login.setText("Login");
        LBL_Login.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        LBL_Login.setName("LBL_Login"); // NOI18N

        LBL_Username.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LBL_Username.setText("Username");
        LBL_Username.setName("LBL_Username"); // NOI18N

        LBL_Password.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LBL_Password.setText("Password");
        LBL_Password.setName("LBL_Password"); // NOI18N

        BTN_OK.setText("OK");
        BTN_OK.setName("BTN_OK"); // NOI18N
        BTN_OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_OKActionPerformed(evt);
            }
        });

        BTN_EXIT.setText("EXIT");
        BTN_EXIT.setName("BTN_EXIT"); // NOI18N
        BTN_EXIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_EXITActionPerformed(evt);
            }
        });

        TBX_Username.setName("TBX_Username"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LBL_Username, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(LBL_Password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BTN_OK, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(BTN_EXIT))
                    .addComponent(TBX_Username)
                    .addComponent(PBX_Password))
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LBL_Login)
                .addGap(155, 155, 155))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(LBL_Login)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBL_Username)
                    .addComponent(TBX_Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBL_Password)
                    .addComponent(PBX_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_EXIT)
                    .addComponent(BTN_OK))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_OKActionPerformed
        String Username = TBX_Username.getText().toString();
        String Password = PBX_Password.getText().toString();
        String ID;
        
        try 
        {
            Password = sha1(Password);
        } 
        catch (NoSuchAlgorithmException ex) 
        {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try
        {
            Statement stmt = koneksi.createStatement();
            String query = "SELECT*FROM login_username WHERE Username = '"+Username+"' AND Password = '"+Password+"'";
            rs = stmt.executeQuery(query);
            
            if(rs.next())
            {
                ID = rs.getString("ID_Login");
                LoginInfo.setID(ID);
        
                JOptionPane.showMessageDialog(null, "Login Berhasil");
                dispose();
                
                LoginInfo LI = new LoginInfo();
                LI.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Username Atau Password Salah");
                TBX_Username.setText("");
                PBX_Password.setText("");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_BTN_OKActionPerformed

    private void BTN_EXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EXITActionPerformed
        dispose();
    }//GEN-LAST:event_BTN_EXITActionPerformed

    
    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_EXIT;
    private javax.swing.JButton BTN_OK;
    private javax.swing.JLabel LBL_Login;
    private javax.swing.JLabel LBL_Password;
    private javax.swing.JLabel LBL_Username;
    private javax.swing.JPasswordField PBX_Password;
    private javax.swing.JTextField TBX_Username;
    // End of variables declaration//GEN-END:variables

    static String sha1(String input) throws NoSuchAlgorithmException 
    {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        
        for (int i = 0; i < result.length; i++) 
        {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }         
        return sb.toString();
    }
}
