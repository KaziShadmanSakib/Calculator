package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.awt.*;
import java.util.Stack;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Display display = new Display();
        Digit level1[] = new Digit[4];
        Digit level2[] = new Digit[4];
        Digit level3[] = new Digit[5];
        int xPos = -160;
        int yPos = 60;
        int value = 7;
        for(int i=0;i<3;i++){
            level1[i] = new Digit(value,xPos,yPos,display);
            xPos = xPos + 50;
            value = value+1;
        }
        level1[3] = new Digit("/",xPos,yPos,display);
        xPos = -160;
        yPos = 95;
        value = 4;
        for(int i=0;i<3;i++){
            level2[i] = new Digit(value,xPos,yPos,display);
            xPos = xPos + 50;
            value = value+1;
        }
        level2[3] = new Digit("*",xPos,yPos,display);
        xPos = -160;
        yPos = 130;
        value = 1;
        for(int i=0;i<3;i++){
            level3[i] = new Digit(value,xPos,yPos,display);
            xPos = xPos + 50;
            value = value+1;
        }
        level3[3] = new Digit("-",xPos,yPos,display);
        Digit zeroButton = new Digit(0,-160,160,display);
        Digit percent = new Digit(".",-110,160,display);
        Digit dot = new Digit("%",-60,160,display);
        Digit plus = new Digit("+",-10,160,display);

        Button equal = new Button("=");
        equal.setTranslateX(60);
        equal.setTranslateY(160);
        equal.setMaxWidth(90);
        equal.setOnAction(actionEvent -> {
            Maths maths = new Maths();
            String expression = display.screen.getText();
            display.screen.clear();
            int result = maths.result(expression);
            String resultInString = Integer.toString(result);
            display.screen.setText(resultInString);
        });
        Button clear = new Button("C");
        clear.setTranslateX(60);
        clear.setTranslateY(118);
        clear.setMaxWidth(90);
        clear.setMinHeight(45);
        clear.setOnAction(actionEvent -> {
            display.screen.clear();
        });
        StackPane root = new StackPane(display.screen,level1[0].button,
                level1[1].button,level1[2].button,level1[3].button,level2[0].button,
                level2[1].button,level2[2].button,level3[0].button,level3[1].button,
                level3[2].button,zeroButton.button,level2[3].button,level3[3].button,
                plus.button,percent.button,dot.button,equal,clear);
        Scene scene = new Scene(root,370,370);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
