package Module4.ContainerExamples.others;

import javax.swing.*;

public class JPanelExample2 extends JFrame {

    private final int DEFAULT_WIDTH = 300;
    private final int DEFAULT_HEIGHT = 150;

    public JPanelExample2() {
        createComponent();
    }

    private void createComponent() {

        setTitle("Advanced JPanel Example");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // Set the default operation when the frame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the main panel to hold multiple components
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); // vertical layout

        // Create a label and text field for user's name input
        JPanel namePanel = new JPanel(); // default FlowLayout
        namePanel.add(new JLabel("Name:"));
        namePanel.add(new JTextField(15));

        // Create a label and combo box for selecting a user's occupation
        JPanel occupationPanel = new JPanel();
        occupationPanel.add(new JLabel("Occupation:"));
        String[] occupations = {"Developer", "Designer", "Manager"};
        occupationPanel.add(new JComboBox<>(occupations));

        // Create a submission button
        JButton submitButton = new JButton("Submit");

        // Add individual panels and button to the main panel
        mainPanel.add(namePanel);
        mainPanel.add(occupationPanel);
        mainPanel.add(submitButton);

        // Add some space around the main panel
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add the main panel to the frame's content pane
        add(mainPanel);

        // Optionally, you can set the frame to start in the middle of the screen
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        JFrame frame = new JPanelExample2();
        // Set the size of the frame
        frame.setSize(300, 150);
        // Important to make the frame visible
        frame.setVisible(true);
    }
}
