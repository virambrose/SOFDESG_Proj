package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
    private FXMLLoader mainMenu = new FXMLLoader(getClass().getResource("mainMenu.fxml"));

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = loader.load();
        Scene mainScene = new Scene(root);
        Controller controller = loader.getController();
        mainMenu mainMenuController = mainMenu.getController();
        controller.list.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            controller.showItemListener();
        });
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(mainScene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
