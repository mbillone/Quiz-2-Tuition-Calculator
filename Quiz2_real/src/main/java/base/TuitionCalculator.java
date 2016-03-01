package base;
import java.util.Scanner;

import org.apache.poi.ss.formula.functions.FinanceLib;

public class TuitionCalculator {
	// variables used and their setters and getters
	private static double TotalTuitionBill;
	private static double PercentTuitionIncrease;
	private static double APR;
	private static double PaymentPerMonth;
	private static double InitialTuition;
	private static double RepaymentTerm;
	
	private static double getTotalTuitionBill() {
		return TotalTuitionBill;
	}
	private static void setTotalTuitionBill(double totalTuitionBill) {
		TotalTuitionBill = totalTuitionBill;
	}
	private static double getPercentTuitionIncrease() {
		return PercentTuitionIncrease;
	}
	private static void setPercentTuitionIncrease(double percentTuitionIncrease) {
		PercentTuitionIncrease = percentTuitionIncrease;
	}
	private static double getAPR() {
		return APR;
	}
	private static void setAPR(double aPR) {
		APR = aPR;
	}
	private static double getPaymentPerMonth() {
		return PaymentPerMonth;
	}
	private static void setPaymentPerMonth(double paymentPerMonth) {
		PaymentPerMonth = paymentPerMonth;
	}
	private static double getInitialTuition() {
		return InitialTuition;
	}
	private static void setInitialTuition(double initialTuition) {
		InitialTuition = initialTuition;
	}
	private static double getRepaymentTerm() {
		return RepaymentTerm;
	}
	private static void setRepaymentTerm(double repaymentTerm) {
		RepaymentTerm = repaymentTerm;
	}
	
public static void main(String[] args) {
	UserInput();
	System.out.println("Your total tuition bill is:" + TotalTuitionBillCalc()
			+ "Your monthly payment is:" + RepaymentCalc() + "in a term of" + getRepaymentTerm());
			
}
// User inputs to be used in calculations
public static void UserInput(){
	
	Scanner input = new Scanner(System.in);
	System.out.println("Enter your initial tuition cost:");
	setInitialTuition(input.nextDouble());
	
	System.out.println("Enter the percent increase in tuition (as a decimal):");
	setPercentTuitionIncrease(input.nextDouble());
	
	System.out.println("Enter the repayment APR of your loan (as a decimal):");
	setAPR(input.nextDouble());
	
	System.out.println("Enter the repayment term for your loan:");
	setRepaymentTerm(input.nextDouble());
	
}
// calculates the total tuition after a 4 year degree
public static double TotalTuitionBillCalc(){
	double totalTuition = getTotalTuitionBill();
	double initialTuition = getInitialTuition();
	for(int i=0;i < 4;i++){
		 totalTuition += ((initialTuition * getPercentTuitionIncrease()) + initialTuition);
	}
	return totalTuition;
}
// calculates the monthly payment based off of interest rate
	public static double RepaymentCalc()
	{
		double rate = getAPR() / (100*12);
		double numOfTerms = getRepaymentTerm() * 12;
		double todaysValue = -TotalTuitionBillCalc();
		double futureVal = 0;
		boolean t = false;
		double monthlyPay = FinanceLib.pmt(rate, numOfTerms, todaysValue, futureVal, t);
		return monthlyPay;
}

}
