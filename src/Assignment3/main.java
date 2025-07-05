package Assignment3;
/* * Name: Kyle Angeles
 * Date 7/4/25
 * Description - using oop concepts and try and exception block to create a program
 * for a payroll program that includes the classes of the following and to make it a functionak
 * payroll as would a business should distrubed money to their employees and persons
* */
//Imported Libaries
import java.text.NumberFormat;
//EndRegion Imported libaries

public class main {

    /*Region Functions*/
    public static void main(String[] args) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        //Algorithim for Salaried Staff along with using a try block
        //This is the code for the first try block
        try {
            SalariedStaff staff1 = new SalariedStaff("Staff name: ", 6000);

            //Print statements along with varibles
            System.out.println("Original salary" + staff1.getName() + ": " +
                    currency.format(staff1.getYearlySalary()));
            //Print new line
            System.out.println();

            //Example using 68000 for setYearlySalary
            staff1.setYearlySalary(68000); //change salary
            System.out.println("Updated salary for " + staff1.getName() + ": " +
                    currency.format(staff1.getYearlySalary()));

            //Creating
        }
    }

/*EndRegion functions*/
