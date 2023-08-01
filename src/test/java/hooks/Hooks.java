package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class Hooks {

    //public static RequestSpecification request;

    @Before
    public void setup(){




    }

    @After
    public void teardown(){

        //response loglama olabilir

    }
}
