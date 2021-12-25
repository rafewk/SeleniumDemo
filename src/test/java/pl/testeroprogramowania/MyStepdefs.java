package pl.testeroprogramowania;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {
    @Given("User with unique email")
    public void userWithUniqueEmail() {
        System.out.println("User with unique email");
    }

    @When("User register itself")
    public void userRegisterItself() {
        System.out.println("User register itself");
    }

    @Then("User is redirected to the logged user's page")
    public void userIsRedirectedToTheLoggedUserSPage() {
        System.out.println("User is redirected to the logged user's page");
    }

    @Given("User with email already registered in database")
    public void userWithEmailAlreadyRegisteredInDatabase() {
        System.out.println("User with email already registered in database");
    }

    @Then("Error message informing about already registered email appears")
    public void errorMessageInformingAboutAlreadyRegisteredEmailAppears() {
        System.out.println("Error message informing about already registered email appears");
    }
}
