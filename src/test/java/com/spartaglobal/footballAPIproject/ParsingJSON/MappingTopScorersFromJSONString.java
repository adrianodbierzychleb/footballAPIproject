package com.spartaglobal.footballAPIproject.ParsingJSON;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spartaglobal.footballAPIproject.HTTPServices.TopScorersHTTPService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MappingTopScorersFromJSONString {

    private TopScorersHTTPService topScorersHTTPService = new TopScorersHTTPService();

    public Map<String,Object> mapDetails(String competition){
        Map<String, Object> topScorers = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        topScorersHTTPService.executeTopScorersResponse(competition);
        String topScorersJSON = topScorersHTTPService.getTopScorersJSONString();
        try{
            topScorers = objectMapper.readValue(topScorersJSON, Map.class);
        }catch (IOException e){
            e.printStackTrace();
        }

        return topScorers;
    }
}
