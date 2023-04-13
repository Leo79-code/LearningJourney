package team.bupt.learningjourney.controller;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class ControllerInitiator {
    public static void initPageController(String itemName, Node node) throws IOException {
        switch (itemName) {
            case "Timetable":
                break;
            case "Courses":
                CourseController courseController = new CourseController((BorderPane) node);
                courseController.loadFile();
                break;
            case "School Report":
                SchoolReportController schoolReportController = new SchoolReportController((GridPane) node);
                schoolReportController.loadFile();
                break;
            case "Awards":

                break;
            case "Journal":
                JournalController journalController = new JournalController((BorderPane) node);
                journalController.loadFile();
                break;
            default:

                break;
        }
        return;
    }
}
