// Test program for Employee Payroll System
public class PayrollSystemTest {
    public static void main(String[] args) {
        // Instantiate HourlyEmployee
        HourlyEmployee hourlyEmployee = new HourlyEmployee(1, "Alice", "Research Assistant", 20.0, 40);
        System.out.println("\nHourly Employee Details:");
        hourlyEmployee.displayInfo();

        // Instantiate SalariedEmployee
        SalariedEmployee salariedEmployee = new SalariedEmployee(2, "Bob", "Professor", 4000.0);
        System.out.println("\nSalaried Employee Details:");
        salariedEmployee.displayInfo();

        // Instantiate ExecutiveEmployee
        ExecutiveEmployee executiveEmployee = new ExecutiveEmployee(3, "Charlie", "Dean", 8000.0, 15.0);
        System.out.println("\nExecutive Employee Details:");
        executiveEmployee.displayInfo();

        // Display Total Payroll
        double totalPayroll = hourlyEmployee.calculateWeeklySalary() +
                              salariedEmployee.calculateWeeklySalary() +
                              executiveEmployee.calculateWeeklySalary();
        System.out.println("\nTotal Payroll for the week: " + totalPayroll);
    }
}
