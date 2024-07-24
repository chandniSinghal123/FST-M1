package Activities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class Activity3  {
        RequestSpecification requestSpec;
        ResponseSpecification responseSpec;
        int petId;


        @BeforeClass
        public void setup(){
            //Request specification

            requestSpec= new RequestSpecBuilder()
                    .setBaseUri("https://petstore.swagger.io/v2/pet")
                    .addHeader("Content-Type","application/json")
                    .build();

            //Response specification
            responseSpec = new ResponseSpecBuilder()
                    .expectStatusCode(200)
                    .expectBody("status",equalTo("alive"))
                    .expectResponseTime(lessThanOrEqualTo(5000L))
                    .build();

        }

        @DataProvider
        public Object[][] petInfoProvider(){
            Object[][] testData = new Object[][]{
                    {56788,"Kittu","alive"},
                    {56791,"Mittu","alive"}
            };
            return testData;
        }

        @Test(priority = 1)

        public void postRequest(){

            //Request body
            Map<String, Object> reqBody = new HashMap<>();
            reqBody.put("id",56788);
            reqBody.put("name", "Kittu");
            reqBody.put("status", "alive");

            //Save the response
            Response response = given().spec(requestSpec).body(reqBody).log().all().when().post();

            //assertions
            response.then().spec(responseSpec).body("name",equalTo("Kittu"));

            //second set of values
            reqBody.put("id",56791);
            reqBody.put("name", "Mittu");
            reqBody.put("status", "alive");

            response = given().spec(requestSpec).body(reqBody).log().all().when().post();
            response.then().spec(responseSpec).body("name",equalTo("Mittu"));




        }

        @Test(dataProvider ="petInfoProvider" , priority = 2)

        public void GetRequest(int id,String name,String status){

            given().spec(requestSpec).pathParam("petId",id).
                    when().get("/{petId}").
                    then().spec(responseSpec);

        }

        @Test(dataProvider = "petInfoProvider", priority = 3)

        public void DeleteRequest(int id,String name,String status){

            given().spec(requestSpec).pathParam("petId",id).
                    when().delete("/{petId}").
                    then().statusCode(200).body("message",equalTo(""+id));

        }
    }


