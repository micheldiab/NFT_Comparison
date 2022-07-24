package ahmad;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MagicEdenGetCollections {
	
	//Gets an array list of collections, and adds collection symbol and name to that collection
	public static ArrayList<Collections> magicEdenCollections(ArrayList<Collections> collections) throws IOException{
		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				MediaType mediaType = MediaType.parse("text/plain");
				Request request = new Request.Builder()
				  .url("https://api-mainnet.magiceden.dev/v2/collections?offset=0&limit=100")
				  .method("GET", null)
				  .build();
				JSONObject obj;
				Response response = client.newCall(request).execute();
				String stringResponse = response.body().string();
				System.out.println(stringResponse);
				JSONArray arr = new JSONArray(stringResponse);
				for(int i = 0; i<arr.length();i++) {
					obj = arr.getJSONObject(i);
					
					Collections c = new Collection1();
					try {
					c.setCollectionName(obj.getString("name"));
					c.setSymbol(obj.getString("symbol"));
					collections.add(c);
					}
						catch (Exception e) {
							// TODO: handle exception
							continue;
						}
					
					}
		
		return collections;
	} 
	
	
	//Add floor price to collections
	public static ArrayList<Collections> magicEdenFloorPrice(ArrayList<Collections> collections) throws IOException, InterruptedException{
		Request requestStats;
		Response response;
		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
		String stringResponse;
		JSONObject obj;
		Long floorPrice;
	
		for(Collections c: collections) {
		
			requestStats = new Request.Builder()
					  .url("https://api-mainnet.magiceden.dev/v2/collections/"+c.getSymbol()+"/stats")
					  .method("GET", null)
					  .build();
			response = client.newCall(requestStats).execute();
			stringResponse = response.body().string();
			System.out.println(stringResponse);
			if(stringResponse.charAt(0)!='{') continue; 
			obj = new JSONObject(stringResponse);
			try {
			floorPrice = (long) (obj.getLong("floorPrice"));

			//floorPrice=obj.getLong("floorPrice");
		
		//	System.out.println("XXXX FLOAT: "+floatFromLong+" XXXX");
			System.out.println("XXXX LONG: "+floorPrice+" XXXX");
			c.setMagicEdenFloorPrice(floorPrice);
			//System.out.println(c.getCollectionName());
		
			}
			catch(Exception e){
				continue;
			}
		}
	
		return collections;	
	}
	
	public static ArrayList<Collections> getCollections() throws Exception {	
		
		ArrayList<Collections> collections = new ArrayList<>();
		collections = magicEdenCollections(collections);
		collections = magicEdenFloorPrice(collections);
		
		
		System.out.println("Now with OpenSea");
		System.out.println("Now with OpenSea");
		System.out.println("Now with OpenSea");
		System.out.println("Now with OpenSea");
		collections = OpenSea.OpenSeaFloorPrice(collections);
		
		System.out.println("Now AFTER OpenSea");
		System.out.println("Now AFTER OpenSea");
		System.out.println("Now AFTER OpenSea");
		System.out.println("Now AFTER OpenSea");
		
//		for(Collection c: collections){
//			System.out.println(c.getCollectionName()+" "+  c.getSymbol() + " " + c.getMagicEdenFloorPrice());
//		}
		for(int j=0;j<collections.size();j++)
		{
			if(collections.get(j)==null)
				collections.set(j, new NullCollection());
			
			else if(collections.get(j).getValid()==null||collections.get(j).getValid()==false )
					collections.set(j, new NullCollection());
				
			}
			System.out.println("FINISH");


		
		return collections;
	}
		

}
