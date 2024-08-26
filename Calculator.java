import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    mf.setOutput("To", "Do");
  }
}
