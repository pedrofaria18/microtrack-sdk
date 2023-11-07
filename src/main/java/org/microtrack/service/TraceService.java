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

    public ResponseTrace checkpoint(Manager manager, Trace trace) throws IOException, InterruptedException, IllegalAccessException {
        if (!manager.isTracingEnabled()) {
            ResponseTrace responseTrace = new ResponseTrace();
            responseTrace.setMessage("Tracing disabled!");
            return responseTrace;
        }

        trace.setTimestamp(new Timestamp(System.currentTimeMillis()));

        return centralService.sendTrace(trace);
    }

}
