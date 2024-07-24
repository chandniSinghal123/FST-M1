package Activities;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.internal.Utils.log;

public class Activity2 {

        @Test(priority = 1)
        public void addnewuser(){


        File file = new File("src/test/resources/input.json");
            Response response=
                    given().baseUri("https://petstore.swagger.io/v2/user").
                            header("Content-Type", "application/json").
                            body(file).
                            log().all().
                            when().post();


            //Assertions
            response.then().
                    statusCode(200).
                    body("code",equalTo(200)).
                    body("message",equalTo("325738"))
                    .log().all();



        }

        @Test(priority = 2)
        public void getusername(){
            given().
                    baseUri("https://petstore.swagger.io/v2/user").
                    header("Content-Type", "application/json").
                    pathParam("username","poulamifstone").
                    log().all().
                    when().
                    get("/{username}").
                    then().
                    statusCode(200).
                    body("id",equalTo(325738)).
                    body("firstName",equalTo("Chandni")).
                    body("lastName",equalTo("Singhal")).
                    body("username",equalTo("ChandniS")).
                    body("email",equalTo("chandnisinghal@mail.com")).
                    body("phone",equalTo("9650029385")).
                    log().all();
        }


        @Test(priority = 3)
        public void deleteuser(){
            given().
                    baseUri("https://petstore.swagger.io/v2/user").
                    header("Content-Type", "application/json").
                    pathParam("username","chandnisinghalone").
                    log().all().
                    when().
                    delete("/{username}").
                    then().
                    statusCode(200).
                    body("message",equalTo("chandnisinghalone")).
                    log().all();

        }
    }


