package Assignment3;
/* * Name: Kyle Angeles
 * Date 7/4/25
 * Description - using oop concepts and try and exception block to create a program
 * for a payroll program that includes the classes of the following and to make it a functional
 * payroll as would a business should distribute money to their employees and persons
* */
//Imported Libraries
import java.text.NumberFormat;
//EndRegion Imported libraries

public class MainTest {

    /*Region Functions*/
    public static void main(String[] args) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        //Algorithm for Salaried Staff along with using a try block
        //This is the code for the first try block
        try {
            SalariedStaff staff1 = new SalariedStaff("Staff name: ", 6000);

            //Print statements along with variables
            System.out.println("Original salary" + staff1.getName() + ": " +
                    currency.format(staff1.getYearlySalary()));
            //Print new line
            System.out.println();

            //Example using 68000 for setYearlySalary
            staff1.setYearlySalary(68000); //change salary
            System.out.println("Updated salary for " + staff1.getName() + ": " +
                    currency.format(staff1.getYearlySalary()));
            System.out.println();

            //Hourly Woker Test
            HourlyWorker worker1 = new HourlyWorker("Staff name: ", "Birth Date: ", "EmployeeID:", 18.50, 40.0);
            System.out.println("Hourly rate for " + worker1.getName() +
                    currency.format(worker1.getHourlyRate()));

            System.out.println();
            //For example setting the hourly rate to 20
            worker1.setHourlyRate(20.0);
            System.out.println("Updated Hourly  rate for " + staff1.getName() + ":" +
                    currency.format(worker1.getHourlyRate()));

        } catch (IllegalArgumentException e) {
            Syetem.out.println("Error" + e.getMessage());

        }
    }
}

//This code is for the second try block: payroll report for 5 emplyees.


/*EndRegion functions*/
