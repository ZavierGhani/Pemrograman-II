package Controller;

import DAO.BukuDAO;
import DAO.PelangganDAO;
import DAO.PenjualanDAO;
import Model.Buku;
import Model.Pelanggan;
import Model.Penjualan;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class PenjualanController {

    @FXML
    private TableView<Penjualan> tablePenjualan;

    @FXML
    private TableColumn<Penjualan, Integer> colId;

    @FXML
    private TableColumn<Penjualan, Integer> colPelanggan;

    @FXML
    private TableColumn<Penjualan, Integer> colBuku;

    @FXML
    private TableColumn<Penjualan, Integer> colJumlah;

    @FXML
    private TableColumn<Penjualan, Double> colTotal;

    @FXML
    private ComboBox<Pelanggan> cbPelanggan;

    @FXML
    private ComboBox<Buku> cbBuku;

    @FXML
    private TextField txtJumlah;

    @FXML
    private Label lblTotal;

    private PenjualanDAO penjualanDAO;
    private PelangganDAO pelangganDAO;
    private BukuDAO bukuDAO;

    private ObservableList<Penjualan> listPenjualan;

    @FXML
    public void initialize() {
        penjualanDAO = new PenjualanDAO();
        pelangganDAO = new PelangganDAO();
        bukuDAO = new BukuDAO();

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colPelanggan.setCellValueFactory(new PropertyValueFactory<>("pelangganId"));
        colBuku.setCellValueFactory(new PropertyValueFactory<>("bukuId"));
        colJumlah.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));

        cbPelanggan.setItems(FXCollections.observableArrayList(
                pelangganDAO.getAllPelanggan()
        ));

        cbBuku.setItems(FXCollections.observableArrayList(
                bukuDAO.getAllBuku()
        ));

        loadData();
    }

    private void loadData() {
        listPenjualan = FXCollections.observableArrayList(
                penjualanDAO.getAllPenjualan()
        );
        tablePenjualan.setItems(listPenjualan);
    }

    private double hitungTotal() {
        Buku buku = cbBuku.getValue();
        int jumlah = Integer.parseInt(txtJumlah.getText());
        return buku.getHarga() * jumlah;
    }

    @FXML
    private void handleTambah() {
        Pelanggan pelanggan = cbPelanggan.getValue();
        Buku buku = cbBuku.getValue();

        if (pelanggan == null || buku == null) return;

        Penjualan p = new Penjualan();
        p.setPelangganId(pelanggan.getId());
        p.setBukuId(buku.getId());
        p.setJumlah(Integer.parseInt(txtJumlah.getText()));
        p.setTotal(hitungTotal());

        penjualanDAO.insertPenjualan(p);
        showAlert("YES", "Data Penjualan berhasil ditambahkan.");
        loadData();
        clearForm();
    }

    @FXML
    private void handleUpdate() {
        Penjualan selected = tablePenjualan.getSelectionModel().getSelectedItem();
        if (selected == null) return;

        selected.setPelangganId(cbPelanggan.getValue().getId());
        selected.setBukuId(cbBuku.getValue().getId());
        selected.setJumlah(Integer.parseInt(txtJumlah.getText()));
        selected.setTotal(hitungTotal());

        penjualanDAO.updatePenjualan(selected);
        showAlert("YES", "Data Penjualan berhasil diperbarui.");
        loadData();
        clearForm();
    }

    @FXML
    private void handleHapus() {
        Penjualan selected = tablePenjualan.getSelectionModel().getSelectedItem();
        if (selected == null) return;

        penjualanDAO.deletePenjualan(selected.getId());
        showAlert("YES", "Data Penjualan berhasil dihapus.");
        loadData();
        clearForm();
    }

    private void clearForm() {
        cbPelanggan.setValue(null);
        cbBuku.setValue(null);
        txtJumlah.clear();
        lblTotal.setText("-");
    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
