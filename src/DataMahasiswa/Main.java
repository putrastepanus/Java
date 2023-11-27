/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DataMahasiswa;

import java.sql.*;
import com.raven.swing.table.Table;
import fungsi.KoneksiJDBC1;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author stepa
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form DataMahasiswa
     */
//    private Table tableMahasiswa;
    private KoneksiJDBC1 konek;
    //0 = Simpan atau 1 = Update
    private int StatusUpdate = 0;
    private TableRowSorter<DefaultTableModel> rowSorter;
    private Map<String, String[]> jurusanPerFakultas = new HashMap<>();

    public Main() {
        initComponents();
        konek = new KoneksiJDBC1();
        loadDataToTable();
        textFieldNIM.requestFocus();

        tampilkanHasilCari();
        
        jurusanPerFakultas.put("Fakultas Teknik", new String[]{"Teknik Informatika", "Teknik Sipil", "Teknik Elektro"});
        jurusanPerFakultas.put("Fakultas Ekonomi", new String[]{"Manajemen", "Akuntansi", "Ekonomi Pembangunan"});
        jurusanPerFakultas.put("Fakultas Hukum", new String[]{"Hukum Bisnis", "Hukum Internasional"});
        jurusanPerFakultas.put("Fakultas Psikologi", new String[]{"Psikologi Klinis", "Psikologi Industri", "Psikologi Pendidikan"});

    }

    private void tampilkanHasilCari() {
        rowSorter = new TableRowSorter<>((DefaultTableModel) tableMahasiswa.getModel());
        tableMahasiswa.setRowSorter(rowSorter);

        textFieldCari.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                cari();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                cari();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                cari();
            }
        });
    }

    private void cari() {
        String query = textFieldCari.getText().toLowerCase();
        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + query, 0, 1, 2, 3, 4, 5));
    }

    private void loadDataToTable() {
        System.out.println("\n==REFRESH Tabel");
        konek.showData(tableMahasiswa);
        System.out.println("==Selesai REFRESH Tabel \n");
    }

    private void resetFormInput() {
        textFieldNIM.setText("");
        textFieldNama.setText("");
        textFieldNomorTelepon.setText("");
        comboBoxFakultas.setSelectedItem("Fakultas Teknik");
        comboBoxJurusan.setSelectedItem("Teknik Informatika");
        textFieldNomorTelepon.setText("");
        textFieldIPK.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        buttonCustomSimpan = new button.ButtonCustom();
        buttonCustomEdit = new button.ButtonCustom();
        textFieldNama = new textfield.TextField();
        textFieldNIM = new textfield.TextField();
        comboBoxFakultas = new combo_suggestion.ComboBoxSuggestion();
        comboBoxJurusan = new combo_suggestion.ComboBoxSuggestion();
        textFieldNomorTelepon = new textfield.TextField();
        textFieldIPK = new textfield.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMahasiswa = new com.raven.swing.table.Table();
        buttonCustomHapus = new button.ButtonCustom();
        textFieldCari = new textfield.TextField();
        buttonCustom1 = new button.ButtonCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Data Mahasiswa");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.white);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel5.setText("Fakultas");

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel1.setText("Data Mahasiswa");

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel4.setText("Jurusan");

        buttonCustomSimpan.setText("Simpan");
        buttonCustomSimpan.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        buttonCustomSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCustomSimpanActionPerformed(evt);
            }
        });

        buttonCustomEdit.setText("Edit");
        buttonCustomEdit.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        buttonCustomEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCustomEditActionPerformed(evt);
            }
        });

        textFieldNama.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        textFieldNama.setLabelText("Nama");

        textFieldNIM.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        textFieldNIM.setLabelText("NIM");

        comboBoxFakultas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Fakultas Teknik", "Fakultas Ekonomi", "Fakultas Hukum", "Fakultas Psikologi" }));
        comboBoxFakultas.setToolTipText("");
        comboBoxFakultas.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        comboBoxFakultas.setName(""); // NOI18N
        comboBoxFakultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxFakultasActionPerformed(evt);
            }
        });

        comboBoxJurusan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Teknik Informatika", "Teknik Sipil", "Teknik Elektro", "Teknik Industri", "Teknik Mesin", "Manajemen", "Akuntansi", "Ekonomi Pembangunan", "Hukum Bisnis", "Hukum Internasional", "Psikologi Klinis", "Psikologi Industri", "Psikologi Pendidikan" }));
        comboBoxJurusan.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        comboBoxJurusan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxJurusanActionPerformed(evt);
            }
        });

        textFieldNomorTelepon.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        textFieldNomorTelepon.setLabelText("Nomor Telepon");

        textFieldIPK.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        textFieldIPK.setLabelText("IPK");

        tableMahasiswa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "NIM", "NAMA", "Fakultas", "Jurusan", "No Telepon", "IPK"
            }
        ));
        tableMahasiswa.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        tableMahasiswa.setShowGrid(false);
        tableMahasiswa.setShowHorizontalLines(true);
        jScrollPane1.setViewportView(tableMahasiswa);

        buttonCustomHapus.setText("Hapus");
        buttonCustomHapus.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        buttonCustomHapus.setStyle(button.ButtonCustom.ButtonStyle.DESTRUCTIVE);
        buttonCustomHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCustomHapusActionPerformed(evt);
            }
        });

        textFieldCari.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        textFieldCari.setLabelText("Cari NIM, Nama, Jurusan..dll");
        textFieldCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldCariActionPerformed(evt);
            }
        });

        buttonCustom1.setText("Reset");
        buttonCustom1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCustom1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(textFieldIPK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textFieldNomorTelepon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textFieldNIM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textFieldNama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboBoxFakultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(comboBoxJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(buttonCustomSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonCustomEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCustomHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textFieldCari, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonCustomHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonCustomEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(42, 42, 42)
                        .addComponent(textFieldNIM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(textFieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBoxFakultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(textFieldNomorTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(textFieldIPK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(buttonCustomSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCustomSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCustomSimpanActionPerformed
        try {
            String nim = textFieldNIM.getText();
            String nama = textFieldNama.getText();
            String NOHP = textFieldNomorTelepon.getText();
            String Fakultas = comboBoxFakultas.getSelectedItem().toString();
            String Jurusan = comboBoxJurusan.getSelectedItem().toString();
            Float IPK = Float.valueOf(textFieldIPK.getText());

            if (StatusUpdate == 0) { //Input
                System.out.println("Masuk Ke SIMPAN");
                //Input Data
                konek.inputData(nim, nama, Fakultas, Jurusan, NOHP, IPK);

                resetFormInput(); //reset Inputan
                loadDataToTable(); //Menampikan Tabel

            } else if (StatusUpdate == 1) { //Update
                System.out.println("Masuk ke UPDATE");
                konek.updateData(nim, nama, Fakultas, Jurusan, NOHP, IPK);

                resetFormInput(); //reset Inputan
                loadDataToTable(); //Menampikan Tabel

                StatusUpdate = 0; //Ubah kondisi ke Simpan
                textFieldNIM.setEnabled(true);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Format yang di masukkan salah.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan. Periksa kembali input Anda.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_buttonCustomSimpanActionPerformed

    private void buttonCustomEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCustomEditActionPerformed
        //Setting IPK tidak bisa di klik
        textFieldNIM.setEnabled(false);
        int selectedRowTable = tableMahasiswa.getSelectedRow();

        if (selectedRowTable >= 0) {
            textFieldNIM.setText(String.valueOf(tableMahasiswa.getValueAt(selectedRowTable, 0)));
            textFieldNama.setText(String.valueOf(tableMahasiswa.getValueAt(selectedRowTable, 1)));
            comboBoxFakultas.setSelectedItem(String.valueOf(tableMahasiswa.getValueAt(selectedRowTable, 2)));
            comboBoxJurusan.setSelectedItem(String.valueOf(tableMahasiswa.getValueAt(selectedRowTable, 3)));
            textFieldNomorTelepon.setText(String.valueOf(tableMahasiswa.getValueAt(selectedRowTable, 4)));
            textFieldIPK.setText(String.valueOf(tableMahasiswa.getValueAt(selectedRowTable, 5)));
        }
        StatusUpdate = 1;
    }//GEN-LAST:event_buttonCustomEditActionPerformed

    private void buttonCustomHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCustomHapusActionPerformed
        int selectedRowTable = tableMahasiswa.getSelectedRow();

        if (selectedRowTable >= 0) {
            String NIM = String.valueOf(tableMahasiswa.getValueAt(selectedRowTable, 0));
            konek.hapusData(NIM);
            loadDataToTable();
        }

    }//GEN-LAST:event_buttonCustomHapusActionPerformed

    private void textFieldCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldCariActionPerformed

    }//GEN-LAST:event_textFieldCariActionPerformed

    private void buttonCustom1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCustom1ActionPerformed
        textFieldCari.setText("");
    }//GEN-LAST:event_buttonCustom1ActionPerformed

    private void comboBoxJurusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxJurusanActionPerformed

        String Fakultas = comboBoxFakultas.getSelectedItem().toString();

        if (Fakultas.equalsIgnoreCase("Fakultas Teknik")) {
        }
    }//GEN-LAST:event_comboBoxJurusanActionPerformed

    private void comboBoxFakultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxFakultasActionPerformed
        String selectedFakultas = comboBoxFakultas.getSelectedItem().toString();

        // Ambil daftar jurusan untuk fakultas yang dipilih
        String[] jurusan = jurusanPerFakultas.get(selectedFakultas);

        // Perbarui model ComboBox Jurusan
        DefaultComboBoxModel<String> jurusanModel = new DefaultComboBoxModel<>(jurusan);
        comboBoxJurusan.setModel(jurusanModel);
    }//GEN-LAST:event_comboBoxFakultasActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.ButtonCustom buttonCustom1;
    private button.ButtonCustom buttonCustomEdit;
    private button.ButtonCustom buttonCustomHapus;
    private button.ButtonCustom buttonCustomSimpan;
    private combo_suggestion.ComboBoxSuggestion comboBoxFakultas;
    private combo_suggestion.ComboBoxSuggestion comboBoxJurusan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.table.Table tableMahasiswa;
    private textfield.TextField textFieldCari;
    private textfield.TextField textFieldIPK;
    private textfield.TextField textFieldNIM;
    private textfield.TextField textFieldNama;
    private textfield.TextField textFieldNomorTelepon;
    // End of variables declaration//GEN-END:variables
}
