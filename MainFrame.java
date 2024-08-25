import javax.swing.*;
import java.awt.GridLayout;

/**
 * Frame containing the whole user interface
 */
public class MainFrame extends JFrame {
  private int fieldNum = 7; // number of fields

  private JPanel mainPanel;
  private JPanel inputPanel;
  private JTextArea leftText;
  private JTextArea rightText;
  private JLabel[] labels; // labels for input fields
  private JTextField[] fields; // input fields
  private JButton startButton; // button to calculate table

  /**
   * Constructor for the mainframe
   */
  public MainFrame() {
    this.setSize(500, 500);

    mainPanel = new JPanel();
    inputPanel = new JPanel();
    leftText = new JTextArea(" ");
    rightText = new JTextArea(" ");
    leftText.setEditable(false);
    rightText.setEditable(false);

    this.add(mainPanel);

    mainPanel.setLayout(new GridLayout(1,3, 5, 5)); // sets the main panel to the grid layout
    inputPanel.setLayout(new GridLayout(9,2, 3, 3)); // sets the input panel to the grid layout

    mainPanel.add(inputPanel);
    mainPanel.add(leftText);
    mainPanel.add(rightText);

    createInput(inputPanel);

    this.setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  /**
   * Sets the output in the text areas to the given strings
   * @param left the text to display in the left area
   * @param right the text to display in the right area
   */
  public void setOutput(String left, String right) {
    leftText.setText(left);
    rightText.setText(right);
  }

  // creates the input panel and populates labels[] and fields[]
  private void createInput(JPanel inputPanel) {
    labels = new JLabel[fieldNum];
    fields = new JTextField[fieldNum];

    labels[0] = new JLabel("Course Index: ");
    labels[1] = new JLabel("/");
    labels[2] = new JLabel("Course Rating: ");
    labels[3] = new JLabel("Par: ");
    labels[4] = new JLabel("Minimum Handicap: ");
    labels[5] = new JLabel("Maximum Handicap: ");
    labels[6] = new JLabel("Step Value: ");

    fields[0] = new JTextField("98");
    fields[1] = new JTextField("113");
    fields[2] = new JTextField("63.3");
    fields[3] = new JTextField("66");
    fields[4] = new JTextField("0.0");
    fields[5] = new JTextField("54.0");
    fields[6] = new JTextField("0.1");

    for (int i = 0; i < fieldNum; i++) {
      labels[i].setHorizontalAlignment(SwingConstants.RIGHT);
    }
    labels[1].setHorizontalAlignment(SwingConstants.CENTER);

    inputPanel.add(labels[0]);

    JPanel indexPanel = new JPanel(new GridLayout(1, 3));
    indexPanel.add(fields[0]);
    indexPanel.add(labels[1]);
    indexPanel.add(fields[1]);

    inputPanel.add(indexPanel);

    inputPanel.add(labels[2]);
    inputPanel.add(fields[2]);
    inputPanel.add(labels[3]);
    inputPanel.add(fields[3]);

    inputPanel.add(new JPanel());
    inputPanel.add(new JPanel());

    inputPanel.add(labels[4]);
    inputPanel.add(fields[4]);
    inputPanel.add(labels[5]);
    inputPanel.add(fields[5]);
    inputPanel.add(labels[6]);
    inputPanel.add(fields[6]);

    inputPanel.add(new JPanel());
    inputPanel.add(new JPanel());
    inputPanel.add(new JPanel());

    startButton = new JButton("Calculate");
    inputPanel.add(startButton);
  }
}
