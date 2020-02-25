package sample;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.Node;

public class Digit {
    private int xPos;
    private int yPos;
    private int value;
    private int width;
    private String operator;
    public Button button;
    public Digit(int value, int xPos, int yPos, Display display){
        this.value = value;
        this.xPos = xPos;
        this.yPos = yPos;
        String number = Integer.toString(value);
        button = new Button(number);
        button.setTranslateX(xPos);
        button.setTranslateY(yPos);
        button.setMaxHeight(20);
        button.setMaxWidth(35);
        button.setOnAction(actionEvent -> {
            display.screen.appendText(number);
        });
    }
    public Digit(String operator, int xPos, int yPos, Display display){
        this.operator = operator;
        this.xPos = xPos;
        this.yPos = yPos;
        button = new Button(operator);
        button.setTranslateX(xPos);
        button.setTranslateY(yPos);
        button.setMaxHeight(20);
        button.setMaxWidth(35);
        button.setOnAction(actionEvent -> {
            display.screen.appendText(operator);
        });
    }
    public Digit(String operator, int xPos, int yPos,int width, Display display){
        this.operator = operator;
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        button = new Button(operator);
        button.setTranslateX(xPos);
        button.setTranslateY(yPos);
        button.setMaxHeight(20);
        button.setMaxWidth(width);
        button.setOnAction(actionEvent -> {
            display.screen.appendText(operator);
        });
    }
}
