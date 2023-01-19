package com.finantix.mock.hsbc.ann.UrlConstants;

public class AnnConstants {

    public static final String ERROR_TRUST_TOKEN_HEADER_FOUND = "No E2E Trust Token header found";
    public static final String ERROR_TRUST_TOKEN_INVALIDSTRUCTURE = "Invalid token structure";
    public static final String ERROR_TRUST_TOKEN_VALIDATION = "AuthZ Rule Validation Failed";
    public static final String ERROR_TRUST_TOKEN_EXPIRED = "X-HSBC-E2E-Trust-Token expired";

    public static final String ERROR_CHNL_COUNTRY_CODE = "Region info is required";

    public static final String ERROR_ALERTYPE = "The type you submitted is not SRDII_EVENT_CORPORATE_ACTION or NON_SRDII_EVENT_CORPORATE_ACTION, please check"; // 500
    public static final String ERROR_MEETING_NOTIFICATION_ALERTYPE = "The type you submitted is not SRDII_EVENT_MEETING_NOTICE or NON_SRDII_EVENT_MEETING_NOTICE, please check"; // 500
    public static final String ERROR_DUPLICATED_REQUESTID = "Please do not submit duplicate data,check requestId or itemList"; // 500
    public static final String ERROR_EMPTY_ITEM_LIST = "itemList itemList is not allowed to be empty"; // 400

    public static final String TOKEN_SAMPLE = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJzZXJ2aWNlX2FwaSJdLCJleHAiOjE2Mzc4NTYyMTMsImF1dGhvcml0aWVzIjpbIlJPTEVfU0VSVklDRSJdLCJqdGkiOiI1NmViNDMyNS0wMzlhLTQxN2QtODkyOC1mZTFhNDRiOTcxYTciLCJjbGllbnRfaWQiOiJwYmtyYy1zZXJ2aWNlIiwiY29udGFjdF9lbWFpbCI6InN0dWFydC55b3hhbGxAaHNiY2liLmNvbSJ9.bHDIf6SiCjNI5fZZqVFirvyFqPPHfduH0y02PuiT83mvqZpRYYUsI33bGKT-JI15zpP5PfDoySIh-q_F0NnqmFX5aYHzIuKM-v1gc7S1Lllht3Ty6XWk3hwM-4H5H0eZzEge2rXJ0qY29N9dch4wyCdXZ2Q-JDrpKr3My8NGGr_BdAPDAjya5aqcJkj72QgAmP_Phl6KNn-FhzAQnSAtuOQ95xAFQjeSyNcpEzZhQo3Tewz1Fj0RvLPAWPcu01hHzExxa8VPf1ohlMW5JaXwFOZVwHd57hjdlJLRziSRetdqeopYM6JsBor7kux-4_ueJow7VtlccyWahGEefDlLig";
    public static final String ERROR_NO_E2E_TRUST_TOKEN_HEADER_FOUND = "No E2E Trust Token header found";

    public static final String ERROR_WHITHOUT_HEADER_CHNL_CONTRY_CODE = "Region info is required";
    public static final String ERROR_INVALID_TOKEN_STRUCTURE = "Invalid token structure";
    public static final String ERROR_BUSINESSID_REQUIRED = "businessId businessId is required";
    public static final String ERROR_REQUESTID_REQUIRED = "requestId requestId is required";

    // JWT

    public static final String ERROR_IN_CREDENTIALS_VALIDATION = "Error in credentials validation";
    public static final String UNAUTHORIZED = "Unauthorized";
    public static final String ERROR_INPUT_STRUCTURE = "Invalid Structure";
    public static final String BAD_REQUEST = "Bad request";
}
