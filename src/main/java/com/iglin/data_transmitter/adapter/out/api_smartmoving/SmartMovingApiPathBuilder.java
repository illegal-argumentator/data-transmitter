package com.iglin.data_transmitter.adapter.out.api_smartmoving;

public final class SmartMovingApiPathBuilder {

    private static final String BASE_URL = "https://api.smartmoving.com/api";

    public static String buildLeads(String providerKey) {
        return BASE_URL + "/leads/from-provider/v2?providerKey=" + providerKey;
    }

}
