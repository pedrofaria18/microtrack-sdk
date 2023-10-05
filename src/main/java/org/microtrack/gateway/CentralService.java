package org.microtrack.gateway;

import org.microtrack.dto.ResponseTrace;
import org.microtrack.dto.Trace;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class CentralService {

    public ResponseTrace sendTrace(Trace trace) throws IOException, InterruptedException {
        try {

            String uri = "https://3ae7-2804-7f2-2895-5089-d494-3136-99a-3a9.ngrok-free.app/traces";

            System.out.println(uri);

            HttpClient client = HttpClient.newBuilder().build();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(trace.getAllString(), StandardCharsets.UTF_8))
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
