import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ConnectionDB.ConnectionDB;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        
        ConnectionDB.cnx();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    Parent root;
    try {
        root = FXMLLoader.load(getClass().getResource("/interfaces/Main.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("OLAP");
        primaryStage.setScene(scene);
        primaryStage.show();

    } catch (IOException e) {

    }
  

    }
}
