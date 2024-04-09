package com.sparta.mz.apitesting;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BulkLab {
    public static void main(String[] args) {
        // Request body for bulk geocode lookup
        String requestBodyBulkGeocode = """
                {
                  "geolocations" : [{
                    "longitude":  0.629834723775309,
                    "latitude": 51.7923246977375
                  }, {
                    "longitude": -2.49690382054704,
                    "latitude": 53.5351312861402,
                    "radius": 1000,
                    "limit": 1000000
                  }]
                }""";

        // API endpoint
        String endpoint = "https://api.postcodes.io/postcodes";

        // Create an instance of HttpClient
        HttpClient httpClient = HttpClient.newBuilder().build();

        // Build the request with the URI, headers, and request body
        HttpRequest request = HttpRequest.newBuilder()
                .uri(createUri(endpoint)) // Create URI object
                .header("Content-Type", "application/json") // Set content type header
                .POST(HttpRequest.BodyPublishers.ofString(requestBodyBulkGeocode)) // Set request body
                .build();

        try {
            // Send the request and capture the response
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Output status code of the response
            System.out.println("Status code: " + response.statusCode());

            // Output the response body in a pretty-printed JSON format
            System.out.println("Response body:");
            prettyPrintJson(response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Helper method to create URI object
    private static URI createUri(String endpoint) {
        try {
            return new URI(endpoint);
        } catch (URISyntaxException e) {
            throw new RuntimeException("Invalid URI: " + endpoint, e);
        }
    }

    // Helper method to pretty print JSON string
    private static void prettyPrintJson(String json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = gson.toJson(gson.fromJson(json, Object.class));
        System.out.println(prettyJson);
    }
}
