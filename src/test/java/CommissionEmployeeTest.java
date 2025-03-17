import EmployeeObjects.CommissionEmployee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Suresh
 * Test class for CommissionEmployee
 */
public class CommissionEmployeeTest {

    private CommissionEmployee emp ;

    @BeforeEach
    public void setUp() {
        emp = new CommissionEmployee("Clint", "Barton", 6847, "Sales", "Customer Representative", .0265);
    }

    /**
     * Test the increase sales method with positive value
     */
    @Test
    public void testIncreaseSalesWithPositiveValue() {
        emp.increaseSales(100);
        assert emp.getSales() == 100.0;
    }

    /**
     * Test the increase sales method with a negative value
     */
    @Test
    public void testIncreaseSalesWithNegativeValue() {
        emp.increaseSales(-100);
        assert emp.getSales() == 0.0;
    }

    /**
     * Test the holiday bonus method
     */
    @Test
    public void testHolidayBonus() {
        double holidayBonus = emp.holidayBonus();
        assert holidayBonus == 0.0;
    }

    /**
     * Test the annual raise method
     */
    @Test
    public void testAnnualRaise() {
        emp.annualRaise();
        emp.annualRaise();
        assert emp.getRate() == .0305;
    }

}
