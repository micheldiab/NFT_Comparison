package ahmad;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OpenSea {
public static ArrayList<Collections> OpenSeaFloorPrice(ArrayList<Collections> collections) throws IOException, InterruptedException{
	
	
	OkHttpClient client = new OkHttpClient();
	Request request;
	String stringResponse;
	JSONObject responseJSON;
	JSONObject ss;


	//System.out.println("WE ARE HERE!!!!!!!!!!!!");
	String[] nameWithTop = new String[100];
	String[] nameWithBottom = new String[100];
	String[] nameWithSolana = new String[100];
	String name;
	int i = 0;
	for(Collections c: collections) {
		name = c.getCollectionName().toLowerCase();
		nameWithTop[i] = name.replaceAll(" ", "-");
		nameWithBottom[i] = name.replaceAll(" ", "_");
		nameWithSolana[i] = nameWithTop[i] + "-solana";
		c.setValid(false);
		//System.out.println(c.getCollectionName() +"  " + nameWithTop[i]+ " "+ nameWithBottom[i]+ " " + nameWithSolana[i]);
		i++;
	}
	
	i=0;
	int k =0;
	for(Collections c: collections) {
		//if(c.getValid()) continue;
		//System.out.println("Sleeping for 300ms");
		Thread.sleep(1500);
	request = new Request.Builder()
	  .url("https://api.opensea.io/api/v1/collection/"+ nameWithTop[i] +"/stats")
	  .get()
	  .addHeader("Accept", "application/json")
	  .build();
	System.out.println(nameWithTop[i]);
	i++;
	try {
	Response response = client.newCall(request).execute();
	//if(response.code() == 200)System.out.println("RESPONSE CODE IS 200");
	stringResponse = response.body().string();
	System.out.println(stringResponse);
	responseJSON = new JSONObject(stringResponse);
	ss = (JSONObject)responseJSON.get("stats");
	
	c.setOpenSeaFloorPrice(ss.getFloat("floor_price"));
	c.setValid(true);
	k++;
	}
	catch(Exception e) {
		continue;
		}
	}//for with top

	
	
	return collections;
  }

}

