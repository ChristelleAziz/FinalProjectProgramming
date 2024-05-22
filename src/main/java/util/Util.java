package util;

public class Util {
    /**
     * converts each word in a string to title case
     * @param strIn the input string
     * @return the string in title case
     */
    public static String toTitleCase(String strIn) {
        if (strIn == null || strIn.isEmpty()) {
            return strIn;
        }

        String[] words = strIn.split(" ");
        String firstWord = words[0];
        String secondWord = words[1];

        String titleCaseFirstWord = firstWord.substring(0, 1).toUpperCase() + firstWord.substring(1).toLowerCase();
        String titleCaseSecondWord = secondWord.substring(0, 1).toUpperCase() + secondWord.substring(1).toLowerCase();

        return titleCaseFirstWord + " " + titleCaseSecondWord;
    }
}
