package sample;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

class CheckBoxLabel extends HBoxWidgetAbstract {
    private CheckBox check;
    private Label label;
    private Label number;

    CheckBoxLabel(String text, int count){
        check = new CheckBox();
        label = new Label(text);
        number = new Label(count + ". ");
        this.getChildren().addAll(number, label, check);
    }

    String getText(){
        return label.getText();
    }

    String getNumText(){
        return "#"+label.getText();
    }
}
