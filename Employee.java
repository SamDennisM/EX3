// Base class: Employee
class Employee {
    protected int employeeId;
    protected String employeeName;
    protected String designation;

    public Employee(int employeeId, String employeeName, String designation) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.designation = designation;
    }

    // Getter and Setter methods
    public int getEmployeeId() { return employeeId; }
    public String getEmployeeName() { return employeeName; }
    public String getDesignation() { return designation; }

    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }
    public void setDesignation(String designation) { this.designation = designation; }

    public double calculateBonus() {
        return 0.0; // Base class has no specific bonus calculation
    }

    public void displayInfo() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + employeeName);
        System.out.println("Designation: " + designation);
    }
}

// Derived class: HourlyEmployee
class HourlyEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public HourlyEmployee(int employeeId, String employeeName, String designation, double hourlyRate, int hoursWorked) {
        super(employeeId, employeeName, designation);
        setHourlyRate(hourlyRate);
        setHoursWorked(hoursWorked);
    }

    public double getHourlyRate() { return hourlyRate; }
    public int getHoursWorked() { return hoursWorked; }

    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate > 0) this.hourlyRate = hourlyRate;
        else throw new IllegalArgumentException("Hourly rate must be positive.");
    }

    public void setHoursWorked(int hoursWorked) {
        if (hoursWorked >= 0) this.hoursWorked = hoursWorked;
        else throw new IllegalArgumentException("Hours worked must be non-negative.");
    }

    public double calculateWeeklySalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public double calculateBonus() {
        return calculateWeeklySalary() * 0.05; // Example: 5% bonus for hourly employees
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Hourly Rate: " + hourlyRate);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Weekly Salary: " + calculateWeeklySalary());
        System.out.println("Bonus: " + calculateBonus());
    }
}

// Derived class: SalariedEmployee
class SalariedEmployee extends Employee {
    private double monthlySalary;

    public SalariedEmployee(int employeeId, String employeeName, String designation, double monthlySalary) {
        super(employeeId, employeeName, designation);
        setMonthlySalary(monthlySalary);
    }

    public double getMonthlySalary() { return monthlySalary; }

    public void setMonthlySalary(double monthlySalary) {
        if (monthlySalary > 0) this.monthlySalary = monthlySalary;
        else throw new IllegalArgumentException("Monthly salary must be positive.");
    }

    public double calculateWeeklySalary() {
        return monthlySalary / 4; // Assuming 4 weeks per month
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.1; // Example: 10% bonus for salaried employees
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Monthly Salary: " + monthlySalary);
        System.out.println("Weekly Salary: " + calculateWeeklySalary());
        System.out.println("Bonus: " + calculateBonus());
    }
}

// Derived class: ExecutiveEmployee (from SalariedEmployee)
class ExecutiveEmployee extends SalariedEmployee {
    private double bonusPercentage;

    public ExecutiveEmployee(int employeeId, String employeeName, String designation, double monthlySalary, double bonusPercentage) {
        super(employeeId, employeeName, designation, monthlySalary);
        setBonusPercentage(bonusPercentage);
    }

    public double getBonusPercentage() { return bonusPercentage; }

    public void setBonusPercentage(double bonusPercentage) {
        if (bonusPercentage >= 0 && bonusPercentage <= 100) this.bonusPercentage = bonusPercentage;
        else throw new IllegalArgumentException("Bonus percentage must be between 0 and 100.");
    }

    @Override
    public double calculateBonus() {
        double baseBonus = super.calculateBonus();
        return baseBonus + (getMonthlySalary() * 12 * (bonusPercentage / 100));
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Bonus Percentage: " + bonusPercentage);
        System.out.println("Total Bonus: " + calculateBonus());
    }
}
