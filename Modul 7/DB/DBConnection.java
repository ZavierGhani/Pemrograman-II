package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // GANTI sesuai konfigurasi MySQL kamu
    private static final String URL = "jdbc:mysql://localhost:3306/db_toko_buku_za";
    private static final String USER = "root";
    private static final String PASS = "";

    // Method untuk mendapatkan koneksi
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Koneksi ke database BERHASIL");
        } catch (SQLException e) {
            System.out.println("Koneksi ke database GAGAL");
            e.printStackTrace();
        }
        return conn;
    }
}
