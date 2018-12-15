import java.math.BigDecimal;

public class CostCalculator {
    private  final BigDecimal UNIT_PRICE;

    CostCalculator(BigDecimal unitPrice){
         this.UNIT_PRICE = unitPrice;
    }

    public BigDecimal calculate(int part)throws IllegalArgumentException {
        if(part < 0){
            throw new IllegalArgumentException();
        }
        return  UNIT_PRICE.multiply(new BigDecimal(part));
    }
}