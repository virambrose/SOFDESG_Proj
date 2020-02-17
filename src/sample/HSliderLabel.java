package sample;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;

class HSliderLabel extends HBox {
    private Slider slider;
    private Label dLabel;
    private Label label;
    private double sliderVal;

    HSliderLabel(String text){
        label = new Label(text);
        dLabel = new Label("0.0");
        slider = new Slider(0.0d, 10.0d, 0.0d);
        sliderVal = 0.0d;
    }




}
