package com.spartaglobal.footballAPIproject.HTTPServices;

import com.spartaglobal.footballAPIproject.config.APIKey;
import com.spartaglobal.footballAPIproject.config.FootballURLConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class TopScorersHTTPService {


    private CloseableHttpResponse topScorersResponse;
    private String topScorersJSONString;


    public void executeTopScorersResponse(String competition)
    {
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        String topScorersURL = FootballURLConfig.BASE_URL + FootballURLConfig.COMPETITION + competition + FootballURLConfig.DATA_FROM_COMPETITION;

        HttpGet httpGet = new HttpGet(topScorersURL);

        httpGet.addHeader(APIKey.API_TOKEN, APIKey.API_KEY);

        try{
            topScorersResponse = closeableHttpClient.execute(httpGet);
            topScorersJSONString = EntityUtils.toString(topScorersResponse.getEntity());
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public String getTopScorersJSONString(){
        return topScorersJSONString;
    }

}
