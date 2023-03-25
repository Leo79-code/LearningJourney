package team.bupt.learningjourney.utils;

/**
 * Data Utilities Classes
 *
 * @author Jian Liu
 */
public class DataUtil {

    public static int getIndexForArray(String[] array, String item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }
}
