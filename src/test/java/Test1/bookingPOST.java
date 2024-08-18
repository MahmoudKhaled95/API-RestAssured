package Test1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.FileReader;
import java.io.IOException;
import org.testng.Assert;

 
 import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class bookingPOST {

	private static final String BASE_URL = "https://restful-booker.herokuapp.com";  
    private JSONObject testData;

    @BeforeClass
    public void setup() throws IOException {
        // Load test data from JSON file
        FileReader reader = new FileReader("src/test/resources/bookingData.json");
        testData = new JSONObject(new JSONTokener(reader));
    }
    
    @Test
    
    public void validateAddItemSuccess() {
    	
        // Prepare request
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given()
                 .contentType("application/json")
                .body(testData.toString())
                .log().all();
 
        // Post request
        Response response = request.post("/booking"); 
        response.then().log().all();

        // Validate response status code (200 Ok)
        Assert.assertEquals(response.getStatusCode(), 200);
  
        JSONObject responseBody = new JSONObject(response.getBody().asString());
        JSONObject responseBooking = responseBody.getJSONObject("booking");

        // access data from bookingData.json
        JSONObject responseBookingDates = responseBooking.getJSONObject("bookingdates");
        JSONObject expectedBookingDates = testData.getJSONObject("bookingdates");
        // validation of data
        Assert.assertEquals(responseBookingDates.getString("checkin"), expectedBookingDates.getString("checkin"));
        Assert.assertEquals(responseBookingDates.getString("checkout"), expectedBookingDates.getString("checkout"));
        Assert.assertEquals(responseBooking.getString("additionalneeds"), testData.getString("additionalneeds"));
        Assert.assertEquals(responseBooking.getString("firstname"), testData.getString("firstname"));
        Assert.assertEquals(responseBooking.getString("lastname"), testData.getString("lastname"));
        Assert.assertEquals(responseBooking.getInt("totalprice"), testData.getInt("totalprice"));
        Assert.assertEquals(responseBooking.getBoolean("depositpaid"), testData.getBoolean("depositpaid"));
       
    }
}
