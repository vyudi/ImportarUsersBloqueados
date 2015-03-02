package be.life.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class RestCall {
	 public static String callApi(String id) throws Exception {
	        URL yahoo = new URL("http://graph.facebook.com/"+id+"/picture?type=large");
	        URLConnection yc = yahoo.openConnection();
	        BufferedReader in = new BufferedReader(
	                                new InputStreamReader(
	                                yc.getInputStream()));
	        String inputLine;

	        while ((inputLine = in.readLine()) != null) 
	            System.out.println(inputLine);
	        in.close();
	        
	        return id;
	    }
	 
}
