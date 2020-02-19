package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.util.ArrayList;


public class Controller {
    //FXML Objects
    @FXML
    TextField nameBox = new TextField();
    @FXML
    Button add = new Button();
    @FXML
    Button delButton = new Button();
    @FXML
    Button saveButton = new Button();
    @FXML
    ComboBox<String> combo = new ComboBox<>();
    @FXML
    AnchorPane displayPane = new AnchorPane();
    @FXML
    ListView<String> list = new ListView<>();

    //non-FXML
    private static final int max = 50;
    private int count = 0;
    private ArrayList<checkItem> items = new ArrayList<>();

    //FXML methods
    @FXML
    void addItem(){
        if(!(nameBox.getText() == null)){
            combo.getItems().add(nameBox.getText());
            list.getItems().add(nameBox.getText());
            items.add(new checkItem(nameBox.getText()));
            count++;
            nameBox.clear();
        }
    }

    @FXML
    void showItem(){
        displayPane.getChildren().clear();
        int ind = combo.getItems().lastIndexOf(combo.getValue());
        System.out.println(combo.getValue());
        System.out.println(ind);
        try {
            displayPane.getChildren().add(items.get(ind));
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ERROR!");
        }
    }

    @FXML
    void saveItem(){
        int ind = combo.getItems().lastIndexOf(combo.getValue());
        items.get(ind).saveConfigToFile();
    }

}
