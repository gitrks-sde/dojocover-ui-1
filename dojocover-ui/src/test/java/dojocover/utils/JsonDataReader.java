package dojocover.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.io.File;

import dojocover.models.SignInUser;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

public class JsonDataReader {
	
	
private static final ObjectMapper mapper=new ObjectMapper();
	
	private JsonDataReader() {}
	
	public static Object[][] getJsonData(String classpathPath)
	{
		try(InputStream in=JsonDataReader.class.getClassLoader().getResourceAsStream(classpathPath))
		{
			if(in==null)
			{
				throw new IllegalStateException("Test data not found at "+classpathPath);
			}
			List<SignInUser> users= mapper.readValue(in, new TypeReference<List<SignInUser>>() {});
			
			Object[][] data=new Object[users.size()][1];
			for(int i=0;i<users.size();i++)
			{
				data[i][0]=users.get(i);
			}
			
			return data;
		}catch(IOException e)
		{
			throw new IllegalStateException(e);
		}
		
		}
	
	public static SignInUser getUserByName(String jsonFilePath,String targetUser)
	{
		ObjectMapper objectMapper=new ObjectMapper();
		try {
			List<SignInUser> users=objectMapper.readValue(new File(jsonFilePath), new TypeReference<List<SignInUser>>() {});
			for(SignInUser user: users)
			{
				if(user.getName().equalsIgnoreCase(targetUser))
				{
					return user;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		throw new RuntimeException("Name "+targetUser+" not found in file");
	}
	
	
			
		
		
	
	 
}
