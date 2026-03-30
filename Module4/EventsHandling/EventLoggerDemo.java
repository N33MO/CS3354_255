package Module4.EventsHandling;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * EventLoggerDemo - Demonstrates multiple event types in Swing.
 *
 * A label shows the CURRENT event in red and the PREVIOUS event in black.
 * Covered events:
 *   Mouse    : pressed, released, clicked, entered, exited
 *   Motion   : moved, dragged
 *   Keyboard : pressed, released, typed
 */
public class EventLoggerDemo {

    // Tracks the previous and current event descriptions
    private static String previousEvent = "(none)";
    private static String currentEvent  = "(none)";

    // Two labels so we can style them independently
    private static JLabel previousLabel;
    private static JLabel currentLabel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Event Logger Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 350);
        frame.setLocationRelativeTo(null);

        // ── Panel that captures mouse/motion events ──────────────────────────
        JPanel eventPanel = new JPanel();
        eventPanel.setBackground(new Color(230, 240, 255));
        eventPanel.setPreferredSize(new Dimension(500, 180));
        eventPanel.setBorder(BorderFactory.createTitledBorder(
                "Move / Click / Drag your mouse here, or press keys"));

        // ── Labels for event display ─────────────────────────────────────────
        previousLabel = new JLabel("Previous: (none)");
        previousLabel.setFont(new Font("Monospaced", Font.PLAIN, 14));
        previousLabel.setForeground(Color.BLACK);

        currentLabel = new JLabel("Current:  (none)");
        currentLabel.setFont(new Font("Monospaced", Font.BOLD, 14));
        currentLabel.setForeground(Color.RED);

        // ── Info label at the bottom ─────────────────────────────────────────
        JLabel infoLabel = new JLabel("Click inside the blue area and use the keyboard.");
        infoLabel.setFont(new Font("SansSerif", Font.ITALIC, 11));
        infoLabel.setForeground(Color.DARK_GRAY);

        // ── Layout ───────────────────────────────────────────────────────────
        JPanel displayPanel = new JPanel(new GridLayout(3, 1, 4, 4));
        displayPanel.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
        displayPanel.add(currentLabel);
        displayPanel.add(previousLabel);
        displayPanel.add(infoLabel);

        frame.setLayout(new BorderLayout(0, 0));
        frame.add(eventPanel, BorderLayout.CENTER);
        frame.add(displayPanel, BorderLayout.SOUTH);

        // ── Mouse Listener (press, release, click, enter, exit) ──────────────
        MouseListener mouseListener = new MouseListener() {
            @Override
            public void mousePressed(MouseEvent e) {
                String btn = buttonName(e.getButton());
                logEvent("Mouse PRESSED  [" + btn + "]  at (" + e.getX() + ", " + e.getY() + ")");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                String btn = buttonName(e.getButton());
                logEvent("Mouse RELEASED [" + btn + "]  at (" + e.getX() + ", " + e.getY() + ")");
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                String btn = buttonName(e.getButton());
                int clicks = e.getClickCount();
                logEvent("Mouse CLICKED  [" + btn + "]  x" + clicks + " at (" + e.getX() + ", " + e.getY() + ")");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                logEvent("Mouse ENTERED  panel");
                eventPanel.setBackground(new Color(200, 230, 255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                logEvent("Mouse EXITED   panel");
                eventPanel.setBackground(new Color(230, 240, 255));
            }
        };

        // ── Mouse Motion Listener (move, drag) ───────────────────────────────
        MouseMotionListener motionListener = new MouseMotionListener() {
            @Override
            public void mouseMoved(MouseEvent e) {
                logEvent("Mouse MOVED    at (" + e.getX() + ", " + e.getY() + ")");
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                logEvent("Mouse DRAGGED  at (" + e.getX() + ", " + e.getY() + ")");
            }
        };

        eventPanel.addMouseListener(mouseListener);
        eventPanel.addMouseMotionListener(motionListener);

        // ── Key Listener (pressed, released, typed) ───────────────────────────
        // Attached to the frame so it always receives key events
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                logEvent("Key PRESSED    [" + keyDescription(e) + "]");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                logEvent("Key RELEASED   [" + keyDescription(e) + "]");
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // keyTyped only fires for printable chars; getKeyChar() gives the character
                logEvent("Key TYPED      '" + e.getKeyChar() + "'");
            }
        });

        // Frame must be focusable to receive key events
        frame.setFocusable(true);
        frame.requestFocusInWindow();

        frame.setVisible(true);
    }

    // ── Helpers ───────────────────────────────────────────────────────────────

    /** Shifts current → previous, sets new current, then refreshes labels. */
    private static void logEvent(String description) {
        previousEvent = currentEvent;
        currentEvent  = description;

        previousLabel.setText("Previous: " + previousEvent);
        currentLabel .setText("Current:  " + currentEvent);
    }

    /** Returns a human-readable mouse button name. */
    private static String buttonName(int button) {
        switch (button) {
            case MouseEvent.BUTTON1: return "LEFT";
            case MouseEvent.BUTTON2: return "MIDDLE";
            case MouseEvent.BUTTON3: return "RIGHT";
            default:                 return "BUTTON" + button;
        }
    }

    /**
     * Returns a readable description for a key event:
     * uses the key text (e.g. "A", "Space", "Enter", "Up") and notes
     * any active modifiers (Shift, Ctrl, Alt).
     */
    private static String keyDescription(KeyEvent e) {
        String key  = KeyEvent.getKeyText(e.getKeyCode());
        String mods = KeyEvent.getModifiersExText(e.getModifiersEx());
        return mods.isEmpty() ? key : mods + "+" + key;
    }
}
