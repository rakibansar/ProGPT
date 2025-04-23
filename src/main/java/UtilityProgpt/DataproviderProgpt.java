package UtilityProgpt;
import org.testng.annotations.DataProvider;


public class DataproviderProgpt {
	
	@DataProvider(name= "Usernameandpassword")
	public Object[][] tdata() 
	{	
		return new Object[][] 
		{	
			{"Rakib@yopmail.com", "Rakib@*1#", "Dashboard | ProGPT"},           
			{"Rakib1@yopmail.com","Rakib1@123", "Sign In | ProGPT"},           
			{"Rakib12@yopmail.com","Rakib1@123", "Sign In | ProGPT"},           

			         /*yellow*/
			           /*Red*/
		};		
	}
}
