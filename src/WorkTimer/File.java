package WorkTimer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;

public class File {
    private static Calendar c = Calendar.getInstance();
    private static String month = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
    private static String directory = "C:/Users/Wiewior/WorkTimer/";
    private static String fileName = month + ".txt";


    public File() throws IOException {

        FileWriter myWriter = new FileWriter(directory + fileName, true);


    }
}
