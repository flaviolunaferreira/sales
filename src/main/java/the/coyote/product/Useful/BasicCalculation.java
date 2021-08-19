package the.coyote.product.Useful;

import java.math.BigDecimal;

public class BasicCalculation<Interface> {

	Calculate Add = (a, b) -> a.add(b);
    Calculate Subtract = (a, b) -> a.subtract(b);
    Calculate Multiply = (a, b) -> a.multiply(b);
    Calculate RemainingDivision = (a,b) -> a.remainder(b);
    Calculate Division = (a, b) -> a.divide(b);
	
    public BigDecimal executeOperation(Calculate calculate, BigDecimal a, BigDecimal b) {
        return calculate.calc(a,b);
    }

}

interface Calculate {
    public BigDecimal calc(BigDecimal a, BigDecimal b);
}
