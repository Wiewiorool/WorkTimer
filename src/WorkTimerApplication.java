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
    private static String directory = "/Users/Wiewior/WorkTimer";
    private static Calendar c = Calendar.getInstance();
    private static String month = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);

    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static LocalDateTime now = LocalDateTime.now();

    public static void main(String[] args) throws IOException {
        var scanner = new Scanner(System.in);

       /* File files = new File(directory);
        if (!files.exists()) {
            if (files.mkdirs()) {
                System.out.println("Directory is created! " + directory);
            } else {
                System.out.println("Failed to create directory!");
            }
        }*/


        System.out.println("How much hour's did You worked today?");
        int time = scanner.nextInt();
        if (time == 1) {
            h = String.valueOf(Hours.HOUR).toLowerCase();
        } else {
            h = String.valueOf(Hours.HOURS).toLowerCase();
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