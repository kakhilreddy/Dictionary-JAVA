/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;


public class JsonParser {
    HttpURLConnection c;
    
   
    String getMeaning(String word)
    { String url="http://api.pearson.com/v2/dictionaries/ldoce5/entries?headword="+word+"&limit=1";
   StringBuilder sb = new StringBuilder();
   String meaning=null;
        try {
                  URL u = new URL(url);
            c = (HttpURLConnection) u.openConnection();
              c.setRequestMethod("GET");
        c.setRequestProperty("Content-length", "0");
        c.setUseCaches(false);
        c.setAllowUserInteraction(false);
         c.connect();
         BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
               
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line+"\n");
                }
                br.close();
                JSONObject root=new JSONObject(sb.toString());
                JSONArray results=root.getJSONArray("results");
                if(results.length()==0)
                    return "No meaning found";
                JSONObject s=results.getJSONObject(0);
                JSONArray senses=s.getJSONArray("senses");
                JSONObject def=senses.getJSONObject(0);
                JSONArray def1=def.getJSONArray("definition");
                meaning=def1.getString(0);
                
        } catch (IOException ex) {
            Logger.getLogger(JsonParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return meaning;
      
       
       
        
    }
    
}
