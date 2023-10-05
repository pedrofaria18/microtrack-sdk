package org.microtrack.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

@Setter
@Builder
@AllArgsConstructor
public class Trace implements Serializable {

    private @NonNull String traceId;
    private @NonNull String serviceName;
    private Timestamp timestamp;
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
