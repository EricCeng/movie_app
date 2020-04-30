package life.drift.movie.utils;

import java.math.BigDecimal;

public class CalScoreUtil {

    public static BigDecimal add(String value1, String value2){
        BigDecimal bigDecimal1 = new BigDecimal(value1);
        BigDecimal bigDecimal2 = new BigDecimal(value2);
        return bigDecimal1.add(bigDecimal2);
    }

    public static BigDecimal divide(String value1, String value2){
        BigDecimal bigDecimal1 = new BigDecimal(value1);
        BigDecimal bigDecimal2 = new BigDecimal(value2);
        return bigDecimal1.divide(bigDecimal2);
    }
}
