package org.microtrack.service;

import org.microtrack.dto.Trace;
import org.microtrack.gateway.CentralService;

public class TraceService {

    private final CentralService centralService;

    public TraceService() {
        this.centralService = new CentralService();
    }

    public void checkpoint(Manager manager, Trace trace) {
        if (!manager.isTracingEnabled()) return;

        centralService.sendTrace(trace);
    }

    public String getDataMessage() throws Exception {
//        sendTrace(serviceName, traceId, genericData);
//        return String.format("%s, %s, %s!", serviceName, traceId, genericData);
        return "";
    }

}
