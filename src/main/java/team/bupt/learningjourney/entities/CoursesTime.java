package team.bupt.learningjourney.entities;

public class CoursesTime {
    private String courseName;
    private String weekday;
    private int time;

    public CoursesTime() {
    }

    public CoursesTime(String courseName, String weekday, int time) {
        this.courseName = courseName;
        this.weekday = weekday;
        this.time = time;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }
}
