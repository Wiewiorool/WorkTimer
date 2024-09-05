import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        var scanner = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();

        int a = scanner.nextInt();
        String sumAsString = Integer.toString(a);

        FileWriter myWriter = new FileWriter("sum.txt");
        myWriter.write(dtf.format(now) + " " + sumAsString + " godzin.");
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
    }
}