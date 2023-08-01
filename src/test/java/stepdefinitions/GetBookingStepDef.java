package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import pojo.restful.Booking;

public class GetBookingStepDef {
    String baseUri = "https://restful-booker.herokuapp.com/";

    RequestSpecBuilder request = new RequestSpecBuilder().setBaseUri(baseUri);

    Response response;

    @Given("User sets the {string} path as {int}")
    public void userSetsThePathAs(String pathParam, int pathValue) {
        request.addPathParam(pathParam,pathValue);
    }

    @When("user sends a request to {string}")
    public void userSendsARequestTo(String endpoint)  {    // Write code here that turns the phrase above into concrete actions    throw new cucumber.api.PendingException();}
        RequestSpecification spec =request.build();
        response = RestAssured.given().spec(spec).log().all().when().get(endpoint);


        response.then().statusCode(200);
    }

    @Then("user should see expected record")
    public void userShouldSeeExpectedRecord() {
        Booking booking = response.as(Booking.class);

        System.out.println(booking);

        Assert.assertEquals(booking.getFirstname(), "Mary");
        Assert.assertEquals(booking.getLastname(), "Smith");

        // expected data normal sartlarda bazi queryler veya baz alinan datalardan olusturulur.
        // Dersimizde Fake API lar kullandigimiz icin baz aldigimiz datalar degisiklik gostermekte.
        // Bu yuzden bu test her zaman pass olmayabilir
        // Pass olmadigi durumda lutfen requesti manuel atip expected datayi hard coded olarak degistiriniz

    }
}
