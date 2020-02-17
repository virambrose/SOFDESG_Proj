package sample;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

class CheckBoxLabel extends HBox {
    private CheckBox check;
    private Label label;

    CheckBoxLabel(String text){
        check = new CheckBox();
        label = new Label(text);
        this.getChildren().addAll(label, check);
    }
}
