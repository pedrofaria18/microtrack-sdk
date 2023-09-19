package org.microtrack;

public class Manager {
    private final String serviceName;
    private String traceId;
    private Object genericData;

    public Manager(String serviceName, String traceId, Object genericData) {
        this.serviceName = serviceName;
        this.traceId = traceId;
        this.genericData = genericData;
    }

    public String getDataMessage() {
        return String.format("%s, %s, %s!", serviceName, traceId, genericData);
    }
}
