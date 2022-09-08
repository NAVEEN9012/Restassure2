import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class restapi {

    @Test(priority = 1)
    void test() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".\\jsonfiles\\employe.json");
        Object obj = jsonParser.parse(reader);
        JSONObject empjsonobj= (JSONObject)obj;
        String fname=(String) empjsonobj.get("firstName");
        String lname=(String) empjsonobj.get("lastName");
        System.out.println("First name:"+fname);
        System.out.println("last name:"+lname);
       JSONArray array = (JSONArray)empjsonobj.get("address");
       for (int i=0;i< array.size();i++)
       {
         JSONObject address= (JSONObject)array.get(i);
            String street = (String)address.get("street");
           String city = (String)address.get("city");
           String state = (String)address.get("state");
           System.out.println("Street name:"+street);
           System.out.println("city name:"+city);
           System.out.println("state name:"+state);

       }


    }

}

