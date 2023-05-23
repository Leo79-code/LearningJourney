package team.bupt.learningjourney.views.service;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 * @author Jian Liu
 * @date 2023/03/25
 * Application Program Interface for Pages
 */
public interface IPageService {
    Node generatePage(Pane root);
}
