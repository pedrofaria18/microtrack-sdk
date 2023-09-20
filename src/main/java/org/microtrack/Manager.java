package org.microtrack;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class Manager {
    private final String serviceName;
    private String traceId;
    private Object genericData;

    public Manager(String serviceName, String traceId, Object genericData) {
        this.serviceName = serviceName;
        this.traceId = traceId;
        this.genericData = genericData;
    }

    public void sendTrace(String serviceName, String traceId, Object genericData) throws Exception {
        String uri = "http://localhost:3000/trace";

        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(String.format("{\"serviceName\": \"%s\", \"traceId\": \"%s\", \"genericData\": \"%s\"}", serviceName, traceId, genericData)))
                .build();

        HttpResponse<?> response = client.send(request, HttpResponse.BodyHandlers.discarding());
        System.out.println(response.statusCode());
    }

    public String getDataMessage() throws Exception {
        sendTrace(serviceName, traceId, genericData);
        return String.format("%s, %s, %s!", serviceName, traceId, genericData);
    }
}
