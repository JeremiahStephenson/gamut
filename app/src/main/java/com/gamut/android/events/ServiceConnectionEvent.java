package com.gamut.android.events;

/**
 * Created by jeremiahstephenson on 1/30/14.
 */
public class ServiceConnectionEvent {

    public enum ServiceConnectionType {
        CONNECTED,
        DISCONNECTED
    }

    private ServiceConnectionType serviceConnectionType;

    public ServiceConnectionEvent(ServiceConnectionType type) {
        serviceConnectionType = type;
    }

    public ServiceConnectionType getServiceConnectionType() {
        return serviceConnectionType;
    }

}