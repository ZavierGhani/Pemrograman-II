package DAO;

import Model.Buku;
import DB.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BukuDAO {

    private Connection conn;

    public BukuDAO() {
        conn = DBConnection.getConnection();
    }

    // ===== CREATE =====
    public void insertBuku(Buku buku) {
        String sql = "INSERT INTO buku (judul, penulis, harga, stok) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, buku.getJudul());
            ps.setString(2, buku.getPenulis());
            ps.setDouble(3, buku.getHarga());
            ps.setInt(4, buku.getStok());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ===== READ =====
    public List<Buku> getAllBuku() {
        List<Buku> list = new ArrayList<>();
        String sql = "SELECT * FROM buku";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Buku buku = new Buku(
                        rs.getInt("id"),
                        rs.getString("judul"),
                        rs.getString("penulis"),
                        rs.getDouble("harga"),
                        rs.getInt("stok")
                );
                list.add(buku);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // ===== UPDATE =====
    public void updateBuku(Buku buku) {
        String sql = "UPDATE buku SET judul=?, penulis=?, harga=?, stok=? WHERE id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, buku.getJudul());
            ps.setString(2, buku.getPenulis());
            ps.setDouble(3, buku.getHarga());
            ps.setInt(4, buku.getStok());
            ps.setInt(5, buku.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ===== DELETE =====
    public void deleteBuku(int id) {
        String sql = "DELETE FROM buku WHERE id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

