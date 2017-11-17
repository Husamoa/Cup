package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.FormValidation;
import model.Table;
import java.net.URL;
import java.util.*;


public class Controller implements Initializable {

    // Players. 1/8 cup.

    @FXML
    private Label player1, player2, player3, player4, player5, player6, player7, player8;

    // Label to score.

    @FXML
    private TextField textField1, textField2, textField3, textField4, textField5, textField6, textField7;
    @FXML
    private TextField textField8, textField9, textField10, textField11, textField12, textField13, textField14;


    // 1/4 final.
    @FXML
    public Label label1, label2, label3, label4;

    // 1/2 final.

    @FXML
    public Label label5, label6;

    // Winner.

    @FXML
    public Label label7;

    // Defined table - player list.

    @FXML
    TableView<Table> playersList;
    @FXML
    TableColumn<Table, String> iName;
    @FXML
    TableColumn<Table, String> iSurname;
    @FXML
    TableColumn<Table, String> iCity;

    @FXML
    TextField nameInput, surnameInput, cityInput;
    @FXML
    Label nameLabel;
    @FXML
    Label surnameLabel;
    @FXML
    Label cityLabel;


    // Data in table.

    public ObservableList<Table> data = FXCollections.observableArrayList();

    // Adding players in table.

    @FXML
    public void setAdd(ActionEvent event) {


        // FORM VALIDATION
        
        boolean name = FormValidation.textFieldNotEpmty(nameInput, nameLabel, "Wpisz imię!");
        boolean surname = FormValidation.textFieldNotEpmty(surnameInput, surnameLabel, "Wpisz nazwisko!");
        boolean city = FormValidation.textFieldNotEpmty(cityInput, cityLabel, "Wpisz miasto!");

        if (name && surname && city) {
            Table entry = new Table(nameInput.getText(), surnameInput.getText(), cityInput.getText());

            data.add(entry);

            clearForm();
        }

    }

    private void clearForm() {

        nameInput.clear();
        surnameInput.clear();
        cityInput.clear();

    }

    @FXML
    public void setDelete (ActionEvent event ) {

        int selectedRow = playersList.getSelectionModel().getSelectedIndex();
        if (selectedRow >= 0) {
            playersList.getItems().remove(selectedRow);
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Brak zaznaczenia");
            alert.setHeaderText("Nie zaznaczono zawodnika!");
            alert.setContentText("Proszę zaznaczyć zawodnika w tabeli.");

            alert.showAndWait();
        }

    }


    @FXML
    public void winner1() {

        // Change String to int.

        int score1 = Integer.parseInt(textField1.getText());
        int score2 = Integer.parseInt(textField2.getText());

        if (score1 > score2) {
            label1.setText(player1.getText());
        } else {
            label1.setText(player2.getText());
        }
    }

    @FXML
    public void winner2() {

        int score3 = Integer.parseInt(textField3.getText());
        int score4 = Integer.parseInt(textField4.getText());

        if (score3 > score4) {
            label2.setText(player3.getText());
        } else {
            label2.setText(player4.getText());
        }
    }

    @FXML
    public void winner3() {

        int score5 = Integer.parseInt(textField5.getText());
        int score6 = Integer.parseInt(textField6.getText());

        if (score5 > score6) {
            label3.setText(player5.getText());
        } else {
            label3.setText(player6.getText());
        }
    }

    @FXML

    public void winner4() {

        int score7 = Integer.parseInt(textField7.getText());
        int score8 = Integer.parseInt(textField8.getText());

        if (score7 > score8) {
            label4.setText(player7.getText());
        } else {
            label4.setText(player8.getText());
        }
    }

    @FXML
    public void winner5() {

        int score3 = Integer.parseInt(textField9.getText());
        int score4 = Integer.parseInt(textField10.getText());

        if (score3 > score4) {
            label5.setText(label1.getText());
        } else {
            label5.setText(label2.getText());
        }
    }

    @FXML
    public void winner6() {

        int score3 = Integer.parseInt(textField11.getText());
        int score4 = Integer.parseInt(textField12.getText());

        if (score3 > score4) {
            label6.setText(label3.getText());
        } else {
            label6.setText(label4.getText());
        }
    }

    @FXML
    public void winner7() {

        int score3 = Integer.parseInt(textField13.getText());
        int score4 = Integer.parseInt(textField14.getText());

        if (score3 > score4) {
            label7.setText(label5.getText());
        } else {
            label7.setText(label6.getText());
        }
    }



    @FXML
    public void initialize(URL location, ResourceBundle resources) {

        iName.setCellValueFactory(new PropertyValueFactory<>("rName"));
        iSurname.setCellValueFactory(new PropertyValueFactory<>("rSurname"));
        iCity.setCellValueFactory(new PropertyValueFactory<>("rCity"));

        playersList.setItems(data);

    }

    @FXML
    public void setShuffle() {

        FXCollections.shuffle(data);

        player1.setText(String.valueOf(iName.getCellData(0) + " " + iSurname.getCellData(0)));
        player2.setText(String.valueOf(iName.getCellData(1) + " " + iSurname.getCellData(1)));
        player3.setText(String.valueOf(iName.getCellData(2) + " " + iSurname.getCellData(2)));
        player4.setText(String.valueOf(iName.getCellData(3) + " " + iSurname.getCellData(3)));
        player5.setText(String.valueOf(iName.getCellData(4) + " " + iSurname.getCellData(4)));
        player6.setText(String.valueOf(iName.getCellData(5) + " " + iSurname.getCellData(5)));
        player7.setText(String.valueOf(iName.getCellData(6) + " " + iSurname.getCellData(6)));
        player8.setText(String.valueOf(iName.getCellData(7) + " " + iSurname.getCellData(7)));

    }
}
