import EmployeeObjects.HourlyEmployee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for HourlyEmployee
 */
public class HourlyEmployeeTest {

    private HourlyEmployee emp;

    @BeforeEach
    public void setUp() {
        emp = new HourlyEmployee("Tony", "Stark", 5749, "Service", "Lead Service Manager", 32.85);
    }

    @Test
    public void testIncreaseHoursPositiveNumber(){
        emp.increaseHours(5);
        assert emp.getHoursWorked() == 5.0;
    }

    @Test
    public void testIncreaseHoursNegativeNumber(){
        emp.increaseHours(-5);
        assert emp.getHoursWorked() == 0.0;
    }

    @Test
    public void testAnnualRaise(){
        emp.annualRaise();
        assert emp.getWage() == 34.49;
    }

    @Test
    public void testCalculateWeeklyPayWhenHoursLessThanForty(){
        emp.increaseHours(35);
        double weeklyPay = emp.calculateWeeklyPay();
        assert weeklyPay == 1149.75;
    }

    @Test
    public void testCalculateWeeklyPayWhenHoursMoreThanForty(){
        emp.increaseHours(45);
        double weeklyPay = emp.calculateWeeklyPay();
        assert weeklyPay == 1560.38;
    }

}
