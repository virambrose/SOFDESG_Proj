package sample;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.util.ArrayList;

public class checkItem extends VBox {
    private ArrayList<CheckBoxLabel> boxes = new ArrayList<>();
    private ArrayList<Boolean> values = new ArrayList<Boolean>();
    private int count = 0;
    private Label title;
    private TextField componentField;
    private Button addComp;
    private VBox components;

    checkItem(String title){
        this.title = new Label(title);
        componentField = new TextField();
        addComp = new Button("Add");
        components = new VBox();
        addComp.setOnAction(event -> addItem(componentField.getText()));
        componentField.setOnAction(event -> addItem(componentField.getText()));
        HBox hBox = new HBox(componentField, addComp);
        this.getChildren().addAll(this.title, hBox, this.components);
    }

    private void addItem(String str){
        boxes.add(new CheckBoxLabel(str + " ", count+1));
        values.add(false);
        componentField.clear();
        components.getChildren().clear();
        components.getChildren().addAll(boxes);
        count++;
    }

    void removeItem(String str){

    }

    Boolean getValue(int index){
        return values.get(index);
    }

}
