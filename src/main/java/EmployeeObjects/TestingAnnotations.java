package EmployeeObjects;

import EmployeeBlueprints.Employee;
import annotations.EmployeeType;
import annotations.PayRate;
import annotations.WeeklyPayCalculator;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestingAnnotations {

    public static void main(String[] args) {
        // Create instances of each employee type
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Tony", "Stark", 5749, "Service", "Lead Service Manager", 32.85);
        SalaryEmployee salaryEmployee = new SalaryEmployee("Steve", "Rogers", 1234, "Management", "Manager", 85000);
        CommissionEmployee commissionEmployee = new CommissionEmployee("Natasha", "Romanoff", 5678, "Sales", "Sales Representative", 0.05);

        // Array of employee objects
        Employee[] employees = {hourlyEmployee, salaryEmployee, commissionEmployee};

        // Count the number of employee types
        int employeeTypeCount = 0;
        for (Employee employee : employees) {
            if (employee.getClass().isAnnotationPresent(EmployeeType.class)) {
                employeeTypeCount++;
            }
        }
        System.out.println("You have " + employeeTypeCount + " employee types");

        // Loop through each employee and check for annotations on fields and methods
        for (Employee employee : employees) {
            Class<?> employeeClass = employee.getClass();

            // Check fields for PayRate annotation
            for (Field field : employeeClass.getDeclaredFields()) {
                if (field.isAnnotationPresent(PayRate.class)) {
                    field.setAccessible(true);
                    try {
                        double payRate = field.getDouble(employee);
                        System.out.println("Employee pay rate: $" + payRate);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }

            // Check methods for WeeklyPayCalculator annotation
            for (Method method : employeeClass.getDeclaredMethods()) {
                if (method.isAnnotationPresent(WeeklyPayCalculator.class)) {
                    try {
                        double weeklyPay = (double) method.invoke(employee);
                        System.out.println("Weekly pay: $" + weeklyPay);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}