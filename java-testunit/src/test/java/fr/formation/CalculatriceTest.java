package fr.formation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatriceTest {
    private Calculatrice calculatrice = new Calculatrice();
    
    @Test
    void shouldReturnOneWhenZeroAndOne() {
        // given
        int a = 0;
        int b = 1;

        // when
        int result = calculatrice.addition(a, b);

        // then
        Assertions.assertEquals(1, result);
    }
    
    @Test
    void shouldReturnFiveWhenMinusTenAndFithteen() {
        // given
        int a = -10;
        int b = 15;

        // when
        int result = calculatrice.addition(a, b);

        // then
        Assertions.assertEquals(5, result);
    }

    @ParameterizedTest
    @CsvSource({ "4,8,12", "-5,10,5", "0,80,80" })
    void shouldAdditionCorrectWithParams(int a, int b, int expected) {
        // given

        // when
        int result = calculatrice.addition(a, b);

        // then
        Assertions.assertEquals(expected, result);
    }
    
    @Test
    void shouldReturnMinusFiveWhenFiveAndTen() {
        // given
        int a = 5;
        int b = 10;

        // when
        int result = calculatrice.soustraction(a, b);

        // then
        Assertions.assertEquals(-5, result);
    }
}
