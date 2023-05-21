package team.bupt.learningjourney.views.service.impl;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import java.io.IOException;

import team.bupt.learningjourney.controller.AwardsController;
import team.bupt.learningjourney.views.service.IPageService;

/**
 * @author Jiayi Meng
 * @date 2023/05/19
 * used to create a pane for UI
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
