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
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import static GUIPROJECT.CipherHelp.substitutionCipher;
import static GUIPROJECT.CipherHelp.translationCipher;

public class CryptDecryptGUI {
    private JFrame window;

        public CryptDecryptGUI() {
            final String WINDOW_TITLE = "Cipher Tool";
            final String MESSAGE_LABEL = "Message:";
            final String RESULT_LABEL = "Result:";
            final String ALPHABET1_LABEL = "Alphabet 1:";
            final String ALPHABET2_LABEL = "Alphabet 2:";
            final String SHIFT_LABEL = "Shift Number:";
            final String KEY_LABEL = "Complexity Key:";
            final String ENCRYPT_BUTTON_TEXT = "Encrypt";
            final String DECRYPT_BUTTON_TEXT = "Decrypt";
            final String EXIT_BUTTON_TEXT = "Exit";

            final String MESSAGE_TOOLTIP = "Enter the message to encrypt or decrypt.";
            final String RESULT_TOOLTIP = "Encrypted or decrypted result will appear here.";
            final String ALPHABET1_TOOLTIP = "Alphabet used in substitution cipher (source).";
            final String ALPHABET2_TOOLTIP = "Alphabet used in substitution cipher (target).";
            final String SHIFT_TOOLTIP = "Shift amount for translation cipher (1-25).";
            final String KEY_TOOLTIP = "Optional complexity key.";
            final String ENCRYPT_TOOLTIP = "Click to encrypt.";
            final String DECRYPT_TOOLTIP = "Click to decrypt.";
            final String EXIT_TOOLTIP = "Click to close the application.";

            final char ENCRYPT_MNEMONIC = KeyEvent.VK_E;
            final char DECRYPT_MNEMONIC = KeyEvent.VK_D;
            final char EXIT_MNEMONIC = KeyEvent.VK_X;

            // Window setup
            window = new JFrame(WINDOW_TITLE);
            window.setSize(650, 500);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setLayout(null);
            window.setLocationRelativeTo(null);
            window.setResizable(false);


            // Components
            JLabel messageLabel = new JLabel(MESSAGE_LABEL);
            JTextArea messageField = new JTextArea();
            messageField.setLineWrap(true);
            JScrollPane messageScroll = new JScrollPane(messageField);

            JLabel resultLabel = new JLabel(RESULT_LABEL);
            JTextArea resultField = new JTextArea();
            resultField.setEditable(false);
            resultField.setLineWrap(true);
            JScrollPane resultScroll = new JScrollPane(resultField);

            JLabel alpha1Label = new JLabel(ALPHABET1_LABEL);
            JTextField alpha1Field = new JTextField();

            JLabel alpha2Label = new JLabel(ALPHABET2_LABEL);
            JTextField alpha2Field = new JTextField();

            JLabel shiftLabel = new JLabel(SHIFT_LABEL);
            JTextField shiftField = new JTextField();

            JLabel keyLabel = new JLabel(KEY_LABEL);
            JTextField keyField = new JTextField();

            JRadioButton substitutionButton = new JRadioButton("Substitution", true);
            JRadioButton translationButton = new JRadioButton("Translation");

            ButtonGroup cipherTypeGroup = new ButtonGroup();
            cipherTypeGroup.add(substitutionButton);
            cipherTypeGroup.add(translationButton);

            JButton encryptButton = new JButton(ENCRYPT_BUTTON_TEXT);
            JButton decryptButton = new JButton(DECRYPT_BUTTON_TEXT);
            JButton exitButton = new JButton(EXIT_BUTTON_TEXT);

            JLabel errorLabel = new JLabel("");

            // Set bounds
            int x1 = 30, x2 = 150, y = 30, h = 25, w1 = 120, w2 = 400;
            messageLabel.setBounds(x1, y, w1, h);
            messageScroll.setBounds(x2, y, w2, 60);
            y += 70;
            substitutionButton.setBounds(x2, y, 150, h);
            translationButton.setBounds(x2 + 160, y, 150, h);
            y += 40;
            alpha1Label.setBounds(x1, y, w1, h);
            alpha1Field.setBounds(x2, y, w2, h);
            y += 30;
            alpha2Label.setBounds(x1, y, w1, h);
            alpha2Field.setBounds(x2, y, w2, h);
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
            alpha1Field.setToolTipText(ALPHABET1_TOOLTIP);
            alpha2Field.setToolTipText(ALPHABET2_TOOLTIP);
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
                boolean isSub = substitutionButton.isSelected();
                alpha1Field.setEnabled(isSub);
                alpha2Field.setEnabled(isSub);
                shiftField.setEnabled(!isSub);
            };
            substitutionButton.addActionListener(toggleFields);
            translationButton.addActionListener(toggleFields);
            toggleFields.actionPerformed(null);

            // Action logic
            encryptButton.addActionListener(e -> {
                errorLabel.setText("");
                String input = messageField.getText().trim();
                if (input.isEmpty()) {
                    errorLabel.setText("Message is required.");
                    return;
                }
                try {
                    String result;
                    if (substitutionButton.isSelected()) {
                        String a1 = alpha1Field.getText().trim();
                        String a2 = alpha2Field.getText().trim();
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

            exitButton.addActionListener(e -> window.dispose());

            // Add to window
            window.add(messageLabel);
            window.add(messageScroll);
            window.add(substitutionButton);
            window.add(translationButton);
            window.add(alpha1Label);
            window.add(alpha1Field);
            window.add(alpha2Label);
            window.add(alpha2Field);
            window.add(shiftLabel);
            window.add(shiftField);
            window.add(keyLabel);
            window.add(keyField);
            window.add(resultLabel);
            window.add(resultScroll);
            window.add(errorLabel);
            window.add(encryptButton);
            window.add(decryptButton);
            window.add(exitButton);

            // Show
            window.setVisible(true);
        }

    }












