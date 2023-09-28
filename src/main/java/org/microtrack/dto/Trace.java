package org.microtrack.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;

import java.sql.Timestamp;

@Builder
@AllArgsConstructor
public class Trace {

    private @NonNull String traceId;
    private @NonNull String serviceName;
    private @NonNull Timestamp timestamp;
    private String checkpointName;
    private Boolean isError;
    private Object genericData;

    public String getAllString() {
        return String.format(
                "{\"serviceName\": \"%s\", \"traceId\": \"%s\", " +
                    "\"timestamp\": \"%s\", \"checkpointName\": \"%s\", \"isError\": \"%s\", " +
                        "\"genericData\": \"%s\"}",
                serviceName, traceId, timestamp, checkpointName, isError, genericData
        );
    }

}
