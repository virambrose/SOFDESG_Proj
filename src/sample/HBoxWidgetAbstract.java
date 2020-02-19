package sample;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

abstract class HBoxWidgetAbstract extends HBox {
    private Label label;
    private Label number;

    abstract String getText();

    abstract String  getNumText();
}
