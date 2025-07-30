package ClassExercise4;
/*
 * AUTHOR: Kyle Angeles
 * DATE: 7/29/25
 * Description - This program is designed to calculate the area and perimeter
 * using the formula's 2 *(length + length) and length * width
 * and implementing using GUI to make the calculation seem like an actual graphic CALCULATOR
 * just like in windows
 */


/*REGION IMPORTS*/
import javax.swing.*;
import java.awt.*;
/*ENDREGION IMPORTS*/

/*REGION FUNCTIONS*/
public class SpaceEater extends JFrame {

        //Declaring JTextField and JLabel
        private JTextField lengthField, widthField;
        private JLabel areaLabel, perimeterLabel;


        public SpaceEater() {

            //GUI LAYOUT
            setTitle(" Area and perimeter of Rectangle Calculator" +
                    "- Space Eater");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(400, 300);
            setLayout(new GridLayout(6, 2, 10, 10));

            Font aodaFont = new Font("Arial", Font.PLAIN, 14);

            //Text field for calculation
            add(new JLabel("Length:"));
            lengthField = new JTextField();
            lengthField.setFont(aodaFont);
            add(lengthField);

            add(new JLabel("Width:"));
            widthField = new JTextField();
            widthField.setFont(aodaFont);
            add(widthField);


            //Button layout
            JButton calcBtn = new JButton("Calculate");
            JButton resetBtn = new JButton("Reset");
            JButton clearBtn = new JButton("Clear");
            JButton exitBtn = new JButton("Exit");

            calcBtn.setFont(aodaFont);
            resetBtn.setFont(aodaFont);
            clearBtn.setFont(aodaFont);
            exitBtn.setFont(aodaFont);

            add(calcBtn);
            add(resetBtn);
            add(clearBtn);
            add(exitBtn);


            //Result labels
            areaLabel = new JLabel("Area: ");
            perimeterLabel = new JLabel("Perimeter: ");
            add(areaLabel);
            add(perimeterLabel);


            //Action listeners
            calcBtn.addActionListener(e -> calculate());
            resetBtn.addActionListener(e -> reset());
            clearBtn.addActionListener(e-> Clear());
            exitBtn.addActionListener(e -> System.exit(0));

            setVisible(true);

        }
        /*END REGION GUI LAYOUT */

    /*REGION ACTION LISTENERS AND METHODS FOR ALL THE BUTTONS AND ETC*/
    private void Clear() {
        lengthField.setText("");
        widthField.setText("");
        areaLabel.setText("Area: ");
        perimeterLabel.setText("Perimeter: ");
    }

    /*Method for calculation*/
        private void calculate() {
            try {
                double length = Double.parseDouble(lengthField.getText().trim());
                double width = Double.parseDouble(widthField.getText().trim());


                if (length <= 0 || width <= 0) {
                    throw new IllegalArgumentException("All Values must be positive");
                }

                double area = length * width;
                double perimeter = 2 * (length + width);

                areaLabel.setText("Area: " + area);
                perimeterLabel.setText("Perimeter: " + perimeter);


            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,
                        "Please enter valid positive numbers for length and width.",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        //Reset Button function method
        private void reset() {
            lengthField.setText("");
            widthField.setText("");
            areaLabel.setText("Area: ");
            perimeterLabel.setText("Perimeter: ");
        }




        public static void main(String[] args) {
            SwingUtilities.invokeLater(SpaceEater::new);
        }
    /*ENDREGION ACTION LISTENERS AND METHODS FOR ALL THE BUTTONS AND ETC*/

}
/*ENDREGION FUNCTIONS*/
