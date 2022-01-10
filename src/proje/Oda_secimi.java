/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static proje.Ana_sayfa.conn;
import static proje.Ana_sayfa.i;
import static proje.Ana_sayfa.names;
import static proje.Ana_sayfa.rs;

public class Oda_secimi extends javax.swing.JFrame {

    String g, c, otel_id, mus_id, sayi, kisi_s, eklenecek_hesap, oda_tipi, sayi_o, oda_id;
    int sayi1, fiyat1, kisi_sa, tarih_farki;
    public static Connection conn;
    public static ResultSet rs, rs2, rs3, rs4;
    public int i;

    public int daysBetweenTwoTimestamp(String t1, String t2) {
        String[] parts1 = t1.split("/"); //"MM/dd/yyyy"
        String[] parts2 = t2.split("/"); //"MM/dd/yyyy"

        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();

        cal1.set(Calendar.DAY_OF_MONTH, Integer.valueOf(parts1[0])); //DAY
        cal1.set(Calendar.MONTH, Integer.valueOf(parts1[1])); //MONTH
        cal1.set(Calendar.YEAR, Integer.valueOf(parts1[2])); //YEAR

        cal2.set(Calendar.DAY_OF_MONTH, Integer.valueOf(parts2[0])); //DAY
        cal2.set(Calendar.MONTH, Integer.valueOf(parts2[1])); //MONTH
        cal2.set(Calendar.YEAR, Integer.valueOf(parts2[2])); //YEAR

        long diff = cal2.getTimeInMillis() - cal1.getTimeInMillis();
        long day = diff / (24 * 60 * 60 * 1000);
        return Math.abs(Math.toIntExact(day));
    }

    public static void ac() {
        //Connection conn ;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SYSTEM", "SYSTEM");

            /* String sql = "select * from oteller";
            pst = conn.prepareStatement(sql);
            rs=pst.executeQuery();
            System.out.println("");
            while(rs.next())
                
            //  System.out.println(rs.getString(1)+" "+rs.getString(2)+ " ");
            conn.close();*/
        } catch (Exception e) {
            System.out.println("exception");
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

    public Oda_secimi() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        jLabel1.setText(otel_id);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        fiyat = new javax.swing.JLabel();
        fiyati_gör = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        combo = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("  ");

        jPanel1.setBackground(new java.awt.Color(249, 235, 202));

        fiyat.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        fiyat.setForeground(new java.awt.Color(102, 0, 102));
        fiyat.setText("----");

        fiyati_gör.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        fiyati_gör.setForeground(new java.awt.Color(102, 0, 102));
        fiyati_gör.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proje/hand.png"))); // NOI18N
        fiyati_gör.setText("Fiyatı Gör");
        fiyati_gör.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiyati_görActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 0, 102));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proje/booking.png"))); // NOI18N
        jButton1.setText("Rezervasyon Yap");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        combo.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        combo.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        combo.setForeground(new java.awt.Color(102, 0, 102));
        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aile odası", "Standart oda" }));
        combo.setSelectedIndex(-1);
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });

        jComboBox1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        jComboBox1.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(102, 0, 102));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        jComboBox1.setSelectedIndex(-1);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(102, 0, 102));
        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 102));
        jLabel1.setText("Otel Adı");

        jButton2.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 0, 102));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proje/left-arrow.png"))); // NOI18N
        jButton2.setText("GERİ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 102));
        jLabel2.setText("Kişi Sayısı");

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 102));
        jLabel3.setText("Konsept");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 116, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fiyat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fiyati_gör)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fiyati_gör, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fiyat))
                        .addGap(0, 69, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(236, 236, 236)
                    .addComponent(jLabel4)
                    .addContainerGap(289, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(238, 238, 238)
                    .addComponent(jLabel4)
                    .addContainerGap(109, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        ac();
        Statement stmt, stmt2, stmt3, stmt4;

        System.out.println(oda_id);
        try {
            stmt = conn.createStatement();
            /*stmt2 = conn.createStatement();
            stmt3 = conn.createStatement();*/

            String sql = "SELECT MÜŞTERİ_İD FROM MÜŞTERİLER WHERE MÜŞTERİ_GIRIS='1'";

            /*String sql2="select max(REZERVASYON_İD) from rezervasyon";
            String sql3="select max(ODA_İD) from rezervasyon";*/
            rs = stmt.executeQuery(sql);
            /*  rs2=stmt2.executeQuery(sql2);
            rs3=stmt3.executeQuery(sql3); */
            while (rs.next()) {
                i = rs.getInt(1);
            }
            /* while(rs2.next()){
            sayi=String.valueOf(rs2.getInt(1));   
            int sayi1=Integer.valueOf(sayi);
            sayi1=sayi1+1;
            sayi=String.valueOf(sayi1);}
            while(rs3.next()){
            sayi_o=String.valueOf(rs3.getInt(1));   
            int sayi1=Integer.valueOf(sayi_o);
            sayi1=sayi1+1;
            sayi_o=String.valueOf(sayi1);}*/
        } catch (SQLException ex) {
            Logger.getLogger(Ana_sayfa.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* Statement stmt1=null;
        try{
            String sql1="Select od.ODA_İD from OTELLER o ,ODALAR od WHERE o.OTEL_İD='"+otel_id+"' and o.OTEL_İD=od.OTEL_İD AND od.ODA_İD IN(select ODA_İD from odalar where ODA_KİŞİSAYİSİ='"+kisi_sa+"'  minus\n" +
            "select REZERVASYON_ODA from rezervasyon WHERE GİRİŞ_TARİHİ between '"+g+"' and '"+c+"' AND ÇIKIŞ_TARİHİ BETWEEN '"+g+"' and '"+c+"')";       
     
            rs=stmt1.executeQuery(sql1);
       
            while(rs.next()){
        //      oda_id=rs.getString(1);
                System.out.println(rs.getInt(1)+" <--");
              //diğer methodun alım tipinden dolayı hata veriyor
            }
        }catch (SQLException ex) {
         Logger.getLogger(Ana_sayfa.class.getName()).log(Level.SEVERE, null, ex);
     } */
        System.out.print(i);
        if (i != 0) {
            CallableStatement callableStatement = null;
            String procedure = "{call proje.rezervasyon_kayit(?,?,?,?,?,?,?)}";
            try {
                System.out.println(oda_id);
                callableStatement = conn.prepareCall(procedure);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                PreparedStatement pst = null;
                callableStatement.setString(1, "2"); //rezervasyon id otomatik artıyo
                callableStatement.setString(2, otel_id);//butondan geliyo
                callableStatement.setString(3, oda_id);
                callableStatement.setDouble(4, Double.valueOf(i));//
                callableStatement.setString(5, g);
                callableStatement.setString(6, c);
                callableStatement.setString(7, eklenecek_hesap);

                callableStatement.execute();
                JOptionPane.showMessageDialog(null, "REZERVASYON YAPILMIŞTIR");
                callableStatement.close();

            } catch (SQLException ex) {
                Logger.getLogger(Oda_secimi.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            Musteri_giris m = new Musteri_giris();
            m.setVisible(true);
            this.hide();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void fiyati_görActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiyati_görActionPerformed

        ac();
        Statement stmt3;
        if (combo.getSelectedItem().toString() == "Aile odası") {
            oda_tipi = "AİLE";
        } else if (combo.getSelectedItem().toString() == "Standart oda") {
            oda_tipi = "STANDART";
        }
        if (jComboBox1.getSelectedItem().toString() == "1") {
            kisi_sa = 1;
        } else if (jComboBox1.getSelectedItem().toString() == "2") {
            kisi_sa = 2;
        } else if (jComboBox1.getSelectedItem().toString() == "3") {
            kisi_sa = 3;
        } else if (jComboBox1.getSelectedItem().toString() == "4") {
            kisi_sa = 4;
        } else if (jComboBox1.getSelectedItem().toString() == "5") {
            kisi_sa = 5;
        }

        try {
            stmt3 = conn.createStatement();
            if (otel_id.equals("GL07")) {
                String sql3 = "SELECT ODA_İD,ODA_FİYATI FROM GÖLBAŞI_ODALAR WHERE ODA_İD IN\n"
                        + "(select ODA_İD from GÖLBAŞI_ODALAR minus\n"
                        + "select REZERVASYON_ODA from REZERVASYON where ((GİRİŞ_TARİHİ>='" + g + "' AND GİRİŞ_TARİHİ<='" + c + "') OR (ÇIKIŞ_TARİHİ>='" + g + "' AND ÇIKIŞ_TARİHİ<='" + c + "') ) AND  REZERVASYON_OTEL LIKE '%GL07%')\n"
                        + "AND \n"
                        + "ODA_TİPİ='" + oda_tipi + "'\n"
                        + "AND \n"
                        + "ODA_KİŞİSAYISI='" + kisi_sa + "'";
                rs4 = stmt3.executeQuery(sql3);

                while (rs4.next()) {
                    fiyat1 = Integer.valueOf(rs4.getInt(2));
                    oda_id = rs4.getString(1);
                    System.out.println(rs4.getString(1));

                }
            } else if (otel_id.equals("BT15")) {
                String sql3 = "SELECT ODA_İD,ODA_FİYATI FROM BATIKENT_ODALAR WHERE ODA_İD IN\n"
                        + "(select ODA_İD from BATIKENT_ODALAR minus\n"
                        + "select REZERVASYON_ODA from REZERVASYON where ((GİRİŞ_TARİHİ>='" + g + "' AND GİRİŞ_TARİHİ<='" + c + "') OR (ÇIKIŞ_TARİHİ>='" + g + "' AND ÇIKIŞ_TARİHİ<='" + c + "') ) AND  REZERVASYON_OTEL LIKE '%BT15%')\n"
                        + "AND \n"
                        + "ODA_TİPİ='" + oda_tipi + "'\n"
                        + "AND \n"
                        + "ODA_KİŞİSAYISI='" + kisi_sa + "'";
                rs4 = stmt3.executeQuery(sql3);

                while (rs4.next()) {
                    fiyat1 = Integer.valueOf(rs4.getInt(2));
                    oda_id = rs4.getString(1);
                    System.out.println(rs4.getString(1));

                }

            } else if (otel_id.equals("KZ20")) {
                String sql3 = "SELECT ODA_İD,ODA_FİYATI FROM KIZILAY_ODALAR WHERE ODA_İD IN\n"
                        + "(select ODA_İD from KIZILAY_ODALAR minus\n"
                        + "select REZERVASYON_ODA from REZERVASYON where ((GİRİŞ_TARİHİ>='" + g + "' AND GİRİŞ_TARİHİ<='" + c + "') OR (ÇIKIŞ_TARİHİ>='" + g + "' AND ÇIKIŞ_TARİHİ<='" + c + "') ) AND  REZERVASYON_OTEL LIKE '%KZ20%')\n"
                        + "AND \n"
                        + "ODA_TİPİ='" + oda_tipi + "'\n"
                        + "AND \n"
                        + "ODA_KİŞİSAYISI='" + kisi_sa + "'";
                rs4 = stmt3.executeQuery(sql3);

                while (rs4.next()) {
                    fiyat1 = Integer.valueOf(rs4.getInt(2));
                    oda_id = rs4.getString(1);
                    System.out.println(rs4.getString(1));

                }

            } else if (otel_id.equals("CK06")) {
                System.out.print(oda_tipi);
                String sql3 = "SELECT ODA_İD,ODA_FİYATI FROM ÇANKAYA_ODALAR WHERE ODA_İD IN\n"
                        + "(select ODA_İD, from ÇANKAYA_ODALAR minus\n"
                        + "select REZERVASYON_ODA from REZERVASYON where ((GİRİŞ_TARİHİ>='" + g + "' AND GİRİŞ_TARİHİ<='" + c + "') OR (ÇIKIŞ_TARİHİ>='" + g + "' AND ÇIKIŞ_TARİHİ<='" + c + "') ) AND  REZERVASYON_OTEL LIKE '%CK06%')\n"
                        + "AND \n"
                        + "ODA_TİPİ='" + oda_tipi + "'\n"
                        + "AND \n"
                        + "ODA_KİŞİSAYISI='" + kisi_sa + "'";
                rs4 = stmt3.executeQuery(sql3);

                while (rs4.next()) {
                    fiyat1 = Integer.valueOf(rs4.getInt(2));
                    oda_id = rs4.getString(1);
                    System.out.println(rs4.getString(1));

                }

            }
        } catch (SQLException ex) {
            //Logger.getLogger(Oda_secimi.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("sorun 412");
        }
        // kisi_sa=Integer.valueOf(kisi_s);
        if (oda_id == null) {
            JOptionPane.showMessageDialog(null, "UYGUN ODA BULUNMAMAKTADIR BULUNMAMAKTADIR");
        }
        String gi_t = String.valueOf(g);
        String ci_t = String.valueOf(c);
        tarih_farki = daysBetweenTwoTimestamp(gi_t, ci_t);
        //System.out.println("\n"+fiyat1+"tarih farkıııııııııııııı");
        int hesap = fiyat1 * kisi_sa * tarih_farki;
        eklenecek_hesap = String.valueOf(hesap);
        fiyat.setText(tarih_farki + " gün için " + kisi_sa + " kişilik hesap " + hesap + " TL");
    }//GEN-LAST:event_fiyati_görActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        Oteller o = new Oteller(names);
        o.setVisible(true);
        this.hide();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(Oda_secimi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Oda_secimi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Oda_secimi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Oda_secimi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                Oda_secimi a1 = new Oda_secimi();
                a1.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JLabel fiyat;
    private javax.swing.JButton fiyati_gör;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
