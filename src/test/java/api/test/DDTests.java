package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utils.DataProviders;
import io.restassured.response.Response;

public class DDTests {

	@Test(priority = 1,dataProvider = "Data",dataProviderClass = DataProviders.class)
	public void testPostUser(String id,String un,String fn,String ln,String email,String pwd,String ph)
	{
		User userPayload=new User();
		userPayload.setId(Integer.parseInt(id));
		userPayload.setUsername(un);
		userPayload.setFirstName(fn);
		userPayload.setLastName(ln);
		userPayload.setEmail(email);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		
		
		Response response = UserEndpoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
	@Test(priority = 2,dataProvider = "UserNames",dataProviderClass = DataProviders.class)
	public void testDeleteUserByName(String un)
	{
		Response response = UserEndpoints.deleteUser(un);
		Assert.assertEquals(response.getStatusCode(),200);
	}
}
