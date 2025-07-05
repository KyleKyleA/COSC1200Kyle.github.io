package Assignment3;

//Class for the salaried staff
//Region function
public class SalariedStaff extends Employee {
    private double yearlySalary;

    public SalariedStaff(String name, String birthName, String EmployeeID, double yearlySalary) {
        super(name, birthName, EmployeeID);
        setYearlySalary(yearlySalary);
    }

    public double setYearlySalary() {
        return yearlySalary;
    }

    //set yearly salary
    //Sets an error message when it's a negative number
    public void setYearlySalary(double yearlySalary) {
        if (yearlySalary < 0) {
            throw new IllegalArgumentException("Yearly salary cannot be a negative integer.");
        }
        this.yearlySalary = yearlySalary;
    }

    public double calculatePayDay() {
        return Math.round((yearlySalary / 52.0 ) * 100 ) / 100;
    }

}
//EndRegion Functions
