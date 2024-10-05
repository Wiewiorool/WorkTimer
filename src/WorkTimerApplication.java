
import java.io.*;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class WorkTimerApplication {


    private static double salaryPerHour = 31.44;
    private static int sum = 0;
    private static int lines = 0;
    private static double yearlySalary = 0;

    private static String h = " ";
    private static String directory = "C:/Users/Wiewior/WorkTimer/";
    private static Calendar c = Calendar.getInstance();
    private static String month = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
    private static String fileName = month + ".txt";

    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static LocalDateTime now = LocalDateTime.now();


    public static void main(String[] args) throws IOException {
        createDirectory();


        var scanner = new Scanner(System.in);

        FileWriter myWriter = new FileWriter(directory + fileName, true);

        System.out.println(" ");
        System.out.println("How many hour's did You worked today?");

        int time = scanner.nextInt();
        if (time == 1) {
            h = String.valueOf(Hours.HOUR).toLowerCase();
        } else {
            h = String.valueOf(Hours.HOURS).toLowerCase();
        }

        myWriter.write(dtf.format(now) + " " + Integer.toString(time) + " " + h);
        myWriter.write("\n");
        myWriter.flush();
        System.out.println("Successfully wrote to the file.");

        var scanner1 = new Scanner(new File(directory + fileName));

        while (scanner1.hasNextLine()) {
            String[] a = scanner1.nextLine().split(" ");
            sum += Integer.parseInt(a[1]);
        }

        BufferedReader reader = new BufferedReader(new FileReader(directory + fileName));

        while (reader.readLine() != null) lines++;
        reader.close();

        if (lines == YearMonth.now().

                lengthOfMonth()) {
            myWriter.write("Work time summary of " + month + " " + sum);
            myWriter.write("\n");
            myWriter.write("Salary for september: " + sum * salaryPerHour + " PLN");
            myWriter.close();
        }

    }

    private static void createDirectory() {
        File file = new File(directory);
        if (!file.exists()) {
            file.mkdirs();


        }
    }
}



