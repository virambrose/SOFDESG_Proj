package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();
        Scene mainScene = new Scene(root);
        mainScene.getStylesheets().add("sample/styles.css");
        controller.list.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            controller.showItemListener();
        });
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(mainScene);
        primaryStage.setMaximized(true);
        primaryStage.show();
        controller.add.setStyle(".button");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
