package team.bupt.learningjourney.views.service.impl;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import java.io.IOException;

import team.bupt.learningjourney.views.service.IPageService;
import team.bupt.learningjourney.controller.CourseController;

/**
 * @author Tianhang Sun
 * @date 2023/05/19
 * This class is an overview of whole course page
 */
public class Courses implements IPageService {
    /**
     * @param root Pass in the sub-page node in the main page menu
     * @return {@link Node} Return page node
     * This method is for generating a new page
     */
    @Override
    public Node generatePage(Pane root)  {

        Text label = new Text("Courses");
        label.setFont(Font.font("STLiti", FontWeight.BOLD, 50));
        label.setFill(Color.rgb(189, 49, 36));

        HBox hbox1 = new HBox();
        hbox1.setAlignment(Pos.CENTER);
        hbox1.setSpacing(10);
        hbox1.setPadding(new Insets(40, 0, 40, 0));
        hbox1.getChildren().addAll(label);

        BorderPane bp = new BorderPane();
        bp.setBackground(Background.fill(Color.rgb(242, 202, 42, .7)));
        bp.setPadding(new Insets(0, 120, 0, 120));
        bp.setTop(hbox1);

        try {
            CourseController sr = new CourseController(bp);
            bp = sr.loadFile();

            return bp;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}