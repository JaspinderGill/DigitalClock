import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Clock extends JFrame {

    // Global Variables
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;

    // Constructor
    void Clock() {
        // Set properties for the JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Java Clock");
        this.setLayout(new FlowLayout());
        this.setSize(350, 250);
        this.getContentPane().setBackground(Color.BLACK);
        this.setResizable(true);

        // See the format for the time, day and date
        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("MMMM  dd  yyyy");

        // Set properties for time label
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Helvetica", Font.PLAIN, 50));
        timeLabel.setForeground(new Color(248, 161, 100));
        timeLabel.setBackground(Color.black);

        // Set properties for day label
        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Helvetica", Font.PLAIN, 35));
        dayLabel.setForeground(new Color(243, 163, 180));

        // Set properties for date label
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Courier", Font.PLAIN, 35));
        dateLabel.setForeground(new Color(255, 160, 90));

        // Add all labels to the JFrame and set visible
        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.setVisible(true);

        // Run setTime() method
        setTime();
    }

    // Method to set the time and update every 1000ms
    public void setTime() {
        // Continuous loop to check time, day and date
        while (true) {
            // Get current time and set to timeLabel
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            // Get current day and set to dayLabel
            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            // Get current date and set to dateLabel
            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            // try catch block to sleep loop every 1000ms
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}