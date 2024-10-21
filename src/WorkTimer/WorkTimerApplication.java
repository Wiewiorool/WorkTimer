/*
package WorkTimer;

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

    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static LocalDateTime now = LocalDateTime.now();


    public static void main(String[] args) throws IOException {




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



*/
