package Controllers;
import models.employes;
import ConnectionDB.ConnectionDB;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class employesController implements Initializable {

    Connection cnx ;
    public PreparedStatement st ;
    public ResultSet result ;
    public ObservableList<employes> data = FXCollections.observableArrayList();

    
    @FXML
    private TableColumn<employes, String> cln_dip;

    @FXML
    private TableColumn<employes, String> cln_function;

    @FXML
    private TableColumn<employes, Integer> cln_id;

    @FXML
    private TableColumn<employes, Integer> cln_ndep;

    @FXML
    private TableColumn<employes, String> cln_nom;

    @FXML
    private TableColumn<employes, String> cln_prenom;

    @FXML
    private TableColumn<employes, String> cln_sit;

    @FXML
    private TableView<employes> employes;


    public void showEmployes(){
        employes.getItems().clear();
        String sql = "SELECT * FROM EMPLOYE_D ORDER BY NUM_EMP " ;

        try {
            st = cnx.prepareStatement(sql);
            System.out.println("Executing SQL query: " + sql);
            result = st.executeQuery();
            while(result.next()) {
			data.add(new employes(result.getInt("NUM_EMP"),result.getString("NOM_EMP"),result.getString("PRENOM_EMP"),result.getString("FONCTION"),result.getString("SITUATION_FAMILIALE"),result.getString("DIPLOME"),result.getInt("NUM_DEPT")));
			}
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        cln_id.setCellValueFactory(new PropertyValueFactory<employes, Integer>("id"));
        cln_nom.setCellValueFactory(new PropertyValueFactory<employes, String>("nom"));
        cln_prenom.setCellValueFactory(new PropertyValueFactory<employes, String>("prenom"));
        cln_function.setCellValueFactory(new PropertyValueFactory<employes, String>("function"));
        cln_sit.setCellValueFactory(new PropertyValueFactory<employes, String>("situation_f"));
        cln_dip.setCellValueFactory(new PropertyValueFactory<employes, String>("diplome"));
        cln_ndep.setCellValueFactory(new PropertyValueFactory<employes, Integer>("num_dept"));


        employes.setItems(data);
        
		


    }

    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cnx = ConnectionDB.cnx();
		showEmployes();		

	}
    
}
