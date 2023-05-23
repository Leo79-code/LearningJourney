package team.bupt.learningjourney.utils;

/**
 * @author Jian Liu
 * @date 2023/03/25
 * Data Utilities Classes
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
