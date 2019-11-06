package com.spartaglobal.footballAPIproject;

import static org.junit.Assert.assertTrue;

import com.fasterxml.jackson.databind.util.TypeKey;
import com.spartaglobal.footballAPIproject.HTTPServices.PlayerDetailsHTTPService;
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
    //134793 ID Max value
    @BeforeClass
    public static void setup()
    {
        //playerDetailsHTTPService.executePlayerDetailsRequest("371");
    }

    @Test
    public void test(){
        Map<String, String> result = mappingPlayerDetailsFromJSONString.mapDetails("371");
        //System.out.println(result);
//        List<String> keys = new ArrayList<>(result.keySet());
//        for (int i = 0; i < keys.size() ; i++) {
//            System.out.println(keys.get(i) + " " + result.get(keys.get(i)));
//        }
//        for(Map.Entry<String, String> entry : result.entrySet())
//        {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }

        Iterator it = result.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " " + pair.getValue());
            it.remove();
        }

    }
}
