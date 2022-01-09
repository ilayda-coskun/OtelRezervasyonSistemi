package proje;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Ana_sayfa extends javax.swing.JFrame {

    public static Connection conn;
    public static ResultSet rs, rs1, rs2, rs3;
    public static int i;
    public static String isim;
    public static String soyisim;
    public static ArrayList<String> names = new ArrayList<String>();

    //connection c = new connection ();
    public static void ac() {
        //Connection conn ;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SYSTEM", "SYSTEM");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void kapat() {

        Connection conn = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SYSTEM", "SYSTEM");
            conn.close();

        } catch (Exception e) {
            System.out.println("exception");
        }
    }

    public Ana_sayfa() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        
        ac();
        Statement stmt;

        try {
            stmt = conn.createStatement();

            String sql = "SELECT MÜŞTERİ_İD,MÜŞTERİ_AD,MÜŞTERİ_SOYİSİM FROM MÜŞTERİLER WHERE MÜŞTERİ_GIRIS='1'";

            rs = stmt.executeQuery(sql);
            i = 0;
            while (rs.next()) {
                i = rs.getInt(1);
                isim = rs.getString(2);
                soyisim = rs.getString(3);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Ana_sayfa.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (i != 0) {
            jButton2.setText(isim + " " + soyisim);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        giris_tarihi = new com.toedter.calendar.JDateChooser();
        cikis_tarihi = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(240, 86, 211));

        jPanel1.setBackground(new java.awt.Color(249, 235, 202));
        jPanel1.setPreferredSize(new java.awt.Dimension(495, 495));

        jTextField1.setFont(new java.awt.Font("Bahnschrift", 0, 15)); // NOI18N
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Bahnschrift", 0, 15)); // NOI18N
        jButton3.setForeground(new java.awt.Color(102, 0, 102));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proje/search (1).png"))); // NOI18N
        jButton3.setText("OTEL ARA");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Bahnschrift", 0, 15)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 0, 102));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proje/man-user.png"))); // NOI18N
        jButton2.setText("MÜŞTERİ GİRİŞ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 102));
        jLabel1.setText("ŞEHİR");

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 102));
        jLabel2.setText("GİRİŞ TARİHİ");

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 102));
        jLabel3.setText("ÇIKIŞ TARİHİ");

        giris_tarihi.setFont(new java.awt.Font("Bahnschrift", 0, 15)); // NOI18N

        cikis_tarihi.setFont(new java.awt.Font("Bahnschrift", 0, 15)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 27)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 102));
        jLabel4.setText("OTEL REZERVASYON SİSTEMİ");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proje/hotel-iconn.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(giris_tarihi, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cikis_tarihi, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 45, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(251, 251, 251))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(134, 134, 134))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(109, 109, 109))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(19, 19, 19))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(giris_tarihi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cikis_tarihi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            if (i != 0) {
                Musteri n = new Musteri();
                n.setVisible(true);
                this.hide();

            } else {
                Müsteri_giris m = new Müsteri_giris();
                m.setVisible(true);
                this.hide();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Rezervasyon Yapınız");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        ac();
        Statement stmt;
        Statement stmt1;
        Statement stmt2;
        Statement stmt3;
        if (jTextField1.getText().equals("ANKARA")) {

            try {
                stmt = conn.createStatement();
                stmt1 = conn.createStatement();
                stmt2 = conn.createStatement();
                stmt3 = conn.createStatement();

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat g = new SimpleDateFormat("mm-dd-yyyy");

                String sql = "select distinct OTEL_İD from GÖLBAŞI_ODALAR where ODA_İD in (select ODA_İD from GÖLBAŞI_ODALAR minus select rezervasyon_oda from REZERVASYON where ((GİRİŞ_TARİHİ>='" + sdf.format(giris_tarihi.getDate()) + "' AND GİRİŞ_TARİHİ<='" + sdf.format(cikis_tarihi.getDate()) + "') OR (GİRİŞ_TARİHİ>='" + sdf.format(giris_tarihi.getDate()) + "' AND ÇIKIŞ_TARİHİ<='" + sdf.format(cikis_tarihi.getDate()) + "') ) AND  REZERVASYON_OTEL LIKE '%GL07%')";
                String sql1 = "select distinct OTEL_İD  from BATIKENT_ODALAR where ODA_İD in (select ODA_İD from BATIKENT_ODALAR minus select rezervasyon_oda from REZERVASYON where ((GİRİŞ_TARİHİ>='" + sdf.format(giris_tarihi.getDate()) + "' AND GİRİŞ_TARİHİ<='" + sdf.format(cikis_tarihi.getDate()) + "') OR (ÇIKIŞ_TARİHİ>='" + sdf.format(giris_tarihi.getDate()) + "' AND ÇIKIŞ_TARİHİ<='" + sdf.format(cikis_tarihi.getDate()) + "') ) AND  REZERVASYON_OTEL LIKE '%BT15%')";
                String sql2 = "select distinct OTEL_İD  from ÇANKAYA_ODALAR where ODA_İD in (select ODA_İD from ÇANKAYA_ODALAR minus select rezervasyon_oda from REZERVASYON where ((GİRİŞ_TARİHİ>='" + sdf.format(giris_tarihi.getDate()) + "' AND GİRİŞ_TARİHİ<='" + sdf.format(cikis_tarihi.getDate()) + "') OR (ÇIKIŞ_TARİHİ>='" + sdf.format(giris_tarihi.getDate()) + "' AND ÇIKIŞ_TARİHİ<='" + sdf.format(cikis_tarihi.getDate()) + "') ) AND  REZERVASYON_OTEL LIKE '%CK06%')";
                String sql3 = "select distinct OTEL_İD  from KIZILAY_ODALAR where ODA_İD in (select ODA_İD from KIZILAY_ODALAR minus select rezervasyon_oda from REZERVASYON where ((GİRİŞ_TARİHİ>='" + sdf.format(giris_tarihi.getDate()) + "' AND GİRİŞ_TARİHİ<='" + sdf.format(cikis_tarihi.getDate()) + "') OR (ÇIKIŞ_TARİHİ>='" + sdf.format(giris_tarihi.getDate()) + "' AND ÇIKIŞ_TARİHİ<='" + sdf.format(cikis_tarihi.getDate()) + "') ) AND  REZERVASYON_OTEL LIKE '%KZ20%')";

                rs = stmt.executeQuery(sql);
                rs1 = stmt1.executeQuery(sql1);
                rs2 = stmt2.executeQuery(sql2);
                rs3 = stmt3.executeQuery(sql3);

                //ArrayList<String> names = new ArrayList<String>();
                names.clear();
                for (int i = 0; i < names.size(); i++) {
                    System.out.println(names.get(i));
                    System.out.println(i);
                }

                while (rs.next()) {
                    names.add(rs.getString(1));

                }
                while (rs1.next()) {
                    names.add(rs1.getString(1));

                }
                while (rs2.next()) {
                    names.add(rs2.getString(1));

                }
                while (rs3.next()) {
                    names.add(rs3.getString(1));

                }

                if (names.size() == 0) {
                    JOptionPane.showMessageDialog(null, "SEÇTİĞİNİZ ŞEHİRDE OTELİMİZ BULUNMAMAKTADIR");
                } else {

                    Oteller n = new Oteller(names);
                    n.id = String.valueOf(i);

                    n.giris = sdf.format(giris_tarihi.getDate());
                    n.cikis = sdf.format(cikis_tarihi.getDate());
                    n.names = names;
                    // n.kisi=kisi.getSelectedItem().toString();
                    n.text = jTextField1.getText();
                    n.setVisible(true);
                    this.hide();
                }

            } catch (SQLException ex) {
                Logger.getLogger(Ana_sayfa.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (jTextField1.getText().equals("İZMİR")) {
            System.out.println("izmir ");
        } else if (jTextField1.getText().equals("İSTANBUL")) {
            System.out.println("İSTANBUL");
        } else {
            System.out.println("yanlış");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(Ana_sayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ana_sayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ana_sayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ana_sayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Ana_sayfa a1 = new Ana_sayfa();
                a1.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser cikis_tarihi;
    private com.toedter.calendar.JDateChooser giris_tarihi;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
