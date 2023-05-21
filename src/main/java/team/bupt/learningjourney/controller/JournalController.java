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
import team.bupt.learningjourney.utils.Dialogs.JournalImportDialog;

/**
 * @author Xinxiu Liu
 * @date 2023/05/19
 * This class is used to control the Journal UI
 */
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
        Button buttonCheck = new Button("Check");
        buttonCheck.setTextFill(Color.GRAY);
        buttonCheck.setFont(Font.font("Verdana", FontWeight.BOLD, 18));

        HBox hBox1 = new HBox(22);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setMinHeight(90);
        Label top1 = new Label("Please choose semester:");
        top1.setTextFill(Color.BLACK);
        top1.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        ChoiceBox<String> choiceBox1 = new ChoiceBox<String>(FXCollections.observableArrayList("one", "two", "three", "four", "five", "six", "seven", "eight"));
        choiceBox1.setOnAction(e -> sem = choiceBox1.getSelectionModel().getSelectedItem());
        Label top2 = new Label("Please choose week:");
        top2.setTextFill(Color.BLACK);
        top2.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        ChoiceBox<String> choiceBox2 = new ChoiceBox<String>(FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"));
        choiceBox2.setOnAction(e -> week = choiceBox2.getSelectionModel().getSelectedItem());
        hBox1.getChildren().addAll(top1, choiceBox1, top2, choiceBox2, buttonCheck);
        borderPane.setTop(hBox1);

        buttonCheck.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                loadFile();
            }
        });
        Text text3 = new Text("Welcome to My Journey!");
        text3.setFill(Color.ORANGE);
        text3.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
        text3.setFill(Color.rgb(189, 49, 36));
        VBox vBox2 = new VBox(20);
        vBox2.setMinSize(10, 10);
        Image image = new Image("file:src/main/resources/journey.jpg");
        ImageView imageView = new ImageView(image);
        vBox2.setAlignment(Pos.CENTER);
        vBox2.getChildren().addAll(text3, imageView);
        borderPane.setCenter(vBox2);
        HBox hBox3 = new HBox(20);
        hBox3.setMinHeight(90);
        hBox3.setAlignment(Pos.CENTER);
        Button buttonAdd = new Button("Append");

        buttonAdd.setTextFill(Color.GRAY);
        buttonAdd.setFont(Font.font("Verdana", FontWeight.BOLD, 22));
        buttonAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                onImportButtonClick();
            }
        });
        hBox3.getChildren().addAll(buttonAdd);
        borderPane.setBottom(hBox3);
        borderPane.setBackground(Background.fill(Color.rgb(242, 202, 42, .7)));

    }

    /**
     * This method is used to load Journal.json
     */
    public void loadFile() {
        for (Journal journal : journals) {
            addLabel(journal);
        }
    }

    /**
     * @param journal a journal object
     * This method is used show the information stored in object
     */
    public void addLabel(Journal journal) {
        Label label = new Label(journal.getDes());
        label.setFont(Font.font("", FontWeight.BOLD, 20));
        String sem1 = journal.getSem();
        int week1 = journal.getWeek();
        String url = journal.getUrl();
        Image image = new Image(url);
        ImageView imageView = new ImageView(image);

        if (sem1.equals(sem) && String.valueOf(week1).equals(week)) {
            VBox vBox = new VBox(20);
            vBox.setMinSize(10, 10);
            vBox.setAlignment(Pos.CENTER);
            vBox.getChildren().addAll(imageView, label);
            borderPane.setCenter(vBox);
        }
    }

    /**
     * The method is used to define action about import journey.
     */
    protected void onImportButtonClick() {
        JournalImportDialog dialog = new JournalImportDialog();
        dialog.setHeaderText("Please add Journal");
        dialog.showAndWait().ifPresent(result -> {

            String sem = result[0];
            int week = Integer.parseInt(result[1]);
            String des = result[2];
            String url = result[3];

            ObjectNode childNode = objectMapper.createObjectNode();
            childNode.put("sem", sem);
            childNode.put("week", week);
            childNode.put("des", des);
            childNode.put("url", url);
            loadFile();
            ((ArrayNode) rootNode).add(childNode);
            try {
                objectMapper.writeValue(jsonFile, rootNode);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}





