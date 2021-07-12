/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Udyan Sharma
 */

package Ensorcell;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONObject;
import org.json.JSONArray;


public class APICon{
	public static HttpURLConnection connection;
	public static void main( String[] args){
	    BufferedReader reader;
	    String line;
	    StringBuffer responseContent = new StringBuffer();
		
		try{
	    	URL url=new URL("https://www.regcheck.org.uk/api/reg.asmx/CheckIndia?username=udyan2&&RegistrationNumber=GJ03ER0563");
	    	connection=(HttpURLConnection) url.openConnection();
	    	connection.setRequestMethod("GET");
		    	connection.setConnectTimeout(5000);
		    	connection.setReadTimeout(5000);
		    	
		    	int status = connection.getResponseCode();
		    	System.out.println(status);
		    	
		    	if (status>299) {
		    		reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
		    		while ((line=reader.readLine())!=null){
		    			responseContent.append(line);
		    		}
		    	reader.close();
		    	} else {
		    		reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		    		while ((line=reader.readLine())!=null){
		    			responseContent.append(line);
		    		}
		    	}
		    	reader.close();
		    	
		    	System.out.println(responseContent);
		    	
		    } catch (MalformedURLException e){
		    	e.printStackTrace();
		    } catch (IOException e){
		    	e.printStackTrace();
		    } finally{
		    	connection.disconnect();
		    }
	}

}

