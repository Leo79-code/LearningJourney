package team.bupt.learningjourney.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import team.bupt.learningjourney.entities.CourseInfo;
import team.bupt.learningjourney.utils.Dialogs.CourseImportDialog;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


/**
 * @author Tianhang Sun
 * @date 2023/05/19
 * The CourseCotroller is for adding and showing the content of courses
 */
public class CourseController {
    BorderPane bp = new BorderPane();
    //定义的变量
    ObjectMapper objectMapper = new ObjectMapper();
    //Jackson库用于数据绑定的类
    File jsonFile = new File("src/main/resources/json/Courses.json");
    //json文件
    JsonNode rootNode = objectMapper.readTree(jsonFile);
    //树模型的json节点
    List<CourseInfo> courses = objectMapper.readValue(jsonFile, new TypeReference<>() {
    });

    /**
     * @param bp
     * @throws IOException
     * The constructor receives the original panel in order to do changes in it
     */
    //readValue方法，将文件解析并且保存到List里，CoursesTime类就是POJO定义的
    public CourseController(BorderPane bp) throws IOException {
        this.bp = bp;
    }


    /**
     * @return {@link BorderPane}
     * This methods is for create table to show course contents and
     * also import courses information
     */
    public BorderPane loadFile() {

        TableView<CourseInfo> table = new TableView<>();



        final ObservableList<CourseInfo> data = FXCollections.observableArrayList();

        TableColumn<CourseInfo, String> NoCol = new TableColumn<>("No");
        NoCol.setMinWidth(75);
        NoCol.setCellValueFactory(new PropertyValueFactory<>("no"));

        NoCol.setCellFactory(TextFieldTableCell.<CourseInfo>forTableColumn());
        NoCol.setOnEditCommit(
                (TableColumn.CellEditEvent<CourseInfo, String> t) -> {
                    ((CourseInfo) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setCourseNo(t.getNewValue());
                });


        TableColumn<CourseInfo, String> SemesterCol =
                new TableColumn<>("Semester");
        SemesterCol.setMinWidth(175);
        SemesterCol.setCellValueFactory(
                new PropertyValueFactory<>("semester"));
        SemesterCol.setCellFactory(TextFieldTableCell.<CourseInfo>forTableColumn());
        SemesterCol.setOnEditCommit(
                (TableColumn.CellEditEvent<CourseInfo, String> t) -> {
                    ((CourseInfo) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setSemester(t.getNewValue());
                });

        TableColumn<CourseInfo, String> NameCol = new TableColumn<>("Name");
        NameCol.setMinWidth(175);
        NameCol.setCellValueFactory(
                new PropertyValueFactory<>("name"));
        NameCol.setCellFactory(TextFieldTableCell.<CourseInfo>forTableColumn());
        NameCol.setOnEditCommit(
                (TableColumn.CellEditEvent<CourseInfo, String> t) -> {
                    ((CourseInfo) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setCourseName(t.getNewValue());
                });

        TableColumn<CourseInfo, String> PropertyCol = new TableColumn<>("Property");
        PropertyCol.setMinWidth(160);
        PropertyCol.setCellValueFactory(
                new PropertyValueFactory<>("property"));
        PropertyCol.setCellFactory(TextFieldTableCell.<CourseInfo>forTableColumn());
        PropertyCol.setOnEditCommit(
                (TableColumn.CellEditEvent<CourseInfo, String> t) -> {
                    ((CourseInfo) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setProperty(t.getNewValue());
                });

        TableColumn<CourseInfo, String> CreditCol = new TableColumn<>("Credit");
        CreditCol.setMinWidth(145);
        CreditCol.setCellValueFactory(
                new PropertyValueFactory<>("credit"));
        CreditCol.setCellFactory(TextFieldTableCell.<CourseInfo>forTableColumn());
        CreditCol.setOnEditCommit(
                (TableColumn.CellEditEvent<CourseInfo, String> t) -> {
                    ((CourseInfo) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setCredit(Float.parseFloat(t.getNewValue()));
                });

        TableColumn<CourseInfo, String> GradeCol = new TableColumn<>("Grade");
        GradeCol.setMinWidth(145);
        GradeCol.setCellValueFactory(
                new PropertyValueFactory<>("grade"));
        GradeCol.setCellFactory(TextFieldTableCell.<CourseInfo>forTableColumn());
        GradeCol.setOnEditCommit(
                (TableColumn.CellEditEvent<CourseInfo, String> t) -> {
                    ((CourseInfo) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setGrade(Float.parseFloat(t.getNewValue()));
                });
        table.setEditable(true);
        table.getColumns().addAll(NoCol, SemesterCol, NameCol, PropertyCol, CreditCol, GradeCol);
        NoCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCourseNo()));
        SemesterCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSemester()));
        NameCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCourseName()));
        PropertyCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProperty()));
        CreditCol.setCellValueFactory(cellData -> new SimpleStringProperty(Float.toString(cellData.getValue().getCredit())));
        GradeCol.setCellValueFactory(cellData -> new SimpleStringProperty(Float.toString(cellData.getValue().getGrade())));


        for (CourseInfo course : courses) {
            data.add(
                    new CourseInfo(course.getCourseNo(), course.getSemester(), course.getCourseName(), course.getProperty(), course.getCredit(), course.getGrade())
            );
        }
        table.setItems(data);

        final HBox hb = new HBox();

        final Button ImButton = new Button("Import Data");
        ImButton.setTextFill(Color.rgb(84, 188, 189, .7));
        ImButton.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        ImButton.setOnAction(e->{
            onImportButtonClick();
        });

        hb.getChildren().addAll(ImButton);
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(40, 0, 40, 0));
        hb.setSpacing(3);


        final VBox vbox = new VBox();
        vbox.setSpacing(0);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(table);


        bp.setCenter(vbox);
        bp.setBottom(hb);

        return this.bp;
    }


    /**
     * This method is for getting information from customers input and
     * transfer them into JSONfiles
     */
    protected void onImportButtonClick() {
        CourseImportDialog dialog = new CourseImportDialog();
        dialog.setHeaderText("Please fill in the course information");
        dialog.showAndWait().ifPresent(result -> {
            int no1 = getLength()+1;
            String no =  Integer.toString(no1);
            String semester = result[0];
            String name = result[1];
            String property = result[2];
            float credit = Float.parseFloat(result[3]);
            float grade = Float.parseFloat(result[4]);

            for (CourseInfo course : courses) {
                if (course.getCourseName().equals(result[1])) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("The course has existed");
                    alert.showAndWait();
                    return ;
                }
            }



            ObjectNode childNode = objectMapper.createObjectNode();
            childNode.put("courseNo", no);
            childNode.put("semester", semester);
            childNode.put("courseName", name);
            childNode.put("property", property);
            childNode.put("credit", credit);
            childNode.put("grade", grade);

            ((ArrayNode) rootNode).add(childNode);

            try {
                objectMapper.writeValue(jsonFile, rootNode);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            loadFile();
        });
    }

    /**
     * @return int
     * This method is for finding the number of courses in JSON file
     */
    public int getLength(){
        int count=0;
        for(CourseInfo course:courses){
          count++;
        }
        return  count;
    }



}

