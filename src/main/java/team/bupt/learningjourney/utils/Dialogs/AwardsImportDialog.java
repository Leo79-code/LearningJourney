package team.bupt.learningjourney.utils.Dialogs;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
/**
 * @author Jiayi Meng
 * @date 2023/05/19
 * Used to implement importAward function
 */
public class AwardsImportDialog extends Dialog<String[]> {
    public AwardsImportDialog() {
        setTitle("Add Awards!");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        TextField nameField = new TextField();
        nameField.setId("nameField");

        TextField yearField = new TextField();
        yearField.setId("yearField");

        TextField kindField = new TextField();
        kindField.setId("kindField");

        TextField projectField = new TextField();
        projectField.setId("projectField");

        TextField memberField = new TextField();
        memberField.setId("memberField");

        TextField awardField = new TextField();
        awardField.setId("awardField");

        TextField bonusField = new TextField();
        bonusField.setId("bonusField");


        grid.add(new Label("Award Name:"), 0, 0);
        grid.add(nameField, 1, 0);

        grid.add(new Label("Year:"), 0, 1);
        grid.add(yearField, 1, 1);

        grid.add(new Label("Kind:"), 0, 2);
        grid.add(kindField, 1, 2);

        grid.add(new Label("Project Name:"), 0, 3);
        grid.add(projectField, 1, 3);

        grid.add(new Label("Team Member:"), 0, 4);
        grid.add(memberField, 1, 4);

        grid.add(new Label("Award:"), 0, 5);
        grid.add(awardField, 1, 5);

        grid.add(new Label("Bonus:"), 0, 6);
        grid.add(bonusField, 1, 6);

        getDialogPane().setContent(grid);

        ButtonType importButtonType = new ButtonType("Import", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButtonType = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        getDialogPane().getButtonTypes().addAll(importButtonType, cancelButtonType);

        setResultConverter(dialogButton -> {
            if (dialogButton == importButtonType) {
                String[] result = {nameField.getText(), yearField.getText(), kindField.getText(),projectField.getText(),memberField.getText(),awardField.getText(),bonusField.getText()};
                return result;
            }
            return null;
        });

        setWidth(800);
        setHeight(600);
    }
}
