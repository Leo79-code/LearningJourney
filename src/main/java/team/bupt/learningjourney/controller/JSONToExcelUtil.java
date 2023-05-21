package team.bupt.learningjourney.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

/**
 * @author Li Sizhe
 * @date 2023/05/18
 * The class is used for generating Excel file according to the Json file
 */
public class JSONToExcelUtil {

    /**
     * The method will be called from SchoolReport.java when is asked to export Excel file
     */
    public void exportExcel() {
        String json = JSONToExcelUtil.readJsonFile("src/main/resources/json/Courses.json");

        try {
            String uploadFile = "generatedFile/test.xlsx";
            OutputStream excel = new FileOutputStream(uploadFile);
            XSSFWorkbook workBook = new XSSFWorkbook();
            XSSFSheet sheet = workBook.createSheet();
            XSSFRow row = null;
            XSSFCell cell = null;
            row = sheet.createRow(0);
            String[] names = {"courseNo", "semester", "courseName", "property", "credit", "grade"};
            for (int index = 0; index < 6; index++) {
                cell = row.createCell(index);
                cell.setCellValue(names[index]);
            }
            int count = 1;
            JSONArray dataArray = JSONArray.parseArray(json);
            for (int i = 0; i < dataArray.size(); i++) {
                JSONObject dataObj = dataArray.getJSONObject(i);
                String courseNo = dataObj.getString("courseNo");
                String semester = dataObj.getString("semester");
                String courseName = dataObj.getString("courseName");
                String property = dataObj.getString("property");
                String credit = dataObj.getString("credit");
                String grade = dataObj.getString("grade");

                row = sheet.createRow(count);
                cell = row.createCell(0);
                cell.setCellValue(courseNo);

                cell = row.createCell(1);
                cell.setCellValue(semester);

                cell = row.createCell(2);
                cell.setCellValue(courseName);

                cell = row.createCell(3);
                cell.setCellValue(property);

                cell = row.createCell(4);
                cell.setCellValue(credit);

                cell = row.createCell(5);
                cell.setCellValue(grade);

                count++;

            }
            workBook.write(excel);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * @param fileName The name of Json file
     * @return {@link String} The content of Json
     */
    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}