package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GridGIU extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("GridGUI.fxml"));
        primaryStage.setTitle("Coloring");
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }
}
