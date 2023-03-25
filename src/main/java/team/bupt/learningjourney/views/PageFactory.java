package team.bupt.learningjourney.views;

import team.bupt.learningjourney.views.service.IPageService;
import team.bupt.learningjourney.views.service.impl.*;

/**
 * @author Jian Liu
 */
public class PageFactory {

    public static IPageService createPageService(String itemName) {
        IPageService pageService = null;
        switch (itemName) {
            case "Courses":
                pageService = new Courses();
                break;
            case "School Report":
                pageService = new SchoolReport();
                break;
            case "Contest":
                pageService = new Contest();
                break;
            case "Log":
                pageService = new Log();
                break;
            default:
                pageService = new Timetable();
                break;
        }
        return pageService;
    }
}
