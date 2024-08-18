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

public class authPOST {
 
	private static final String BASE_URL = "https://restful-booker.herokuapp.com";  
    private JSONObject testData;
    
     @BeforeClass
    public void setup() throws IOException {
        // Load test data from JSON file
        FileReader reader = new FileReader("src/test/resources/body.json");
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
        Response response = request.post("/auth");  

        // Validate response status code
        Assert.assertEquals(response.getStatusCode(), 200);
        // Validate response not empty
        Assert.assertFalse(response.getBody().asString().isEmpty());
        // access token from response
        JSONObject responseBody = new JSONObject(response.getBody().asString());
        String token = responseBody.getString("token");
        
        // Validate token is not empty or null
        Assert.assertNotNull(token, "Token is null");
        Assert.assertFalse(token.isEmpty(), "Token is empty");
        
        // Save token in global variable for using it later
        GlobalVariables.Token = token;
        
        System.out.println("Token generated and saved successfully: " + GlobalVariables.Token);
    }
 
    
    }

