package com;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Create {

	@Test
	public void NodeCreate() {

		RestAssured.baseURI = "http://api.e2enetworks.com";

		Response res=given().
				param("name", "truetest")
				.param("region", "ncr")
				.param("plan", "C-4vCPU-12RAM-100DISK-C2.12GB-CentOS-7.5")
				.param("image", "CentOS-7.5-Distro")
				.param("ssh_keys",
						"ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQDYzhkPZUcRal9oBGE6E91xdthkc0p4AHaT24Idh+32KeD7YpERJemuuWYgapFd6IXMRb7G+OjXwDna0TyyH5CUBgnOnSWov3kyFzkrqdchJDVYM4uW+RIk1bVhKJjGqR7/s+8U6Fg/1m8ptpIRh1U5pAJe2+H1e8fitoi2F3MCeXa8kaoL66iB9Y/Xekdo0zQjtkws/BgBR0JJwJZapcqJPNK1RipXjQ4Krc69tXr1EC8oWmXrU7sYstxgrL+mAMUCvpxSweblU6lUjR+CIiO7gVPQQVXWth3u8Sc66ci8OF/QV6PoghQzfKZ0RFTjMmhiapxXigrjfDD/cNUAfBO1 abhinav.garg@e2enetworks.com\r\n")
				.param("backups", "false")
				.

				header("x-api-key", "3009e9da-811b-424b-861b-e99f0682bffa").

				header("Authorization",
						"Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJjejBXYVVKVF9wWmE5MXNpRl9QRXVxUUpqdm5VODhsMXdsVmNla1ZiUXBRIn0.eyJqdGkiOiJmMWRmNDYyMS01MmFiLTQ4YzEtOWIxZC03Y2NlNmQ1YjU3OTgiLCJleHAiOjE2MjEwNzY1NTMsIm5iZiI6MCwiaWF0IjoxNTg5NTQwNTUzLCJpc3MiOiJodHRwOi8vZ2F0ZXdheS5lMmVuZXR3b3Jrcy5jb20vYXV0aC9yZWFsbXMvYXBpbWFuIiwiYXVkIjoiYXBpbWFudWkiLCJzdWIiOiJlOTc0NWQ2Ni0wOWE2LTRhOGMtOWYzMC1jOTJiYzM5ZTY5MzYiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJhcGltYW51aSIsImF1dGhfdGltZSI6MCwic2Vzc2lvbl9zdGF0ZSI6IjU2NjBhZGJiLTEzMjEtNDE5Yy1hNjM3LTIyODZkNmNlZjE1MCIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOltdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsidW1hX2F1dGhvcml6YXRpb24iLCJhcGl1c2VyIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwibmFtZSI6ImFiaGluYXYgZ2FyZyIsInByZWZlcnJlZF91c2VybmFtZSI6ImFiaGluYXZnYXJnM0BnbWFpbC5jb20iLCJnaXZlbl9uYW1lIjoiYWJoaW5hdiIsImZhbWlseV9uYW1lIjoiZ2FyZyIsImVtYWlsIjoiYWJoaW5hdmdhcmczQGdtYWlsLmNvbSJ9.iHkC5iTdPSwBK7ddY5hoCaK_YrbRwZDZRgXFBwlI-K1b5JWxErfAlU4OIzd2Uq_bT83eYlcyecqXE0-NDm9D7YvcgNbMjGFvM8HlAc4M57TJcnHRxIJCrHmfleZ9ukPrSBz_-GXY-jWaIGG3WLs4DAcIwNZYIF9SoUHmZ0scVNkn7YOICBAZnsCX9djrmmH12xH6VNk6PtWPA0W3tJrYRCFMFga1M7pFgJtJBZ2KsS5JkKdSQpZf435zZ5qzN6InaSq8u9PSCwV0I8ynEoP3Kd8-rZgSNw1Qn-a2CvS-y9X6XI1EIzU_b64u4DBfLEOVAE2jkXhUC0qkF_y2hBYk9w")
				.

				when().post("/myaccount/api/v1/nodes/").then().assertThat()
				.statusCode(200).and().contentType(ContentType.JSON).and()
				/*.body("data.plan", equalTo("C2.12GB")).and()
				.body("data.name", equalTo("truetest")).and()
				.body("data.status", equalTo("Creating"))*/
		.extract().response();
		String responseString = res.asString();
		System.out.println(responseString);
		JsonPath js= new JsonPath(responseString);
		String data =js.getString("data");
		System.out.println(data);
		
		
	}

	}

