package com.spartaglobal.footballAPIproject.ParsingJSON;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spartaglobal.footballAPIproject.HTTPServices.PlayerDetailsHTTPService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MappingPlayerDetailsFromJSONString {

    private PlayerDetailsHTTPService playerDetailsHTTPService = new PlayerDetailsHTTPService();

    public Map<String, String> mapDetails(String playerID){
        Map<String, String> playerDetails = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        playerDetailsHTTPService.executePlayerDetailsRequest(playerID);
        String playerDetailsJSON = playerDetailsHTTPService.getPlayerDetailsJSONString();
        try {
            playerDetails = objectMapper.readValue(playerDetailsJSON, Map.class);
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        return playerDetails;
    }

}
