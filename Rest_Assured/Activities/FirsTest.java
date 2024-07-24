package examples;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

public class firsttest {
    // GET https://petstore.swagger.io/v2/pet/findByStatus?status=alive
    @Test
    public void getRequestWithQueryParam() {
        //Send request and save response

        Response response =
                given().
                        baseUri("https://petstore.swagger.io/v2/pet").
                        header("Content-Type", "application/json").
                        queryParam("status", "alive").
                        log().all().
                        when().
                        get("/findByStatus");

        System.out.println(response.getBody().asPrettyString());
        System.out.println(response.getHeaders().asList());


        String petstatus = response.then().extract().path("[0]['status']");
        System.out.println("Pet status is" + petstatus);

        Assert.assertEquals(petstatus, "alive");
    }

    // GET https://petstore.swagger.io/v2/pet/{petId}

    @Test

    public void getRequestWithPathParam() {
         given().
                baseUri("https://petstore.swagger.io/v2/pet").
                 header("Content-Type", "application/json").
                 pathParam("petId",772321).
                 log().all().
                 when().
                 get("/{petId}").
                 then().
                 statusCode(200).
                 body("name",equalTo("Riley")).
                 body("status",equalTo("alive")).
                 log().all();

    }

}
