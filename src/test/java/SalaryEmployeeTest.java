import EmployeeObjects.SalaryEmployee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Suresh
 * This class tests the SalaryEmployee class.
 */
public class SalaryEmployeeTest {

    private SalaryEmployee emp;

    @BeforeEach
    public void setUp() {
        emp = new SalaryEmployee("Steve", "Rodgers", 3781, "Sales", "Manager", 64325);
    }

    @Test
    public void testCalculateWeeklyPay() {
        double weeklyPay = emp.calculateWeeklyPay();
        assert weeklyPay == 1237.02;
    }

    @Test
    public void testHolidayBonus() {
        double holidayBonus = emp.holidayBonus();
        assert holidayBonus == 2164.54;
    }
}
