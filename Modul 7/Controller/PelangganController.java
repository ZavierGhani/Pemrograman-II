package Controller;

import DAO.PelangganDAO;
import Model.Pelanggan;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class PelangganController {

    @FXML private TextField txtNama;
    @FXML private TextField txtEmail;
    @FXML private TextField txtTelepon;

    @FXML private TableView<Pelanggan> tablePelanggan;
    @FXML private TableColumn<Pelanggan, Integer> colId;
    @FXML private TableColumn<Pelanggan, String> colNama;
    @FXML private TableColumn<Pelanggan, String> colEmail;
    @FXML private TableColumn<Pelanggan, String> colTelepon;

    private PelangganDAO pelangganDAO;
    private ObservableList<Pelanggan> listPelanggan;

    @FXML
    public void initialize() {
        pelangganDAO = new PelangganDAO();

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTelepon.setCellValueFactory(new PropertyValueFactory<>("telepon"));

        loadData();

        tablePelanggan.getSelectionModel().selectedItemProperty()
                .addListener((obs, oldVal, selected) -> {
                    if (selected != null) {
                        txtNama.setText(selected.getNama());
                        txtEmail.setText(selected.getEmail());
                        txtTelepon.setText(selected.getTelepon());
                    }
                });
    }

    private void loadData() {
        listPelanggan = FXCollections.observableArrayList(
                pelangganDAO.getAllPelanggan()
        );
        tablePelanggan.setItems(listPelanggan);
    }

    @FXML
    private void tambahPelanggan() {
        Pelanggan p = new Pelanggan();
        p.setNama(txtNama.getText());
        p.setEmail(txtEmail.getText());
        p.setTelepon(txtTelepon.getText());

        pelangganDAO.insertPelanggan(p);
        
        showAlert("YES", "Data Pelanggan berhasil ditambahkan.");
        clearForm();
        loadData();
    }

    @FXML
    private void updatePelanggan() {
        Pelanggan selected = tablePelanggan.getSelectionModel().getSelectedItem();
        if (selected == null) return;

        selected.setNama(txtNama.getText());
        selected.setEmail(txtEmail.getText());
        selected.setTelepon(txtTelepon.getText());

        pelangganDAO.updatePelanggan(selected);
        showAlert("YES", "Data Pelanggan berhasil diperbarui.");
        clearForm();
        loadData();
    }

    @FXML
    private void hapusPelanggan() {
        Pelanggan selected = tablePelanggan.getSelectionModel().getSelectedItem();
        if (selected == null) return;

        pelangganDAO.deletePelanggan(selected.getId());
        showAlert("YES", "Data Pelanggan berhasil dihapus.");
        clearForm();
        loadData();
    }

    private void clearForm() {
        txtNama.clear();
        txtEmail.clear();
        txtTelepon.clear();
        tablePelanggan.getSelectionModel().clearSelection();
    }
    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}




