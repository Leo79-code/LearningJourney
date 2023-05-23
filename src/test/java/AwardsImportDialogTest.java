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
import team.bupt.learningjourney.utils.Dialogs.AwardsImportDialog;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
class AwardsImportDialogTest extends ApplicationTest {

    private AwardsImportDialog dialog;

    @Start
    public void start(Stage stage) {
        dialog = new AwardsImportDialog();
        dialog.show();
    }

    @Test
    void testImport(FxRobot robot) {
        robot.clickOn("#nameField").write("Test Award");
        robot.clickOn("#yearField").write("2023");
        robot.clickOn("#kindField").write("Innovation");
        robot.clickOn("#projectField").write("Test Project");
        robot.clickOn("#memberField").write("Alice, Bob");
        robot.clickOn("#awardField").write("First Prize");
        robot.clickOn("#bonusField").write("100");
        robot.clickOn("Import");

        String[] result = dialog.getResult();
        assertArrayEquals(new String[]{"Test Award", "2023", "Innovation", "Test Project", "Alice, Bob", "First Prize", "100"}, result);
    }

    @Test
    void testCancel(FxRobot robot) {
        robot.clickOn("Cancel");

        assertNull(dialog.getResult());
    }
}
