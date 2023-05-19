package team.bupt.learningjourney.utils.Dialogs;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class AwardsImportDialog extends Dialog<String[]> {
    public AwardsImportDialog() {
        // 创建对话框的标题
        setTitle("Add Awards!");

        // 创建GridPane来放置UI元素
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        // 创建UI元素
        TextField nameField = new TextField();
        TextField yearField = new TextField();
        TextField kindField = new TextField();
        TextField projectField = new TextField();
        TextField memberField = new TextField();
        TextField awardField = new TextField();
        TextField bonusField = new TextField();

        // 将UI元素添加到GridPane中
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
        // 将GridPane添加到对话框中
        getDialogPane().setContent(grid);

        // 创建"导入"按钮
        ButtonType importButtonType = new ButtonType("Import", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButtonType = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        getDialogPane().getButtonTypes().addAll(importButtonType, cancelButtonType);

        // 在用户点击"导入"按钮时执行操作
        setResultConverter(dialogButton -> {
            if (dialogButton == importButtonType) {
                //TODO: 在button中调用Controller类中的load方法
                String[] result = {nameField.getText(), yearField.getText(), kindField.getText(),projectField.getText(),memberField.getText(),awardField.getText(),bonusField.getText()};
                return result;
            }
            return null;
        });

        // 设置弹窗的宽度和高度
        setWidth(800);
        setHeight(600);
    }
}
