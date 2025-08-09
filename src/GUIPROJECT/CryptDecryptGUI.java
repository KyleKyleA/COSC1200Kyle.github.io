package GUIPROJECT;
/*
 * Author: Kyle Angeles
 * Date: 7/30/25
 * Description: Design and construct a GUI front end for the application built for assignment #2 (Cypher).
 *  The application will allow the user to enter and configure all that is required before choosing
 * to encrypt or decrypt.
 *
 * */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class CryptDecryptGUI extends CipherHelp{
    private JFrame windowframe;

        public CryptDecryptGUI() {
            // THIS IS FOR LABELS, BUTTONS, TEXT AREA's
            final String WINDOW_TITLE = ("Kyle's Angeles Cipher/Decrypt Application");
            final String MESSAGE_LABEL = "Message:";
            final String RESULT_LABEL = "Result:";
            final String ALPHABET1_LABEL = "Alphabet 1:";
            final String ALPHABET2_LABEL = "Alphabet 2:";
            final String SHIFT_LABEL = "Shift Number:";
            final String KEY_LABEL = "Complexity Key:";
            final String ENCRYPT_BUTTON_TEXT = "Encrypt";
            final String DECRYPT_BUTTON_TEXT = "Decrypt";
            final String EXIT_BUTTON_TEXT = "Exit";

            //MESSAGES AFTER
            final String MESSAGE_TOOLTIP = "Enter the message to encrypt or decrypt.";
            final String RESULT_TOOLTIP = "Encrypted or decrypted result will appear here.";
            final String ALPHABET1_TOOLTIP = "Alphabet used in substitution cipher (source).";
            final String ALPHABET2_TOOLTIP = "Alphabet used in substitution cipher (target).";
            final String SHIFT_TOOLTIP = "Shift amount for translation cipher (1-25).";
            final String KEY_TOOLTIP = "Enter complexity (number of repetition, (1-10). ";
            final String ENCRYPT_TOOLTIP = "Click to encrypt.";
            final String DECRYPT_TOOLTIP = "Click to decrypt.";
            final String EXIT_TOOLTIP = "Click to close the application.";
            final String ZoomIN_TOOLTIP = "Click to zoom in on the application.";
            final String ZoomOut_TOOLTIP = "Click to zoom out on the application";

            /*SHORTCUTS OR HOTKEYS*/
            final char ENCRYPT_MNEMONIC = KeyEvent.VK_E;
            final char DECRYPT_MNEMONIC = KeyEvent.VK_D;
            final char EXIT_MNEMONIC = KeyEvent.VK_X;
            final int ZOOM_IN_MNEMONIC = KeyEvent.VK_Z;
            final int ZOOM_OUT_MNEMONIC = KeyEvent.VK_O;

            // Window setup
            windowframe = new JFrame(WINDOW_TITLE);
            windowframe.setSize(700, 600);
            windowframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            windowframe.setLayout(null);
            windowframe.setLocationRelativeTo(null);
            windowframe.setResizable(false);

            /*Label for Title
            * Alignment
            * */
            JLabel Window_Title = new JLabel(WINDOW_TITLE);
            Window_Title.setHorizontalAlignment(SwingConstants.RIGHT);


            /*Message Label*/
            JLabel messageLabel = new JLabel(MESSAGE_LABEL);
            JTextArea messageField = new JTextArea();
            messageField.setLineWrap(true);
            JScrollPane messageScroll = new JScrollPane(messageField);

            /*Result Label*/
            JLabel resultLabel = new JLabel(RESULT_LABEL);
            JTextArea resultField = new JTextArea();
            resultField.setEditable(false);
            resultField.setLineWrap(true);
            JScrollPane resultScroll = new JScrollPane(resultField);

            /*START FOR ALPHABET FIELD*/
            JLabel alphabet1Label = new JLabel(ALPHABET1_LABEL);
            JTextField alphabet1Field = new JTextField();

            JLabel alphabet2Label = new JLabel(ALPHABET2_LABEL);
            JTextField alphabet2Field = new JTextField();
            /*END FOR ALPHABET FIELD*/

            JLabel shiftLabel = new JLabel(SHIFT_LABEL);
            JTextField shiftField = new JTextField();

            JLabel keyLabel = new JLabel(KEY_LABEL);
            JTextField keyField = new JTextField();

            JRadioButton subsBtn = new JRadioButton("Substitution", true);
            JRadioButton transbtn = new JRadioButton("Translation");

            ButtonGroup cipherTypeGroup = new ButtonGroup();
            cipherTypeGroup.add(subsBtn);
            cipherTypeGroup.add(transbtn);

            JButton encryptButton = new JButton(ENCRYPT_BUTTON_TEXT);
            JButton decryptButton = new JButton(DECRYPT_BUTTON_TEXT);
            JButton exitButton = new JButton(EXIT_BUTTON_TEXT);

            /*Extra Feature to this program allowing zoom in and zoom out option*/
            //Zoom in
            JButton zoomInBtn = new JButton(ZoomIN_TOOLTIP);
            zoomInBtn.setMnemonic(ZOOM_IN_MNEMONIC);

            JButton zoomOutBtn = new JButton(ZoomOut_TOOLTIP);
            zoomOutBtn.setMnemonic(ZOOM_OUT_MNEMONIC);



            JLabel errorLabel = new JLabel("");

            // Set bounds for each TEXT AREA'S
            int x1 = 30, x2 = 150, y = 30, h = 25, w1 = 120, w2 = 400;
            messageLabel.setBounds(x1, y, w1, h);
            messageScroll.setBounds(x2, y, w2, 60);
            y += 70;
            subsBtn.setBounds(x2, y, 150, h);
            transbtn.setBounds(x2 + 160, y, 150, h);
            y += 40;
            alphabet1Label.setBounds(x1, y, w1, h);
            alphabet1Field.setBounds(x2, y, w2, h);
            y += 30;
            alphabet2Label.setBounds(x1, y, w1, h);
            alphabet2Field.setBounds(x2, y, w2, h);
            y += 30;
            shiftLabel.setBounds(x1, y, w1, h);
            shiftField.setBounds(x2, y, w2, h);
            y += 30;
            keyLabel.setBounds(x1, y, w1, h);
            keyField.setBounds(x2, y, w2, h);
            y += 30;
            resultLabel.setBounds(x1, y, w1, h);
            resultScroll.setBounds(x2, y, w2, 60);
            y += 70;
            errorLabel.setBounds(x2, y, w2, h);
            y += 30;

            encryptButton.setBounds(x2, y, 100, h);
            decryptButton.setBounds(x2 + 120, y, 100, h);
            exitButton.setBounds(x2 + 240, y, 100, h);


            // Tooltips
            messageField.setToolTipText(MESSAGE_TOOLTIP);
            resultField.setToolTipText(RESULT_TOOLTIP);
            alphabet1Field.setToolTipText(ALPHABET1_TOOLTIP);
            alphabet2Field.setToolTipText(ALPHABET2_TOOLTIP);
            shiftField.setToolTipText(SHIFT_TOOLTIP);
            keyField.setToolTipText(KEY_TOOLTIP);
            encryptButton.setToolTipText(ENCRYPT_TOOLTIP);
            decryptButton.setToolTipText(DECRYPT_TOOLTIP);
            exitButton.setToolTipText(EXIT_TOOLTIP);

            // Mnemonics
            encryptButton.setMnemonic(ENCRYPT_MNEMONIC);
            decryptButton.setMnemonic(DECRYPT_MNEMONIC);
            exitButton.setMnemonic(EXIT_MNEMONIC);

            // Visibility logic
            ActionListener toggleFields = e -> {
                boolean isSub = subsBtn.isSelected();
                alphabet1Field.setEnabled(isSub);
                alphabet2Field.setEnabled(isSub);
                shiftField.setEnabled(!isSub);
            };
            subsBtn.addActionListener(toggleFields);
            transbtn.addActionListener(toggleFields);
            toggleFields.actionPerformed(null);

            // ACTION LISTENER FOR EACH BUTTON
            encryptButton.addActionListener(e -> {
                errorLabel.setText("");
                String input = messageField.getText().trim();
                if (input.isEmpty()) {
                    errorLabel.setText("Message is required.");
                    return;
                }
                try {
                    String result;
                    if (subsBtn.isSelected()) {
                        String a1 = alphabet1Field.getText().trim();
                        String a2 = alphabet2Field.getText().trim();
                        if (a1.isEmpty() || a1.length() != a2.length()) {
                            errorLabel.setText("Both alphabets must be non-empty and equal in length.");
                            return;
                        }
                        int complexity = 1;
                        try {
                            complexity = Integer.parseInt(keyField.getText().trim());
                            if (complexity < 1) complexity = 1;
                        } catch (Exception ex) {
                            complexity = 1; // default complexity if input invalid
                        }
                        result = substitutionCipher(input, complexity, a1, a2);
                    } else {
                        int shift = Integer.parseInt(shiftField.getText().trim());
                        if (shift < 1 || shift > 25) {
                            errorLabel.setText("Shift must be between 1 and 25.");
                            return;
                        }
                        int complexity = 1;
                        try {
                            complexity = Integer.parseInt(keyField.getText().trim());
                            if (complexity < 1) complexity = 1;
                        } catch (Exception ex) {
                            complexity = 1;
                        }
                        result = translationCipher(input, shift, complexity);
                    }
                    resultField.setText(result);
                } catch (Exception ex) {
                    errorLabel.setText("Error: " + ex.getMessage());
                }
            });

            decryptButton.addActionListener(e -> {
                errorLabel.setText("");
                String input = messageField.getText().trim();
                if (input.isEmpty()) {
                    errorLabel.setText("Message is required");
                    return;
                }

                try {
                    String result;
                    if (subsBtn.isSelected()) {
                        String a1 = alphabet1Field.getText().trim();
                        String a2 = alphabet2Field.getText().trim();
                        if (a1.isEmpty() || a1.length() != a2.length()) {

                            errorLabel.setText("Both alphabets must be non-empty and equal in length");
                            return;
                        }
                        int complexity = 1;
                        try{
                            complexity = Integer.parseInt(keyField.getText().trim());
                            if (complexity < 1) complexity = 1;
                        } catch (Exception ex) {
                            complexity = 1;
                        }
                        //Logic is for reverse mapping
                        result = substitutionCipher(input, complexity, a2, a1);
                    } else {
                        int shift = Integer.parseInt(shiftField.getText().trim());
                        if (shift < 1 || shift > 25) {
                            errorLabel.setText("Shift must be 1 and 25");
                            return;
                        }
                        int complexity = 1;
                        try  {
                            complexity = Integer.parseInt(keyField.getText().trim());
                            if (complexity < 1) complexity = 1;
                        } catch (Exception ex) {
                            complexity = 1;
                        }
                        // reverse shift by using (26 - shift)
                        result = translationCipher(input, 26 - shift, complexity);
                    }
                    resultField.setText(result);
                } catch (Exception ex) {
                    errorLabel.setText("Error: " + ex.getMessage());
                }
            });

            /*Zoom in action listnener*/
            zoomOutBtn.addActionListener(e ->{
                Dimension size = windowframe.getSize();
                //Example width and size
                windowframe.setSize(size.width + 100, size.height + 75);
            });

            zoomInBtn.addActionListener(e -> {
                Dimension size = windowframe.getSize();
                windowframe.setSize(size.width - 100, size.height - 75);
            });


            exitButton.addActionListener(e -> windowframe.dispose());

            // Adding every field into the newframe
            windowframe.add(messageLabel);
            windowframe.add(messageScroll);
            windowframe.add(subsBtn);
            windowframe.add(transbtn);
            windowframe.add(alphabet1Label);
            windowframe.add(alphabet1Field);
            windowframe.add(alphabet2Label);
            windowframe.add(alphabet2Field);
            windowframe.add(shiftLabel);
            windowframe.add(shiftField);
            windowframe.add(keyLabel);
            windowframe.add(keyField);
            windowframe.add(resultLabel);
            windowframe.add(resultScroll);
            windowframe.add(errorLabel);
            windowframe.add(encryptButton);
            windowframe.add(decryptButton);
            windowframe.add(exitButton);
            windowframe.add(zoomInBtn);
            windowframe.add(zoomOutBtn);


            // Show window
            windowframe.setVisible(true);
        };

    }













