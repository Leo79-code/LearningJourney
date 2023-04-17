package team.bupt.learningjourney.entities;
//创建数据对象的
public class Journal {
    private String des;
    private String sem;
    private int week;
    private String url;

    public Journal() {
    }

    public Journal(String des, String sem, int week, String url) {
        this.des = des;
        this.sem = sem;
        this.week = week;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }
}
