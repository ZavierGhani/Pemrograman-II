package DAO;

import Model.Pelanggan;
import DB.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PelangganDAO {

    private Connection conn;

    public PelangganDAO() {
        conn = DBConnection.getConnection();
    }

    // ===== READ =====
    public List<Pelanggan> getAllPelanggan() {
        List<Pelanggan> list = new ArrayList<>();
        String sql = "SELECT * FROM pelanggan";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Pelanggan p = new Pelanggan();
                p.setId(rs.getInt("id"));
                p.setNama(rs.getString("nama"));
                p.setEmail(rs.getString("email"));
                p.setTelepon(rs.getString("telepon"));
                list.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // ===== CREATE =====
    public void insertPelanggan(Pelanggan p) {
        String sql = "INSERT INTO pelanggan (nama, email, telepon) VALUES (?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNama());
            ps.setString(2, p.getEmail());
            ps.setString(3, p.getTelepon());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ===== UPDATE =====
    public void updatePelanggan(Pelanggan p) {
        String sql = "UPDATE pelanggan SET nama=?, email=?, telepon=? WHERE id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNama());
            ps.setString(2, p.getEmail());
            ps.setString(3, p.getTelepon());
            ps.setInt(4, p.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ===== DELETE =====
    public void deletePelanggan(int id) {
        String sql = "DELETE FROM pelanggan WHERE id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

