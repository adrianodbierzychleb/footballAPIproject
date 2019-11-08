package com.spartaglobal.footballAPIproject.ParsingJSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreatingArrayListOfPlayerDetails {

    private List<Map> playerDetails = new ArrayList<>();
    private MappingPlayerDetailsFromJSONString mappingPlayerDetailsFromJSONString = new MappingPlayerDetailsFromJSONString();

    public void populateArray()
    {
        String lowerBoundryOfPlayerID = "354";
        String upperBoundryOfPlayerID = "372";

        for (Integer i = Integer.parseInt(lowerBoundryOfPlayerID); i <= Integer.parseInt(upperBoundryOfPlayerID); i++)
        {
            playerDetails.add(mappingPlayerDetailsFromJSONString.mapDetails(i.toString()));
        }

    }


    public List<Map> getPlayerDetails()
    {
        return playerDetails;
    }

}
