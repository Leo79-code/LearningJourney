package team.bupt.learningjourney.controller;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import team.bupt.learningjourney.entities.CoursesTime;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class TimetableController {
    @FXML
    public BorderPane rootPane;
    public GridPane timetable;

    ObjectMapper objectMapper = new ObjectMapper();
    CoursesTime[] coursesTime;

    {
        try {
            coursesTime = objectMapper.readValue(new File("src/main/resources/json/CoursesTime.json"), CoursesTime[].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void initialize() {
        for(int i = 0; i <= coursesTime.length - 1; i++){
            addLabel(coursesTime[i]);
        }

    }

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
}
