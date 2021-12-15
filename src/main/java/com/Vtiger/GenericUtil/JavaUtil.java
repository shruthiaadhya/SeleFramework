package com.Vtiger.GenericUtil;

import java.util.Random;

import com.github.javafaker.Faker;

public class JavaUtil {
	
	/**
	 * @author Admin
	 * Description: Singleton concept
	 */
	private JavaUtil()
	{
		
	}
	
	/**
	 * @author Admin
	 * Description: Creating JavaUtil object
	 * 
	 * @return
	 */
	public static JavaUtil objJavaUtil()
	{
		JavaUtil jv=new JavaUtil();
		return jv;
	}
	
	/**
	 * @author Admin
	 * Description: Generates Random Number
	 * 
	 * @return
	 */
	public int generateRandomNumber()
	{
		Random r=new Random();
		return r.nextInt(1000);
	}
	
	/**
	 * @author Admin
	 * Description: Generates Random Fullname
	 * 
	 * @return
	 */
	public String generateRandomName()
	{
		Faker faker=new Faker();
		return faker.name().fullName();
	}
	
	/**
	 * @author Admin
	 * Description: Generates Random FirstName
	 * 
	 * @return
	 */
	public String generateFirstName()
	{
		Faker faker=new Faker();
		return faker.name().firstName();
	}
	
	/**
	 * @author Admin
	 * Description: Generates Random LastName
	 * 
	 * @return
	 */
	public String generateLastName()
	{
		Faker faker=new Faker();
		return faker.name().lastName();
	}
	
	/**
	 * @author Admin
	 * Description:generating random phone number
	 * 
	 * @return
	 */
	public String generatePhoneNo()
	{
		Faker faker=new Faker();
		return faker.phoneNumber().cellPhone();
	}

}
