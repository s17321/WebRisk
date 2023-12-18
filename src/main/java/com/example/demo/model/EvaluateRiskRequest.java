package com.example.demo.model;

import java.util.List;

public class EvaluateRiskRequest {
    private String uri;
    private List<com.google.webrisk.v1.ThreatType> threatTypes;
    private boolean allowScan;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<com.google.webrisk.v1.ThreatType> getThreatTypes() {
        return threatTypes;
    }

    public void setThreatTypes(List<com.google.webrisk.v1.ThreatType> threatTypes) {
        this.threatTypes = threatTypes;
    }

    public boolean isAllowScan() {
        return allowScan;
    }

    public void setAllowScan(boolean allowScan) {
        this.allowScan = allowScan;
    }
}

enum ThreatType {
    THREAT_TYPE_UNSPECIFIED,
    SOCIAL_ENGINEERING,
    MALWARE,
    UNWANTED_SOFTWARE
}