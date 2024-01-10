package Controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MainController{

    @FXML
    private AnchorPane root; // Initialize root

    private Parent fxml;

    Connection cnx;

    @FXML
    private Button exit_btn;

   

    @FXML
    void exit_btn(ActionEvent event) throws SQLException {
        System.exit(0);
    }

    @FXML
    void btn_acceuille(ActionEvent event) throws IOException {

        fxml = FXMLLoader.load(getClass().getResource("/interfaces/Acceuille.fxml"));
        root.getChildren().removeAll();
        root.getChildren().setAll(fxml);

    }

    @FXML
    void btn_employes(ActionEvent event) throws IOException {
        fxml = FXMLLoader.load(getClass().getResource("/interfaces/employes.fxml"));
        root.getChildren().removeAll();
        root.getChildren().setAll(fxml);
    }
}
