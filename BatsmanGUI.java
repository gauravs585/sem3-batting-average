import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BatsmanGUI {
    private JFrame frame;
    private Batsman batsman;

    private JTextField runsTextField;
    private JTextField dismissalsTextField;

    public BatsmanGUI() {
        frame = new JFrame("Batsman Statistics");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        batsman = new Batsman();

        JLabel runsLabel = new JLabel("Total Runs:");
        frame.add(runsLabel);

        runsTextField = new JTextField(10);
        frame.add(runsTextField);

        JLabel dismissalsLabel = new JLabel("Number of Dismissals:");
        frame.add(dismissalsLabel);

        dismissalsTextField = new JTextField(10);
        frame.add(dismissalsTextField);

        JButton calculateButton = new JButton("Calculate Stats");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateAndDisplay();
            }
        });
        frame.add(calculateButton);

        frame.setVisible(true);
    }

    private void calculateAndDisplay() {
        try {
            int totalRuns = Integer.parseInt(runsTextField.getText());
            int numDismissals = Integer.parseInt(dismissalsTextField.getText());

            batsman.setTotalRuns(totalRuns);
            batsman.setNumDismissals(numDismissals);

            double result = batsman.calculateBattingAverage();

            // Display stats
            JOptionPane.showMessageDialog(frame,
                    "Total Runs: " + batsman.getTotalRuns() +
                            "\nNumber of Dismissals: " + batsman.getNumDismissals() +
                            "\nBatting Average: " + (result == -1 ? "Not Applicable" : result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter valid numeric values for runs and dismissals.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BatsmanGUI();
            }
        });
    }
}

