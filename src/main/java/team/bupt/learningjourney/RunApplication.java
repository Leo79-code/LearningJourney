package team.bupt.learningjourney;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import team.bupt.learningjourney.utils.DataUtil;
import team.bupt.learningjourney.utils.ProjectValues;
import team.bupt.learningjourney.utils.StyleUtil;
import team.bupt.learningjourney.views.PageFactory;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;


import static team.bupt.learningjourney.controller.ControllerInitiator.initPageController;

/**
 * @author Jian Liu
 * @date 2023/04/17
 * The main entrance of JavaFX and the implementation of the main menu
 */
public class RunApplication extends Application {

    private HBox root;
    private Node currentPageNode = null;
    private VBox leftMenu;
    private Integer currentMenuIndex;
    private Integer tempIndex;

    @Override
    public void start(Stage primaryStage) throws Exception {
        double screenWidth = Screen.getPrimary().getBounds().getWidth();
        double screenHeight = Screen.getPrimary().getBounds().getHeight();
        root = new HBox();
        leftMenu = (VBox) getLeftMenu(root);
        root.getChildren().add(leftMenu);
        currentPageNode = PageFactory.createPageService("welcome").generatePage(root);

        HBox.setHgrow(currentPageNode, Priority.ALWAYS);
        root.getChildren().add(currentPageNode);
        StyleUtil.setPaneBackground(root, Color.WHITE);
        Scene scene = new Scene(root, 1280, 800);
        primaryStage.setTitle("Learning Journey");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Get the left navigation bar
     */
    private Node getLeftMenu(Pane root) {
        double leftWidth = ProjectValues.leftMenuWidth;
        VBox vbox = new VBox();
        vbox.setMinHeight(root.getPrefHeight());
        vbox.setMinWidth(leftWidth);
        StyleUtil.setPaneBackground(vbox, Color.web(ProjectValues.COLOR_PRIMARY));
        // Adding items to the navigation bar
        vbox.getChildren().addAll(getLeftMenuItemList(leftWidth));
        return vbox;
    }

    /**
     * Right side page routing
     */
    private Node routePage(Pane root, String itemName) throws IOException {
        Node node = PageFactory.createPageService(itemName).generatePage(root);
        initPageController(itemName, node);
        return node;
    }

    /**
     * Generate left navigation bar button
     */
    private List<Button> getLeftMenuItemList(double width) {
        double buttonHeight = 65;
        List<Button> buttonList = new ArrayList<>(5);
        String[] itemNames = {"Timetable", "Courses", "School Report", "Awards", "Journal"};
        for (String name : itemNames) {
            Button button = new Button(name);
            button.setMinWidth(width);
            button.setMinHeight(buttonHeight);
            StyleUtil.setButtonBackground(button, Color.web(ProjectValues.COLOR_PRIMARY), Color.WHITE);
            //Add the hover effect when the mouse moves over the navigation bar options
            button.setOnMouseMoved(event -> {
                if (currentMenuIndex == null || !button.getText().equals(itemNames[currentMenuIndex])) {
                    StyleUtil.setButtonBackground(button, Color.web(ProjectValues.COLOR_HOVER), Color.WHITE);
                    StyleUtil.setFont(button, Color.WHITE, -1);
                } else {
                    StyleUtil.setButtonBackground(button, Color.web(ProjectValues.COLOR_HOVER), Color.web(ProjectValues.COLOR_SELECTED));
                }
            });
            button.setOnMouseExited(event -> {
                if (currentMenuIndex == null || !button.getText().equals(itemNames[currentMenuIndex])) {
                    StyleUtil.setButtonBackground(button, Color.web(ProjectValues.COLOR_PRIMARY), Color.WHITE);
                } else {
                    StyleUtil.setButtonBackground(button, Color.web(ProjectValues.COLOR_PRIMARY), Color.web(ProjectValues.COLOR_SELECTED));
                }
            });
            button.setOnMouseClicked(event -> {
                currentMenuIndex = DataUtil.getIndexForArray(itemNames, button.getText());
                try {
                    currentPageNode = routePage(root, name);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                root.getChildren().remove(1);    //Clear the right page routing component node
                HBox.setHgrow(currentPageNode, Priority.ALWAYS);
                root.getChildren().add(currentPageNode);
                StyleUtil.setFont(button, Color.web(ProjectValues.COLOR_SELECTED), -1);
                //Checked state logic
                if (tempIndex != null) {
                    Button node = (Button) leftMenu.getChildren().get(tempIndex);
                    StyleUtil.setFont(node, Color.WHITE, -1);    //Clear selected state style
                    StyleUtil.setButtonBackground(node, Color.web(ProjectValues.COLOR_PRIMARY), Color.WHITE);
                }
                StyleUtil.setFont(button, Color.web(ProjectValues.COLOR_SELECTED), -1);    //Set the selected style
                tempIndex = currentMenuIndex;

            });
            buttonList.add(button);
        }
        return buttonList;
    }

    public static void main(String[] args) {
        launch();
    }

}
