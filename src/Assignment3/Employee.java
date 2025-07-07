package Assignment3;

public abstract class Employee extends Person  {
    
    private final String employeeID;
    
    public Employee(String name, String birthDate, String employeeID) {
        super(name, birthDate);
        
        if (!employeeID.matches("\\d{8}")) {
            throw new IllegalArgumentException("Employee ID must be exactly 8 digits or characters");
        }
        
        this.employeeID = employeeID;
    }
    
    public String getEmployeeID() {
        return employeeID;
    }
    
    public abstract double calculatePayDay();
}
