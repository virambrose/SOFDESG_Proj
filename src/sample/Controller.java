package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


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
    @FXML
    Button loadButton = new Button();

    //not-FXML Objects and Properties
    protected LinkedList<checkItem> items = new LinkedList<>();
    private int count = 0;
    //FXML methods
    @FXML
    void addItem(){
        if(!nameBox.getText().equals("")){
            list.getItems().add(nameBox.getText());
            items.add(new checkItem(nameBox.getText()));
            count++;
            nameBox.clear();
        }
    }

    @FXML
    void deleteItem(){
        int ind = list.getSelectionModel().getSelectedIndex();
        if (ind > -1) items.remove(ind);
        updateItems();
    }

    @FXML
    void saveItem(){
        int ind = list.getSelectionModel().getSelectedIndex();
        if (ind > -1) items.get(ind).saveConfigToFile();
    }

    @FXML
    private void loadFile() throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("config file", "*.cbcfg"));
        File file = fileChooser.showOpenDialog(loadButton.getScene().getWindow());
        List<String> lines = new ArrayList<>();
        String title;
        Scanner fileReader = new Scanner(file);
        title = fileReader.nextLine();
        System.out.println(title);
        while(fileReader.hasNextLine()){
            String debug = fileReader.nextLine();
            lines.add(debug);
            System.out.println(debug);
        }
        checkItem item = new checkItem(title);
        for(String s : lines){
            String substr;
            String indicator = item.types[0];
            substr = s.substring(1);
            System.out.println(s.substring(0,1));
            switch (s.substring(0, 1)) {
                case "#":
                    indicator = item.types[0];
                    break;
                case "~":
                    indicator = item.types[1];
                    break;
            }
            System.out.println(indicator);
            System.out.println(substr);
            item.addItem(substr, indicator);
        }
        items.add(item);
        updateItems();
    }

    void showItemListener(){
        displayPane.getChildren().clear();
        int ind = list.getSelectionModel().getSelectedIndex();
        try {
            if (ind > -1)
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
