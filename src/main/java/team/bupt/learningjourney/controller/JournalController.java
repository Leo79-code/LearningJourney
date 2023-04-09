package team.bupt.learningjourney.controller;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import team.bupt.learningjourney.entities.Journal;


import java.io.File;
import java.io.IOException;
import java.util.List;

public class JournalController {

    public BorderPane borderPane;
    ObjectMapper objectMapper = new ObjectMapper();
    File jsonFile = new File("src/main/resources/json/Journal.json");
    JsonNode rootNode = objectMapper.readTree(jsonFile);
    List<Journal> journals = objectMapper.readValue(jsonFile, new TypeReference<>() {
    });

    //BorderPane borderPane = new BorderPane();
    //HBox hBox = new HBox(20);
    public JournalController() throws IOException{}

    public void loadFile(){
        for (Journal journal:journals){
            addLabel(journal);
        }
    }
    public void addLabel (Journal journal){
     Label label = new Label(journal.getDes());

     //取出来了
     System.out.println(journal.getDes());
     label.setFont(Font.font("",FontWeight.BOLD,20));


    //borderPane = new BorderPane();
    //borderPane.setCenter(label);


    }





}





