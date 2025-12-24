package DAO;

import Model.Penjualan;
import DB.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PenjualanDAO {

    private Connection conn;

    public PenjualanDAO() {
        conn = DBConnection.getConnection();
    }

    // ===== READ =====
    public List<Penjualan> getAllPenjualan() {
        List<Penjualan> list = new ArrayList<>();
        String sql = "SELECT * FROM penjualan";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Penjualan p = new Penjualan();
                p.setId(rs.getInt("id"));
                p.setPelangganId(rs.getInt("pelanggan_id"));
                p.setBukuId(rs.getInt("buku_id"));
                p.setJumlah(rs.getInt("jumlah"));
                p.setTotal(rs.getDouble("total"));

                list.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // ===== CREATE =====
    public void insertPenjualan(Penjualan p) {
        String sql = "INSERT INTO penjualan (pelanggan_id, buku_id, jumlah, total) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, p.getPelangganId());
            ps.setInt(2, p.getBukuId());
            ps.setInt(3, p.getJumlah());
            ps.setDouble(4, p.getTotal());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ===== UPDATE =====
    public void updatePenjualan(Penjualan p) {
        String sql = "UPDATE penjualan SET pelanggan_id=?, buku_id=?, jumlah=?, total=? WHERE id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, p.getPelangganId());
            ps.setInt(2, p.getBukuId());
            ps.setInt(3, p.getJumlah());
            ps.setDouble(4, p.getTotal());
            ps.setInt(5, p.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ===== DELETE ===
    public void deletePenjualan(int id) {
        String sql = "DELETE FROM penjualan WHERE id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
