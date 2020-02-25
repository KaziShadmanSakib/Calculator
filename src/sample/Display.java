package sample;

import javafx.scene.control.TextField;

public class Display{
    public TextField screen;
    public Display(){
        screen = new TextField();
        screen.setTranslateX(0);
        screen.setTranslateY(-1);
        screen.setMaxWidth(350);
        screen.setMinHeight(70);
    }
}
