package Controller;

import Model.Mahasiswa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MahasiswaController {

    @FXML
    private TableView<Mahasiswa> tableMahasiswa;

    @FXML
    private TableColumn<Mahasiswa, String> colNim;

    @FXML
    private TableColumn<Mahasiswa, String> colNama;

    @FXML
    public void initialize() {

        colNim.setCellValueFactory(new PropertyValueFactory<>("nim"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));

        tableMahasiswa.setItems(getDataMahasiswa());
    }

    private ObservableList<Mahasiswa> getDataMahasiswa() {
        return FXCollections.observableArrayList(
            new Mahasiswa(2, "Zavier", "0205"),
            new Mahasiswa(8, "Niska", "0206"),
            new Mahasiswa(1, "Prince", "0707"),
            new Mahasiswa(4, "Amanda", "1103"),
            new Mahasiswa(5, "Marcus", "1101"),
            new Mahasiswa(6, "Brenda", "1203"),
            new Mahasiswa(9, "Yesaya", "1204"),
            new Mahasiswa(3, "Livy", "1606"),
            new Mahasiswa(7, "Almer", "1709"),
            new Mahasiswa(10, "Royce", "1911")
        );
    }
}
