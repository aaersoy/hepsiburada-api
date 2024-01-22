package utils;

import clients.RestAssuredClient;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Helper extends RestAssuredClient {

    public Helper(){
        super(PropertyManager.getInstance().getBaseUrl());
    }

    public JSONObject generateJsonObject(String expectedJson) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(new FileReader("src/__files/"+ expectedJson + ".json"));
    }

    public Response get(){
        return get("");
    }

    public Response post(Object object) {
        return post("", object);
    }
}
