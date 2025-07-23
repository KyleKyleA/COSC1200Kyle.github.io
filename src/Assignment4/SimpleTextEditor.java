package Assignment4;

/*Region Imported Libaries*/
//GUI
import javax.swing.*;

//Layout and Events
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        /*GUI Layout*/
        JFrame frame = new JFrame("Welcome to simple Text Editor ");
        frame.setSize(500, 600);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //Only one use of this Function
        JTextArea textArea = new JTextArea();

        //JScroll



        //Save Button


        //Open Button



        //Exit button


        //TextField


        //FileChooser



        //Writing file



        //Reading from a file



        //ActionListner for those buttons and the file




    }
}
/*EndRegion Function*/
