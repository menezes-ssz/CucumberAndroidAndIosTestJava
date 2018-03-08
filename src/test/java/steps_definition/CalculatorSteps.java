package steps_definition;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.RemoteWebDriverHelper;
import screen.CalculatorScreen;

public class CalculatorSteps {
	
	private CalculatorScreen calculatorScreen;
	
	@Given("^i'am in Calculator Screen$")
	public void i_am_in_Calculator_Screen() throws MalformedURLException  {
		calculatorScreen = new CalculatorScreen(RemoteWebDriverHelper.getDriverByPlatformName(System.getProperty("environment")));
	}

	@When("^sum two numbers$")
	public void sum_two_numbers()  {
	    calculatorScreen.fillFirstNumber("10").fillSecondNumber("300").closeKeyboard().buttonSum.click();
	}

	@Then("^show the result of sum$")
	public void show_the_result_of_sum()  {
	   assertTrue(calculatorScreen.operationResult().equals("310")); ;
	}

	@When("^subtract two numbers$")
	public void subtract_two_numbers()  {
	    calculatorScreen.fillFirstNumber("100").fillSecondNumber("50").closeKeyboard().buttonSubtract.click();
	}

	@Then("^show the result of subtraction$")
	public void show_the_result_of_subtraction()  {
		assertTrue(calculatorScreen.operationResult().equals("50"));
	}

	@When("^divide two numbers$")
	public void divide_two_numbers()  {
	    calculatorScreen.fillFirstNumber("20").fillSecondNumber("4").closeKeyboard().buttonDivide.click();
	}

	@Then("^show the result of division$")
	public void show_the_result_of_division()  {
		assertTrue(calculatorScreen.operationResult().equals("5"));
	}

	@When("^multiply two numbers$")
	public void multiply_two_numbers()  {
	    calculatorScreen.fillFirstNumber("100").fillSecondNumber("100").closeKeyboard().buttonMultiply.click();
	}

	@Then("^show the result of multiplication$")
	public void show_the_result_of_multiplication()  {
		assertTrue(calculatorScreen.operationResult().equals("10000"));
	}

	@When("^divide by zero$")
	public void divide_by_zero()  {
	    calculatorScreen.fillFirstNumber("10").fillSecondNumber("0").closeKeyboard().buttonDivide.click();
	}

	@Then("^show the message cannot divide by zero!$")
	public void show_the_message_cannot_divide_by_zero()  {
		assertTrue(calculatorScreen.operationResult().equals("Cannot divide by zero!"));
	}
}
