package team.bupt.learningjourney.utils.Dialogs;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

/**
 * @author Jian Liu
 * @date 2023/05/17
 * Pop-up window for importing course information
 */
public class TimetableImportDialog extends Dialog<String[]> {

    public TimetableImportDialog() {
        setTitle("Import New Course");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        TextField nameField = new TextField();
        TextField timeField = new TextField();
        TextField weekField = new TextField();

        grid.add(new Label("Course Name:"), 0, 0);
        grid.add(nameField, 1, 0);

        grid.add(new Label("Weekday:"), 0, 1);
        grid.add(weekField, 1, 1);

        grid.add(new Label("Class Time:"), 0, 2);
        grid.add(timeField, 1, 2);

        getDialogPane().setContent(grid);

        ButtonType importButtonType = new ButtonType("Import", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButtonType = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        getDialogPane().getButtonTypes().addAll(importButtonType, cancelButtonType);

        setResultConverter(dialogButton -> {
            if (dialogButton == importButtonType) {
                String[] result = {nameField.getText(), weekField.getText(), timeField.getText()};
                return result;
            }
            return null;
        });

        setWidth(800);
        setHeight(600);
    }
}
