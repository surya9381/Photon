package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.endpoints.UserEndpoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests2 {

	Faker faker;
	User userPayload;
	@BeforeClass
	public void presetup()
	{
		faker=new Faker();
		userPayload=new User();
	 	userPayload.setId(faker.idNumber().hashCode());
	 	userPayload.setFirstName(faker.name().firstName());
	 	userPayload.setLastName(faker.name().lastName());
	 	userPayload.setUsername(faker.name().username());
	 	userPayload.setEmail(faker.internet().safeEmailAddress());
	 	userPayload.setPassword(faker.internet().password());
	 	userPayload.setUserStatus(0);
	}
	
	@Test(priority = 1)
	public void testPostUser()
	{
		Response response = UserEndpoints2.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
	@Test(priority = 2)
	public void testGetUser()
	{
		Response response = UserEndpoints2.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
	@Test(priority = 3)
	public void testUpdateUser()
	{
		Response response = UserEndpoints2.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
	@Test(priority = 4)
	public void testDeleteUser()
	{
		Response response = UserEndpoints2.deleteUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
	
	
	
	
}
