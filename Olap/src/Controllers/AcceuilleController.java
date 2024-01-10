package Controllers;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import ConnectionDB.ConnectionDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import models.Rapidite;
import models.Rapidite_c;
public class AcceuilleController implements Initializable {

    Connection cnx ;
    public PreparedStatement st ;
    public ResultSet result ;
    public ObservableList<Rapidite> data = FXCollections.observableArrayList();
    public ObservableList<Rapidite_c> dataa = FXCollections.observableArrayList();

    @FXML
    private TableView<Rapidite> Trapidite;

    @FXML
    private ChoiceBox<String> box1;

    @FXML
    private ChoiceBox<String> box2;

    @FXML
    private ChoiceBox<String> box3;

    @FXML
    private ChoiceBox<String> box4;

    @FXML
    private TableColumn<Rapidite, String> cln_1;

    @FXML
    private TableColumn<Rapidite, String> cln_2;

    @FXML
    private TableColumn<Rapidite, String> cln_3;

    @FXML
    private TableColumn<Rapidite, String> cln_4;

    @FXML
    private TableColumn<Rapidite, Float> cln_5;

    @FXML
    private TableColumn<Rapidite, Float> cln_6;

    @FXML
    private TableColumn<Rapidite, Float> cln_7;

    @FXML
    private TableColumn<Rapidite, Float> cln_8;

    @FXML
    private TableColumn<Rapidite, Float> cln_9;

    @FXML
    private AnchorPane root;

    @FXML
    void btn_max(ActionEvent event) {

        Trapidite.getItems().clear();
        
        String sql = "SELECT *\r\n" + //
                "FROM (SELECT\r\n" + //
                "    rapidite.client_d.nom_client,\r\n" + //
                "    rapidite.produit_d.nom_prod,\r\n" + //
                "    rapidite.employe_d.nom_emp,\r\n" + //
                "    rapidite.mois_d.designation_mois,\r\n" + //
                "    rapidite.rapidite_f.nbr_jours_retard,\r\n" + //
                "    rapidite.rapidite_f.duree_prevue,\r\n" + //
                "    rapidite.rapidite_f.duree_reelle\r\n" + //
                "FROM\r\n" + //
                "         rapidite.rapidite_f\r\n" + //
                "    INNER JOIN rapidite.client_d ON rapidite.rapidite_f.code_client = rapidite.client_d.code_client\r\n" + //
                "    INNER JOIN rapidite.pays_d ON rapidite.client_d.num_pays = rapidite.pays_d.num_pays\r\n" + //
                "    INNER JOIN rapidite.employe_d ON rapidite.rapidite_f.num_emp = rapidite.employe_d.num_emp\r\n" + //
                "    INNER JOIN rapidite.departement_d ON rapidite.employe_d.num_dept = rapidite.departement_d.num_dept\r\n" + //
                "    INNER JOIN rapidite.produit_d ON rapidite.rapidite_f.num_prod = rapidite.produit_d.num_prod\r\n" + //
                "    INNER JOIN rapidite.categorie_d ON rapidite.produit_d.num_cat = rapidite.categorie_d.num_cat\r\n" + //
                "    INNER JOIN rapidite.fournisseur_d ON rapidite.produit_d.num_fourn = rapidite.fournisseur_d.num_fourn\r\n" + //
                "    INNER JOIN rapidite.mois_d ON rapidite.rapidite_f.num_mois = rapidite.mois_d.num_mois\r\n" + //
                "    INNER JOIN rapidite.saison_d ON rapidite.mois_d.num_saison = rapidite.saison_d.num_saison\r\n" + //
                "    INNER JOIN rapidite.annee_d ON rapidite.mois_d.num_annee = rapidite.annee_d.num_annee)\r\n" + //
                "WHERE nbr_jours_retard = (SELECT MAX(nbr_jours_retard) FROM rapidite_f)" ;

         try {
            st = cnx.prepareStatement(sql);
            result = st.executeQuery();
            while(result.next()) {
			data.add(new Rapidite(result.getString("nom_client"),result.getString("nom_prod"),result.getString("nom_emp"),result.getString("Designation_mois"),0,0,result.getInt("nbr_jours_retard"),result.getInt("duree_prevue"),result.getInt("duree_reelle")));
			}
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        cln_1.setText(null);
        cln_2.setText(null);
        cln_3.setText(null);
        cln_4.setText("nom Employe");
        cln_5.setText("Nbr jours retard");
        cln_6.setText("Duree Prevue");
        cln_7.setText("Duree reelle");
        cln_8.setText(null);
        cln_9.setText(null);

        cln_1.setCellValueFactory(null);
        cln_2.setCellValueFactory(null);
        cln_3.setCellValueFactory(null);
        cln_4.setCellValueFactory(new PropertyValueFactory<Rapidite,String>("num_emp"));
        cln_5.setCellValueFactory(new PropertyValueFactory<Rapidite,Float>("nbr_jours_retard"));
        cln_6.setCellValueFactory(new PropertyValueFactory<Rapidite, Float>("duree_prevue"));
        cln_7.setCellValueFactory(new PropertyValueFactory<Rapidite, Float>("duree_reel"));
        cln_8.setCellValueFactory(null);
        cln_9.setCellValueFactory(null);

        Trapidite.setItems(data);
	

    }



    @FXML
    void btn_min(ActionEvent event) {

        Trapidite.getItems().clear();
        
        String sql = "SELECT *\r\n" + //
                "FROM (SELECT\r\n" + //
                "    rapidite.client_d.nom_client,\r\n" + //
                "    rapidite.produit_d.nom_prod,\r\n" + //
                "    rapidite.employe_d.nom_emp,\r\n" + //
                "    rapidite.mois_d.designation_mois,\r\n" + //
                "    rapidite.rapidite_f.nbr_jours_retard,\r\n" + //
                "    rapidite.rapidite_f.duree_prevue,\r\n" + //
                "    rapidite.rapidite_f.duree_reelle\r\n" + //
                "FROM\r\n" + //
                "         rapidite.rapidite_f\r\n" + //
                "    INNER JOIN rapidite.client_d ON rapidite.rapidite_f.code_client = rapidite.client_d.code_client\r\n" + //
                "    INNER JOIN rapidite.pays_d ON rapidite.client_d.num_pays = rapidite.pays_d.num_pays\r\n" + //
                "    INNER JOIN rapidite.employe_d ON rapidite.rapidite_f.num_emp = rapidite.employe_d.num_emp\r\n" + //
                "    INNER JOIN rapidite.departement_d ON rapidite.employe_d.num_dept = rapidite.departement_d.num_dept\r\n" + //
                "    INNER JOIN rapidite.produit_d ON rapidite.rapidite_f.num_prod = rapidite.produit_d.num_prod\r\n" + //
                "    INNER JOIN rapidite.categorie_d ON rapidite.produit_d.num_cat = rapidite.categorie_d.num_cat\r\n" + //
                "    INNER JOIN rapidite.fournisseur_d ON rapidite.produit_d.num_fourn = rapidite.fournisseur_d.num_fourn\r\n" + //
                "    INNER JOIN rapidite.mois_d ON rapidite.rapidite_f.num_mois = rapidite.mois_d.num_mois\r\n" + //
                "    INNER JOIN rapidite.saison_d ON rapidite.mois_d.num_saison = rapidite.saison_d.num_saison\r\n" + //
                "    INNER JOIN rapidite.annee_d ON rapidite.mois_d.num_annee = rapidite.annee_d.num_annee)\r\n" + //
                "WHERE nbr_jours_retard = (SELECT MIN(nbr_jours_retard) FROM rapidite_f)" ;

         try {
            st = cnx.prepareStatement(sql);
            result = st.executeQuery();
            while(result.next()) {
			data.add(new Rapidite(result.getString("nom_client"),result.getString("nom_prod"),result.getString("nom_emp"),result.getString("Designation_mois"),0,0,result.getInt("nbr_jours_retard"),result.getInt("duree_prevue"),result.getInt("duree_reelle")));
			}
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        cln_1.setText(null);
        cln_2.setText(null);
        cln_3.setText(null);
        cln_4.setText("nom Employe");
        cln_5.setText("Nbr jours retard");
        cln_6.setText("Duree Prevue");
        cln_7.setText("Duree reelle");
        cln_8.setText(null);
        cln_9.setText(null);

        cln_1.setCellValueFactory(null);
        cln_2.setCellValueFactory(null);
        cln_3.setCellValueFactory(null);
        cln_4.setCellValueFactory(new PropertyValueFactory<Rapidite,String>("num_emp"));
        cln_5.setCellValueFactory(new PropertyValueFactory<Rapidite,Float>("nbr_jours_retard"));
        cln_6.setCellValueFactory(new PropertyValueFactory<Rapidite, Float>("duree_prevue"));
        cln_7.setCellValueFactory(new PropertyValueFactory<Rapidite, Float>("duree_reel"));
        cln_8.setCellValueFactory(null);
        cln_9.setCellValueFactory(null);

        Trapidite.setItems(data);

    }

        @FXML
    void groupe(ActionEvent event) {

        if (box1.getValue()== "Client" && box2.getValue()=="Product" && box3.getValue()== "Employe" && box4.getValue()=="Mois") {

        A(); }

        if (box1.getValue()== "Pays" && box2.getValue()=="Product" && box3.getValue()== "Employe" && box4.getValue()=="Mois") {

        B(); }

         if (box1.getValue()== "All" && box2.getValue()=="Product" && box3.getValue()== "Employe" && box4.getValue()=="Mois") {

        C(); }

        if (box1.getValue()== "Client" && box2.getValue()=="Fournisseur" && box3.getValue()== "Employe" && box4.getValue()=="Mois") {

        D(); }

        if (box1.getValue()== "Client" && box2.getValue()=="Categorie" && box3.getValue()== "Employe" && box4.getValue()=="Mois") {

        E(); }

         if (box1.getValue()== "Client" && box2.getValue()=="All" && box3.getValue()== "Employe" && box4.getValue()=="Mois") {

        F(); }

        if (box1.getValue()== "Client" && box2.getValue()=="Product" && box3.getValue()== "Departements" && box4.getValue()=="Mois") {

        G(); }

        if (box1.getValue()== "Client" && box2.getValue()=="Product" && box3.getValue()== "All" && box4.getValue()=="Mois") {

        H(); }

        if (box1.getValue()== "Client" && box2.getValue()=="Product" && box3.getValue()== "Employe" && box4.getValue()=="Saison") {

        J();}

        if (box1.getValue()== "Client" && box2.getValue()=="Product" && box3.getValue()== "Employe" && box4.getValue()=="Annees") {

        K();}

         if (box1.getValue()== "Client" && box2.getValue()=="Product" && box3.getValue()== "Employe" && box4.getValue()=="All") {

        L();}

         if (box1.getValue()== "All" && box2.getValue()=="All" && box3.getValue()== "All" && box4.getValue()=="All") {

        M();}

        if (box1.getValue()== "All" && box2.getValue()=="Categorie" && box3.getValue()== "Departements" && box4.getValue()=="Saison") {

        N();}



    }

    private String [] Dimention1 = {"Client","Pays","All"} ;
    private String [] Dimention2 = {"Product","Fournisseur","Categorie","All"} ;
    private String [] Dimention3 = {"Employe","Departements","All"} ;
    private String [] Dimention4 = {"Mois","Saison","Annees","All"} ;

    public void A(){

        Trapidite.getItems().clear();
        String sql = "SELECT\r\n" + //
                "    rapidite.client_d.code_client,\r\n" + //
                "    rapidite.produit_d.nom_prod,\r\n" + //
                "    rapidite.employe_d.nom_emp,\r\n" + //
                "    rapidite.mois_d.designation_mois,\r\n" + //
                "    rapidite.rapidite_f.retard_debut,\r\n" + //
                "    rapidite.rapidite_f.retard_fin,\r\n" + //
                "    rapidite.rapidite_f.nbr_jours_retard,\r\n" + //
                "    rapidite.rapidite_f.duree_prevue,\r\n" + //
                "    rapidite.rapidite_f.duree_reelle\r\n" + //
                "FROM\r\n" + //
                "         rapidite.rapidite_f\r\n" + //
                "    INNER JOIN rapidite.client_d ON rapidite.rapidite_f.code_client = rapidite.client_d.code_client\r\n" + //
                "    INNER JOIN rapidite.employe_d ON rapidite.rapidite_f.num_emp = rapidite.employe_d.num_emp\r\n" + //
                "    INNER JOIN rapidite.departement_d departement_d1 ON rapidite.employe_d.num_dept = departement_d1.num_dept\r\n" + //
                "    INNER JOIN rapidite.produit_d ON rapidite.rapidite_f.num_prod = rapidite.produit_d.num_prod\r\n" + //
                "    INNER JOIN rapidite.categorie_d ON rapidite.produit_d.num_cat = rapidite.categorie_d.num_cat\r\n" + //
                "    INNER JOIN rapidite.fournisseur_d ON rapidite.produit_d.num_fourn = rapidite.fournisseur_d.num_fourn\r\n" + //
                "    INNER JOIN rapidite.mois_d ON rapidite.rapidite_f.num_mois = rapidite.mois_d.num_mois\r\n" + //
                "    INNER JOIN rapidite.saison_d ON rapidite.mois_d.num_saison = rapidite.saison_d.num_saison\r\n" + //
                "    INNER JOIN rapidite.annee_d ON rapidite.mois_d.num_annee = rapidite.annee_d.num_annee\r\n" + //
                "    INNER JOIN rapidite.pays_d ON rapidite.pays_d.num_pays = rapidite.client_d.num_pays " ;

        try {
            st = cnx.prepareStatement(sql);
            result = st.executeQuery();
            while(result.next()) {
			data.add(new Rapidite(result.getString("Code_client"),result.getString("nom_prod"),result.getString("nom_emp"),result.getString("Designation_mois"),result.getInt("retard_debut"),result.getInt("retard_fin"),result.getInt("nbr_jours_retard"),result.getInt("duree_prevue"),result.getInt("duree_reelle")));
			}
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        cln_1.setText("Code client");
        cln_2.setText("Nom Produit");
        cln_3.setText("nom Employe");
        cln_4.setText("designation Mois");
        cln_5.setText("Retard Debut");
        cln_6.setText("Retard Fin");
        cln_7.setText("Nbr jours retard");
        cln_8.setText("Duree Prevue");
        cln_9.setText("Duree reelle");

        cln_1.setCellValueFactory(new PropertyValueFactory<Rapidite, String>("code_client"));
        cln_2.setCellValueFactory(new PropertyValueFactory<Rapidite,String>("num_prod"));
        cln_3.setCellValueFactory(new PropertyValueFactory<Rapidite,String>("num_emp"));
        cln_4.setCellValueFactory(new PropertyValueFactory<Rapidite,String>("num_mois"));
        cln_5.setCellValueFactory(new PropertyValueFactory<Rapidite,Float>("retard_debut"));
        cln_6.setCellValueFactory(new PropertyValueFactory<Rapidite,Float>("retard_fin"));
        cln_7.setCellValueFactory(new PropertyValueFactory<Rapidite,Float>("nbr_jours_retard"));
        cln_8.setCellValueFactory(new PropertyValueFactory<Rapidite, Float>("duree_prevue"));
        cln_9.setCellValueFactory(new PropertyValueFactory<Rapidite, Float>("duree_reel"));

        Trapidite.setItems(data);
  
	

    }

public void B(){

        Trapidite.getItems().clear();
        
        String sql = "SELECT\r\n" + //
                "    rapidite.pays_d.designation_pays,\r\n" + //
                "    rapidite.produit_d.nom_prod,\r\n" + //
                "    rapidite.employe_d.nom_emp,\r\n" + //
                "    rapidite.mois_d.designation_mois,\r\n" + //
                "    rapidite.rapidite_f.retard_debut,\r\n" + //
                "    rapidite.rapidite_f.retard_fin,\r\n" + //
                "    SUM(rapidite.rapidite_f.nbr_jours_retard) AS \"Sum_NBR_JOURS_RETARD\",\r\n" + //
                "    rapidite.rapidite_f.duree_prevue,\r\n" + //
                "    rapidite.rapidite_f.duree_reelle\r\n" + //
                "FROM\r\n" + //
                "         rapidite.rapidite_f\r\n" + //
                "    INNER JOIN rapidite.client_d ON rapidite.rapidite_f.code_client = rapidite.client_d.code_client\r\n" + //
                "    INNER JOIN rapidite.employe_d ON rapidite.rapidite_f.num_emp = rapidite.employe_d.num_emp\r\n" + //
                "    INNER JOIN rapidite.departement_d departement_d1 ON rapidite.employe_d.num_dept = departement_d1.num_dept\r\n" + //
                "    INNER JOIN rapidite.produit_d ON rapidite.rapidite_f.num_prod = rapidite.produit_d.num_prod\r\n" + //
                "    INNER JOIN rapidite.categorie_d ON rapidite.produit_d.num_cat = rapidite.categorie_d.num_cat\r\n" + //
                "    INNER JOIN rapidite.fournisseur_d ON rapidite.produit_d.num_fourn = rapidite.fournisseur_d.num_fourn\r\n" + //
                "    INNER JOIN rapidite.mois_d ON rapidite.rapidite_f.num_mois = rapidite.mois_d.num_mois\r\n" + //
                "    INNER JOIN rapidite.saison_d ON rapidite.mois_d.num_saison = rapidite.saison_d.num_saison\r\n" + //
                "    INNER JOIN rapidite.annee_d ON rapidite.mois_d.num_annee = rapidite.annee_d.num_annee\r\n" + //
                "    INNER JOIN rapidite.pays_d ON rapidite.pays_d.num_pays = rapidite.client_d.num_pays\r\n" + //
                "GROUP BY\r\n" + //
                "    rapidite.pays_d.designation_pays,\r\n" + //
                "    rapidite.produit_d.nom_prod,\r\n" + //
                "    rapidite.employe_d.nom_emp,\r\n" + //
                "    rapidite.mois_d.designation_mois,\r\n" + //
                "    rapidite.rapidite_f.retard_debut,\r\n" + //
                "    rapidite.rapidite_f.retard_fin,\r\n" + //
                "    rapidite.rapidite_f.duree_prevue,\r\n" + //
                "    rapidite.rapidite_f.duree_reelle " ;

        try {
            st = cnx.prepareStatement(sql);
            result = st.executeQuery();
            while(result.next()) {
			data.add (new Rapidite(result.getString("Designation_pays"),result.getString("nom_prod"),result.getString("nom_emp"),result.getString("designation_mois"),result.getInt("retard_debut"),result.getInt("retard_fin"),result.getInt("sum_nbr_jours_retard"),result.getInt("duree_prevue"),result.getInt("duree_reelle")));
			}
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        cln_1.setText("Designation pays");
        cln_2.setText("Num Produit");
        cln_3.setText("Code Employe");
        cln_4.setText("Code Mois");
        cln_5.setText("sum_nbr_jours_retard");
        cln_6.setText("Duree Prevue");
        cln_7.setText("Duree reelle");

        cln_1.setCellValueFactory(new PropertyValueFactory<Rapidite, String>("code_client"));
        cln_2.setCellValueFactory(new PropertyValueFactory<Rapidite,String>("num_prod"));
        cln_3.setCellValueFactory(new PropertyValueFactory<Rapidite,String>("num_emp"));
        cln_4.setCellValueFactory(new PropertyValueFactory<Rapidite,String>("num_mois"));
        cln_5.setCellValueFactory(new PropertyValueFactory<Rapidite,Float>("nbr_jours_retard"));
        cln_6.setCellValueFactory(new PropertyValueFactory<Rapidite, Float>("duree_prevue"));
        cln_7.setCellValueFactory(new PropertyValueFactory<Rapidite, Float>("duree_reel"));
        cln_8.setCellValueFactory(null);
        cln_9.setCellValueFactory(null);
        Trapidite.setItems(data);
  
	

    }



public void C(){

        Trapidite.getItems().clear();
        
        String sql = "SELECT\r\n" + //
                "    rapidite.produit_d.nom_prod,\r\n" + //
                "    rapidite.employe_d.nom_emp,\r\n" + //
                "    rapidite.mois_d.designation_mois,\r\n" + //
                "    rapidite.rapidite_f.retard_debut,\r\n" + //
                "    rapidite.rapidite_f.retard_fin,\r\n" + //
                "    SUM(rapidite.rapidite_f.nbr_jours_retard) AS \"Sum_NBR_JOURS_RETARD\",\r\n" + //
                "    rapidite.rapidite_f.duree_prevue,\r\n" + //
                "    rapidite.rapidite_f.duree_reelle\r\n" + //
                "FROM\r\n" + //
                "         rapidite.rapidite_f\r\n" + //
                "    INNER JOIN rapidite.client_d ON rapidite.rapidite_f.code_client = rapidite.client_d.code_client\r\n" + //
                "    INNER JOIN rapidite.employe_d ON rapidite.rapidite_f.num_emp = rapidite.employe_d.num_emp\r\n" + //
                "    INNER JOIN rapidite.departement_d departement_d1 ON rapidite.employe_d.num_dept = departement_d1.num_dept\r\n" + //
                "    INNER JOIN rapidite.produit_d ON rapidite.rapidite_f.num_prod = rapidite.produit_d.num_prod\r\n" + //
                "    INNER JOIN rapidite.categorie_d ON rapidite.produit_d.num_cat = rapidite.categorie_d.num_cat\r\n" + //
                "    INNER JOIN rapidite.fournisseur_d ON rapidite.produit_d.num_fourn = rapidite.fournisseur_d.num_fourn\r\n" + //
                "    INNER JOIN rapidite.mois_d ON rapidite.rapidite_f.num_mois = rapidite.mois_d.num_mois\r\n" + //
                "    INNER JOIN rapidite.saison_d ON rapidite.mois_d.num_saison = rapidite.saison_d.num_saison\r\n" + //
                "    INNER JOIN rapidite.annee_d ON rapidite.mois_d.num_annee = rapidite.annee_d.num_annee\r\n" + //
                "    INNER JOIN rapidite.pays_d ON rapidite.pays_d.num_pays = rapidite.client_d.num_pays\r\n" + //
                "GROUP BY\r\n" + //
                "    rapidite.produit_d.nom_prod,\r\n" + //
                "    rapidite.employe_d.nom_emp,\r\n" + //
                "    rapidite.mois_d.designation_mois,\r\n" + //
                "    rapidite.rapidite_f.retard_debut,\r\n" + //
                "    rapidite.rapidite_f.retard_fin,\r\n" + //
                "    rapidite.rapidite_f.duree_prevue,\r\n" + //
                "    rapidite.rapidite_f.duree_reelle " ;

        try {
            st = cnx.prepareStatement(sql);
            result = st.executeQuery();
            while(result.next()) {
			data.add (new Rapidite( "Designation_pays",result.getString("nom_prod"),result.getString("nom_emp"),result.getString("designation_mois"),result.getInt("retard_debut"),result.getInt("retard_fin"),result.getInt("sum_nbr_jours_retard"),result.getInt("duree_prevue"),result.getInt("duree_reelle")));
			}
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        cln_2.setText("Num Produit");
        cln_3.setText("Code Employe");
        cln_4.setText("Code Mois");
        cln_5.setText("sum_nbr_jours_retard");
        cln_6.setText("Duree Prevue");
        cln_7.setText("Duree reelle");

        cln_1.setCellValueFactory(null);
        cln_2.setCellValueFactory(new PropertyValueFactory<Rapidite,String>("num_prod"));
        cln_3.setCellValueFactory(new PropertyValueFactory<Rapidite,String>("num_emp"));
        cln_4.setCellValueFactory(new PropertyValueFactory<Rapidite,String>("num_mois"));
        cln_5.setCellValueFactory(new PropertyValueFactory<Rapidite,Float>("nbr_jours_retard"));
        cln_6.setCellValueFactory(new PropertyValueFactory<Rapidite, Float>("duree_prevue"));
        cln_7.setCellValueFactory(new PropertyValueFactory<Rapidite, Float>("duree_reel"));
        cln_8.setCellValueFactory(null);
        cln_9.setCellValueFactory(null);
        Trapidite.setItems(data);
  
	

    }

    
public void E(){

        Trapidite.getItems().clear();
        
        String sql = "SELECT\r\n" + //
                "    rapidite.client_d.nom_client,\r\n" + //
                "    rapidite.categorie_d.nom_cat,\r\n" + //
                "    rapidite.employe_d.nom_emp,\r\n" + //
                "    rapidite.mois_d.designation_mois,\r\n" + //
                "    rapidite.rapidite_f.retard_debut,\r\n" + //
                "    rapidite.rapidite_f.retard_fin,\r\n" + //
                "    SUM(rapidite.rapidite_f.nbr_jours_retard) AS \"Sum_NBR_JOURS_RETARD\",\r\n" + //
                "    rapidite.rapidite_f.duree_prevue,\r\n" + //
                "    rapidite.rapidite_f.duree_reelle\r\n" + //
                "FROM\r\n" + //
                "         rapidite.rapidite_f\r\n" + //
                "    INNER JOIN rapidite.client_d ON rapidite.rapidite_f.code_client = rapidite.client_d.code_client\r\n" + //
                "    INNER JOIN rapidite.employe_d ON rapidite.rapidite_f.num_emp = rapidite.employe_d.num_emp\r\n" + //
                "    INNER JOIN rapidite.departement_d departement_d1 ON rapidite.employe_d.num_dept = departement_d1.num_dept\r\n" + //
                "    INNER JOIN rapidite.produit_d ON rapidite.rapidite_f.num_prod = rapidite.produit_d.num_prod\r\n" + //
                "    INNER JOIN rapidite.categorie_d ON rapidite.produit_d.num_cat = rapidite.categorie_d.num_cat\r\n" + //
                "    INNER JOIN rapidite.fournisseur_d ON rapidite.produit_d.num_fourn = rapidite.fournisseur_d.num_fourn\r\n" + //
                "    INNER JOIN rapidite.mois_d ON rapidite.rapidite_f.num_mois = rapidite.mois_d.num_mois\r\n" + //
                "    INNER JOIN rapidite.saison_d ON rapidite.mois_d.num_saison = rapidite.saison_d.num_saison\r\n" + //
                "    INNER JOIN rapidite.annee_d ON rapidite.mois_d.num_annee = rapidite.annee_d.num_annee\r\n" + //
                "    INNER JOIN rapidite.pays_d ON rapidite.pays_d.num_pays = rapidite.client_d.num_pays\r\n" + //
                "GROUP BY\r\n" + //
                "    rapidite.client_d.nom_client,\r\n" + //
                "    rapidite.categorie_d.nom_cat,\r\n" + //
                "    rapidite.employe_d.nom_emp,\r\n" + //
                "    rapidite.mois_d.designation_mois,\r\n" + //
                "    rapidite.rapidite_f.retard_debut,\r\n" + //
                "    rapidite.rapidite_f.retard_fin,\r\n" + //
                "    rapidite.rapidite_f.duree_prevue,\r\n" + //
                "    rapidite.rapidite_f.duree_reelle" ;

        try {
            st = cnx.prepareStatement(sql);
            result = st.executeQuery();
            while(result.next()) {
			data.add (new Rapidite(result.getString("nom_client"),result.getString("nom_cat"),result.getString("nom_emp"),result.getString("designation_mois"),result.getInt("retard_debut"),result.getInt("retard_fin"),result.getInt("sum_nbr_jours_retard"),result.getInt("duree_prevue"),result.getInt("duree_reelle")));
			}
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        cln_1.setText("Designation pays");
        cln_2.setText("nom categorie");
        cln_3.setText("Code Employe");
        cln_4.setText("Code Mois");
        cln_5.setText("sum_nbr_jours_retard");
        cln_6.setText("Duree Prevue");
        cln_7.setText("Duree reelle");

        cln_1.setCellValueFactory(new PropertyValueFactory<Rapidite, String>("code_client"));
        cln_2.setCellValueFactory(new PropertyValueFactory<Rapidite,String>("num_prod"));
        cln_3.setCellValueFactory(new PropertyValueFactory<Rapidite,String>("num_emp"));
        cln_4.setCellValueFactory(new PropertyValueFactory<Rapidite,String>("num_mois"));
        cln_5.setCellValueFactory(new PropertyValueFactory<Rapidite,Float>("nbr_jours_retard"));
        cln_6.setCellValueFactory(new PropertyValueFactory<Rapidite, Float>("duree_prevue"));
        cln_7.setCellValueFactory(new PropertyValueFactory<Rapidite, Float>("duree_reel"));
        cln_8.setCellValueFactory(null);
        cln_9.setCellValueFactory(null);
        Trapidite.setItems(data);
  
	

    }

public void D(){

        Trapidite.getItems().clear();
        
        String sql = "SELECT\r\n" + //
                "    rapidite.client_d.nom_client,\r\n" + //
                "    rapidite.fournisseur_d.nom_fourn,\r\n" + //
                "    rapidite.employe_d.nom_emp,\r\n" + //
                "    rapidite.mois_d.designation_mois,\r\n" + //
                "    rapidite.rapidite_f.retard_debut,\r\n" + //
                "    rapidite.rapidite_f.retard_fin,\r\n" + //
                "    SUM(rapidite.rapidite_f.nbr_jours_retard) AS \"Sum_NBR_JOURS_RETARD\",\r\n" + //
                "    rapidite.rapidite_f.duree_prevue,\r\n" + //
                "    rapidite.rapidite_f.duree_reelle\r\n" + //
                "FROM\r\n" + //
                "         rapidite.rapidite_f\r\n" + //
                "    INNER JOIN rapidite.client_d ON rapidite.rapidite_f.code_client = rapidite.client_d.code_client\r\n" + //
                "    INNER JOIN rapidite.pays_d ON rapidite.client_d.num_pays = rapidite.pays_d.num_pays\r\n" + //
                "    INNER JOIN rapidite.employe_d ON rapidite.rapidite_f.num_emp = rapidite.employe_d.num_emp\r\n" + //
                "    INNER JOIN rapidite.departement_d ON rapidite.employe_d.num_dept = rapidite.departement_d.num_dept\r\n" + //
                "    INNER JOIN rapidite.produit_d ON rapidite.rapidite_f.num_prod = rapidite.produit_d.num_prod\r\n" + //
                "    INNER JOIN rapidite.categorie_d ON rapidite.produit_d.num_cat = rapidite.categorie_d.num_cat\r\n" + //
                "    INNER JOIN rapidite.fournisseur_d ON rapidite.produit_d.num_fourn = rapidite.fournisseur_d.num_fourn\r\n" + //
                "    INNER JOIN rapidite.mois_d ON rapidite.rapidite_f.num_mois = rapidite.mois_d.num_mois\r\n" + //
                "    INNER JOIN rapidite.saison_d ON rapidite.mois_d.num_saison = rapidite.saison_d.num_saison\r\n" + //
                "    INNER JOIN rapidite.annee_d ON rapidite.mois_d.num_annee = rapidite.annee_d.num_annee\r\n" + //
                "GROUP BY\r\n" + //
                "    rapidite.client_d.nom_client,\r\n" + //
                "    rapidite.fournisseur_d.nom_fourn,\r\n" + //
                "    rapidite.employe_d.nom_emp,\r\n" + //
                "    rapidite.mois_d.designation_mois,\r\n" + //
                "    rapidite.rapidite_f.retard_debut,\r\n" + //
                "    rapidite.rapidite_f.retard_fin,\r\n" + //
                "    rapidite.rapidite_f.duree_prevue,\r\n" + //
                "    rapidite.rapidite_f.duree_reelle" ;

        try {
            st = cnx.prepareStatement(sql);
            result = st.executeQuery();
            while(result.next()) {
			data.add (new Rapidite(result.getString("nom_client"),result.getString("nom_fourn"),result.getString("nom_emp"),result.getString("designation_mois"),result.getInt("retard_debut"),result.getInt("retard_fin"),result.getInt("sum_nbr_jours_retard"),result.getInt("duree_prevue"),result.getInt("duree_reelle")));
			}
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        cln_1.setText("Designation pays");
        cln_2.setText("nom fourn");
        cln_3.setText("Code Employe");
        cln_4.setText("Code Mois");
        cln_5.setText("sum_nbr_jours_retard");
        cln_6.setText("Duree Prevue");
        cln_7.setText("Duree reelle");

        cln_1.setCellValueFactory(new PropertyValueFactory<Rapidite, String>("code_client"));
        cln_2.setCellValueFactory(new PropertyValueFactory<Rapidite,String>("num_prod"));
        cln_3.setCellValueFactory(new PropertyValueFactory<Rapidite,String>("num_emp"));
        cln_4.setCellValueFactory(new PropertyValueFactory<Rapidite,String>("num_mois"));
        cln_5.setCellValueFactory(new PropertyValueFactory<Rapidite,Float>("nbr_jours_retard"));
        cln_6.setCellValueFactory(new PropertyValueFactory<Rapidite, Float>("duree_prevue"));
        cln_7.setCellValueFactory(new PropertyValueFactory<Rapidite, Float>("duree_reel"));
        cln_8.setCellValueFactory(null);
        cln_9.setCellValueFactory(null);
        Trapidite.setItems(data);
  
	

    }

public void F(){

        Trapidite.getItems().clear();
        
        String sql = "SELECT\r\n" + //
                "    rapidite.client_d.nom_client,\r\n" + //
                "    rapidite.employe_d.nom_emp,\r\n" + //
                "    rapidite.mois_d.designation_mois,\r\n" + //
                "    AVG(rapidite.rapidite_f.nbr_jours_retard) AS \"Avg_NBR_JOURS_RETARD\",\r\n" + //
                "    AVG(rapidite.rapidite_f.duree_prevue)     AS \"Avg_DUREE_PREVUE\",\r\n" + //
                "    AVG(rapidite.rapidite_f.duree_reelle)     AS \"Avg_DUREE_REELLE\"\r\n" + //
                "FROM\r\n" + //
                "         rapidite.rapidite_f\r\n" + //
                "    INNER JOIN rapidite.client_d ON rapidite.rapidite_f.code_client = rapidite.client_d.code_client\r\n" + //
                "    INNER JOIN rapidite.pays_d ON rapidite.client_d.num_pays = rapidite.pays_d.num_pays\r\n" + //
                "    INNER JOIN rapidite.employe_d ON rapidite.rapidite_f.num_emp = rapidite.employe_d.num_emp\r\n" + //
                "    INNER JOIN rapidite.departement_d ON rapidite.employe_d.num_dept = rapidite.departement_d.num_dept\r\n" + //
                "    INNER JOIN rapidite.produit_d ON rapidite.rapidite_f.num_prod = rapidite.produit_d.num_prod\r\n" + //
                "    INNER JOIN rapidite.categorie_d ON rapidite.produit_d.num_cat = rapidite.categorie_d.num_cat\r\n" + //
                "    INNER JOIN rapidite.fournisseur_d ON rapidite.produit_d.num_fourn = rapidite.fournisseur_d.num_fourn\r\n" + //
                "    INNER JOIN rapidite.mois_d ON rapidite.rapidite_f.num_mois = rapidite.mois_d.num_mois\r\n" + //
                "    INNER JOIN rapidite.saison_d ON rapidite.mois_d.num_saison = rapidite.saison_d.num_saison\r\n" + //
                "    INNER JOIN rapidite.annee_d ON rapidite.mois_d.num_annee = rapidite.annee_d.num_annee\r\n" + //
                "GROUP BY\r\n" + //
                "    rapidite.client_d.nom_client,\r\n" + //
                "    rapidite.employe_d.nom_emp,\r\n" + //
                "    rapidite.mois_d.designation_mois" ;

        try {
            st = cnx.prepareStatement(sql);
            result = st.executeQuery();
            while(result.next()) {
			data.add (new Rapidite( result.getString("nom_client"),"",result.getString("nom_emp"),result.getString("designation_mois"),0,0,result.getFloat("avg_nbr_jours_retard"),result.getFloat("avg_duree_prevue"),result.getFloat("avg_duree_reelle")));
			}
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        cln_1.setText("nom_client");
        cln_3.setText("Code Employe");
        cln_4.setText("Code Mois");
        cln_5.setText("avg_nbr_jours_retard");
        cln_6.setText("avg Duree Prevue");
        cln_7.setText("avg Duree reelle");

        cln_2.setCellValueFactory(null);
        cln_1.setCellValueFactory(new PropertyValueFactory<Rapidite,String>("code_client"));
        cln_3.setCellValueFactory(new PropertyValueFactory<Rapidite,String>("num_emp"));
        cln_4.setCellValueFactory(new PropertyValueFactory<Rapidite,String>("num_mois"));
        cln_5.setCellValueFactory(new PropertyValueFactory<Rapidite, Float>("nbr_jours_retard"));
        cln_6.setCellValueFactory(new PropertyValueFactory<Rapidite, Float>("duree_prevue"));
        cln_7.setCellValueFactory(new PropertyValueFactory<Rapidite, Float>("duree_reel"));
        cln_8.setCellValueFactory(null);
        cln_9.setCellValueFactory(null);
        Trapidite.setItems(data);
  
	

    }


public void G(){

        Trapidite.getItems().clear();
        
        String sql = "SELECT\r\n" + //
                "    rapidite.client_d.nom_client,\r\n" + //
                "    rapidite.produit_d.nom_prod,\r\n" + //
                "    rapidite.departement_d.designation_dept,\r\n" + //
                "    rapidite.mois_d.designation_mois,\r\n" + //
                "    AVG(rapidite.rapidite_f.nbr_jours_retard) AS \"Avg_NBR_JOURS_RETARD\",\r\n" + //
                "    AVG(rapidite.rapidite_f.duree_prevue)     AS \"Avg_DUREE_PREVUE\",\r\n" + //
                "    AVG(rapidite.rapidite_f.duree_reelle)     AS \"Avg_DUREE_REELLE\"\r\n" + //
                "FROM\r\n" + //
                "         rapidite.rapidite_f\r\n" + //
                "    INNER JOIN rapidite.client_d ON rapidite.rapidite_f.code_client = rapidite.client_d.code_client\r\n" + //
                "    INNER JOIN rapidite.pays_d ON rapidite.client_d.num_pays = rapidite.pays_d.num_pays\r\n" + //
                "    INNER JOIN rapidite.employe_d ON rapidite.rapidite_f.num_emp = rapidite.employe_d.num_emp\r\n" + //
                "    INNER JOIN rapidite.departement_d ON rapidite.employe_d.num_dept = rapidite.departement_d.num_dept\r\n" + //
                "    INNER JOIN rapidite.produit_d ON rapidite.rapidite_f.num_prod = rapidite.produit_d.num_prod\r\n" + //
                "    INNER JOIN rapidite.categorie_d ON rapidite.produit_d.num_cat = rapidite.categorie_d.num_cat\r\n" + //
                "    INNER JOIN rapidite.fournisseur_d ON rapidite.produit_d.num_fourn = rapidite.fournisseur_d.num_fourn\r\n" + //
                "    INNER JOIN rapidite.mois_d ON rapidite.rapidite_f.num_mois = rapidite.mois_d.num_mois\r\n" + //
                "    INNER JOIN rapidite.saison_d ON rapidite.mois_d.num_saison = rapidite.saison_d.num_saison\r\n" + //
                "    INNER JOIN rapidite.annee_d ON rapidite.mois_d.num_annee = rapidite.annee_d.num_annee\r\n" + //
                "GROUP BY\r\n" + //
                "    rapidite.client_d.nom_client,\r\n" + //
                "    rapidite.produit_d.nom_prod,\r\n" + //
                "    rapidite.departement_d.designation_dept,\r\n" + //
                "    rapidite.mois_d.designation_mois" ;

        try {
            st = cnx.prepareStatement(sql);
            result = st.executeQuery();
            while(result.next()) {
			data.add(new Rapidite(result.getString("nom_client"),result.getString("nom_prod"),result.getString("designation_dept"),result.getString("designation_mois"),0,0,result.getFloat("avg_nbr_jours_retard"),result.getFloat("avg_duree_prevue"),result.getFloat("avg_duree_reelle")));
			}
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        cln_1.setText("Code client");
        cln_2.setText("nom prod");
        cln_3.setText("dept");
        cln_4.setText("designation Mois");
        cln_8.setText(null);
        cln_9.setText(null);
        cln_5.setText("avg_nbr_jours_retard");
        cln_6.setText("avg Duree Prevue");
        cln_7.setText("avg Duree reelle");

        cln_1.setCellValueFactory(new PropertyValueFactory<Rapidite, String>("code_client"));
        cln_2.setCellValueFactory(new PropertyValueFactory<Rapidite,String>("num_prod"));
        cln_3.setCellValueFactory(new PropertyValueFactory<Rapidite,String>("num_emp"));
        cln_4.setCellValueFactory(new PropertyValueFactory<Rapidite,String>("num_mois"));
        cln_8.setCellValueFactory(null);
        cln_9.setCellValueFactory(null);
        cln_5.setCellValueFactory(new PropertyValueFactory<Rapidite,Float>("nbr_jours_retard"));
        cln_6.setCellValueFactory(new PropertyValueFactory<Rapidite, Float>("duree_prevue"));
        cln_7.setCellValueFactory(new PropertyValueFactory<Rapidite, Float>("duree_reel"));

        Trapidite.setItems(data);
	

    }

public void H(){

        Trapidite.getItems().clear();
        
        String sql = "SELECT\r\n" + //
                "    rapidite.client_d.nom_client,\r\n" + //
                "    rapidite.produit_d.nom_prod,\r\n" + //
                "    rapidite.mois_d.designation_mois,\r\n" + //
                "    AVG(rapidite.rapidite_f.nbr_jours_retard) AS \"Avg_NBR_JOURS_RETARD\",\r\n" + //
                "    AVG(rapidite.rapidite_f.duree_prevue)     AS \"Avg_DUREE_PREVUE\",\r\n" + //
                "    AVG(rapidite.rapidite_f.duree_reelle)     AS \"Avg_DUREE_REELLE\"\r\n" + //
                "FROM\r\n" + //
                "         rapidite.rapidite_f\r\n" + //
                "    INNER JOIN rapidite.client_d ON rapidite.rapidite_f.code_client = rapidite.client_d.code_client\r\n" + //
                "    INNER JOIN rapidite.pays_d ON rapidite.client_d.num_pays = rapidite.pays_d.num_pays\r\n" + //
                "    INNER JOIN rapidite.employe_d ON rapidite.rapidite_f.num_emp = rapidite.employe_d.num_emp\r\n" + //
                "    INNER JOIN rapidite.departement_d ON rapidite.employe_d.num_dept = rapidite.departement_d.num_dept\r\n" + //
                "    INNER JOIN rapidite.produit_d ON rapidite.rapidite_f.num_prod = rapidite.produit_d.num_prod\r\n" + //
                "    INNER JOIN rapidite.categorie_d ON rapidite.produit_d.num_cat = rapidite.categorie_d.num_cat\r\n" + //
                "    INNER JOIN rapidite.fournisseur_d ON rapidite.produit_d.num_fourn = rapidite.fournisseur_d.num_fourn\r\n" + //
                "    INNER JOIN rapidite.mois_d ON rapidite.rapidite_f.num_mois = rapidite.mois_d.num_mois\r\n" + //
                "    INNER JOIN rapidite.saison_d ON rapidite.mois_d.num_saison = rapidite.saison_d.num_saison\r\n" + //
                "    INNER JOIN rapidite.annee_d ON rapidite.mois_d.num_annee = rapidite.annee_d.num_annee\r\n" + //
                "GROUP BY\r\n" + //
                "    rapidite.client_d.nom_client,\r\n" + //
                "    rapidite.produit_d.nom_prod,\r\n" + //
                "    rapidite.mois_d.designation_mois" ;

        try {
            st = cnx.prepareStatement(sql);
            result = st.executeQuery();
            while(result.next()) {
			data.add(new Rapidite(result.getString("nom_client"),result.getString("nom_prod"),"",result.getString("designation_mois"),0,0,result.getFloat("avg_nbr_jours_retard"),result.getFloat("avg_duree_prevue"),result.getFloat("avg_duree_reelle")));
			}
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        cln_1.setText("Code client");
        cln_2.setText("Produit");
        cln_3.setText(null);
        cln_4.setText("designation Mois");
        cln_8.setText(null);
        cln_9.setText(null);
        cln_5.setText("avg_nbr_jours_retard");
        cln_6.setText("avg Duree Prevue");
        cln_7.setText("avg Duree reelle");

        cln_1.setCellValueFactory(new PropertyValueFactory<Rapidite, String>("code_client"));
        cln_2.setCellValueFactory(new PropertyValueFactory<Rapidite,String>("num_prod"));
        cln_3.setCellValueFactory(null);
        cln_4.setCellValueFactory(new PropertyValueFactory<Rapidite,String>("num_mois"));
        cln_8.setCellValueFactory(null);
        cln_9.setCellValueFactory(null);
        cln_5.setCellValueFactory(new PropertyValueFactory<Rapidite,Float>("nbr_jours_retard"));
        cln_6.setCellValueFactory(new PropertyValueFactory<Rapidite, Float>("duree_prevue"));
        cln_7.setCellValueFactory(new PropertyValueFactory<Rapidite, Float>("duree_reel"));

        Trapidite.setItems(data);
	

    }


public void J(){

        Trapidite.getItems().clear();
        
        String sql = "SELECT\r\n" + //
                "    rapidite.client_d.nom_client,\r\n" + //
                "    rapidite.produit_d.nom_prod,\r\n" + //
                "    rapidite.employe_d.nom_emp,\r\n" + //
                "    rapidite.saison_d.designation_saison,\r\n" + //
                "    SUM(rapidite.rapidite_f.nbr_jours_retard) AS \"Sum_NBR_JOURS_RETARD\",\r\n" + //
                "    AVG(rapidite.rapidite_f.duree_prevue)     AS \"Avg_DUREE_PREVUE\",\r\n" + //
                "    AVG(rapidite.rapidite_f.duree_reelle)     AS \"Avg_DUREE_REELLE\"\r\n" + //
                "FROM\r\n" + //
                "         rapidite.rapidite_f\r\n" + //
                "    INNER JOIN rapidite.client_d ON rapidite.rapidite_f.code_client = rapidite.client_d.code_client\r\n" + //
                "    INNER JOIN rapidite.pays_d ON rapidite.client_d.num_pays = rapidite.pays_d.num_pays\r\n" + //
                "    INNER JOIN rapidite.employe_d ON rapidite.rapidite_f.num_emp = rapidite.employe_d.num_emp\r\n" + //
                "    INNER JOIN rapidite.departement_d ON rapidite.employe_d.num_dept = rapidite.departement_d.num_dept\r\n" + //
                "    INNER JOIN rapidite.produit_d ON rapidite.rapidite_f.num_prod = rapidite.produit_d.num_prod\r\n" + //
                "    INNER JOIN rapidite.categorie_d ON rapidite.produit_d.num_cat = rapidite.categorie_d.num_cat\r\n" + //
                "    INNER JOIN rapidite.fournisseur_d ON rapidite.produit_d.num_fourn = rapidite.fournisseur_d.num_fourn\r\n" + //
                "    INNER JOIN rapidite.mois_d ON rapidite.rapidite_f.num_mois = rapidite.mois_d.num_mois\r\n" + //
                "    INNER JOIN rapidite.saison_d ON rapidite.mois_d.num_saison = rapidite.saison_d.num_saison\r\n" + //
                "    INNER JOIN rapidite.annee_d ON rapidite.mois_d.num_annee = rapidite.annee_d.num_annee\r\n" + //
                "GROUP BY\r\n" + //
                "    rapidite.client_d.nom_client,\r\n" + //
                "    rapidite.produit_d.nom_prod,\r\n" + //
                "    rapidite.employe_d.nom_emp,\r\n" + //
                "    rapidite.saison_d.designation_saison" ;

        try {
            st = cnx.prepareStatement(sql);
            result = st.executeQuery();
            while(result.next()) {
			data.add (new Rapidite(result.getString("nom_client"),result.getString("nom_prod"),result.getString("nom_emp"),result.getString("designation_saison"),0,0,result.getInt("sum_nbr_jours_retard"),result.getFloat("avg_duree_prevue"),result.getFloat("avg_duree_reelle")));
			}
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        cln_1.setText("nom client");
        cln_2.setText("Num Produit");
        cln_3.setText("nom Employe");
        cln_4.setText("saison");
        cln_5.setText("sum_nbr_jours_retard");
        cln_6.setText("avg Duree Prevue");
        cln_7.setText("avg Duree reelle");

        cln_1.setCellValueFactory(new PropertyValueFactory<Rapidite, String>("code_client"));
        cln_2.setCellValueFactory(new PropertyValueFactory<Rapidite,String>("num_prod"));
        cln_3.setCellValueFactory(new PropertyValueFactory<Rapidite,String>("num_emp"));
        cln_4.setCellValueFactory(new PropertyValueFactory<Rapidite,String>("num_mois"));
        cln_5.setCellValueFactory(new PropertyValueFactory<Rapidite,Float>("nbr_jours_retard"));
        cln_6.setCellValueFactory(new PropertyValueFactory<Rapidite, Float>("duree_prevue"));
        cln_7.setCellValueFactory(new PropertyValueFactory<Rapidite, Float>("duree_reel"));
        cln_8.setCellValueFactory(null);
        cln_9.setCellValueFactory(null);
        Trapidite.setItems(data);
  
	

    }


public void K(){

        Trapidite.getItems().clear();
        
        String sql = "SELECT\r\n" + //
                "    rapidite.client_d.nom_client,\r\n" + //
                "    rapidite.produit_d.nom_prod,\r\n" + //
                "    rapidite.employe_d.nom_emp,\r\n" + //
                "    rapidite.annee_d.designation_annee,\r\n" + //
                "    SUM(rapidite.rapidite_f.nbr_jours_retard) AS \"Sum_NBR_JOURS_RETARD\",\r\n" + //
                "    AVG(rapidite.rapidite_f.duree_prevue)     AS \"Avg_DUREE_PREVUE\",\r\n" + //
                "    AVG(rapidite.rapidite_f.duree_reelle)     AS \"Avg_DUREE_REELLE\"\r\n" + //
                "FROM\r\n" + //
                "         rapidite.rapidite_f\r\n" + //
                "    INNER JOIN rapidite.client_d ON rapidite.rapidite_f.code_client = rapidite.client_d.code_client\r\n" + //
                "    INNER JOIN rapidite.pays_d ON rapidite.client_d.num_pays = rapidite.pays_d.num_pays\r\n" + //
                "    INNER JOIN rapidite.employe_d ON rapidite.rapidite_f.num_emp = rapidite.employe_d.num_emp\r\n" + //
                "    INNER JOIN rapidite.departement_d ON rapidite.employe_d.num_dept = rapidite.departement_d.num_dept\r\n" + //
                "    INNER JOIN rapidite.produit_d ON rapidite.rapidite_f.num_prod = rapidite.produit_d.num_prod\r\n" + //
                "    INNER JOIN rapidite.categorie_d ON rapidite.produit_d.num_cat = rapidite.categorie_d.num_cat\r\n" + //
                "    INNER JOIN rapidite.fournisseur_d ON rapidite.produit_d.num_fourn = rapidite.fournisseur_d.num_fourn\r\n" + //
                "    INNER JOIN rapidite.mois_d ON rapidite.rapidite_f.num_mois = rapidite.mois_d.num_mois\r\n" + //
                "    INNER JOIN rapidite.saison_d ON rapidite.mois_d.num_saison = rapidite.saison_d.num_saison\r\n" + //
                "    INNER JOIN rapidite.annee_d ON rapidite.mois_d.num_annee = rapidite.annee_d.num_annee\r\n" + //
                "GROUP BY\r\n" + //
                "    rapidite.client_d.nom_client,\r\n" + //
                "    rapidite.produit_d.nom_prod,\r\n" + //
                "    rapidite.employe_d.nom_emp,\r\n" + //
                "    rapidite.annee_d.designation_annee" ;

        try {
            st = cnx.prepareStatement(sql);
            result = st.executeQuery();
            while(result.next()) {
			data.add (new Rapidite(result.getString("nom_client"),result.getString("nom_prod"),result.getString("nom_emp"),result.getString("designation_annee"),0,0,result.getInt("sum_nbr_jours_retard"),result.getFloat("avg_duree_prevue"),result.getFloat("avg_duree_reelle")));
			}
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        cln_1.setText("nom client");
        cln_2.setText("Num Produit");
        cln_3.setText("nom Employe");
        cln_4.setText("annee");
        cln_5.setText("sum_nbr_jours_retar");
        cln_6.setText("avg Duree Prevue");
        cln_7.setText("avg Duree reelle");

        cln_1.setCellValueFactory(new PropertyValueFactory<Rapidite, String>("code_client"));
        cln_2.setCellValueFactory(new PropertyValueFactory<Rapidite,String>("num_prod"));
        cln_3.setCellValueFactory(new PropertyValueFactory<Rapidite,String>("num_emp"));
        cln_4.setCellValueFactory(new PropertyValueFactory<Rapidite,String>("num_mois"));
        cln_5.setCellValueFactory(new PropertyValueFactory<Rapidite,Float>("nbr_jours_retard"));
        cln_6.setCellValueFactory(new PropertyValueFactory<Rapidite, Float>("duree_prevue"));
        cln_7.setCellValueFactory(new PropertyValueFactory<Rapidite, Float>("duree_reel"));
        cln_8.setCellValueFactory(null);
        cln_9.setCellValueFactory(null);
        Trapidite.setItems(data);
  
	

    }


public void L(){

        Trapidite.getItems().clear();
        
        String sql = "SELECT\r\n" + //
                "    rapidite.client_d.nom_client,\r\n" + //
                "    rapidite.produit_d.nom_prod,\r\n" + //
                "    rapidite.employe_d.nom_emp,\r\n" + //
                "    SUM(rapidite.rapidite_f.nbr_jours_retard) AS \"Sum_NBR_JOURS_RETARD\",\r\n" + //
                "    AVG(rapidite.rapidite_f.duree_prevue)     AS \"Avg_DUREE_PREVUE\",\r\n" + //
                "    AVG(rapidite.rapidite_f.duree_reelle)     AS \"Avg_DUREE_REELLE\"\r\n" + //
                "FROM\r\n" + //
                "         rapidite.rapidite_f\r\n" + //
                "    INNER JOIN rapidite.client_d ON rapidite.rapidite_f.code_client = rapidite.client_d.code_client\r\n" + //
                "    INNER JOIN rapidite.pays_d ON rapidite.client_d.num_pays = rapidite.pays_d.num_pays\r\n" + //
                "    INNER JOIN rapidite.employe_d ON rapidite.rapidite_f.num_emp = rapidite.employe_d.num_emp\r\n" + //
                "    INNER JOIN rapidite.departement_d ON rapidite.employe_d.num_dept = rapidite.departement_d.num_dept\r\n" + //
                "    INNER JOIN rapidite.produit_d ON rapidite.rapidite_f.num_prod = rapidite.produit_d.num_prod\r\n" + //
                "    INNER JOIN rapidite.categorie_d ON rapidite.produit_d.num_cat = rapidite.categorie_d.num_cat\r\n" + //
                "    INNER JOIN rapidite.fournisseur_d ON rapidite.produit_d.num_fourn = rapidite.fournisseur_d.num_fourn\r\n" + //
                "    INNER JOIN rapidite.mois_d ON rapidite.rapidite_f.num_mois = rapidite.mois_d.num_mois\r\n" + //
                "    INNER JOIN rapidite.saison_d ON rapidite.mois_d.num_saison = rapidite.saison_d.num_saison\r\n" + //
                "    INNER JOIN rapidite.annee_d ON rapidite.mois_d.num_annee = rapidite.annee_d.num_annee\r\n" + //
                "GROUP BY\r\n" + //
                "    rapidite.client_d.nom_client,\r\n" + //
                "    rapidite.produit_d.nom_prod,\r\n" + //
                "    rapidite.employe_d.nom_emp" ;

        try {
            st = cnx.prepareStatement(sql);
            result = st.executeQuery();
            while(result.next()) {
			data.add(new Rapidite(result.getString("nom_client"),result.getString("nom_prod"),result.getString("nom_emp"),"",0,0,result.getFloat("Sum_nbr_jours_retard"),result.getFloat("avg_duree_prevue"),result.getFloat("avg_duree_reelle")));
			}
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        cln_1.setText("Code client");
        cln_2.setText("Produit");
        cln_3.setText("Employe");
        cln_4.setText(null);
        cln_8.setText(null);
        cln_9.setText(null);
        cln_5.setText("sum_nbr_jours_retar");
        cln_6.setText("avg Duree Prevue");
        cln_7.setText("avg Duree reelle");

        cln_1.setCellValueFactory(new PropertyValueFactory<Rapidite, String>("code_client"));
        cln_2.setCellValueFactory(new PropertyValueFactory<Rapidite,String>("num_prod"));
        cln_3.setCellValueFactory(new PropertyValueFactory<Rapidite,String>("num_emp"));
        cln_4.setCellValueFactory(null);
        cln_8.setCellValueFactory(null);
        cln_9.setCellValueFactory(null);
        cln_5.setCellValueFactory(new PropertyValueFactory<Rapidite,Float>("nbr_jours_retard"));
        cln_6.setCellValueFactory(new PropertyValueFactory<Rapidite, Float>("duree_prevue"));
        cln_7.setCellValueFactory(new PropertyValueFactory<Rapidite, Float>("duree_reel"));

        Trapidite.setItems(data);
	

    }


public void M(){

        Trapidite.getItems().clear();
        
        String sql = "SELECT\r\n" + //
                "    SUM(rapidite.rapidite_f.nbr_jours_retard) AS \"Sum_NBR_JOURS_RETARD\",\r\n" + //
                "    AVG(rapidite.rapidite_f.duree_prevue)     AS \"Avg_DUREE_PREVUE\",\r\n" + //
                "    AVG(rapidite.rapidite_f.duree_reelle)     AS \"Avg_DUREE_REELLE\"\r\n" + //
                "FROM\r\n" + //
                "         rapidite.rapidite_f\r\n" + //
                "    INNER JOIN rapidite.client_d ON rapidite.rapidite_f.code_client = rapidite.client_d.code_client\r\n" + //
                "    INNER JOIN rapidite.pays_d ON rapidite.client_d.num_pays = rapidite.pays_d.num_pays\r\n" + //
                "    INNER JOIN rapidite.employe_d ON rapidite.rapidite_f.num_emp = rapidite.employe_d.num_emp\r\n" + //
                "    INNER JOIN rapidite.departement_d ON rapidite.employe_d.num_dept = rapidite.departement_d.num_dept\r\n" + //
                "    INNER JOIN rapidite.produit_d ON rapidite.rapidite_f.num_prod = rapidite.produit_d.num_prod\r\n" + //
                "    INNER JOIN rapidite.categorie_d ON rapidite.produit_d.num_cat = rapidite.categorie_d.num_cat\r\n" + //
                "    INNER JOIN rapidite.fournisseur_d ON rapidite.produit_d.num_fourn = rapidite.fournisseur_d.num_fourn\r\n" + //
                "    INNER JOIN rapidite.mois_d ON rapidite.rapidite_f.num_mois = rapidite.mois_d.num_mois\r\n" + //
                "    INNER JOIN rapidite.saison_d ON rapidite.mois_d.num_saison = rapidite.saison_d.num_saison\r\n" + //
                "    INNER JOIN rapidite.annee_d ON rapidite.mois_d.num_annee = rapidite.annee_d.num_annee" ;

        try {
            st = cnx.prepareStatement(sql);
            result = st.executeQuery();
            while(result.next()) {
			data.add(new Rapidite("","","","",0,0,result.getFloat("Sum_nbr_jours_retard"),result.getFloat("avg_duree_prevue"),result.getFloat("avg_duree_reelle")));
			}
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        cln_5.setText("total jours perdus");
        cln_6.setText("moyenne duree prevue");
        cln_7.setText("moyenne duree reele");
        cln_9.setText(null);
        cln_1.setText(null);
        cln_2.setText(null);
        cln_3.setText(null);
        cln_4.setText(null);
        cln_8.setText(null);

        cln_1.setCellValueFactory(null);
        cln_2.setCellValueFactory(null);
        cln_3.setCellValueFactory(null);
        cln_4.setCellValueFactory(null);
        cln_8.setCellValueFactory(null);
        cln_9.setCellValueFactory(null);
        cln_5.setCellValueFactory(new PropertyValueFactory<Rapidite,Float>("nbr_jours_retard"));
        cln_6.setCellValueFactory(new PropertyValueFactory<Rapidite, Float>("duree_prevue"));
        cln_7.setCellValueFactory(new PropertyValueFactory<Rapidite, Float>("duree_reel"));

        Trapidite.setItems(data);
	

    }


public void N(){

        Trapidite.getItems().clear();
        
        String sql = "SELECT\r\n" + //
                "    rapidite.categorie_d.nom_cat,\r\n" + //
                "    rapidite.departement_d.designation_dept,\r\n" + //
                "    rapidite.saison_d.designation_saison,\r\n" + //
                "    SUM(rapidite.rapidite_f.nbr_jours_retard) AS \"Sum_NBR_JOURS_RETARD\",\r\n" + //
                "    AVG(rapidite.rapidite_f.duree_prevue)     AS \"Avg_DUREE_PREVUE\",\r\n" + //
                "    AVG(rapidite.rapidite_f.duree_reelle)     AS \"Avg_DUREE_REELLE\"\r\n" + //
                "FROM\r\n" + //
                "         rapidite.rapidite_f\r\n" + //
                "    INNER JOIN rapidite.client_d ON rapidite.rapidite_f.code_client = rapidite.client_d.code_client\r\n" + //
                "    INNER JOIN rapidite.pays_d ON rapidite.client_d.num_pays = rapidite.pays_d.num_pays\r\n" + //
                "    INNER JOIN rapidite.employe_d ON rapidite.rapidite_f.num_emp = rapidite.employe_d.num_emp\r\n" + //
                "    INNER JOIN rapidite.departement_d ON rapidite.employe_d.num_dept = rapidite.departement_d.num_dept\r\n" + //
                "    INNER JOIN rapidite.produit_d ON rapidite.rapidite_f.num_prod = rapidite.produit_d.num_prod\r\n" + //
                "    INNER JOIN rapidite.categorie_d ON rapidite.produit_d.num_cat = rapidite.categorie_d.num_cat\r\n" + //
                "    INNER JOIN rapidite.fournisseur_d ON rapidite.produit_d.num_fourn = rapidite.fournisseur_d.num_fourn\r\n" + //
                "    INNER JOIN rapidite.mois_d ON rapidite.rapidite_f.num_mois = rapidite.mois_d.num_mois\r\n" + //
                "    INNER JOIN rapidite.saison_d ON rapidite.mois_d.num_saison = rapidite.saison_d.num_saison\r\n" + //
                "    INNER JOIN rapidite.annee_d ON rapidite.mois_d.num_annee = rapidite.annee_d.num_annee\r\n" + //
                "GROUP BY\r\n" + //
                "    rapidite.categorie_d.nom_cat,\r\n" + //
                "    rapidite.departement_d.designation_dept,\r\n" + //
                "    rapidite.saison_d.designation_saison" ;

        try {
            st = cnx.prepareStatement(sql);
            result = st.executeQuery();
            while(result.next()) {
			data.add(new Rapidite("",result.getString("nom_cat"),result.getString("designation_dept"),result.getString("designation_saison"),0,0,result.getFloat("Sum_nbr_jours_retard"),result.getFloat("avg_duree_prevue"),result.getFloat("avg_duree_reelle")));
			}
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        cln_2.setText("nom cat ");
        cln_3.setText("depart ");
        cln_4.setText("saison");
        cln_5.setText("nbr jours retard somme");
        cln_6.setText("moynne durree prevue");
        cln_7.setText("moyenne durree reel");
        cln_9.setText(null);
        cln_1.setText(null);
        cln_8.setText(null);

        cln_2.setCellValueFactory(new PropertyValueFactory<Rapidite, String>("num_prod"));
        cln_3.setCellValueFactory(new PropertyValueFactory<Rapidite,String>("num_emp"));
        cln_4.setCellValueFactory(new PropertyValueFactory<Rapidite,String>("num_mois"));
        cln_1.setCellValueFactory(null);
        cln_8.setCellValueFactory(null);
        cln_9.setCellValueFactory(null);
        cln_5.setCellValueFactory(new PropertyValueFactory<Rapidite,Float>("nbr_jours_retard"));
        cln_6.setCellValueFactory(new PropertyValueFactory<Rapidite, Float>("duree_prevue"));
        cln_7.setCellValueFactory(new PropertyValueFactory<Rapidite, Float>("duree_reel"));

        Trapidite.setItems(data);
	

    }


@Override


public void initialize(URL arg0, ResourceBundle arg1){

    box1.getItems().addAll(Dimention1);
    box2.getItems().addAll(Dimention2);
    box3.getItems().addAll(Dimention3);
    box4.getItems().addAll(Dimention4);



    cnx = ConnectionDB.cnx();

    
    

}

}