package team.bupt.learningjourney.utils.Dialogs;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

/**
 * @author Jian Liu
 * @date 2023/05/17
 *
 */
public class CourseImportDialog extends Dialog<String[]> {

    public CourseImportDialog() {
        // 创建对话框的标题
        setTitle("Import New Course");

        // 创建GridPane来放置UI元素
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        // 创建UI元素
        TextField semesterField = new TextField();
        TextField nameField = new TextField();
        TextField propertyField = new TextField();
        TextField creditField = new TextField();
        TextField gradeField = new TextField();

        // 将UI元素添加到GridPane中
        grid.add(new Label("Course Semester:"), 0, 0);
        grid.add(semesterField, 1, 0);

        grid.add(new Label("Course Name:"), 0, 1);
        grid.add(nameField, 1, 1);

        grid.add(new Label("Course Property:"), 0, 2);
        grid.add(propertyField, 1, 2);

        grid.add(new Label("Course Credit"), 0, 3);
        grid.add(creditField, 1, 3);

        grid.add(new Label("Course Grade:"), 0, 4);
        grid.add(gradeField, 1, 4);

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
                String[] result = {semesterField.getText(), nameField.getText(), propertyField.getText(),creditField.getText(),gradeField.getText()};
                return result;
            }
            return null;
        });

        // 设置弹窗的宽度和高度
        setWidth(800);
        setHeight(600);
    }
}
