package team.bupt.learningjourney.utils.Dialogs;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;
import java.util.function.Consumer;

public class JournalImportDialog extends Dialog<String[]> {
    public JournalImportDialog() {
        // 创建对话框的标题
        setTitle("Import New Journal:");
        // 创建GridPane来放置UI元素
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        // 创建UI元素
        TextField semField = new TextField();
        TextField weekField = new TextField();
        TextField describeField = new TextField();
        TextField urlField = new TextField();

        // 将UI元素添加到GridPane中
        grid.add(new Label("Semester:"), 0, 0);
        grid.add(semField, 1, 0);

        grid.add(new Label("Week:"), 0, 1);
        grid.add(weekField, 1, 1);

        grid.add(new Label("Description:"), 0, 2);
        grid.add(describeField, 1, 2);

        grid.add(new Label("Photo Path"), 0, 3);
        grid.add(urlField, 1, 3);

        Button buttonAddPhoto = new Button("Add photo");
        buttonAddPhoto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("-----------ADD PHOTO------------");
                Stage stage = new Stage();
                FileChooser fc = new FileChooser();
                final String[] a = {new String()};
                fc.setTitle("upload files");
                fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("图片类型","*.jpg","*.png","*.jpeg"));
                fc.setInitialDirectory(new File("D:\\photo"));
                List<File> list = fc.showOpenMultipleDialog(stage);
                list.forEach(new Consumer<File>() {
                    @Override
                    public void accept(File file) {
                        a[0] = file.getAbsolutePath();
                        System.out.println(a[0]);
                        final ImageView imageView = new ImageView(
                                new Image("file:\\"+a[0],200,200,false,false)
                        );

                        System.out.println("file:\\"+a[0]);
                        final String url  = a[0];
                        urlField.setText(a[0]);
                    }
                });
            }
        });
        grid.add(buttonAddPhoto,1,4);


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
                String[] result = {semField.getText(), weekField.getText(), describeField.getText(),urlField.getText()};
                return result;
            }
            return null;
        });
        // 设置弹窗的宽度和高度
        setWidth(1400);
        setHeight(600);
    }
}
