package Assignment3;
/* * Name: Kyle Angeles
 * Date 7/4/25
 * Description - using oop concepts and try and exception block to create a program
 * for a payroll program that includes the classes of the following and to make it a functional
 * payroll as would a business should distribute money to their employees and persons
* */
/*Imported Libraries*/
import java.text.NumberFormat;
import java.time.LocalDate;
/*EndRegion Imported libraries*/
public class Main {

    /*Region Functions*/
    public static void main(String[] args) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        //This is the code for the first try block
        try {
            System.out.println("Welcome to Test 1");
            System.out.println("Salary staff report");
            System.out.println();

            //Implementation for SalariedStaff
            SalariedStaff staff1 = new SalariedStaff("Kyle Angeles", LocalDate.parse("2006-12-06"), "12345678", 50000);
            System.out.println("Original Salary for " + staff1.getName() + ": " +
                    NumberFormat.getCurrencyInstance().format(staff1.getYearlySalary()));
            System.out.println("---------------------------");

            //Implementation for HourlyWorker
            HourlyWorker worker1 = new HourlyWorker("Kyle Angeles ", LocalDate.parse("2006-12-06"), "12345678", 17.50, 38);
            System.out.println("Hourly rate for " + worker1.getName() + ": " +
                    currency.format(worker1.getHourlyRate()));
            System.out.println("----------------------------");

            //Updated Salary
            staff1.setYearlySalary(70000);
            System.out.println("Updated Salary for " + staff1.getName() + ": " +
                    NumberFormat.getCurrencyInstance().format(staff1.getYearlySalary()));


            //For example setting the hourly rate to 20
            // Update rate and hours
            System.out.println();
            worker1.setHourlyRate(worker1.getHourlyRate() + 2.0);
            worker1.setHoursPerWeek(worker1.getHoursPerWeek() + 5.0);
            System.out.println("Updated hourly rate: " + currency.format(worker1.getHourlyRate()));
            System.out.println("Updated hours per week: " + worker1.getHoursPerWeek());

        } catch (IllegalArgumentException e) {
            System.out.println("Error" + e.getMessage());

        }

        System.out.println();
        System.out.println();

        //This code is for the second try block: payroll report for 5 employees.

        try {

            System.out.println("Test Number 2 ");
            Employee[] payroll = new Employee[5]; //We are going to use 5 employees for instance

            //Adding two new Salaried Staff
            //Randomize Different values that I've created
            payroll[0] = new SalariedStaff("Shawn Nguyen", LocalDate.parse("1990-05-05"), "85629175", 57020);
            payroll[1] = new SalariedStaff("Tre Smith", LocalDate.parse("1999-12-03"), "12345678", 62000);

            payroll[2] = new HourlyWorker("Emily Chan", LocalDate.parse("2004-02-15"), "85723845", 17.00, 38);
            payroll[3] = new HourlyWorker("Liam Matthews", LocalDate.parse("1998-11-23"), "75762107", 20.50, 35);
            payroll[4] = new HourlyWorker("Sara Kim", LocalDate.parse("2006-09-12"), "91023571", 18.25, 42);

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
