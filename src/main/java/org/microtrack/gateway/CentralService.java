package org.microtrack.gateway;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.microtrack.dto.ResponseTrace;
import org.microtrack.dto.Trace;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class CentralService {

    public ResponseTrace sendTrace(Trace trace) throws IOException, InterruptedException, IllegalAccessException {
        try {

            String uri = "https://3474-2804-7f2-2896-2169-be99-3aa8-2c6f-ae91.ngrok-free.app/traces";


            var objectMapper = new ObjectMapper();
            String requestBody = objectMapper.writeValueAsString(trace.convertToMap());

            System.out.println("TRACE: " + requestBody);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody, StandardCharsets.UTF_8))
                    .build();

            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );

            ResponseTrace responseTrace = new ResponseTrace();
            responseTrace.setStatusCode(response.statusCode());
            responseTrace.setMessage(response.body());

            return responseTrace;

        } catch (Exception exception) {
            System.out.print("Erro ao enviar trace para o serviço central!");
            throw exception;
        }

    }

}
