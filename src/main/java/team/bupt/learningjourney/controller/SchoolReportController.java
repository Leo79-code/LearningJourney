package team.bupt.learningjourney.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.text.Text;
import team.bupt.learningjourney.entities.CourseInfo;

/**
 * @author Li Sizhe
 * @date 2023/05/18
 * The controller obtain courses info from Courses.json and calculate the performance statistics
 */
public class SchoolReportController {
    GridPane grid = new GridPane();

    public SchoolReportController(GridPane grid) throws IOException {
        this.grid = grid;
    }

    ObjectMapper objectMapper = new ObjectMapper();
    File jsonFile = new File("src/main/resources/json/Courses.json");
    JsonNode rootNode = objectMapper.readTree(jsonFile);
    List<CourseInfo> coursesInfos = objectMapper.readValue(jsonFile, new TypeReference<>() {
    });

    /**
     * @return {@link GridPane}
     * The method is responsible for calculation, and it returns the GridPane to ControllerInitiator
     */
    public GridPane loadFile() {
        ArrayList<Float> aspList = new ArrayList<>();
        ArrayList<Float> aspCreditList = new ArrayList<>();
        ArrayList<Float> asList = new ArrayList<>();
        ArrayList<Float> asCreditList = new ArrayList<>();
        for (CourseInfo courseInfo : coursesInfos) {
            if (courseInfo.getProperty().equals("compulsory"))
                courseInfo.getCredit();
            courseInfo.getGrade();
            aspList.add(courseInfo.getGrade());
            aspCreditList.add(courseInfo.getCredit());
            if (courseInfo.getProperty().equals("selected") || courseInfo.getProperty().equals("compulsory"))
                courseInfo.getCredit();
            courseInfo.getGrade();
            asList.add(courseInfo.getGrade());
            asCreditList.add(courseInfo.getCredit());
        }
        int size1 = aspList.size();
        int size2 = asList.size();
        float addGrade1 = 0;
        float addCredit1 = 0;
        float addGrade2 = 0;
        float asp = 0;
        float as = 0;
        double gpa = 0;
        double perc = 0;
        for (int i = 0; i < size1; i++) {
            addGrade1 += aspList.get(i) * aspCreditList.get(i);
            addCredit1 += aspCreditList.get(i);
        }
        for (int i = 0; i < size2; i++) {
            addGrade2 += asList.get(i);
        }
        asp = (float) addGrade1 / addCredit1;
        as = (float) addGrade2 / size2;
        gpa = (asp / 100) * 4.0;

        //Range 70 ~ 95
        if (as > 95.0) {
            perc = 0.01 * 100;
        } else if (as < 70.0) {
            perc = 0.80 * 100;
        } else {
            perc = ((95 - asp) / 60.0) * 100;
        }


        Text avg_val = new Text(String.format("%.2f", asp));
        avg_val.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        avg_val.setFill(Color.BLUEVIOLET);
        grid.add(avg_val, 3, 4);

        Text gpa_val = new Text(String.format("%.2f", gpa));
        gpa_val.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        gpa_val.setFill(Color.BLUEVIOLET);
        grid.add(gpa_val, 3, 6);

        Text total_avg_val = new Text(String.format("%.2f", as));
        total_avg_val.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        total_avg_val.setFill(Color.BLUEVIOLET);
        grid.add(total_avg_val, 3, 8);

        Text quoEstim_val = new Text(String.format("%.2f", perc) + " %");
        quoEstim_val.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        quoEstim_val.setFill(Color.BLUEVIOLET);
        grid.add(quoEstim_val, 3, 10);

        return this.grid;
    }
}