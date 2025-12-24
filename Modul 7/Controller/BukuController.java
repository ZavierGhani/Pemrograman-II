package Controller;

import DAO.BukuDAO;
import Model.Buku;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class BukuController {

    @FXML private TableView<Buku> tableBuku;
    @FXML private TableColumn<Buku, Integer> colId;
    @FXML private TableColumn<Buku, String> colJudul;
    @FXML private TableColumn<Buku, String> colPenulis;
    @FXML private TableColumn<Buku, Double> colHarga;
    @FXML private TableColumn<Buku, Integer> colStok;

    @FXML private TextField txtJudul;
    @FXML private TextField txtPenulis;
    @FXML private TextField txtHarga;
    @FXML private TextField txtStok;

    private BukuDAO bukuDAO;
    private ObservableList<Buku> listBuku;

    @FXML
    public void initialize() {
        bukuDAO = new BukuDAO();

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colJudul.setCellValueFactory(new PropertyValueFactory<>("judul"));
        colPenulis.setCellValueFactory(new PropertyValueFactory<>("penulis"));
        colHarga.setCellValueFactory(new PropertyValueFactory<>("harga"));
        colStok.setCellValueFactory(new PropertyValueFactory<>("stok"));

        loadData();

        tableBuku.getSelectionModel().selectedItemProperty()
                .addListener((obs, oldVal, selected) -> {
                    if (selected != null) {
                        txtJudul.setText(selected.getJudul());
                        txtPenulis.setText(selected.getPenulis());
                        txtHarga.setText(String.valueOf(selected.getHarga()));
                        txtStok.setText(String.valueOf(selected.getStok()));
                    }
                });
    }

    private void loadData() {
        listBuku = FXCollections.observableArrayList(bukuDAO.getAllBuku());
        tableBuku.setItems(listBuku);
    }

    @FXML
    private void handleTambah() {
        Buku buku = new Buku();
        buku.setJudul(txtJudul.getText());
        buku.setPenulis(txtPenulis.getText());
        buku.setHarga(Double.parseDouble(txtHarga.getText()));
        buku.setStok(Integer.parseInt(txtStok.getText()));

        bukuDAO.insertBuku(buku);
        showAlert("YES", "Data Buku berhasil ditambahkan.");
        loadData();
        clearForm();
    }

    @FXML
    private void handleUpdate() {
        Buku selected = tableBuku.getSelectionModel().getSelectedItem();
        if (selected == null) return;

        selected.setJudul(txtJudul.getText());
        selected.setPenulis(txtPenulis.getText());
        selected.setHarga(Double.parseDouble(txtHarga.getText()));
        selected.setStok(Integer.parseInt(txtStok.getText()));

        bukuDAO.updateBuku(selected);
        showAlert("YES", "Data Buku berhasil diperbarui.");

        loadData();
        clearForm();
    }

    @FXML
    private void handleHapus() {
        Buku selected = tableBuku.getSelectionModel().getSelectedItem();
        if (selected == null) return;

        bukuDAO.deleteBuku(selected.getId());
        showAlert("YES", "Data Buku berhasil dihapus.");

        loadData();
        clearForm();
    }

    private void clearForm() {
        txtJudul.clear();
        txtPenulis.clear();
        txtHarga.clear();
        txtStok.clear();
        tableBuku.getSelectionModel().clearSelection();
    }
    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
