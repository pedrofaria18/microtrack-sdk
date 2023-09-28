package org.microtrack.gateway;

import org.microtrack.dto.ResponseTrace;
import org.microtrack.dto.Trace;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CentralService {

    public ResponseTrace sendTrace(Trace trace) throws IOException, InterruptedException {
        try {

            String uri = "https://a41e-2804-7f2-2895-5089-cdce-1861-8b4b-ffa.ngrok-free.app/traces";

            System.out.println(uri);

            HttpClient client = HttpClient.newBuilder().build();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(trace.getAllString()))
                    .build();

            HttpResponse<?> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return ResponseTrace.builder()
                    .statusCode(response.statusCode())
                    .message(response.body().toString())
                    .build();

        } catch (Exception exception) {
            System.out.print("Erro ao enviar trace para o serviço central!");
            throw exception;
        }

    }

}
