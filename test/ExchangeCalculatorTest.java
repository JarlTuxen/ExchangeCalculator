import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExchangeCalculatorTest {

    @Test
    void exchangeUSDtoDKKTest() {
        //arrange
        ExchangeCalculator exchangeCalculator = new ExchangeCalculator();

        //act
        double result = exchangeCalculator.exchange("USD", "DKK", 100);

        //assert - expect exact result - should fail due to decimals missing
        assertEquals(753, result, "Exchange 100 USD for 753 DKK");

    }

    @Test
    void exchangeUSDNotAllowedTest(){
        //arrange
        ExchangeCalculator exchangeCalculator = new ExchangeCalculator();

        //act
        //assert - expect USD not to be allowed - test should fail
        assertThrows(IllegalArgumentException.class, () -> exchangeCalculator.exchange("USD", "DKK", 100), "USD not allowed");

    }

    @Test
    void exchangeUSDtoDKKTest01() {
        //arrange
        ExchangeCalculator exchangeCalculator = new ExchangeCalculator();

        //act
        double result = exchangeCalculator.exchange("USD", "DKK", 100);

        //assert - allow 0.1 deviation from 753
        assertEquals(753, result, 0.5 ,"Exchange 100 USD for 753 DKK");

    }

    @Test
    void exchangeSEKNotAllowedTest(){
        //arrange
        ExchangeCalculator exchangeCalculator = new ExchangeCalculator();

        //act
        //assert - expect SEK to not be allowed
        assertThrows(IllegalArgumentException.class, () -> exchangeCalculator.exchange("SEK", "DKK", 100), "SEK not allowed");

    }

}