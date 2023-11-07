package org.microtrack.dto;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Trace implements Serializable {

    private String traceId;
    private String serviceName;
    private Timestamp timestamp;
    private String checkpointName;
    private Boolean isError;
    private Object genericData;
    private List<String> successorBy;

    public Trace() {}

    public Map<String, Object> convertToMap() throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        Field[] fields = this.getClass().getDeclaredFields();

        for (Field field: fields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(this));
        }

        return map;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getCheckpointName() {
        return checkpointName;
    }

    public void setCheckpointName(String checkpointName) {
        this.checkpointName = checkpointName;
    }

    public Boolean getError() {
        return isError;
    }

    public void setError(Boolean error) {
        isError = error;
    }

    public Object getGenericData() {
        return genericData;
    }

    public void setGenericData(Object genericData) {
        this.genericData = genericData;
    }

    public List<String> getSuccessorBy() {
        return successorBy;
    }

    public void setSuccessorBy(ArrayList<String> successorBy) {
        this.successorBy = successorBy;
    }

}
