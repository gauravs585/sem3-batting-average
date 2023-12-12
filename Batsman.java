import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Batsman {
    private int totalRuns;
    private int numDismissals;

    public void setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
    }

    public void setNumDismissals(int numDismissals) {
        this.numDismissals = numDismissals;
    }

    public double calculateBattingAverage() {
        try {
            return (double) totalRuns / numDismissals;
        } catch (ArithmeticException e) {
            System.out.println("Batting average cannot be calculated as the batsman has not been dismissed.");
            return -1;
        }
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public int getNumDismissals() {
        return numDismissals;
    }

    public void displayStats() {
        System.out.println("\nBatsman Statistics:");
        System.out.println("Total Runs: " + totalRuns);
        System.out.println("Number of Dismissals: " + numDismissals);
        System.out.println("Batting Average: " + calculateBattingAverage());
    }
}

