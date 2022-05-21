
package stepDefinition;



import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import StepsDefine.PojoClassApi;
import StepsDefine.RepositoryJava;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static io.restassured.RestAssured.*;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CucumberStep {
 RepositoryJava reposit=new RepositoryJava();
 JSONObject jsonObject = new JSONObject();

	@Given("Get methodto {string}")
	public void get_methodto(String url) {
      reposit.getResponse(url).then().log().all().extract().body();
      
	}

	@Then("Response new is {int}")
	public void response_new_is(int exStatus) {
    Assert.assertTrue(reposit.checkStatusCode(exStatus));
	}

	@Given("post the data")
	public void post_the_data(io.cucumber.datatable.DataTable dataTable) throws JsonProcessingException {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
     List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
	    
	   for (Map<String, String> columns : rows) {
//columns.get("urls"), columns.get("statusCodes")));
		 //  jsonObject.put(columns.get("id"), columns.get("name"));
		// System.out.println(columns.get("id")+columns.get("name"));
		   
		   String id=columns.get("id");
		   String name=columns.get("name");
		   PojoClassApi pojoClassApi=new PojoClassApi();
		   pojoClassApi.setId(id);
		   pojoClassApi.setName(name);;
		 reposit.postValue(pojoClassApi);
  }
	}

	

	@Then("Response StatusCode is {int}")
	public void response_status_code_is(int status) {
		
	}

}
