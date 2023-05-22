package team.bupt.learningjourney.utils.Dialogs;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jian Liu
 * @date 2023/05/17
 * Pop-up window for importing course information
 */
public class TimetableImportDialog extends Dialog<String[]> {

    public TimetableImportDialog() {
        List<String> weekChoices = new ArrayList<>();
        weekChoices.add("Mon");
        weekChoices.add("Tue");
        weekChoices.add("Wed");
        weekChoices.add("Thu");
        weekChoices.add("Fri");
        weekChoices.add("Sat");
        weekChoices.add("Sun");

        List<String> timeChoices = new ArrayList<>();
        timeChoices.add("1");
        timeChoices.add("2");
        timeChoices.add("3");
        timeChoices.add("4");
        timeChoices.add("5");
        timeChoices.add("6");
        timeChoices.add("7");
        timeChoices.add("8");

        setTitle("Import New Course");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        TextField nameField = new TextField();
        nameField.setId("nameField");

        ChoiceBox<String> timeChoiceBox = new ChoiceBox<>();
        timeChoiceBox.setId("timeChoiceBox");
        timeChoiceBox.getItems().addAll(timeChoices);
        timeChoiceBox.setMaxWidth(Double.MAX_VALUE);

        ChoiceBox<String> weekChoiceBox = new ChoiceBox<>();
        weekChoiceBox.setId("weekChoiceBox");
        weekChoiceBox.getItems().addAll(weekChoices);
        weekChoiceBox.setMaxWidth(Double.MAX_VALUE);


        grid.add(new Label("Course Name:"), 0, 0);
        grid.add(nameField, 1, 0);

        grid.add(new Label("Weekday:"), 0, 1);
        grid.add(weekChoiceBox, 1, 1);

        grid.add(new Label("Class Time:"), 0, 2);
        grid.add(timeChoiceBox, 1, 2);

        getDialogPane().setContent(grid);

        ButtonType importButtonType = new ButtonType("Import", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButtonType = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        getDialogPane().getButtonTypes().addAll(importButtonType, cancelButtonType);

        setResultConverter(dialogButton -> {
            if (dialogButton == importButtonType) {
                String[] result = {nameField.getText(), weekChoiceBox.getValue(), timeChoiceBox.getValue()};
                return result;
            }
            return null;
        });

        setWidth(800);
        setHeight(600);
    }
}
