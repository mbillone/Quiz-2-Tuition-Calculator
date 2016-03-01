package base;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TuitionCalculator_Test {
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
				
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
		
	}

	@Before
	public void setUp() throws Exception 
	{
		
	}

	@After
	public void tearDown() throws Exception 
	{
		
	}

	@Test
	public void TotalTuitionTest() {
		double expectedOutput1 = 52800.0;
		double expectedOutput2 = 56000.0;
		double actualValue = TuitionCalculator.TotalTuitionBillCalc();
		
		// do not know how to test this one
		
		
	}
	@Test
	public void monthlyPaymentTest() {
		double APR = .08;
		double repayTerm = 24;
		double totalTuition = 52752.0;
		double resultant = 187.61309385123374;
		
		assertTrue(Math.round(TuitionCalculator.RepaymentCalc()) == resultant);
		assertFalse(Math.round(TuitionCalculator.RepaymentCalc()) == 215.0);
	}}