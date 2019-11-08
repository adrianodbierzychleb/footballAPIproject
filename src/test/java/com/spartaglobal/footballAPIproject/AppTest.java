package com.spartaglobal.footballAPIproject;

import static org.junit.Assert.assertTrue;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.TypeKey;
import com.spartaglobal.footballAPIproject.HTTPServices.PlayerDetailsHTTPService;
import com.spartaglobal.footballAPIproject.HTTPServices.TopScorersHTTPService;
import com.spartaglobal.footballAPIproject.ParsingJSON.CreatingArrayListOfPlayerDetails;
import com.spartaglobal.footballAPIproject.ParsingJSON.MappingPlayerDetailsFromJSONString;
import com.spartaglobal.footballAPIproject.ParsingJSON.MappingTopScorersFromJSONString;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    private static MappingPlayerDetailsFromJSONString mappingPlayerDetailsFromJSONString = new MappingPlayerDetailsFromJSONString();
    private static CreatingArrayListOfPlayerDetails creatingArrayListOfPlayerDetails = new CreatingArrayListOfPlayerDetails();
    private static TopScorersHTTPService topScorersHTTPService = new TopScorersHTTPService();
    private static MappingTopScorersFromJSONString topScorersFromJSONString = new MappingTopScorersFromJSONString();
    //134793 ID Max value
    @BeforeClass
    public static void setup()
    {
        //playerDetailsHTTPService.executePlayerDetailsRequest("371");
        //creatingArrayListOfPlayerDetails.populateArray();
        topScorersHTTPService.executeTopScorersResponse("SA");
    }

    @Test
    public void test2() {
        Map<String, Object> topScorers = topScorersFromJSONString.mapDetails("SA");
//        Iterator it = topScorers.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry pair = (Map.Entry) it.next();
//            System.out.println(pair.getKey() + " " + pair.getValue());
//            it.remove();
//        }
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            JsonNode root = objectMapper.readTree(topScorersHTTPService.getTopScorersJSONString());

            long count = root.path("count").asLong();
            System.out.println("Number of scorers listed is " + count);

            JsonNode competiton = root.path("competition");
            if(!competiton.isMissingNode())
            {
                JsonNode country = competiton.path("area");
                System.out.print("Name of competition " + competiton.path("name") + " ");
                System.out.println("Located in " + country.path("name"));
            }

            JsonNode season = root.path("season");
            if(!season.isMissingNode())
            {
                System.out.println("Start date of the season is: " + season.path("startDate"));
                System.out.println("End date of the season is: " + season.path("endDate"));
                System.out.println("Current matchday: " + season.path("currentMatchday"));
            }

            JsonNode scorers = root.path("scorers");
            if(scorers.isArray()){
                for(JsonNode node: scorers){
                    JsonNode team = node.path("team");
                    JsonNode player = node.path("player");
                    JsonNode nationality = node.path("player");
                    System.out.print("PLayer name: " + player.path("name") + " ");
                    System.out.print("Nationality: " + nationality.path("nationality") + " ");
                    System.out.print("Team: " + team.path("name") + " ");
                    System.out.println("Number of goals: " + node.path("numberOfGoals"));
                }
            }


        }catch(Exception e){
            e.printStackTrace();
        }

    }

//        ObjectMapper objectMapper = new ObjectMapper();
//        Object season = topScorers.get("scorers");
//        Map<String, Object> myarr = new HashMap<>();
//        try {
//            myarr = objectMapper.readValue(season, Map.class);
//        }catch(IOException e)
//        {
//            e.printStackTrace();
//        }
//        System.out.println(season);
//        Iterator it = myarr.entrySet().iterator();
//            while (it.hasNext()) {
//                Map.Entry pair = (Map.Entry) it.next();
//                System.out.println(pair.getKey() + " " + pair.getValue());
//                it.remove();
//            }



    @Test
    public void test(){
        List<Map> players = creatingArrayListOfPlayerDetails.getPlayerDetails();


        for (int i = 0; i < players.size(); i++) {
            //Map<String, String> result = players.get(i);

            Iterator it = players.get(i).entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                System.out.println(pair.getKey() + " " + pair.getValue());
                it.remove();
            }
            System.out.println("");
        }
    }
}
