package helper;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TempAPI {

    RequestSpecification httpRequest;
    Response response;
    String url = "http://localhost:3000/";


    @Test
    public void testingAPI(){
        RestAssured.baseURI = url;
        httpRequest = RestAssured.given().auth().preemptive().basic("admin", "admin");

        //Get Request
//        response = httpRequest.get("/api/teams/search?name=raz");

        //Post + Put Request
        JSONObject params = new JSONObject();
        params.put("name","BTeam");
        params.put("email","BTeam@some.com");
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(params.toJSONString());
//        response = httpRequest.post("/api/teams");

//        response = httpRequest.put("/api/teams/3");

        response = httpRequest.delete("/api/teams/3");

        response.prettyPrint();
    }

}
