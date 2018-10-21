package hellocucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import static org.junit.Assert.*;

public class Stepdefs {
    private String today;
    private String actualAnswer;

    /*@Given("^today is Sunday$")
    public void today_is_Sunday() {
        this.today = "Sunday";
    }*/
    // [^\"]: 不是引号(\")的任意一个字符
    @Given("^today is \"([^\"]*)\"$")
    public void today_is(String today) {
        this.today = today;
    }

    @When("^I ask whether it's Friday yet$")
    public void i_ask_whether_is_s_Friday_yet() {
        this.actualAnswer = IsItFriday.isItFriday(today);
    }
    // [^\"]: 不是引号(\")的任意一个字符
    @Then("^I should be told \"([^\"]*)\"$")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }

    @Given("^today is Friday$")
    public void today_is_Friday() {
        this.today = "Friday";
    }
}

class IsItFriday {
    static String isItFriday(String today) {
        if("Friday".equals(today)){
            return "TGIF";
        }
        return "Nope";
    }
}
