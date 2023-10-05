package org.microtrack.service;

import org.microtrack.dto.ResponseTrace;
import org.microtrack.dto.Trace;
import org.microtrack.gateway.CentralService;

import java.io.IOException;
import java.sql.Timestamp;

public class TraceService {

    private final CentralService centralService;

    public TraceService() {
        this.centralService = new CentralService();
    }

    public ResponseTrace checkpoint(Manager manager, Trace trace) throws IOException, InterruptedException {
        if (!manager.isTracingEnabled()) {
            return ResponseTrace.builder()
                    .message("Tracing disabled!")
                    .build();
        }

        trace.setTimestamp(new Timestamp(System.currentTimeMillis()));

        return centralService.sendTrace(trace);
    }

}
