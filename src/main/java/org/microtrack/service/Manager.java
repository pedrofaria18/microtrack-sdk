package org.microtrack.service;

public class Manager {

    private boolean isTracingEnabled;

    public Manager(boolean isTracingEnabled) {
        this.isTracingEnabled = isTracingEnabled;
    }

    public void setTracingEnabled(boolean tracingEnabled) {
        isTracingEnabled = tracingEnabled;
    }

    public boolean isTracingEnabled() {
        return isTracingEnabled;
    }
}
