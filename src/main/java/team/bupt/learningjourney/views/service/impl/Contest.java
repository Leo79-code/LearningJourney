package team.bupt.learningjourney.views.service.impl;

import team.bupt.learningjourney.utils.StyleUtil;
import team.bupt.learningjourney.views.service.IPageService;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * @author
 */
public class Contest implements IPageService {

    @Override
    public Node generatePage(Pane root) {
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        Label test = new Label("Awards");
        StyleUtil.setFont(test, Color.RED, 30);
        vbox.getChildren().add(test);
        return vbox;
    }

}
