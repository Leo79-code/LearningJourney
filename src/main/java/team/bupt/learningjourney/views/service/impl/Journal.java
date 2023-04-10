package team.bupt.learningjourney.views.service.impl;

import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import team.bupt.learningjourney.controller.JournalController;
import team.bupt.learningjourney.views.service.IPageService;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

/**
 * @author
 */
public class Journal implements IPageService {

    private JournalController journalController;
    public BorderPane borderPane;

    @Override
    public Node generatePage(Pane root) {
        borderPane = new BorderPane();
        //上端布局
        Button button1 = new Button("Check");
        button1.setTextFill(Color.GRAY);
        button1.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        HBox hBox1 = new HBox(22);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setMinHeight(90);
        Label top1 = new Label("Please choose semester:");
        top1.setTextFill(Color.BLACK);
        top1.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        ChoiceBox choiceBox1 = new ChoiceBox(FXCollections.observableArrayList("one", "two", "three", "four", "five", "six", "seven", "eight"));
        Label top2 = new Label("Please choose week:");
        top2.setTextFill(Color.BLACK);
        top2.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        ChoiceBox choiceBox2 = new ChoiceBox(FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"));
        hBox1.getChildren().addAll(top1, choiceBox1, top2, choiceBox2, button1);
        borderPane.setTop(hBox1);

        //中间布局
        Text text3 = new Text("Welcome to My Journey!");
        text3.setFill(Color.ORANGE);
        text3.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
        VBox vBox2 = new VBox(20);
        vBox2.setMinSize(10, 10);
        Image image = new Image("file:src/main/resources/journey.jpg");
        ImageView imageView = new ImageView(image);
        vBox2.setAlignment(Pos.CENTER);
        vBox2.getChildren().addAll(text3, imageView);
        borderPane.setCenter(vBox2);

        //下端布局
        HBox hBox3 = new HBox(20);
        hBox3.setMinHeight(90);
        hBox3.setAlignment(Pos.CENTER);
        Button button2 = new Button("Delete");
        button2.setTextFill(Color.GRAY);
        button2.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Button button3 = new Button("Append");
        button3.setTextFill(Color.GRAY);
        button3.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        hBox3.getChildren().addAll(button2, button3);
        borderPane.setBottom(hBox3);

        borderPane.setBackground(Background.fill(Color.LIGHTGREY));

        return borderPane;
    }
}
