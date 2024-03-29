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

/**
 * @author Xinxiu Liu
 * @date 2023/05/19
 * Used to implement importJourney function
 */
public class JournalImportDialog extends Dialog<String[]> {
    public JournalImportDialog() {
        setTitle("Import New Journal:");
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        TextField semField = new TextField();
        semField.setId("semField");

        TextField weekField = new TextField();
        weekField.setId("weekField");

        TextField describeField = new TextField();
        describeField.setId("describeField");

        TextField urlField = new TextField();
        urlField.setId("urlField");

        grid.add(new Label("Semester:"), 0, 0);
        grid.add(semField, 1, 0);
        grid.add(new Label("Week:"), 0, 1);
        grid.add(weekField, 1, 1);
        grid.add(new Label("Description:"), 0, 2);
        grid.add(describeField, 1, 2);
        grid.add(urlField, 1, 3);

        Button buttonAddPhoto = new Button("Add photo");
        buttonAddPhoto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage = new Stage();
                FileChooser fc = new FileChooser();
                final String[] a = {new String()};
                fc.setTitle("upload files");
                fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Type","*.jpg","*.png","*.jpeg"));
                fc.setInitialDirectory(new File("D:\\photo"));
                List<File> list = fc.showOpenMultipleDialog(stage);
                list.forEach(new Consumer<File>() {
                    @Override
                    public void accept(File file) {
                        a[0] = file.getAbsolutePath();
                        final ImageView imageView = new ImageView(
                                new Image("file:\\"+a[0],200,200,false,false)
                        );
                        final String url  = a[0];
                        urlField.setText(a[0]);
                    }
                });
            }
        });
        grid.add(buttonAddPhoto,0,3);
        getDialogPane().setContent(grid);

        ButtonType importButtonType = new ButtonType("Import", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButtonType = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        getDialogPane().getButtonTypes().addAll(importButtonType, cancelButtonType);

        setResultConverter(dialogButton -> {
            if (dialogButton == importButtonType) {
                String[] result = {semField.getText(), weekField.getText(), describeField.getText(),urlField.getText()};
                return result;
            }
            return null;
        });

        setWidth(1000);
        setHeight(600);
    }
}
