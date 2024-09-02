import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.*;

/**
 * Class for taking the inputs and producing the table
 */
public class Calculator implements ActionListener {
  private double index;
  private double rating;
  private int par;
  private double start;
  private double stop;
  private double step;
  private boolean player; // whether the table is for players

  private MainFrame mf;

  public Calculator(MainFrame mf) {
    this.mf = mf;
    mf.addListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    index = mf.getIndex();
    rating = mf.getRating();
    par = mf.getPar();
    start = mf.getStart();
    stop = mf.getStop();
    step = mf.getStep();

    if (e.getActionCommand().equalsIgnoreCase("Course")) {
      player = false;
    }
    else {
      player = true;
    }

    String leftString = "";
    String rightString = "";

    // creates BigDecimal values for calculations
    BigDecimal handicap = BigDecimal.valueOf(start); // current handicap being calculated
    BigDecimal currentLower = BigDecimal.valueOf(start); // current lower value in range
    BigDecimal bigStep = BigDecimal.valueOf(step); // the step between handicaps
    int currentValue = calculateValue(handicap); // current range's value

    while (handicap.doubleValue() <= stop) {
      int newValue = calculateValue(handicap);

      // checks to see if the value has changed
      if (newValue > currentValue) {
        // appends strings with new ranges
        String newLine = currentLower + " to " + handicap.subtract(bigStep) + "\n";
        leftString = leftString + newLine;
        rightString = rightString + currentValue + "\n";

        // starts the next range of handicaps
        currentLower = handicap;
        currentValue = newValue;
      }

      // iterates to next handicap
      handicap = handicap.add(bigStep);
    }

    // appends final range
    String newLine = currentLower + " to " + handicap.subtract(bigStep) + "\n";
    leftString = leftString + newLine;
    rightString = rightString + currentValue + "\n";

    // sets the output of the mainframe
    mf.setOutput(leftString, rightString);
  }

  // calculates the value based on the handicap
  private int calculateValue(BigDecimal handicap) {
    BigDecimal courseFull = (handicap.multiply(BigDecimal.valueOf(index), new MathContext(5))).add(BigDecimal.valueOf(rating - par));

    // multiplies by 0.95 if it is the player handicaps
    if (player) {
      courseFull = courseFull.multiply(BigDecimal.valueOf(0.95));
    }

    return courseFull.setScale(0, RoundingMode.HALF_UP).intValue();
  }
}
