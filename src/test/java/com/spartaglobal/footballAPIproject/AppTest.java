package com.spartaglobal.footballAPIproject;

import static org.junit.Assert.assertTrue;

import com.fasterxml.jackson.databind.util.TypeKey;
import com.spartaglobal.footballAPIproject.HTTPServices.PlayerDetailsHTTPService;
import com.spartaglobal.footballAPIproject.ParsingJSON.CreatingArrayListOfPlayerDetails;
import com.spartaglobal.footballAPIproject.ParsingJSON.MappingPlayerDetailsFromJSONString;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
    //134793 ID Max value
    @BeforeClass
    public static void setup()
    {
        //playerDetailsHTTPService.executePlayerDetailsRequest("371");
        creatingArrayListOfPlayerDetails.populateArray();

    }

    @Test
    public void test(){
        List<Map> players = creatingArrayListOfPlayerDetails.getPlayerDetails();


        //System.out.println(result);
//        List<String> keys = new ArrayList<>(result.keySet());
//        for (int i = 0; i < keys.size() ; i++) {
//            System.out.println(keys.get(i) + " " + result.get(keys.get(i)));
//        }
//        for(Map.Entry<String, String> entry : result.entrySet())
//        {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }

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
