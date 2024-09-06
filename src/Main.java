import java.io.*;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        var scanner = new Scanner(System.in);
        int time = scanner.nextInt();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDateTime now = LocalDateTime.now();

        FileWriter myWriter = new FileWriter("WorkingHours.txt", true);
        myWriter.write(dtf.format(now) + " " + Integer.toString(time) + " hours.");
        myWriter.write("\n");
        myWriter.close();
        System.out.println("Successfully wrote to the file.");

        Scanner scanner1 = new Scanner(new File("WorkingHours.txt"));

        int sum = 0;
        while (scanner1.hasNextLine()) {
            String[] a = scanner1.nextLine().split(" ");
            sum += Integer.parseInt(a[1]);
        }
        System.out.println(sum);
        scanner1.close();
        Calendar c = Calendar.getInstance();
        String month = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
        Month month1 = Month.valueOf(month.toUpperCase());
        //System.out.println(month1.length(true));

        String name = month + ".txt";
        FileWriter monthFile = new FileWriter(name);
        monthFile.write(Integer.toString(sum));
        monthFile.close();

        Calendar last = Calendar.getInstance();
        last.add(Calendar.MONTH, -1);
        String lastMonth = last.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
        Month lastMonth1 = Month.valueOf(month.toUpperCase());

        BufferedReader reader = new BufferedReader(new FileReader("WorkingHours.txt"));

        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();
        if (lines != lastMonth1.length(true)) {
            FileWriter lastMonthFile = new FileWriter(lastMonth + ".txt");
        }
    }
}