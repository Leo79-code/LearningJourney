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
import team.bupt.learningjourney.utils.Dialogs.JournalImportDialog;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
class JournalImportDialogTest extends ApplicationTest {

    private JournalImportDialog dialog;

    @Start
    public void start(Stage stage) {
        dialog = new JournalImportDialog();
        dialog.show();
    }

    @Test
    void testImport(FxRobot robot) {
        robot.clickOn("#semField").write("one");
        robot.clickOn("#weekField").write("1");
        robot.clickOn("#describeField").write("Test Journal");
        robot.clickOn("#urlField").write("src/main/resources/test.jpg");
        robot.clickOn("Import");

        String[] result = dialog.getResult();
        assertArrayEquals(new String[]{"one", "1", "Test Journal", "src/main/resources/test.jpg"}, result);
    }

    @Test
    void testCancel(FxRobot robot) {
        robot.clickOn("Cancel");

        assertNull(dialog.getResult());
    }
}
