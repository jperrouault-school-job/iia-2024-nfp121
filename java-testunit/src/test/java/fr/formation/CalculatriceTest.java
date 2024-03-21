package fr.formation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
