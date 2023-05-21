package team.bupt.learningjourney.utils.Dialogs;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

/**
 * @author Jian Liu
 * @date 2023/05/17
 *
 */
public class TimetableImportDialog extends Dialog<String[]> {

    public TimetableImportDialog() {
        // 创建对话框的标题
        setTitle("Import New Course");

        // 创建GridPane来放置UI元素
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        // 创建UI元素
        TextField nameField = new TextField();
        TextField timeField = new TextField();
        TextField weekField = new TextField();

        // 将UI元素添加到GridPane中
        grid.add(new Label("Course Name:"), 0, 0);
        grid.add(nameField, 1, 0);

        grid.add(new Label("Weekday:"), 0, 1);
        grid.add(weekField, 1, 1);

        grid.add(new Label("Class Time:"), 0, 2);
        grid.add(timeField, 1, 2);

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
                String[] result = {nameField.getText(), weekField.getText(), timeField.getText()};
                return result;
            }
            return null;
        });

        // 设置弹窗的宽度和高度
        setWidth(800);
        setHeight(600);
    }
}
