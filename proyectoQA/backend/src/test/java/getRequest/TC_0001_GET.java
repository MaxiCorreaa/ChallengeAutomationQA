package getRequest;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TC_0001_GET {

    @Test
    public void getDetails() {
        baseURI = "https://api.openbrewerydb.org/breweries";

        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET, "?by_name=Lagunitas_Brewing_Co&by_state=California");

        String responseBody = response.getBody().asString();

        System.out.println("Response body is: " + responseBody);

        int statusCode = response.getStatusCode();
        System.out.println("Status code: " + statusCode);
        Assertions.assertEquals(statusCode, 200);

        String statusLine = response.getStatusLine();
        System.out.println("Status line: " + statusLine);

        Assertions.assertEquals(statusLine, "HTTP/1.1 200 OK");
        Assertions.assertTrue(responseBody.contains("Lagunitas Brewing Co"));
        Assertions.assertTrue(responseBody.contains("12040"));
        Assertions.assertTrue(responseBody.contains("1280 N McDowell Blvd"));
        Assertions.assertTrue(responseBody.contains("7077694495"));
    }
}
