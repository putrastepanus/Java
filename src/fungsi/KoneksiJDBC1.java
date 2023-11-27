/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fungsi;

/**
 *
 * @author stepa
 */
import java.sql.*;
import com.raven.swing.table.Table;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;

public class KoneksiJDBC1 {

    public Connection getConnection() {
        String host = "localhost";
        String port = "1521";
        String db = "xe";
        String usr = "hr";
        String pwd = "MHS225314060";

        // Load driver class
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException ex) {
            System.out.println("Maaf, driver class tidak ditemukan");
            System.out.println(ex.getMessage());
        }

        // Hubungkan ke sumber data 
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@" + host + ":" + port + ":" + db, usr, pwd);
        } catch (SQLException ex) {
            System.out.println("Maaf, koneksi tidak berhasil.");
            System.out.println(ex.getMessage());
        }
        if (conn != null) {
            System.out.println("Koneksi ke database berhasil terbentuk");
        } else {
            System.out.println("Maaf, koneksi ke database gagal terbentuk");
        }
        return conn;
    }

    public void showData(Table dataTabel) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        
        conn = this.getConnection();
        
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM MAHASISWA");

        DefaultTableModel model = (DefaultTableModel) dataTabel.getModel();
        model.setRowCount(0); // Membersihkan data yang ada pada model tabel

            while (rs.next()) {
                Object[] rowData = {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getFloat(6)
                };
                model.addRow(rowData);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
//                System.out.println("Database Tertutup");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void inputData(String NIM, String NAMA,String FAKULTAS, String JURUSAN, String NO_HP, Float IPK) {
        Connection conn = null;
        PreparedStatement ps = null;

        conn = this.getConnection();

        try {
            ps = conn.prepareStatement("INSERT INTO MAHASISWA values(?,?,?,?,?,?)");
            ps.setString(1, NIM);
            ps.setString(2, NAMA);
            ps.setString(3, FAKULTAS);
            ps.setString(4, JURUSAN);
            ps.setString(5, NO_HP);
            ps.setFloat(6, IPK);
            
            ps.executeUpdate();
            conn.setAutoCommit(false);
            conn.commit();
            System.out.println("Data sudah di-SIMPAN!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());;
        } finally {
            try {
                ps.close();
                conn.close();
                System.out.println("Database Tertutup");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void hapusData(String NIM) {
        Connection conn = null;
        PreparedStatement ps = null;
        conn = this.getConnection();
        
        try {
            ps = conn.prepareStatement("DELETE FROM MAHASISWA WHERE NIM = ?");
            ps.setString(1, NIM);
            
            ps.executeUpdate();
            conn.setAutoCommit(false);
            conn.commit();
            System.out.println("Data sudah di-HAPUS!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void updateData(String NIM, String NAMA,String FAKULTAS, String JURUSAN, String NO_HP, Float IPK) {
        Connection conn = null;
        PreparedStatement ps = null;

        conn = this.getConnection();
        String update = "UPDATE MAHASISWA SET NAMA = ?, FAKULTAS = ?, JURUSAN = ?, NO_TELEPON = ?, IPK = ? WHERE NIM = ?";
        try {
            ps = conn.prepareStatement(update);
            ps.setString(1, NAMA);
            ps.setString(2, FAKULTAS);
            ps.setString(3, JURUSAN);
            ps.setString(4, NO_HP);
            ps.setFloat(5, IPK);
            ps.setString(6, NIM);
            ps.executeUpdate();
            conn.setAutoCommit(false);
            conn.commit();
            System.out.println("Data sudah di-UPDATE!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
