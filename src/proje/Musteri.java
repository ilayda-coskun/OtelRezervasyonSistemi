/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import static proje.Ana_sayfa.ac;
import static proje.Ana_sayfa.conn;
import static proje.Ana_sayfa.i;
import static proje.Ana_sayfa.isim;
import static proje.Ana_sayfa.kapat;
import static proje.Ana_sayfa.rs;
import static proje.Ana_sayfa.soyisim;

/**
 *
 * @author ASUS
 */
public class Musteri extends javax.swing.JFrame {

    public static ArrayList<String> mrezervasyon = new ArrayList<String>();
    public static ArrayList<String> mgiris = new ArrayList<String>();
    public static ArrayList<String> mcikis = new ArrayList<String>();
    public static ArrayList<String> rid = new ArrayList<String>();
    public static ResultSet rs1, rs2;
    public static int sayi;
    public static int buton;

    // public javax.swing.JLabel jLabel4;
    /**
     * Creates new form Musteri
     */
    public Musteri() {
        initComponents();
        mrezervasyon.clear();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        ac();
        Statement stmt;
        try {
            stmt = conn.createStatement();

            String sql = "SELECT MÜŞTERİ_İD,MÜŞTERİ_AD,MÜŞTERİ_SOYİSİM FROM MÜŞTERİLER WHERE MÜŞTERİ_GIRIS='1'";
            // String sql ="SELECT COUNT(r.REZERVASYON_İD) as mycount from rezervasyon r,MÜŞTERİLER m WHERE m.MÜŞTERİ_İD=r.REZERVASYON_MÜŞTERİ and MÜŞTERİ_GIRIS='1'";

            rs = stmt.executeQuery(sql);
            //   rs1=stmt.executeQuery(sql1);
            i = 0;
            while (rs.next()) {
                i = rs.getInt(1);
                isim = rs.getString(2);
                soyisim = rs.getString(3);
                // sayi=rs1.getInt(1);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Ana_sayfa.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (i != 0) {
            jLabel1.setText(isim + " " + soyisim);
        }

        try {
            stmt = conn.createStatement();

            //  String sql ="select o.OTEL_AD,r.GİRİŞ_TARİHİ,r.ÇIKIŞ_TARİHİ,r.REZERVASYON_İD FROM OTELLER o,REZERVASYON r WHERE o.OTEL_İD=r.REZERVASYON_OTEL and r.REZERVASYON_MÜŞTERİ='"+i+"'";
            System.out.print(i + " ");
            String sql = "select REZERVASYON_OTEL,GİRİŞ_TARİHİ,ÇIKIŞ_TARİHİ,REZERVASYON_İD FROM REZERVASYON WHERE REZERVASYON_MÜŞTERİ='" + i + "'";
            rs = stmt.executeQuery(sql);
            mrezervasyon.clear();
            while (rs.next()) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                mrezervasyon.add(rs.getString(1));
                java.sql.Date a = (rs.getDate(2));
                String b = sdf.format(a);
                mgiris.add(b);
                java.sql.Date c = (rs.getDate(3));
                String d = sdf.format(c);
                mcikis.add(d);
                rid.add(rs.getString(4));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Ana_sayfa.class.getName()).log(Level.SEVERE, null, ex);
        }

        String gt = mgiris.get(0);
        //   gt=sdf.format(gt);
        System.out.println(mrezervasyon.size());

        if (mrezervasyon.size() == 1) {
            jPanel7.setVisible(false);
            jPanel3.setVisible(true);
            otel1.setText(mrezervasyon.get(0));
            g1.setText("Giriş tarihi :" + mgiris.get(0));
            c1.setText(" Çıkış Tarihi:" + mcikis.get(0));
            jPanel2.setVisible(false);
            jPanel5.setVisible(false);
            jPanel6.setVisible(false);

        } else if (mrezervasyon.size() == 2) {
            jPanel7.setVisible(false);
            jPanel3.setVisible(true);
            otel1.setText(mrezervasyon.get(0));
            g1.setText("Giriş tarihi :" + mgiris.get(0));
            c1.setText(" Çıkış Tarihi:" + mcikis.get(0));
            jPanel2.setVisible(true);
            otel2.setText(mrezervasyon.get(1));
            g2.setText("Giriş tarihi :" + mgiris.get(1));
            c2.setText(" Çıkış Tarihi:" + mcikis.get(1));
            jPanel5.setVisible(false);
            jPanel6.setVisible(false);

        } else if (mrezervasyon.size() == 3) {
            jPanel7.setVisible(false);
            jPanel3.setVisible(true);
            otel1.setText(mrezervasyon.get(0));
            g1.setText("Giriş tarihi :" + mgiris.get(0));
            c1.setText(" Çıkış Tarihi:" + mcikis.get(0));
            jPanel2.setVisible(true);
            otel2.setText(mrezervasyon.get(1));
            g2.setText("Giriş tarihi :" + mgiris.get(1));
            c2.setText(" Çıkış Tarihi:" + mcikis.get(1));
            jPanel5.setVisible(true);
            otel3.setText(mrezervasyon.get(2));
            g3.setText("Giriş tarihi :" + mgiris.get(2));
            c3.setText(" Çıkış Tarihi:" + mcikis.get(2));
            jPanel6.setVisible(false);

        } else if (mrezervasyon.size() == 4) {
            jPanel7.setVisible(false);
            jPanel3.setVisible(true);
            otel1.setText(mrezervasyon.get(0));
            g1.setText("Giriş tarihi :" + mgiris.get(0));
            c1.setText(" Çıkış Tarihi:" + mcikis.get(0));
            jPanel2.setVisible(true);
            otel2.setText(mrezervasyon.get(1));
            g2.setText("Giriş tarihi :" + mgiris.get(1));
            c2.setText(" Çıkış Tarihi:" + mcikis.get(1));
            jPanel5.setVisible(true);
            otel3.setText(mrezervasyon.get(2));
            g3.setText("Giriş tarihi :" + mgiris.get(2));
            c3.setText(" Çıkış Tarihi:" + mcikis.get(2));
            jPanel6.setVisible(false);
            otel4.setText(mrezervasyon.get(3));
            g4.setText("Giriş tarihi :" + mgiris.get(2));
            c4.setText(" Çıkış Tarihi:" + mcikis.get(2));

        } else if (mrezervasyon.size() == 0) {
            jPanel7.setVisible(false);
            jPanel3.setVisible(false);
            jPanel2.setVisible(false);
            jPanel5.setVisible(false);
            jPanel6.setVisible(false);

        } else {
            jPanel7.setVisible(true);
            System.out.print("asd");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        g2 = new javax.swing.JLabel();
        c2 = new javax.swing.JLabel();
        otel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        otel3 = new javax.swing.JLabel();
        g3 = new javax.swing.JLabel();
        c3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        g4 = new javax.swing.JLabel();
        c4 = new javax.swing.JLabel();
        otel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        otel1 = new javax.swing.JLabel();
        g1 = new javax.swing.JLabel();
        c1 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel8.setBackground(new java.awt.Color(249, 235, 202));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 90));

        jButton4.setBackground(java.awt.Color.lightGray);
        jButton4.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        jButton4.setForeground(new java.awt.Color(102, 0, 102));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proje/exchange.png"))); // NOI18N
        jButton4.setText("TARİH DEĞİŞTİR");
        jButton4.setMaximumSize(new java.awt.Dimension(127, 25));
        jButton4.setMinimumSize(new java.awt.Dimension(127, 25));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(java.awt.Color.lightGray);
        jButton5.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        jButton5.setForeground(new java.awt.Color(102, 0, 102));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proje/cross.png"))); // NOI18N
        jButton5.setText("İPTAL");
        jButton5.setMaximumSize(new java.awt.Dimension(127, 25));
        jButton5.setMinimumSize(new java.awt.Dimension(127, 25));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        g2.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        g2.setForeground(new java.awt.Color(102, 0, 102));
        g2.setText("g2");

        c2.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        c2.setForeground(new java.awt.Color(102, 0, 102));
        c2.setText("c2");

        otel2.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        otel2.setForeground(new java.awt.Color(102, 0, 102));
        otel2.setText("otel2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(c2)
                    .addComponent(otel2)
                    .addComponent(g2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(otel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(g2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c2))
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(400, 90));

        jButton6.setBackground(java.awt.Color.lightGray);
        jButton6.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        jButton6.setForeground(new java.awt.Color(102, 0, 102));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proje/exchange.png"))); // NOI18N
        jButton6.setText("TARİH DEĞİŞTİR");
        jButton6.setMaximumSize(new java.awt.Dimension(127, 25));
        jButton6.setMinimumSize(new java.awt.Dimension(127, 25));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(java.awt.Color.lightGray);
        jButton7.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        jButton7.setForeground(new java.awt.Color(102, 0, 102));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proje/cross.png"))); // NOI18N
        jButton7.setText("İPTAL");
        jButton7.setMaximumSize(new java.awt.Dimension(127, 25));
        jButton7.setMinimumSize(new java.awt.Dimension(127, 25));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        otel3.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        otel3.setForeground(new java.awt.Color(102, 0, 102));
        otel3.setText("otel3");

        g3.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        g3.setForeground(new java.awt.Color(102, 0, 102));
        g3.setText("g3");

        c3.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        c3.setForeground(new java.awt.Color(102, 0, 102));
        c3.setText("c3");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(otel3)
                    .addComponent(g3)
                    .addComponent(c3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(otel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(g3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(400, 90));

        jButton8.setBackground(java.awt.Color.lightGray);
        jButton8.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        jButton8.setForeground(new java.awt.Color(102, 0, 102));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proje/exchange.png"))); // NOI18N
        jButton8.setText("TARİH DEĞİŞTİR");
        jButton8.setMaximumSize(new java.awt.Dimension(127, 25));
        jButton8.setMinimumSize(new java.awt.Dimension(127, 25));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(java.awt.Color.lightGray);
        jButton9.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        jButton9.setForeground(new java.awt.Color(102, 0, 102));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proje/cross.png"))); // NOI18N
        jButton9.setText("İPTAL");
        jButton9.setMaximumSize(new java.awt.Dimension(127, 25));
        jButton9.setMinimumSize(new java.awt.Dimension(127, 25));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        g4.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        g4.setForeground(new java.awt.Color(102, 0, 102));
        g4.setText("g4");

        c4.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        c4.setForeground(new java.awt.Color(102, 0, 102));
        c4.setText("jLabel14");

        otel4.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        otel4.setForeground(new java.awt.Color(102, 0, 102));
        otel4.setText("otel4");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(otel4)
                    .addComponent(g4)
                    .addComponent(c4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(otel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(g4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c4)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel2.setBackground(new java.awt.Color(204, 204, 255));
        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 102));
        jLabel2.setText("KAYITLI REZERVASYONUNUZ BULUNMAMAKTADIR");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 90));

        jButton1.setBackground(java.awt.Color.lightGray);
        jButton1.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 0, 102));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proje/cross.png"))); // NOI18N
        jButton1.setText("İPTAL ");
        jButton1.setMaximumSize(new java.awt.Dimension(127, 25));
        jButton1.setMinimumSize(new java.awt.Dimension(127, 25));
        jButton1.setPreferredSize(new java.awt.Dimension(127, 25));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(java.awt.Color.lightGray);
        jButton2.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 0, 102));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proje/exchange.png"))); // NOI18N
        jButton2.setText("TARİH DEĞİŞTİR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        otel1.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        otel1.setForeground(new java.awt.Color(102, 0, 102));
        otel1.setText("otel1");

        g1.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        g1.setForeground(new java.awt.Color(102, 0, 102));
        g1.setText("g1");

        c1.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        c1.setForeground(new java.awt.Color(102, 0, 102));
        c1.setText("c1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(otel1)
                    .addComponent(g1)
                    .addComponent(c1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(otel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(g1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(c1)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(630, 835, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        jButton11.setFont(new java.awt.Font("Bahnschrift", 0, 15)); // NOI18N
        jButton11.setForeground(new java.awt.Color(102, 0, 102));
        jButton11.setText("ANA SAYFA");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 102));
        jLabel5.setText("REZERVASYONLARIM");

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 102));
        jLabel1.setText("AD SOYAD");

        jButton3.setFont(new java.awt.Font("Bahnschrift", 0, 15)); // NOI18N
        jButton3.setForeground(new java.awt.Color(102, 0, 102));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proje/error.png"))); // NOI18N
        jButton3.setText("OTURUMU KAPAT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Bahnschrift", 0, 15)); // NOI18N
        jButton12.setForeground(new java.awt.Color(102, 0, 102));
        jButton12.setText("HESABI SİL");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton12)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jButton11)
                                .addGap(148, 148, 148)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(53, 53, 53)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ac();
        Statement stmt;

        try {
            stmt = conn.createStatement();

            String sql = "UPDATE MÜŞTERİLER SET MÜŞTERİ_GIRIS='0' WHERE MÜŞTERİ_GIRIS='1'";

            rs = stmt.executeQuery(sql);

            Ana_sayfa a = new Ana_sayfa();
            a.setVisible(true);
            i = 0;
            this.hide();

        } catch (SQLException ex) {
            Logger.getLogger(Ana_sayfa.class.getName()).log(Level.SEVERE, null, ex);
        }
        //  kapat();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //buton=1;
        Tarih_güncelleme t = new Tarih_güncelleme();
        t.otel = mrezervasyon.get(0);
        t.rid = rid.get(0);
        //t.giris=mgiris.get(0);
        //t.cikis=mcikis.get(0);
        t.setVisible(true);
        this.hide();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Tarih_güncelleme t = new Tarih_güncelleme();
        t.otel = mrezervasyon.get(1);
        t.rid = rid.get(1);
        t.setVisible(true);
        this.hide();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Tarih_güncelleme t = new Tarih_güncelleme();
        t.otel = mrezervasyon.get(2);
        t.rid = rid.get(2);
        t.setVisible(true);
        this.hide();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Tarih_güncelleme t = new Tarih_güncelleme();
        t.otel = mrezervasyon.get(3);
        t.rid = rid.get(3);
        t.setVisible(true);
        this.hide();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ac();
        Statement stmt;

        try {
            stmt = conn.createStatement();
            String sql = "DELETE FROM REZERVASYON WHERE REZERVASYON_İD='" + rid.get(0) + "'";
            rs = stmt.executeQuery(sql);
            JOptionPane.showMessageDialog(null, "Rezervasyon silindi");
            Musteri m = new Musteri();
            this.hide();
            m.setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Hata");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        ac();
        Statement stmt;

        try {
            stmt = conn.createStatement();
            String sql = "DELETE FROM REZERVASYON WHERE REZERVASYON_İD='" + rid.get(1) + "'";
            rs = stmt.executeQuery(sql);
            JOptionPane.showMessageDialog(null, "Rezervasyon silindi");
            Musteri m = new Musteri();
            this.hide();
            m.setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Hata");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        ac();
        Statement stmt;
        try {
            stmt = conn.createStatement();
            String sql = "DELETE FROM REZERVASYON WHERE REZERVASYON_İD='" + rid.get(2) + "'";
            rs = stmt.executeQuery(sql);
            JOptionPane.showMessageDialog(null, "Rezervasyon silindi");
            Musteri m = new Musteri();
            this.hide();
            m.setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Hata");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        ac();
        Statement stmt;
        try {
            stmt = conn.createStatement();
            String sql = "DELETE FROM REZERVASYON WHERE REZERVASYON_İD='" + rid.get(3) + "'";
            rs = stmt.executeQuery(sql);
            JOptionPane.showMessageDialog(null, "Rezervasyon silindi");
            Musteri m = new Musteri();
            this.hide();
            m.setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Hata");
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        Ana_sayfa a = new Ana_sayfa();
        a.setVisible(true);
        this.hide();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed

        ac();
        Statement stmt;
        try {
            stmt = conn.createStatement();

            String sql = "DELETE FROM  MÜŞTERİLER WHERE MÜŞTERİ_GIRIS='1'";
            JOptionPane.showMessageDialog(null, "Hesabınız silindi");
            stmt.executeQuery(sql);

        } catch (SQLException ex) {
            Logger.getLogger(Ana_sayfa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

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
            java.util.logging.Logger.getLogger(Musteri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Musteri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Musteri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Musteri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Musteri().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel c1;
    private javax.swing.JLabel c2;
    private javax.swing.JLabel c3;
    private javax.swing.JLabel c4;
    public javax.swing.JLabel g1;
    private javax.swing.JLabel g2;
    private javax.swing.JLabel g3;
    private javax.swing.JLabel g4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel otel1;
    private javax.swing.JLabel otel2;
    private javax.swing.JLabel otel3;
    private javax.swing.JLabel otel4;
    // End of variables declaration//GEN-END:variables
}
