package Test1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 
import org.testng.Assert;

import java.util.List;

 
import org.testng.annotations.Test;
 public class bookingGET {

	private static final String BASE_URL = "https://restful-booker.herokuapp.com";  
 
    String token = GlobalVariables.Token;

    
    @Test 

    
    public void validateGETLIST() {
 
        // Prepare request
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given()
                 .log().all();

        // GET request
        Response response = request.get("/booking");  
        response.then().log().all(); // Log the response


        // Validate response status code
        Assert.assertEquals(response.getStatusCode(), 200);
 
        
        List<Integer> bookingIds = response.jsonPath().getList("bookingid");

        // Assert that the number of booking IDs is greater than zero
        Assert.assertTrue(bookingIds.size() > 0, "The number of booking IDs returned by the API is not greater than zero!");

        System.out.println("Number of booking IDs: " + bookingIds.size());
 
 
    }}

