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
        System.out.println(" .----------------.  .----------------.  .----------------.  .----------------. ");
        System.out.println("| .--------------. || .--------------. || .--------------. || .--------------. |");
        System.out.println("| | _____  _____ | || |     ____     | || |  _______     | || |  ___  ____   | |");
        System.out.println("| ||_   _||_   _|| || |   .'    `.   | || | |_   __ \\    | || | |_  ||_  _|  | |");
        System.out.println("| |  | | /\\ | |  | || |  /  .--.  \\  | || |   | |__) |   | || |   | |_/ /    | |");
        System.out.println("| |  | |/  \\| |  | || |  | |    | |  | || |   |  __ /    | || |   |  __'.    | |");
        System.out.println("| |  |   /\\   |  | || |  \\  `--'  /  | || |  _| |  \\ \\_  | || |  _| |  \\ \\_  | |");
        System.out.println("| |  |__/  \\__|  | || |   `.____.'   | || | |____| |___| | || | |____||____| | |");
        System.out.println("| |              | || |              | || |              | || |              | |");
        System.out.println("| '--------------' || '--------------' || '--------------' || '--------------' |");
        System.out.println(" '----------------'  '----------------'  '----------------'  '----------------' ");

        var scanner = new Scanner(System.in);
        File file = new File(directory);
        if (!file.exists()) {
            file.mkdirs();
        }

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