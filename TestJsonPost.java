package org.vishal.tester;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class TestJsonPost {
	
	public static void main(String args[]){
		
        try {
            JSONObject json =  readJsonFromUrl("http://localhost:7777/JAXRSJsonExample1/rest/countries");
         
            JSONArray array=(JSONArray) json.get("array");
            System.out.println("size "+array.length());
            for(int i=0;i<array.length();i++)
            {
            	JSONObject object=(JSONObject) array.get(i);
            	System.out.println(object.get("id")+" "+object.get("countryName")+" "+object.get("population"));
            }
        	} catch (IOException | JSONException e) {
            
            e.printStackTrace();
        }
		}
	
	private static String readAll(Reader rd)throws IOException{
		StringBuilder sb=new StringBuilder();
		int cp;
		while((cp=rd.read())!= -1){
			sb.append((char)cp);
		}
		String newString="{"+"array:"+sb.toString()+"}";
		return newString;
	}
	
	public static JSONObject readJsonFromUrl(String url)throws IOException, JSONException{
		
		URL url1 = new URL(url);
		HttpURLConnection con= (HttpURLConnection)url1.openConnection();
		con.setRequestMethod("GET");
		con.connect();
		int responsecode= con.getResponseCode();
		
		if(responsecode !=200)
			throw new RuntimeException("HttResponseCodeException "+responsecode );
		else{ InputStream is= con.getInputStream();
		try {
			BufferedReader rd= new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsontext= readAll(rd);
			
			JSONObject jsonobj=new JSONObject(jsontext);
			
			return jsonobj;
		} finally{
			is.close();
		}
	}}
}
