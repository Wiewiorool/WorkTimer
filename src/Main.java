import java.io.*;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static double salaryPerHour = 31.44;
    private static int sum = 0;
    private static int lines = 0;
    private static double yearlySalary = 0;
    private static String hours = "hours";
    private static String hour = "hour";
    private static String h = " ";

    public static void main(String[] args) throws IOException {


        System.out.println("How much hour's did You worked today?");
        var scanner = new Scanner(System.in);
        int time = scanner.nextInt();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        Calendar c = Calendar.getInstance();
        String month = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
        Month month1 = Month.valueOf(month.toUpperCase());

        if (time == 1) {
            h = hour;
        } else {
            h = hours;
        }

        FileWriter myWriter = new FileWriter(month + ".txt", true);
        myWriter.write(dtf.format(now) + " " + Integer.toString(time) + " " + h);
        myWriter.write("\n");
        myWriter.flush();
        System.out.println("Successfully wrote to the file.");

        var scanner1 = new Scanner(new File(month + ".txt"));

        while (scanner1.hasNextLine()) {
            String[] a = scanner1.nextLine().split(" ");
            sum += Integer.parseInt(a[1]);
        }
        /* Calendar last = Calendar.getInstance();
        last.add(Calendar.MONTH, -1);
        String lastMonth = last.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
        Month lastMonth1 = Month.valueOf(month.toUpperCase()); */

        BufferedReader reader = new BufferedReader(new FileReader(month + ".txt"));

        while (reader.readLine() != null) lines++;
        reader.close();
        if (lines == YearMonth.now().lengthOfMonth()) {
            myWriter.write("Work time summary of " + month + " " + sum);
            myWriter.write("\n");
            myWriter.write("Salary for september: " + sum * salaryPerHour + " PLN");
            myWriter.close();
        }

    }
/*
    public class TimerButtons implements ActionListener {
        JFrame frame;
        JTextField textField;
        JButton[] functionButtons = new JButton[3];
        JButton addButton, sumButton;
        JPanel panel;

        Font myFont = new Font("Times New Roman", Font.PLAIN, 15);

        TimerButtons() {
            frame = new JFrame("Work Timer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(420, 550);
            frame.setLayout(null);
            frame.getColorModel();

            textField = new JTextField();
            textField.setBounds(50, 25, 300, 50);
            textField.setFont(myFont);
            textField.setEditable(false);

            addButton = new JButton("Add hours of work");
            panel.add(addButton);
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.getFrameForComponent(addButton);

                }
            });

        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }*/

}