package Module4;

import javax.swing.JFrame;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

public class demo2 extends JFrame {

    private int clickCount = 0;
    private JTextField clickTextField;

    public demo2() {
        // get content pane for setup
        Container cp = getContentPane();
        setTitle("Simple GUI demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        cp.setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Create a button and set its position and size
        JButton button = new JButton("Click Me");

        // Add an action listener to the button
        button.addActionListener(e -> {
            // Show a message dialog when the button is clicked
            javax.swing.JOptionPane.showMessageDialog(this, "Button was clicked!");
        });

        // Add the button to the frame
        cp.add(button, BorderLayout.NORTH);

        // Create a label, text field, and a button to display the click count
        JLabel clickLabel = new JLabel("Click Count:");
        clickTextField = new JTextField(Integer.toString(clickCount), 10);
        clickTextField.setEditable(false);
        JButton countButton = new JButton("Count");
        countButton.addActionListener(new btnCountListener());

        // Create a panel to hold the label and text field
        JPanel clickPanel = new JPanel();
        clickPanel.add(clickLabel);
        clickPanel.add(clickTextField);
        clickPanel.add(countButton);
        cp.add(clickPanel, BorderLayout.CENTER);

        setVisible(true);
    }
    
    private class btnCountListener implements ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            clickCount++;
            clickTextField.setText(Integer.toString(clickCount));
        }
    }

    public static void main(String[] args) {
        new demo2();
    }
}
