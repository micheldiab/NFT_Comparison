package ahmad;

import java.io.IOException;

import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class getPrice {
	
	
	public static double getMagicEdenFloorPrice(String symbol) throws IOException {
		
		//magic eden get collection stats
		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				MediaType mediaType = MediaType.parse("text/plain");
				//"+symbol+"
				//cool_kidz_society
				Request request = new Request.Builder()
				  .url("https://api-mainnet.magiceden.dev/v2/collections/"+symbol+"/stats")
				  .method("GET", null)
				  .build();
				Response response = client.newCall(request).execute();
				String stringResponse = response.body().string();
				JSONObject obj = new JSONObject(stringResponse);
				//System.out.println(stringResponse);
				double doubleFloorPrice=0.0;
				try {
				long floorPrice = obj.getLong("floorPrice");
				System.out.println("zzzz:"+floorPrice);
				doubleFloorPrice = (double)floorPrice;
				
				}
				catch (Exception e) {
					// TODO: handle exception

				}
			
				
				return doubleFloorPrice;
		
	}
	public static double getOpeanSeaFloorPrice(String slug) throws IOException {
		
		OkHttpClient client = new OkHttpClient();
		//cool-kidz-society
		//"+slug+"
		Request request = new Request.Builder()
		  .url("https://api.opensea.io/api/v1/collection/"+slug+"/stats")
		  .get()
		  .addHeader("Accept", "application/json")
		  .build();

		Response response = client.newCall(request).execute();
		
		String stringResponse = response.body().string();
		JSONObject responseJSON = new JSONObject(stringResponse);
		double doubleFloorPrice = 0.0;
		try {
			JSONObject ss = (JSONObject)responseJSON.get("stats");
			float floorPrice = ss.getFloat("floor_price");
			System.out.println("zzzz:"+floorPrice);
		    doubleFloorPrice = floorPrice;
			
			}
			catch (Exception e) {
				// TODO: handle exception
				System.out.println("catch excepition");

			}
				
		return (double) (doubleFloorPrice * 44.66);
			
		
	}

}
