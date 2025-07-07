package Assignment3;

public class HourlyWorker extends Employee {

    //Declaring variables
    private double hourlyRate;
    private double hoursPerWeek;


    public HourlyWorker(String name, String birthDate, String employeeID,
                        double hourlyRate, double hoursPerWeek) {
        super(name, birthDate, employeeID);
        setHourlyRate(hourlyRate);
        setHoursPerWeek(hoursPerWeek);

    }
    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate < 16.00) {
            //Throws a message saying that "Hourly rate must be $16.00"
            throw new IllegalArgumentException("Hourly rate must be $16.00. ");
        }
        this.hourlyRate = hourlyRate;
    }

    //getHoursPerWeek returns the value of hoursPerWeek
    public double getHoursPerWeek() {
        return hoursPerWeek;
    }

    //Method to set the hours per week on the main
    public void setHoursPerWeek(double hoursPerWeek) {
        if (hoursPerWeek < 48.0) {
            throw new IllegalArgumentException("Maximum of hours you can work in a week is 48Hrs. ");
        }
        this.hoursPerWeek = hoursPerWeek;
    }

    //Same thing like the salaried staff
    //But use of hourlyRate and hoursPerWeek
    public double calculatePayDay() {
        return Math.round((hourlyRate * hoursPerWeek ) * 100 ) / 100;
    }

}
