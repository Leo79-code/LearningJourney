package team.bupt.learningjourney.views.service.impl;
import javafx.scene.layout.*;
import team.bupt.learningjourney.controller.JournalController;
import team.bupt.learningjourney.views.service.IPageService;
import javafx.scene.Node;

/**
 * @author Xinxiu Liu
 * @date 2023/05/19
 * used to create a pane for UI
 */
public class Journal implements IPageService {
    private JournalController journalController;
    public BorderPane borderPane;
    @Override
    public Node generatePage(Pane root) {
        borderPane = new BorderPane();
        return borderPane;
    }
}
