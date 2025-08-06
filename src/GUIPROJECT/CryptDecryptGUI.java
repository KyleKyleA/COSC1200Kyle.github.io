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
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CryptDecryptGUI extends JFrame {

    //DECLARATIONS
        private JTextArea messageArea, resultArea;
        private JTextField alphabet1Field, alphabet2Field, shiftField, complexityField;
        private JRadioButton substitutionButton, translationButton;
        private JButton encryptButton, decryptButton, exitButton;
        private JLabel errorLabel;


        // GUI SETUP
        public CryptDecryptGUI() {
            //FRAME SETUP
            setTitle("Welcome to Crypt/DeCrypt GUI");
            setSize(500, 600);
            setLayout(new BorderLayout());
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //FONT FOR THE PROGRAM
            Font aoda = new Font("Arial ", Font.PLAIN, 14);


            //Create components
            createMainPanel();

            setVisible(true);
        }

        private void createMainPanel() {

            //LABEL OR TEXT AREA'S



            //RADIO BUTTONS


            // 3 COMMAND BUTTONS
            JPanel button = new JPanel();
            JButton EncryptBtn = new JButton("Encrypt:");
            JButton DecryptBtn = new JButton("Decrypt");
            JButton ExitBtn = new JButton("Exit");

            /*This Section is for the messages */
            //Encrypt Messages

            //Decrypt Messages

            //Exit Message

            /*Adding buttons*/
            button.add(EncryptBtn);
            button.add(DecryptBtn);
            button.add(ExitBtn);

            // EXIT EXCECUTION
            ExitBtn.addActionListener(e -> System.exit(0));

            // add both panels to frame


        }
        public static void main(String[] args) {

        }

    }








