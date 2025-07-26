package Assignment4;
/* * Name: Kyle Angeles
 * Date 7/22/25
 * Description: For this program, we will be implementing a basic
  Swing UI and reading and writing to a file.
  The actual application will be sort of like Windows Notepad, but even simpler.
 *
 */

/*Region Imported Libraries*/
//GUI
import javax.swing.*;

//Layout and Events
import java.awt.*;
import java.io.FileWriter;

//File I/O
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*EndRegion Imported Libraries*/

/*Region Function*/
public class SimpleTextEditor {
    public static void main(String[] args) {

        /*GUI Layout*/
        JFrame frame = new JFrame("Welcome to simple Text Editor ");
        frame.setSize(500, 600);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //JScroll
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
        textArea.setEditable(true);


        // JFileChooser setup
        JFileChooser fileChooser = new JFileChooser();

        //Secret function
        JLabel totalWordCount = new JLabel("Total Word count: 0");
        buttonPanel.add(totalWordCount);
        frame.add(buttonPanel, BorderLayout.NORTH);

        //ActionListner for those buttons
        /* Update word count as user type*/
        textArea.addCaretListener(e -> {
            String text = textArea.getText().trim();
            int words = text.isEmpty() ? 0 : text.split("\\s+").length;
            totalWordCount.setText("Words: " + words);
        });

        /*SaveButton Function*/
        saveButton.addActionListener(e -> {
            int returnVal = fileChooser.showSaveDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();

                if (!file.getName().toLowerCase().endsWith(".txt")) {
                    file = new File(file.getAbsolutePath() + ".txt");
                }
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write(textArea.getText());
                    JOptionPane.showMessageDialog(frame, "File saved: " + file.getAbsolutePath());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error saving file: " + ex.getMessage());
                }
            }
        });


        /*OpenButton Function */
        openButton.addActionListener(e -> {
            int returnVal = fileChooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String content = "";
                    String line;
                    while ((line = reader.readLine()) != null) {
                        content += line + "\n";
                    }
                    textArea.setText(content);
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
