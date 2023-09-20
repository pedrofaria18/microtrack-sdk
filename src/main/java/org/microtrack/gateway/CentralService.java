package org.microtrack.gateway;

import org.microtrack.dto.Trace;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CentralService {

    public void sendTrace(Trace trace) {
        try {

            String uri = "http://localhost:3001/traces";

            HttpClient client = HttpClient.newBuilder().build();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(trace.getAllString()))
                    .build();

            HttpResponse<?> response = client.send(request, HttpResponse.BodyHandlers.discarding());
            System.out.println(response.statusCode());

        } catch (Exception exception) {
            System.out.print("Erro ao enviar trace para o serviço central!");
        }

    }

}
