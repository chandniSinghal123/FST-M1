package Project;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {
    //set the headers
    Map<String, String> headers = new HashMap<>();
    //create the contract
    @Pact(consumer = "UserConsumer", provider = "UserProvider")
    public RequestResponsePact createPact(PactDslWithProvider builder){
        //Required Headers
            headers.put("Content-Type","application/json");
        //Request and response body
        DslPart reqAndResBody = new PactDslJsonBody()
                .numberType("id",9899)
                .stringType("firstName","Anugna")
                .stringType("lastName","M")
                .stringType("email","anugna@example.com");
        //Interaction
        return builder.given("POST Request").
             uponReceiving("a request to create a user").
                method("POST").
                path("/api/users").
                headers(headers).
                body(reqAndResBody).
             willRespondWith().
                status(201).
                body(reqAndResBody).
             toPact();
    }

    @Test
    @PactTestFor(providerName = "UserProvider",port = "8282")
    public void postRequestTest(){
        //create request body
        Map<String,Object> reqBody = new HashMap<>();
        reqBody.put("id",9899);
        reqBody.put("firstName","Anugna");
        reqBody.put("lastName", "M");
        reqBody.put("email","anugna@example.com");
        //send request, get response and assert response
        given().baseUri("http://localhost:8282").headers(headers).body(reqBody).log().all().
        when().post("/api/users").
        then().statusCode(201).body("firstName",equalTo("Anugna")).log().all();
    }

}
