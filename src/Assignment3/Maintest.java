package Assignment3;
/* * Name: Kyle Angeles
 * Date 7/4/25
 * Description - using oop concepts and try and exception block to create a program
 * for a payroll program that includes the classes of the following and to make it a functional
 * payroll as would a business should distribute money to their employees and persons
* */
//Imported Libraries
import java.text.NumberFormat;
import java.util.Scanner;
//EndRegion Imported libraries
public class Maintest {

    /*Region Functions*/
    public static void main(String[] args) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        Scanner input = new Scanner(System.in);
        //Algorithm for Salaried Staff along with using a try block
        //This is the code for the first try block
        try {
           System.out.println("Enter info for a salaried staff Employee");
           System.out.println("Name: ");
           String name1 = input.nextLine();

            System.out.println("BirthDate (YYYY-MM-DD): ");
            String birth1 = input.nextLine();

            System.out.print("Employee ID (8 digits): ");
            String empID2 = input.nextLine();

            System.out.print("Hourly Rate ($16.00 or more): ");
            double rate = input.nextDouble();

            System.out.print("Hours Per Week (max 48): ");
            double hours = input.nextDouble();

            HourlyWorker worker1 = new HourlyWorker("Staff name: ", "Birth Date: ", "EmployeeID:", 18.50, 40.0);
            System.out.println("Hourly rate for " + worker1.getName() +
                    currency.format(worker1.getHourlyRate()));

            System.out.println();
            //For example setting the hourly rate to 20
            // Update rate and hours
            worker1.setHourlyRate(rate + 2.0);
            worker1.setHoursPerWeek(hours - 5.0);
            System.out.println("Updated hourly rate: " + currency.format(worker1.getHourlyRate()));
            System.out.println("Updated hours per week: " + worker1.getHoursPerWeek());

        } catch (IllegalArgumentException e) {
            System.out.println("Error" + e.getMessage());

        }


//This code is for the second try block: payroll report for 5 emplyees.

        try {


            Employee[] payroll = new Employee[5]; //We are going to use 5 employees for instance

            //Adding two new Salaried Staff
            payroll[0] = new SalariedStaff("Shawn Nguyen", "1990-05-5", "85629175", 57020);
            payroll[1] = new SalariedStaff("Tre Smith", "1999-12-3", "12345678", 62000);

            //Adding three hourlyWorker
            payroll[2] = new HourlyWorker("Emily Chan", "2004-02-15", "85723845", 17.00, 38);
            payroll[3] = new HourlyWorker("Liam Matthews", "1998-11-23", "75762107", 20.50, 35);
            payroll[4] = new HourlyWorker("Sara kim", "2006-9-12", "91023571", 18.25, 42);

            //Payroll Report
            System.out.println("Payroll report:");
            System.out.println("--------------------------");

            double totalPaid = 0.0;

            for (Employee emp : payroll) {
                double pay = emp.calculatePayDay();
                System.out.println("Employee: " + emp.getEmployeeID() + " | Name: " + emp.getName()
                        + " | Weekly pay: " + currency.format(pay));
                totalPaid += pay;
            }

            System.out.println("----------------------------");
            System.out.println("Total paid this week: " + currency.format(totalPaid));

        } catch (IllegalArgumentException error) {
            System.out.println("Error: " + error.getMessage());
        }
    }
}
/*EndRegion functions*/
