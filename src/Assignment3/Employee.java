package Assignment3;
/*Region Imported Libaries*/
import java.time.LocalDate;
/*EndRegion Imported Libraries*/
public abstract class Employee extends Person  {

    private final String employeeID;
/*Region functions*/
    public Employee(String name, LocalDate birthDate, String employeeID) {
        super(name, (birthDate));
        
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
/*EndRegion Functions*/
