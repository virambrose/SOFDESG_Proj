package sample;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class checkItem extends VBox {
    private ArrayList<CheckBoxLabel> boxes = new ArrayList<>();
    private ArrayList<Boolean> values = new ArrayList<>();
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

    void saveConfigToFile(String filename){
        ArrayList<String> strings = new ArrayList<>();
        int x = 0;
        for(CheckBoxLabel box: boxes){
            strings.add(box.getNumText());
        }
        try {
            File file = new File(filename);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(String s: strings){
                bufferedWriter.write(s);
            }
            bufferedWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    Boolean getValue(int index){
        return values.get(index);
    }

}
