package team.bupt.learningjourney.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.io.File;
import java.io.IOException;
import java.util.List;

import team.bupt.learningjourney.entities.Journal;

public class JournalController {

    private final BorderPane borderPane;

    ObjectMapper objectMapper = new ObjectMapper();
    File jsonFile = new File("src/main/resources/json/Journal.json");
    JsonNode rootNode = objectMapper.readTree(jsonFile);
    List<Journal> journals = objectMapper.readValue(jsonFile, new TypeReference<>() {
    });

    // BorderPane borderPane = new BorderPane();
    // HBox hBox = new HBox(20);
    public JournalController(BorderPane borderPane) throws IOException {
    this.borderPane = borderPane;
    }

    public void loadFile() {
        for (Journal journal : journals) {
            addLabel(journal);
        }
    }

    public void addLabel(Journal journal) {
        Label label = new Label(journal.getDes());
        System.out.println(journal.getDes());
        label.setFont(Font.font("",FontWeight.BOLD,20));
        borderPane.setCenter(label);
    }
}





