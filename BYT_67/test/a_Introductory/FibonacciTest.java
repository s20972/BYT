package a_Introductory;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest {

    @Test
    public void testFib() {
        Fibonacci test = new Fibonacci();
        assertEquals("0", 0, test.fibonacci(0));
        assertEquals("1", 1, test.fibonacci(1));
        assertEquals("2", 1, test.fibonacci(2));
        assertEquals("3", 2, test.fibonacci(3));


    }
}
