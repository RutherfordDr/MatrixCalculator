import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ScientificCalculatorTest {

	@Test
	void test_Addition() {
		ScientificCalculator calculator = new ScientificCalculator();
		assertEquals("7.0",calculator.solve(calculator.parseEquation("5 + 2")));
		calculator.deleteHistory();
		
		
	}
	
	@Test
	void test_Substraction() {
		ScientificCalculator calculator = new ScientificCalculator();
		assertEquals("5.0",calculator.solve(calculator.parseEquation("7 - 2")));
		calculator.deleteHistory();
		
	}
	
	@Test
	void test_Multiplication() {
		ScientificCalculator calculator = new ScientificCalculator();
		assertEquals("40.0",calculator.solve(calculator.parseEquation("4 * 10")));
		calculator.deleteHistory();
		
	}
	
	@Test
	void test_Division() {
		ScientificCalculator calculator = new ScientificCalculator();
		assertEquals("25.0",calculator.solve(calculator.parseEquation("50 / 2")));
		calculator.deleteHistory();
		
	}
	
	@Test
	void test_Squared() {
		ScientificCalculator calculator = new ScientificCalculator();
		assertEquals("25.0",calculator.solve(calculator.parseEquation(" 5 ^ 2")));
		calculator.deleteHistory();
		
	}
	
	@Test
	void test_Exponent() {
		ScientificCalculator calculator = new ScientificCalculator();
		assertEquals("125.0",calculator.solve(calculator.parseEquation(" 5 ^ 3")));
		calculator.deleteHistory();
		
	}
	
	@Test
	void test_SquareRoot() {
		ScientificCalculator calculator = new ScientificCalculator();
		assertEquals("9.0",calculator.solve(calculator.parseEquation(" sqrt ( 81 )")));
		calculator.deleteHistory();
		
	}
	
	@Test
	void test_Sin() {
		ScientificCalculator calculator = new ScientificCalculator();
		assertEquals("0.0",calculator.solve(calculator.parseEquation(" sin ( pi )")));
		calculator.deleteHistory();
		
	}
	
	@Test
	void test_Divide_By_Zero() {
		ScientificCalculator calculator = new ScientificCalculator();
		assertEquals("Infinity",calculator.solve(calculator.parseEquation(" 1 / 0")));
		calculator.deleteHistory();
		
	}
	
	@Test
	void test_Answer_that_is_fraction() {
		ScientificCalculator calculator = new ScientificCalculator();
		assertEquals("2.5",calculator.solve(calculator.parseEquation("5 / 2")));
		calculator.deleteHistory();
		
	}
	
	@Test
	void test_Mixed_Equation() {
		ScientificCalculator calculator = new ScientificCalculator();
		assertEquals("3.0",calculator.solve(calculator.parseEquation("5 + 4 - 3 * 4 / 2")));
		calculator.deleteHistory();
		
	}
	
	@Test
	void equation_With_Brackets() {
		ScientificCalculator calculator = new ScientificCalculator();
		assertEquals("26.0",calculator.solve(calculator.parseEquation("( 10 + 3 ) * 2")));
		calculator.deleteHistory();
		
	}
	
	@Test
	void equation_With_Double_Brackets() {
		ScientificCalculator calculator = new ScientificCalculator();
		assertEquals("78.0",calculator.solve(calculator.parseEquation("( ( 10 + 3 ) * 2 ) * 3 ")));
		calculator.deleteHistory();
		
	}
	
	@Test
	void test_Long_Equation() {
		ScientificCalculator calculator = new ScientificCalculator();
		assertEquals("0.0",calculator.solve(calculator.parseEquation("1 + 2 + 3 + 4 - 4 - 3 - 2 - 1")));
		calculator.deleteHistory();
		
	}
	
	@Test
	void test_Invalid_Equation() {
		ScientificCalculator calculator = new ScientificCalculator();
		assertEquals("Not valid equation.",calculator.solve(calculator.parseEquation("( 10 + 5 ) )")));
		calculator.deleteHistory();
	}

}
