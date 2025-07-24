package Assignment4;

/*Region Imported Libaries*/
//GUI
import javax.swing.*;

//Layout and Events
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

//File I/O
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*EndRegion Imported Libaries*/

/*Region Function*/
public class SimpleTextEditor {
    public static void main(String[] args) {

        //Part of the secret sauce
        final int[] filesOpenedCount = {0};

        /*GUI Layout*/
        JFrame frame = new JFrame("Welcome to simple Text Editor ");
        frame.setSize(500, 600);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //JScroll
        //Only one use of this Function
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);


        /*Region for button panel*/
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton saveButton = new JButton("Save Button");
        JButton openButton = new JButton("Open File");
        JButton exitButton = new JButton("Exit Button");

        // Add buttons to panel
        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(exitButton);
        frame.add(buttonPanel, BorderLayout.NORTH);
        /*EndRegion for Button Panel*/


        //TextField
        JTextField textField = new JTextField();
        textArea.setEditable(false);
        frame.add(textArea, BorderLayout.NORTH);


        // JFileChooser setup
        JFileChooser fileChooser = new JFileChooser();

        //Secret function
        JLabel totalWordCount = new JLabel("Total Word count: 0");
        buttonPanel.add(totalWordCount);

        frame.add(buttonPanel, BorderLayout.NORTH);

        //ActionListner for those buttons and the file

        /* Update word count as user type*/
        textArea.addCaretListener(e -> {
            String text = textArea.getText().trim();
            int words = text.isEmpty() ? 0 : text.split("\\s+").length;
            totalWordCount.setText("Words: " + words);
        });

        /*SaveButton Function*/
        saveButton.addActionListener(e -> {
            int returnValue = fileChooser.showSaveDialog(null);
            if (returnValue == fileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write(textArea.getText());
                    textArea.setText("Saved: " + file.getAbsolutePath());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error saving file: " + ex.getMessage());
                }
            }
        });

        /*OpenButton Function */
        openButton.addActionListener(e -> {
            int returnVal = fileChooser.showOpenDialog(null);
            if (returnVal == fileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    StringBuilder content = new StringBuilder();
                     String line;
                    while ((line = reader.readLine()) != null) {
                        content.append(line).append("\n");
                    }
                    textArea.setText(content.toString());
                    textArea.setText("Opened: " + file.getAbsolutePath());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error opening file: " + ex.getMessage());
                }
            }
        });

        /*ExitButton Function */
        exitButton.addActionListener(e -> System.exit(0));

        //Show Frame
        frame.setVisible(true);

    }
}
/*EndRegion Function*/
