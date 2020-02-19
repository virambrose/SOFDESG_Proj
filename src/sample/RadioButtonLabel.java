package sample;

import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
public class RadioButtonLabel extends HBox {
    private Label label;
    private Label number;
    private Label rating;
    private RadioButton[] radioButtons;
    private ToggleGroup group;

    RadioButtonLabel(String label, int number){
        this.label = new Label(label);
        this.number = new Label(number + ". ");
        rating=new Label("1 2 3 4 5");
        radioButtons = new RadioButton[5];
        ToggleGroup group = new ToggleGroup();
        int counter = 1;
        for (RadioButton x : radioButtons){
            x=new RadioButton(Integer.toString(counter++));
            x.setToggleGroup(group);
        }
        this.getChildren().addAll(this.number, this.label);
        this.getChildren().addAll(this.radioButtons);


    }

}
