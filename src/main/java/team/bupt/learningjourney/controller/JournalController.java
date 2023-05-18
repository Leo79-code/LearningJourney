package team.bupt.learningjourney.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javafx.scene.text.Text;
import team.bupt.learningjourney.entities.Journal;
import team.bupt.learningjourney.utils.Dialogs.TimetableImportDialog;

public class JournalController {

    private final BorderPane borderPane;

    ObjectMapper objectMapper = new ObjectMapper();
    File jsonFile = new File("src/main/resources/json/Journal.json");
    JsonNode rootNode = objectMapper.readTree(jsonFile);
    List<Journal> journals = objectMapper.readValue(jsonFile, new TypeReference<>() {
    });
    String sem;
    String week;
    public JournalController(BorderPane borderPane) throws IOException {
    this.borderPane = borderPane;
    Button button1 = new Button("Check");
    button1.setTextFill(Color.GRAY);
    button1.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

    HBox hBox1 = new HBox(22);
    hBox1.setAlignment(Pos.CENTER);
    hBox1.setMinHeight(90);
    Label top1 = new Label("Please choose semester:");
    top1.setTextFill(Color.BLACK);
    top1.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
    ChoiceBox<String> choiceBox1 = new ChoiceBox<String>(FXCollections.observableArrayList("one", "two", "three", "four", "five", "six", "seven", "eight"));
    choiceBox1.setOnAction(e->sem=choiceBox1.getSelectionModel().getSelectedItem());
    Label top2 = new Label("Please choose week:");
    top2.setTextFill(Color.BLACK);
    top2.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
    ChoiceBox<String> choiceBox2 = new ChoiceBox<String>(FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"));
    choiceBox2.setOnAction(e->week=choiceBox2.getSelectionModel().getSelectedItem());
    hBox1.getChildren().addAll(top1, choiceBox1, top2, choiceBox2, button1);
    borderPane.setTop(hBox1);

    button1.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
            System.out.println("sem : "+sem);
            System.out.println("week : "+week);
            loadFile();
        }
    });

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
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                CourseImportDialog dialog = new CourseImportDialog();
                dialog.setHeaderText("Please fill in the journey information");
                dialog.showAndWait().ifPresent(result -> {

                    String name = result[0];
                    String week = result[1];
                    int time = Integer.parseInt(result[2]);

                    ObjectNode childNode = objectMapper.createObjectNode();
                    childNode.put("semester", name);
                    childNode.put("week", week);
                    childNode.put("picture's url", time);
                    ((ArrayNode) rootNode).add(childNode);
                    loadFile();
                });
            }
        });


        Button button3 = new Button("Append");
        button3.setTextFill(Color.GRAY);
        button3.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            }
        });

        hBox3.getChildren().addAll(button2, button3);
        borderPane.setBottom(hBox3);
        borderPane.setBackground(Background.fill(Color.LIGHTGREY));

    }

    public void loadFile() {
        for (Journal journal : journals) {
            addLabel(journal);
        }
    }

    public void addLabel(Journal journal) {
        Label label = new Label(journal.getDes());
        label.setFont(Font.font("",FontWeight.BOLD,20));
        String sem1 = journal.getSem();
        int week1 = journal.getWeek();
        String url = journal.getUrl();
        System.out.println(url);
        Image image = new Image(url);
        ImageView imageView = new ImageView(image);
        System.out.println(sem);
        System.out.println(week);
        System.out.println("---------------------");


        if(week!=null && sem1.equals(sem)){
            VBox vBox1 = new VBox(20);
            vBox1.setMinSize(10, 10);
            vBox1.setAlignment(Pos.CENTER);
            Label label1 = new Label("No Record!");
            label1.setFont(Font.font("",FontWeight.BOLD,20));
            vBox1.getChildren().add(label1);
            borderPane.setCenter(vBox1);
            System.out.println("匹配失败，展示初始页面");
        }
        if(sem1.equals(sem)&&String.valueOf(week1).equals(week)) {
            VBox vBox = new VBox(20);
            vBox.setMinSize(10, 10);
            vBox.setAlignment(Pos.CENTER);
            vBox.getChildren().addAll(imageView,label);
            borderPane.setCenter(vBox);
            System.out.println("匹配成功！");

        }


    }
}





