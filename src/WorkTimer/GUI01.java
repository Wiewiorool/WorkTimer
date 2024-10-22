package WorkTimer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

public class GUI01 {
    private static JFrame frame = new JFrame("Number");
    private static JTextField textField = new JTextField(10);
    private static JButton button = new JButton("Add your work time");

    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static LocalDateTime now = LocalDateTime.now();

    private static String h = " ";
    private static String directory = "C:/Users/Wiewior/WorkTimer/";
    private static Calendar c = Calendar.getInstance();
    private static String month = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
    private static String fileName = month + ".txt";

    public static void main(String[] args) {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());
        frame.add(textField);
        frame.add(button);

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                try {
                    int number = Integer.parseInt(text);
                    toFile(number);
                    textField.setText(" ");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
                }
            }
        });

        frame.setVisible(true);

    }

    private static void toFile(int number) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(directory + fileName, true))) {
            if (number == 1) {
                h = String.valueOf(Hours.HOUR).toLowerCase();
            } else {
                h = String.valueOf(Hours.HOURS).toLowerCase();
            }
            writer.write(dtf.format(now) + " " + number + " " + h);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
