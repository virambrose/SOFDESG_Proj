package sample;

import com.opencsv.CSVWriter;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class checkItem extends VBox {
    private ArrayList<HBoxWidgetAbstract> boxes = new ArrayList<>();
    private ArrayList<value> values = new ArrayList<>();
    private int count = 0;
    private Label title;
    private TextField componentField;
    private RadioButton[] typeSpecifier;
    private ToggleGroup typeTogggle;
    private Button addComp;
    private VBox components;
    private Region spacer;
    private Region spacer1;

    //types of widgets
    String[] types = new String[]{"Checkbox", "Slider", "RadioButton"};
    private static final int max = 3;


    checkItem(String title){
        this.title = new Label(title);
        this.title.setFont(Font.font("Courier New", FontWeight.BOLD, 30));
        this.title.setUnderline(true);


        spacer = new Region();
        spacer.setPrefSize(10,20);

        componentField = new TextField();
        addComp = new Button("Add");
        typeTogggle = new ToggleGroup();
        typeSpecifier = new RadioButton[max];
        for(int x = 0; x < max; x++){
            typeSpecifier[x] = new RadioButton(types[x]);
            typeSpecifier[x].setToggleGroup(typeTogggle);
        }
        HBox types = new HBox(typeSpecifier);
        components = new VBox();
        addComp.setOnAction(event -> addItem(componentField.getText()));
        componentField.setOnAction(event -> addItem(componentField.getText()));
        HBox hBox = new HBox(componentField, addComp);
        this.getChildren().addAll(this.title,spacer, types, hBox, this.components);
    }

    public String getName(){
        return title.getText();
    }

    private void addItem(String str){
        if(componentField.getText().equals("")) return;
        RadioButton selected = (RadioButton) typeTogggle.getSelectedToggle();
        String ident = selected.getText();
        switch (ident) {
            case "Checkbox":
                boxes.add(new CheckBoxLabel(str + " ", count + 1));
                //criteria.add(new criterion(str + " ", 1, count + 1));
                break;
            case "Slider":
                boxes.add(new HSliderLabel(str + " ", count + 1));
                //criteria.add(new criterion(str + " ", 2, count + 1));
                break;
            case "RadioButton":
                boxes.add(new RadioButtonLabel(str + " ", count + 1));
                break;

        }
        values.add(boxes.get(count).value);
        componentField.clear();
        components.getChildren().clear();
        components.getChildren().addAll(boxes);
        count++;
    }

    void addItem(String str, String ident){
        switch (ident) {
            case "Checkbox":
                boxes.add(new CheckBoxLabel(str + " ", count + 1));
                //criteria.add(new criterion(str + " ", 1, count + 1));
                break;
            case "Slider":
                boxes.add(new HSliderLabel(str + " ", count + 1));
                //criteria.add(new criterion(str + " ", 2, count + 1));
                break;
            case "RadioButton":
                boxes.add(new RadioButtonLabel(str + " ", count + 1));
                break;
        }
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
            bufferedWriter.write(this.title.getText() + "\n");
            for(String s: strings){
                bufferedWriter.write(s + "\n");
            }
            bufferedWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    value getValue(int index){
        try{
            return boxes.get(index).value;
        }
        catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            return null;
        }
    }

    void outputValues(String filename) throws IOException, ArrayIndexOutOfBoundsException {
        CSVWriter writer = new CSVWriter(new FileWriter(filename));
        String[] row = new String[boxes.size()];
        int c = 0;
        for(HBoxWidgetAbstract a : boxes){
            String s = "hi";
            row[c++] = s;
        }
        writer.writeNext(row);
        writer.close();
    }

}
