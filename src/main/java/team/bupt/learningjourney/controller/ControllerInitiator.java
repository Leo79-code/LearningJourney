package team.bupt.learningjourney.controller;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class ControllerInitiator {
    public static void initPageController(String itemName, Node node) throws IOException {
        switch (itemName) {
            case "Timetable":
                break;
            case "Courses":

                break;
            case "School Report":

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
