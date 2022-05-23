package stepDefinition;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static io.restassured.RestAssured.*;
//import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class RestAssuredTesting {
	String Baseurl="http://localhost:8081/";
	Response response;
	//Scenario scenario;
	//private static ExtendReoprt report=new ExtendReoprt(); 
	public RestAssuredTesting() {
	// TODO Auto-generated constructor stub
  }
	//@Before
	//public void before(Scenario scenario) {
	//	this.scenario=scenario;
	//}

	@Given("Get call to {string}")
	public void get_call_to(String url) throws URISyntaxException{
	baseURI=Baseurl;	
	
	 RequestSpecification request=given();
	 response= request.when().get(url);


		  System.out.println(response.asPrettyString()+"new change updated might be changed");


}

@Then("Response is {string}")
public void response_is(String status) {
	int actualResponseCode=response.then().extract().statusCode();
	
     assertEquals(status, actualResponseCode +"");
     System.out.println(status+" "+actualResponseCode);
     
     //share report
 	
}

	


}
