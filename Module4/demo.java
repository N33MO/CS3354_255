package Module4;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class demo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JFrame Title");

        JButton button = new JButton("Show Dialog");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog(frame, "My Dialog", true);

                JLabel label = new JLabel("Here shows the dialog text.");
                // set label font and size for better visibility
                label.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 20));
                label.setHorizontalAlignment(SwingConstants.CENTER);
                
                dialog.add(label);
                dialog.setSize(300, 200);
                dialog.setLocationRelativeTo(frame);
                dialog.setVisible(true);
            }
        });
        
        frame.add(button);
        
        frame.setLayout(new FlowLayout());
        frame.setSize(400, 300);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}