package sample;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class checkItem extends VBox {
    private ArrayList<HBoxWidgetAbstract> boxes = new ArrayList<>();
    private ArrayList<Boolean> values = new ArrayList<>();
    private int count = 0;
    private static final int typeAmt = 2;
    private Label title;
    private TextField componentField;
    private RadioButton[] typeSpecifier;
    private ToggleGroup typeTogggle;
    private Button addComp;
    private VBox components;

    checkItem(String title){
        this.title = new Label(title);
        componentField = new TextField();
        addComp = new Button("Add");
        typeTogggle = new ToggleGroup();
        typeSpecifier = new RadioButton[typeAmt];
        //Define types
        typeSpecifier[0] = new RadioButton("Checkbox");
        typeSpecifier[1] = new RadioButton("Slider");
        //Add to Toggle Group
        typeSpecifier[0].setToggleGroup(typeTogggle);
        typeSpecifier[1].setToggleGroup(typeTogggle);
        HBox types = new HBox(typeSpecifier);
        components = new VBox();
        addComp.setOnAction(event -> addItem(componentField.getText()));
        componentField.setOnAction(event -> addItem(componentField.getText()));
        HBox hBox = new HBox(componentField, addComp);
        this.getChildren().addAll(this.title, types, hBox, this.components);
    }

    public String getName(){
        return title.getText();
    }

    private void addItem(String str){
        RadioButton selected = (RadioButton) typeTogggle.getSelectedToggle();
        String ident = selected.getText();
        if(ident.equals("Checkbox")){
            boxes.add(new CheckBoxLabel(str + " ", count+1));
            //criteria.add(new criterion(str + " ", 1, count + 1));
        }
        else if(ident.equals("Slider")){
            boxes.add(new HSliderLabel(str + " ", count+1));
            //criteria.add(new criterion(str + " ", 2, count + 1));
        }
        values.add(false);
        componentField.clear();
        components.getChildren().clear();
        components.getChildren().addAll(boxes);
        count++;
    }

    void removeItem(String str){

    }

    void saveConfigToFile(){
        ArrayList<String> strings = new ArrayList<>();
        for(HBoxWidgetAbstract widget: boxes){
            strings.add(widget.getNumText());
        }
        try {
            File file = new File("./"+this.title.getText()+".cbcfg");
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
