package team.bupt.learningjourney.views.service.impl;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import team.bupt.learningjourney.controller.AwardsController;
import team.bupt.learningjourney.controller.CourseController;
import team.bupt.learningjourney.utils.StyleUtil;
import team.bupt.learningjourney.views.service.IPageService;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.paint.Color;

import java.io.IOException;

/**
 * @author
 */
public class Awards implements IPageService {

    @Override
    public Node generatePage(Pane root) {
        BorderPane borderPane = new BorderPane();
        borderPane.setBackground(Background.fill(Color.rgb(242, 202, 42, .7)));
        borderPane.setPadding(new Insets(0, 120, 0, 120));
        try {
            AwardsController sr = new AwardsController(borderPane);
            borderPane = sr.loadFile();

            return borderPane;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
