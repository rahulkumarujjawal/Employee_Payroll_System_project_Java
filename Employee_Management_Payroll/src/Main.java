import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Emplyee[name = " + name + ",id=" + id + " , salary=" + calculateSalary() + "]";
    }
}

class FullTimeEmployee extends Employee {
    private double monthalySalary;

    public FullTimeEmployee(String name, int id, double monthalySalary) {
        super(name, id);
        this.monthalySalary = monthalySalary;


    }

    @Override
    public double calculateSalary() {
        return monthalySalary;
    }

}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}
//ArrayList<Integer> arrayList = new ArrayList<>();

class PayrollSystem {
    private ArrayList<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

}

public class Main {
    public static void main(String[] args) {
        PayrollSystem   payrollSystem = new PayrollSystem();
        FullTimeEmployee Emp1 = new FullTimeEmployee("Rahul",101,75000.00);
        PartTimeEmployee Emp2 =  new PartTimeEmployee("Tommay" ,102,40,100 );
        payrollSystem.addEmployee(Emp1);
        payrollSystem.addEmployee(Emp2);
        System.out.println("Initial Employee Details: ");
        payrollSystem.displayEmployees();
        System.out.println("Removing Employees");
        payrollSystem.removeEmployee(102);
        System.out.println("Remaining Employees Details: ");
        payrollSystem.displayEmployees();


    }
}
