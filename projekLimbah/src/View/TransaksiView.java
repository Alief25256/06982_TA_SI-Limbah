package View;

import Controller.Proses;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import Model.*;
import Database.koneksi;
import java.sql.ResultSet;

public class TransaksiView extends javax.swing.JFrame {
    private Proses transaksi;
    private ArrayList<Transaksi> arrKeranjang;
    private Integer hargatotal;
    private koneksi koneksi;
    private String nama_barang;

   
    public TransaksiView() throws SQLException {
        initComponents();
        this.hargatotal = 0;
        this.transaksi = new Proses();        
        this.arrKeranjang = new ArrayList<>();
        this.showtblkeranjang();
        this.showtblpesanan();
        this.showComboBoxOwner();
        this.showComboBoxNamaBarang();
        this.showComboBoxHargaBarang();                        
        this.showHargaTotal();
        //this.viewTabel();
        
    }
    
     private void kosong()
    {
        namapembeli.setText("");
        jumlahbarang.setText("");
        tgltransaksi.setText("");
    }
    
    
    public void showtblkeranjang() {
        DefaultTableModel dtmKeranjang = new DefaultTableModel(new String[]{"ID Owner","ID Barang",
            "Nama Barang","Harga Barang",}, 0);
        for (Transaksi trans : this.arrKeranjang) {
                dtmKeranjang.addRow(new String[]{trans.getOwner().getId_owner().toString(),
                    trans.getBarang().getID_barang().toString(), trans.getBarang().getNama_barang(), 
                    trans.getBarang().getHarga_barang().toString()});
        }
        this.tblkeranjang.setModel(dtmKeranjang);
    }
    
    public void showtblpesanan() throws SQLException {
        DefaultTableModel dtmpesanan = new DefaultTableModel(new String[]{"Nama Owner", "Nama Barang",
            "Tanggal Transaksi", "Harga Total"}, 0);
        dtmpesanan.setRowCount(0);
        for (Transaksi p : this.arrKeranjang) {
            dtmpesanan.addRow(new String[]{p.getOwner().getNama_owner(),
                p.getNama_barang().getNama_barang(), p.getTgl_transaksi().toString(), p.getTotal_harga().toString()
            });
        }
        this.tblpesanan.setModel(dtmpesanan);
        
      
    
    }
    
    public void showComboBoxOwner() throws SQLException {
        DefaultComboBoxModel dcbmOwner = new DefaultComboBoxModel();
        for (Owner ow : this.transaksi.getDataOwner()) {
            dcbmOwner.addElement(ow.getNama_owner());
        }
        this.cbPemasok.setModel(dcbmOwner);
    }
    
    public void showComboBoxNamaBarang() throws SQLException {
        DefaultComboBoxModel dcbmBarang = new DefaultComboBoxModel();
        for (Barang br : this.transaksi.getDataBarang()) {
            dcbmBarang.addElement(br.getNama_barang());
        }
        this.cbNamaBarang.setModel(dcbmBarang);
    } 

    public void showComboBoxHargaBarang() throws SQLException {
        DefaultComboBoxModel dcbmHargaBarang = new DefaultComboBoxModel();
        for (Barang br : this.transaksi.getDataBarang()) {
            dcbmHargaBarang.addElement(br.getHarga_barang());
        }
        this.cbHargaBarang.setModel(dcbmHargaBarang);
    }

    public void showHargaTotal() {
        tfTotalHarga.setText(hargatotal.toString());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        namapembeli = new javax.swing.JLabel();
        namabarang = new javax.swing.JLabel();
        namausaha = new javax.swing.JLabel();
        jumlahbarang = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        namaPemasok = new javax.swing.JLabel();
        hargabarang = new javax.swing.JLabel();
        alamat = new javax.swing.JLabel();
        tfNamaPemasok = new javax.swing.JTextField();
        tfJumlahBarang = new javax.swing.JTextField();
        totalharga = new javax.swing.JLabel();
        tfTotalHarga = new javax.swing.JTextField();
        ButtonTotal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblkeranjang = new javax.swing.JTable();
        buttonsimpan = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblpesanan = new javax.swing.JTable();
        tgltransaksi = new javax.swing.JLabel();
        tfTglTransaksi = new javax.swing.JTextField();
        tfNamaPembeli = new javax.swing.JTextField();
        tfHargaBarang = new javax.swing.JTextField();
        tfNamaBarang = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setSize(new java.awt.Dimension(1500, 500));

        namapembeli.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        namapembeli.setText("Nama Pembeli");

        namabarang.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        namabarang.setText("Nama Barang");

        namausaha.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        namausaha.setText("Penjualan Limbah B3");

        jumlahbarang.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jumlahbarang.setText("Jumlah Barang");

        jLabel1.setText("____________________________________________________");

        namaPemasok.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        namaPemasok.setText("Nama Pemasok");

        hargabarang.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        hargabarang.setText("Harga Barang");

        alamat.setFont(new java.awt.Font("Arabic Typesetting", 1, 18)); // NOI18N
        alamat.setText("JL. Hasanuddin, Timika, Papua");

        tfNamaPemasok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNamaPemasokActionPerformed(evt);
            }
        });

        totalharga.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        totalharga.setText("Total Harga");

        ButtonTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ButtonTotal.setText("TOTAL");
        ButtonTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonTotalActionPerformed(evt);
            }
        });

        tblkeranjang.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblkeranjang);

        buttonsimpan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonsimpan.setText("SIMPAN");
        buttonsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonsimpanActionPerformed(evt);
            }
        });

        tblpesanan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblpesanan);

        tgltransaksi.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        tgltransaksi.setText("Tgl Transaksi");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jumlahbarang)
                                    .addComponent(namabarang)
                                    .addComponent(namapembeli)
                                    .addComponent(namaPemasok)
                                    .addComponent(hargabarang)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(totalharga)
                                    .addComponent(tgltransaksi))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfTglTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(tfJumlahBarang)
                            .addComponent(tfNamaPemasok)
                            .addComponent(tfNamaPembeli, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfHargaBarang)
                            .addComponent(tfNamaBarang)
                            .addComponent(tfTotalHarga, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ButtonTotal)
                        .addGap(33, 33, 33)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonsimpan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(namausaha)
                .addGap(822, 822, 822))
            .addGroup(layout.createSequentialGroup()
                .addGap(559, 559, 559)
                .addComponent(alamat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(namausaha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alamat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonsimpan)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(namaPemasok, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfNamaPemasok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(namapembeli, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfNamaPembeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(namabarang, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jumlahbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfJumlahBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(hargabarang, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfHargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tgltransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfTglTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(28, 28, 28)
                        .addComponent(ButtonTotal)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalharga, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTotalActionPerformed
        try {
            Transaksi tr = new Transaksi();
            tr.setJumlah_barang(Integer.parseInt(tfJumlahBarang.getText()));
            tr.setbarang(transaksi.getDataBarang().get(cbHargaBarang.getSelectedIndex()));
            this.hargatotal = this.transaksi.getDataBarang().get(cbHargaBarang.getSelectedIndex())
                    .getHarga_barang() * Integer.parseInt(tfJumlahBarang.getText());
            showHargaTotal();
            arrKeranjang.add(tr);
            tfJumlahBarang.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiView.class.getName()).log(Level.SEVERE, null, ex);
        }
            
         
    }//GEN-LAST:event_ButtonTotalActionPerformed

    private void buttonsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonsimpanActionPerformed
            
            owner = namaPemasok.getText();
            nama_brg = namabarang.getText();
            tgltransaksi.getText();
            hargatotal.getClass();
            Transaksi p = new Transaksi();
        try {
            p.setOwner(this.owner);
            p.setNama_barang(this.nama_brg);
            p.setTgl_transaksi(new SimpleDateFormat("dd/MM/yyyy").parse(this.tfTglTransaksi.getText()));
            p.setTotal_harga(hargatotal);
            this.transaksi.insertTransaksi(p);
            this.showtblpesanan();
            kosong();
        } catch (SQLException | ParseException err) {
            System.out.println(err);
        } 
    }//GEN-LAST:event_buttonsimpanActionPerformed

    private void tfNamaPemasokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNamaPemasokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNamaPemasokActionPerformed
                                 
                                     
        
    
    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonTotal;
    private javax.swing.JLabel alamat;
    private javax.swing.JButton buttonsimpan;
    private javax.swing.JLabel hargabarang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jumlahbarang;
    private javax.swing.JLabel namaPemasok;
    private javax.swing.JLabel namabarang;
    private javax.swing.JLabel namapembeli;
    private javax.swing.JLabel namausaha;
    private javax.swing.JTable tblkeranjang;
    private javax.swing.JTable tblpesanan;
    private javax.swing.JTextField tfHargaBarang;
    private javax.swing.JTextField tfJumlahBarang;
    private javax.swing.JTextField tfNamaBarang;
    private javax.swing.JTextField tfNamaPemasok;
    private javax.swing.JTextField tfNamaPembeli;
    private javax.swing.JTextField tfTglTransaksi;
    private javax.swing.JTextField tfTotalHarga;
    private javax.swing.JLabel tgltransaksi;
    private javax.swing.JLabel totalharga;
    // End of variables declaration//GEN-END:variables
}