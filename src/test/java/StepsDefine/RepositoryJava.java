package StepsDefine;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;



public class RepositoryJava {
	ObjectMapper objectMapper= new ObjectMapper();
	String Baseurl="http://localhost:8081";
	Response response;
	public Response getResponse(String url) {
	response= given().when().get(Baseurl+url);
	return response;
	}
	public ValidatableResponse getValidationThen() {
		return response.then();
	}
	public Boolean checkStatusCode(int status) {
		return response.getStatusCode()==status;
		
	}
	
	//public PojoClassApi[] postValue2(String url)
	//{
	//return given().header("Content-Type", "application/json").body(jsonObject.toJSONString()).when().post(Baseurl+url);
	//}

	public PojoClassApi postValue(PojoClassApi pojoClassApi) throws JsonProcessingException {
		String jsonString=objectMapper.writeValueAsString(pojoClassApi);
		PojoClassApi postResponse = given().contentType(ContentType.JSON).body(jsonString).when().post(Baseurl+"/saveHero").body().as(PojoClassApi.class);
		
				return postResponse ;
	}
}