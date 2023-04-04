package team.bupt.learningjourney.views.service.impl;

import javafx.scene.layout.Background;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * @author
 */
public class SchoolReport implements IPageService {

    @Override
    public Node generatePage(Pane root) {
        GridPane grid = new GridPane();
        //GridPane内容居中
        grid.setAlignment(Pos.CENTER);
        //水平间距
        grid.setHgap(10);
        //垂直间距
        grid.setVgap(10);
        //填充:距离上下左右外框
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setBackground(Background.fill(Color.rgb(242, 202, 42, .7)));

        Text scenetitle = new Text("Average Score & GPA");
        scenetitle.setFont(Font.font("STLiti", FontWeight.BOLD, 30));
        scenetitle.setFill(Color.rgb(189, 49, 36));
        //0行
        //0列
        //占用2列
        //占用1行
        grid.add(scenetitle, 0, 0, 2, 1);

        Label avg = new Label("Average Score for Postgraduate Recommendation");
        avg.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        grid.add(avg, 0, 4);

        Text avg_val = new Text("94.17");
        avg_val.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        avg_val.setFill(Color.BLUEVIOLET);
        grid.add(avg_val, 3, 4);

        Label gpa = new Label("GPA");
        gpa.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        grid.add(gpa, 0, 6);

        Text gpa_val = new Text("3.90/4");
        gpa_val.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        gpa_val.setFill(Color.BLUEVIOLET);
        grid.add(gpa_val, 3, 6);

        Label total_avg = new Label("Total Average Score of Courses");
        total_avg.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        grid.add(total_avg, 0, 8);

        Text total_avg_val = new Text("95.45");
        total_avg_val.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        total_avg_val.setFill(Color.BLUEVIOLET);
        grid.add(total_avg_val, 3, 8);

        Label quoEstim = new Label("Quota Estimate for Postgraduate Recommendation");
        quoEstim.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        grid.add(quoEstim, 0, 10);

        Text quoEstim_val = new Text("35/173");
        quoEstim_val.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        quoEstim_val.setFill(Color.BLUEVIOLET);
        grid.add(quoEstim_val, 3, 10);

        Button btn = new Button("Export Certificate");
        btn.setTextFill(Color.rgb(84, 188, 189, .7));
        btn.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        //登录按钮放到水平布局HBox中方便控制左右
        //HBox hbBtn = new HBox(50);
        //hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        //hbBtn.getChildren().add(btn);
        //grid.add(hbBtn, 0, 14,2,1);
        grid.add(btn, 0, 13, 3, 2);
        final Text actiontarget = new Text();
        grid.add(actiontarget, 0, 16, 5, 1);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Your Certificate has been Generated");
            }
        });
        return grid;
    }

}
