package com;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.google.gson.JsonArray;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Add {
	@Test
	public void Test() {

		RestAssured.baseURI = "http://api.e2enetworks.com";

		Response res = given().header("x-api-key", "c602ba87-52e8-480c-8517-c35c9bd91274").

				header("Authorization",
						"Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJjejBXYVVKVF9wWmE5MXNpRl9QRXVxUUpqdm5VODhsMXdsVmNla1ZiUXBRIn0.eyJqdGkiOiI5YzJlYWIyOS1hMTk5LTQ2OTEtYmM1ZC05ZTdkY2VkYjYwMDgiLCJleHAiOjE2MjEwNzU2MTcsIm5iZiI6MCwiaWF0IjoxNTg5NTM5NjE3LCJpc3MiOiJodHRwOi8vZ2F0ZXdheS5lMmVuZXR3b3Jrcy5jb20vYXV0aC9yZWFsbXMvYXBpbWFuIiwiYXVkIjoiYXBpbWFudWkiLCJzdWIiOiI3MzY4ZDFiNy1lNTJkLTQ5MjItYmNmZi02OWU1MDc5MTI3MGUiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJhcGltYW51aSIsImF1dGhfdGltZSI6MCwic2Vzc2lvbl9zdGF0ZSI6Ijk4MDJhNTAzLTljZWYtNGI4NS1iNTM3LWIyMGFjODZhZTQzYiIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOltdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsidW1hX2F1dGhvcml6YXRpb24iLCJhcGl1c2VyIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwibmFtZSI6IkFiaGluYXYgR2FyZyIsInByZWZlcnJlZF91c2VybmFtZSI6ImFiaGluYXYuZ2FyZytwcmVwYWlkQGUyZW5ldHdvcmtzLmNvbSIsImdpdmVuX25hbWUiOiJBYmhpbmF2IiwiZmFtaWx5X25hbWUiOiJHYXJnIiwiZW1haWwiOiJhYmhpbmF2LmdhcmcrcHJlcGFpZEBlMmVuZXR3b3Jrcy5jb20ifQ.ElnW3qrKEi1Oyh2Oek_3WBojTJSXTiOl5gB1KrHezW10UUIxHPzCjZwPTlQzevvF1EmjEdot8M0vq2nO62KzO781ZLC4jmYmwbKB0hGmYoN-rTD-WBgWFJlDZekv3AZ-Y2gn1BEIT5WVrJ-5UH2Yl8y7bzmB7eR5BZzjKgmQ9DP61jiRDoZsSgnRZEXJY2Th5etUqb7lG7YmuRVzKL7NJLYF6kO5up-t-SQyB2pCyLEB4GKPEueSo8iFwFSU_5PzgzGvD7VepeWZSFevpbOh0DkagoPGDm3RogIti_aJwWv-cQyFGcPVk_NoA-0Lxm2lytfI1I6eS631-4Qzwqj-zA")
				.

				when().get("/myaccount/api/v1/images/").then().assertThat().statusCode(200).and()
				.contentType(ContentType.JSON).extract()
				.response();
		String responseString = res.asString();
		System.out.print(responseString);
		JsonPath js= new JsonPath(responseString);


	
	}
}