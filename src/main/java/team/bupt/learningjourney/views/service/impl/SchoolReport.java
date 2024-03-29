package team.bupt.learningjourney.views.service.impl;

import javafx.scene.layout.Background;
import team.bupt.learningjourney.controller.JSONToExcelUtil;
import team.bupt.learningjourney.views.service.IPageService;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import java.io.IOException;

import team.bupt.learningjourney.controller.SchoolReportController;

/**
 * @author Li Sizhe
 * @date 2023/05/18
 * The class is corresponding to the appearance of the page. It also defines the clicking action
 */
public class SchoolReport implements IPageService {

    /**
     * @param root Pass in the sub-page node in the main page menu
     * @return {@link Node} A Node is returned to RunApplication.java
     * The method defines the structure and the content of the page
     */
    @Override
    public Node generatePage(Pane root) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        grid.setBackground(Background.fill(Color.rgb(242, 202, 42, .7)));

        Text scenetitle = new Text("Average Score & GPA");
        scenetitle.setFont(Font.font("STLiti", FontWeight.BOLD, 30));
        scenetitle.setFill(Color.rgb(189, 49, 36));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label avg = new Label("Average Score for Postgraduate Recommendation");
        avg.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        grid.add(avg, 0, 4);

        Label gpa = new Label("GPA");
        gpa.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        grid.add(gpa, 0, 6);

        Label total_avg = new Label("Total Average Score of Courses");
        total_avg.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        grid.add(total_avg, 0, 8);

        Label quoEstim = new Label("Quota Estimate for Postgraduate Recommendation");
        quoEstim.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        grid.add(quoEstim, 0, 10);

        Button btn = new Button("Export Certificate");
        btn.setTextFill(Color.rgb(84, 188, 189, .7));
        btn.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        grid.add(btn, 0, 13, 3, 2);
        final Text actiontarget = new Text();
        grid.add(actiontarget, 0, 16, 5, 1);

        try {
            SchoolReportController sr = new SchoolReportController(grid);
            grid = sr.loadFile();

            btn.setOnAction(new EventHandler<ActionEvent>() {

                /**
                 * @param e The parameter refers to the clicking event
                 * The method defines what to happen when clicking the button
                 */
                @Override
                public void handle(ActionEvent e) {
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Your Certificate has been Generated");
                    new JSONToExcelUtil().exportExcel();
                }
            });
            return grid;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
