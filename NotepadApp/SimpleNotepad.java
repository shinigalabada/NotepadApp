import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleNotepad extends JFrame {
    private JTextArea textArea;

    public SimpleNotepad() {
        setTitle("Simple Notepad");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Text area
        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Menu bar
        JMenuBar menuBar = new JMenuBar();

        // Edit menu
        JMenu editMenu = new JMenu("Edit");
        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem paste = new JMenuItem("Paste");

        cut.addActionListener(e -> textArea.cut());
        copy.addActionListener(e -> textArea.copy());
        paste.addActionListener(e -> textArea.paste());

        editMenu.add(cut);
        editMenu.add(copy);
        editMenu.add(paste);

        // Help menu
        JMenu helpMenu = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");
        about.addActionListener(e -> JOptionPane.showMessageDialog(this,
                "Simple Notepad\nCreated by: H.S.H.Galabada\nID: s16691"));
        helpMenu.add(about);

        // Format menu (Font & Color chooser)
        JMenu formatMenu = new JMenu("Format");

        JMenuItem fontItem = new JMenuItem("Choose Font");
        fontItem.addActionListener(e -> {
            textArea.setFont(new Font("Serif", Font.PLAIN, 18));
        });

        JMenuItem colorItem = new JMenuItem("Choose Color");
        colorItem.addActionListener(e -> {
            Color chosenColor = JColorChooser.showDialog(this, "Pick a Color", Color.BLACK);
            if (chosenColor != null) {
                textArea.setForeground(chosenColor);
            }
        });

        formatMenu.add(fontItem);
        formatMenu.add(colorItem);

        // Add menus to menu bar
        menuBar.add(editMenu);
        menuBar.add(formatMenu);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SimpleNotepad().setVisible(true);
        });
    }
}
