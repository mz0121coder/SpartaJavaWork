package com.sparta.mz.apitesting;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class PostRequest {
    public static void main(String[] args) {
        // HTTP client initialization
        HttpClient httpClient = HttpClient.newBuilder().build();

        // GET request to retrieve information about a specific postcode
        HttpRequest getRequest = HttpRequest
                .newBuilder()
                .uri(URI.create("https://api.postcodes.io/postcodes/ec2y5as"))
                .build();

        HttpResponse<String> getResponse = null;
        try {
            // Sending the GET request and capturing the response
            getResponse = httpClient.send(
                    getRequest,
                    HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        // Outputting the response from the GET request
        System.out.println("GET Request Response:");
        System.out.println(getResponse.body());
        System.out.println();
        System.out.println(getResponse.statusCode());

        // Extracting headers from the GET response
        Map<String, List<String>> getHeaders = getResponse.headers().map();
        for (var item : getHeaders.entrySet()) {
            System.out.print(item.getKey() + ": ");
            System.out.println(item.getValue());
        }

        System.out.println("\nInterrogating the response body using json parser for GET request:");
        // Parsing JSON response from the GET request
        JSONParser jsonParser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(getResponse.body());
            System.out.println(jsonObject.get("status"));

            JSONObject resultObject = (JSONObject) jsonObject.get("result");
            System.out.println("Primary Care Trust: " + resultObject.get("primary_care_trust"));

            JSONObject codes = (JSONObject) resultObject.get("codes");
            System.out.println("Codes are: " + codes.entrySet().toString());

        } catch (ParseException e) {
            e.printStackTrace();
        }

        // POST request to perform Bulk Reverse Geocoding postcodes
        HttpRequest postRequest = HttpRequest
                .newBuilder()
                .uri(URI.create("https://api.postcodes.io/postcodes"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("{\"postcodes\": [\"SW1A 1AA\", \"SW1A 1AB\"]}"))
                .build();

        HttpResponse<String> postResponse = null;
        try {
            // Sending the POST request and capturing the response
            postResponse = httpClient.send(
                    postRequest,
                    HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        // Outputting the response from the POST request
        System.out.println("\nPOST Request Response:");
        System.out.println(postResponse.body());
        System.out.println();
        System.out.println(postResponse.statusCode());

        // Extracting headers from the POST response
        Map<String, List<String>> postHeaders = postResponse.headers().map();
        for (var item : postHeaders.entrySet()) {
            System.out.print(item.getKey() + ": ");
            System.out.println(item.getValue());
        }

        System.out.println("\nInterrogating the response body using json parser for POST request:");
        // Parsing JSON response from the POST request
        try {
            JSONObject postJsonObject = (JSONObject) jsonParser.parse(postResponse.body());
            System.out.println(postJsonObject.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
