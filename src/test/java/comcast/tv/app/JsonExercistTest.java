package comcast.tv.app;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonExercistTest {


	List<String> memeList;
	JSONParser parser;
	public static void main(String[] args)
	{
		JsonExercistTest json = new JsonExercistTest();
		json.createList();
	}
	
	
	public  List<String> createList() {
		 parser = new JSONParser();

		try
		{    //Reading Json file  
			Object obj = parser.parse(new FileReader("meme.json"));

			JSONObject jsonObject =  (JSONObject) obj;
			JSONObject entryArray = (JSONObject) jsonObject.get("entries");
			JSONArray items = (JSONArray) entryArray.get("items");
			memeList=new ArrayList<String>();
			for(int i=0;i<items.size();i++)
			{
				memeList.add(items.get(i).toString());

			}
			//Sorting the Meme List Alphabetically
			Collections.sort(memeList);
             System.out.println("Sorting the values");
			for(int i=0;i<memeList.size();i++)
			{
				System.out.println(memeList.get(i));
			}
            
	     //Creating a new Json Object with the new object field-score and returning it
			   JSONObject obj1 = new JSONObject();
                
			   for(int i=0;i<memeList.size();i++)
			   {
			     obj1.put(memeList.get(i),"score:"+i);
			   // System.out.println(memeList.get(i));
			   }
			   System.out.println("\nJSON Object: " + obj1);

		} catch (ParseException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 

		return memeList;
	}


}




