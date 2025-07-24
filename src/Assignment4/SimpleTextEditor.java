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
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;

/*EndRegion Imported Libaries*/

/*Region Function*/
public class SimpleTextEditor {
    public static void main(String[] args) {

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
        JPanel buttonPanel = new JPanel();
        JButton saveButton = new JButton("Save Button");
        JButton openButton = new JButton("Open File");
        JButton exitButton = new JButton("Exit Button");
        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(exitButton);
        buttonPanel.add(buttonPanel, BorderLayout.SOUTH);
        /*EndRegion for Button Panel*/


        //TextField
        JTextField textField = new JTextField();
        filePathField.setEditable(false);
        frame.add(filePathField, BorderLayout.NORTH);


        // JFileChooser setup
        JFileChooser fileChooser = new JFileChooser();

        //Secret function
        JLabel wordCountLabel = new JLabel("Words: 0");
        buttonPanel.add(wordCountLabel);


        //ActionListner for those buttons and the file

        /* Update word count as user type*/
        textArea.addCaretListener(e -> {
            String text = textArea.getText().trim();
            int words = text.isEmpty() ? 0 : text.split("\\s+").length;
            wordCountLabel.setText("Words: " + words);
        });
        /*SaveButton Function*/
        saveButton.addActionListener(e ->{
            int returnValue = fileChooser.showSaveDialog(null);
            if (returnValue == fileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (FileWriter writing = new FileWriter(file)) {
                    writing.write(textArea.getText());

                }
            }
        });

        /*OpenButton Function */
        openButton.addActionListener(e -> {

        });

        /*ExitButton Function */
        exitButton.addActionListener(e -> {

        });






        ;
    }
}
/*EndRegion Function*/
