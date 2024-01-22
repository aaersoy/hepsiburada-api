package tests;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Helper;

import java.io.IOException;

public class TestTemp {

    public Helper helper = new Helper();


    @Test
    public void temp2() throws ParseException {
        Response response = helper.get("json");
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(response.asString());
        JSONArray jsonArray = (JSONArray) ((JSONObject) ((JSONArray) ((JSONObject)jsonObject.get("slideshow")).get("slides")).get(1)).get("items");

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK, "Response status code is not shown as 200!");
        Assert.assertTrue(jsonArray != null, "Items are not existed!");
        Assert.assertFalse(jsonArray.isEmpty(), "Item count is not greater than 0!");
    }
}
