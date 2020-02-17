package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;


public class Controller {
    //FXML Objects
    @FXML
    TextField nameBox = new TextField();
    @FXML
    Button add = new Button();
    @FXML
    ComboBox<String> combo = new ComboBox<>();
    @FXML
    AnchorPane displayPane = new AnchorPane();

    //non-FXML
    private static final int max = 50;
    private int count = 0;
    private CheckBoxLabel[] checks = new CheckBoxLabel[max];
    //private HSliderLabel[] sliders = new HSliderLabel[max];
    private VBox[] vBoxes = new VBox[max];

    //FXML methods
    @FXML
    void addItem(){
        if(!(nameBox.getText() == null)){
            combo.getItems().add(nameBox.getText());
            checks[count] = new CheckBoxLabel(nameBox.getText());
            //sliders[count] = new HSliderLabel(nameBox.getText());
            vBoxes[count] = new VBox();
            vBoxes[count].getChildren().addAll(checks[count]);
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
            displayPane.getChildren().add(vBoxes[ind]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ERROR!");
        }
        /*
        if(vBoxes[ind] != null && ind > -1){
            displayPane.getChildren().add(vBoxes[ind]);
        }
        */
    }

}
