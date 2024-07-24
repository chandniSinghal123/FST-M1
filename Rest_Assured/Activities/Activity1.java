package Activities;

import io.restassured.response.Response;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class Activity1 {

    @Test(priority = 1)
    public void addnewpet(){
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("id",99219);
        reqBody.put("name", "Puppyy");
        reqBody.put("status", "alive");


        Response response=
                given().baseUri("https://petstore.swagger.io/v2/pet").
                          header("Content-Type", "application/json").
                          body(reqBody).
                          log().all().
                        when().post();


        //Assertions
        response.then().
                         statusCode(200).
                         body("id",equalTo(99219)).
                         body("name",equalTo("Puppyy")).
                         body("status",equalTo("alive")).
                         log().all();



    }

    @Test(priority = 2)
    public void getpetId(){
        given().
                baseUri("https://petstore.swagger.io/v2/pet").
                header("Content-Type", "application/json").
                pathParam("petId",99219).
                log().all().
                when().
                get("/{petId}").
                then().
                statusCode(200).
                body("id",equalTo(99219)).
                body("name",equalTo("Puppyy")).
                body("status",equalTo("alive")).
                log().all();
    }


    @Test(priority = 3)
    public void deletepet(){
        given().
                baseUri("https://petstore.swagger.io/v2/pet").
                header("Content-Type", "application/json").
                pathParam("petId",99219).
                log().all().
                when().
                delete("/{petId}").
                then().
                statusCode(200).
                body("message",equalTo("99219")).
                log().all();

    }
}
