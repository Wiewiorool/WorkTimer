import java.io.*;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        var scanner = new Scanner(System.in);
        int time = scanner.nextInt();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        Calendar c = Calendar.getInstance();
        String month = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
        Month month1 = Month.valueOf(month.toUpperCase());

        FileWriter myWriter = new FileWriter(month + ".txt", true);
        myWriter.write(dtf.format(now) + " " + Integer.toString(time) + " hours.");
        myWriter.write("\n");
        myWriter.flush();
        System.out.println("Successfully wrote to the file.");

        var scanner1 = new Scanner(new File(month + ".txt"));
        int sum = 0;

        while (scanner1.hasNextLine()) {
            String[] a = scanner1.nextLine().split(" ");
            sum += Integer.parseInt(a[1]);
        }
        /*Calendar last = Calendar.getInstance();
        last.add(Calendar.MONTH, -1);
        String lastMonth = last.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
        Month lastMonth1 = Month.valueOf(month.toUpperCase());*/

        BufferedReader reader = new BufferedReader(new FileReader(month + ".txt"));

        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();
        if (lines == YearMonth.now().lengthOfMonth()) {
            myWriter.write("Work time summary of " + month + " " + sum);
            myWriter.close();
        }

    }

}