package org.microtrack.utils;

import org.microtrack.dto.Trace;

import java.security.Timestamp;

public class Mapper {

    public Trace toTrace(String traceId, String serviceName, Timestamp timestamp, Boolean isError, Object genericData) {
        return Trace.builder()
                .traceId(traceId)
                .build();
    }

}
