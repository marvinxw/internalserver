package com.eppen.internalserver.to;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class HttpUnirest {

    private final String PROTOCOL = "HTTP://";
    private final String IP = "127.0.0.1";
    private final String PORT = "8899";
    private final String Route = "/external/get/";

    public JSONArray get(String timeStamp) {
        JSONArray data = null;

        try {
            assert timeStamp != null;
            HttpResponse<JsonNode> jsonResponse = Unirest.get(String.format("%s%s:%s%s%s", PROTOCOL, IP, PORT, Route, timeStamp))
//                    .queryString("timestamp", timeStamp)
                    .asJson();

            if (jsonResponse.getStatus() == 200) {
                JSONObject res = jsonResponse.getBody().getObject();
                if (res.get("code").toString().equals("1")) {
                    data = (JSONArray) res.get("data");
                }
            }

        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return data;
    }
}
