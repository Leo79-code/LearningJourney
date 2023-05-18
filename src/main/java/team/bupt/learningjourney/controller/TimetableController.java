package team.bupt.learningjourney.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import team.bupt.learningjourney.entities.CoursesTime;
import team.bupt.learningjourney.utils.Dialogs.CourseImportDialog;


import java.io.File;
import java.io.IOException;
import java.util.List;


/**
 * @author Jian Liu
 * @date 2023/05/15
 * The JavaFX Controller for the Timetable Page
 */
public class TimetableController {
    @FXML
    public BorderPane rootPane;
    public GridPane timetable;

    ObjectMapper objectMapper = new ObjectMapper();
    File jsonFile = new File("src/main/resources/json/CoursesTime.json");
    JsonNode rootNode = objectMapper.readTree(jsonFile);
    List<CoursesTime> coursesTimes = objectMapper.readValue(jsonFile, new TypeReference<>() {
    });

    public TimetableController() throws IOException {
    }


    /**
     * @param coursesTime A custom POJO class for storing course time information
     * Set each course as a label and add it to the GridPane
     */
    public void addLabel(CoursesTime coursesTime) {
        Label label = new Label(coursesTime.getCourseName());
        label.setFont(Font.font("", FontWeight.BOLD, 28));

        String weekdays = coursesTime.getWeekday();
        int col = switch (weekdays) {
            case "Mon" -> 1;
            case "Tue" -> 2;
            case "Wed" -> 3;
            case "Thu" -> 4;
            case "Fri" -> 5;
            case "Sat" -> 6;
            case "Sun" -> 7;
            default -> 0;
        };
        timetable.add(label, col, coursesTime.getTime());
        GridPane.setHalignment(label, HPos.CENTER);
    }

    @FXML
    public void initialize() {
        loadFile();
    }

    /**
     *
     */
    @FXML
    protected void onImportButtonClick() {
        CourseImportDialog dialog = new CourseImportDialog();
        dialog.setHeaderText("Please fill in the course information");
        dialog.showAndWait().ifPresent(result -> {
            String name = result[0];
            String week = result[1];
            int time = Integer.parseInt(result[2]);

            ObjectNode childNode = objectMapper.createObjectNode();
            childNode.put("courseName", name);
            childNode.put("weekday", week);
            childNode.put("time", time);
            ((ArrayNode) rootNode).add(childNode);

            try {
                objectMapper.writeValue(jsonFile, rootNode);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void loadFile() {
        for (CoursesTime coursesTime : coursesTimes) {
            addLabel(coursesTime);
        }
    }
}
