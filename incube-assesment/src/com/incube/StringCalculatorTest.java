package com.incube;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

	private final StringCalculator calculator = new StringCalculator();

	@Test
	public void testEmptyStringReturnsZero() {
		assertEquals(0, calculator.add(""));
	}

	@Test
	public void testSingleNumber() {
		assertEquals(1, calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(6, calculator.add("1,5"));
	}

	@Test
	public void testMultipleNumbers() {
		assertEquals(10, calculator.add("1,2,3,4"));
	}

	@Test
	public void testNewLineAsDelimiter() {
		assertEquals(6, calculator.add("1\n2,3"));
	}

	@Test
	public void testCustomDelimiter() {
		assertEquals(3, calculator.add("//;\n1;2"));
	}

	@Test
	public void testNegativeNumberThrowsException() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			calculator.add("1,-2,3");
		});
		assertTrue(exception.getMessage().contains("Negative numbers not allowed"));
	}

	@Test
	public void testMultipleNegativeNumbersThrowException() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			calculator.add("1,-2,-3,4");
		});
		assertTrue(exception.getMessage().contains("Negative numbers not allowed: [-2, -3]"));
	}
}
