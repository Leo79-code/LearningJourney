package team.bupt.learningjourney.controller;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TimetableController {
    @FXML
    public BorderPane rootPane;
    public GridPane timetable;


    @FXML
    public void initialize() {
        addLabel("Math",1, 2);
        addLabel("English",5, 2);
        addLabel("PE",3, 4);
        addLabel("EBU5001",2, 7);
    }

    public void addLabel(String name, int col, int row) {
        Label label = new Label(name);
        label.setFont(Font.font("", FontWeight.BOLD, 28));
        timetable.add(label, col, row);
        GridPane.setHalignment(label, HPos.CENTER);
    }
}
