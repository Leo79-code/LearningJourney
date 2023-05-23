import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.framework.junit5.Start;
import team.bupt.learningjourney.utils.Dialogs.TimetableImportDialog;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
class TimetableImportDialogTest extends ApplicationTest {

    private TimetableImportDialog dialog;

    @Start
    public void start(Stage stage) {
        dialog = new TimetableImportDialog();
        dialog.show();
    }

    @Test
    void testImport(FxRobot robot) {
        robot.clickOn("#nameField").write("Test Course");
        robot.clickOn("#weekChoiceBox").type(KeyCode.DOWN).type(KeyCode.ENTER);
        robot.clickOn("#timeChoiceBox").type(KeyCode.DOWN).type(KeyCode.ENTER);
        robot.clickOn("Import");

        String[] result = dialog.getResult();
        assertArrayEquals(new String[]{"Test Course", "Tue", "2"}, result);
    }

    @Test
    void testCancel(FxRobot robot) {
        robot.clickOn("Cancel");
        assertNull(dialog.getResult());
    }
}
