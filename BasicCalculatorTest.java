import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class BasicCalculatorTest {

	@Test
	void test_Addition() {
		BasicCalculator calculator = new BasicCalculator();
		assertEquals("7.0",calculator.solve(calculator.parseEquation("5 + 2")));
		calculator.deleteHistory();
	}
	
	@Test
	void test_Substraction() {
		BasicCalculator calculator = new BasicCalculator();
		assertEquals("3.0",calculator.solve(calculator.parseEquation("5 - 2")));
		calculator.deleteHistory();
	}
	
	@Test
	void test_Multiplication() {
		BasicCalculator calculator = new BasicCalculator();
		assertEquals("32.0",calculator.solve(calculator.parseEquation("4 * 8")));
		calculator.deleteHistory();
	}
	
	@Test
	void test_Division() {
		BasicCalculator calculator = new BasicCalculator();
		assertEquals("10.0",calculator.solve(calculator.parseEquation("50 / 5")));
		calculator.deleteHistory();
	}
	
	@Test
	void test_Answer_that_is_fraction() {
		BasicCalculator calculator = new BasicCalculator();
		assertEquals("2.5",calculator.solve(calculator.parseEquation("5 / 2")));
		calculator.deleteHistory();
	}
	
	@Test
	void test_Mixed_Equation() {
		BasicCalculator calculator = new BasicCalculator();
		assertEquals("3.0",calculator.solve(calculator.parseEquation("5 + 4 - 3 * 4 / 2")));
		calculator.deleteHistory();
	}
	
	@Test
	void equation_With_Brackets() {
		BasicCalculator calculator = new BasicCalculator();
		assertEquals("26.0",calculator.solve(calculator.parseEquation("( 10 + 3 ) * 2")));
		calculator.deleteHistory();
	}
	
	@Test
	void equation_With_Double_Brackets() {
		BasicCalculator calculator = new BasicCalculator();
		assertEquals("78.0",calculator.solve(calculator.parseEquation("( ( 10 + 3 ) * 2 ) * 3 ")));
		calculator.deleteHistory();
	}
	
	@Test
	void test_Long_Equation() {
		BasicCalculator calculator = new BasicCalculator();
		assertEquals("0.0",calculator.solve(calculator.parseEquation("1 + 2 + 3 + 4 - 4 - 3 - 2 - 1")));
		calculator.deleteHistory();
	}
	
	@Test
	void test_Invalid_Equation() {
		BasicCalculator calculator = new BasicCalculator();
		assertEquals("Not valid equation.",calculator.solve(calculator.parseEquation("( 10 + 5")));
		calculator.deleteHistory();
	}
	

}
