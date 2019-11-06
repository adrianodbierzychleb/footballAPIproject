package com.spartaglobal.footballAPIproject.HTTPServices;

import com.spartaglobal.footballAPIproject.config.APIKey;
import com.spartaglobal.footballAPIproject.config.FootballURLConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.channels.ClosedSelectorException;

public class PlayerDetailsHTTPService {

    private CloseableHttpResponse detailsResponse;
    private String playerDetailsJSONString;

    public void executePlayerDetailsRequest(String playerID)
    {
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();

        String playerDetailsURL = FootballURLConfig.BASE_URL + FootballURLConfig.TABLE_TYPE + playerID;

        HttpGet httpGet = new HttpGet(playerDetailsURL);
        httpGet.addHeader(APIKey.API_TOKEN, APIKey.API_KEY);

        try{
            detailsResponse = closeableHttpClient.execute(httpGet);
            playerDetailsJSONString = EntityUtils.toString(detailsResponse.getEntity());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public String getPlayerDetailsJSONString()
    {
        return playerDetailsJSONString;
    }



}
