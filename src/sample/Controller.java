package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.util.ArrayList;
import java.util.LinkedList;


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
    AnchorPane displayPane = new AnchorPane();
    @FXML
    ListView<String> list = new ListView<>();

    //not-FXML Objects and Properties
    private int count = 0;
    //private ArrayList<checkItem> items = new ArrayList<>();
    private LinkedList<checkItem> items = new LinkedList<>();

    //FXML methods
    @FXML
    void addItem(){
        if(!(nameBox.getText() == null)){
            list.getItems().add(nameBox.getText());
            items.add(new checkItem(nameBox.getText()));
            count++;
            nameBox.clear();
        }
    }

    @FXML
    void showItem(){
        displayPane.getChildren().clear();
        int ind = list.getSelectionModel().getSelectedIndex();
        try {
            displayPane.getChildren().add(items.get(ind));
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ERROR!");
        }
    }

    @FXML
    void deleteItem(){
        int ind = list.getSelectionModel().getSelectedIndex();
        items.remove(ind);
        updateItems();
    }

    @FXML
    void saveItem(){
        int ind = list.getSelectionModel().getSelectedIndex();
        items.get(ind).saveConfigToFile();
    }

    void showItemListener(){
        displayPane.getChildren().clear();
        int ind = list.getSelectionModel().getSelectedIndex();
        try {
            displayPane.getChildren().add(items.get(ind));
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ERROR!");
        }
    }

    private void updateItems(){
        list.getItems().clear();
        for(checkItem x : items){
            list.getItems().add(x.getName());
        }
    }
}
