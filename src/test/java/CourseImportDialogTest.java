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
import team.bupt.learningjourney.utils.Dialogs.CourseImportDialog;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
class CourseImportDialogTest extends ApplicationTest {

    private CourseImportDialog dialog;

    @Start
    public void start(Stage stage) {
        dialog = new CourseImportDialog();
        dialog.show();
    }

    @Test
    void testImport(FxRobot robot) {
        robot.clickOn("#semesterField").write("2022-2023-2");
        robot.clickOn("#nameField").write("Test Course");
        robot.clickOn("#propertyField").write("optional");
        robot.clickOn("#creditField").write("3.0");
        robot.clickOn("#gradeField").write("90");
        robot.clickOn("Import");

        String[] result = dialog.getResult();
        assertArrayEquals(new String[]{"2022-2023-2", "Test Course", "optional", "3.0", "90"}, result);
    }

    @Test
    void testCancel(FxRobot robot) {
        robot.clickOn("Cancel");

        assertNull(dialog.getResult());
    }
}
