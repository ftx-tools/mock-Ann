package com.finantix.mock.hsbc.ann.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AnNDTO {
    private String requestId;
    private String fromSystem;
    private String category;
    private String useCase;
    private String businessId;
    private String locale;
    private List<AlertVariableDTO> variables;
    private List<String> productList;
    private String bookingCenter;
    private String publicationFrequency;
    private String publicationCategory;
    private final List<String> marketsUnderlying;

    public AnNDTO() {
        this.marketsUnderlying = null;
        // Default
    }

    public String getPublicationFrequency() {
        return publicationFrequency;
    }

    public void setPublicationFrequency(String publicationFrequency) {
        this.publicationFrequency = publicationFrequency;
    }

    public String getPublicationCategory() {
        return publicationCategory;
    }

    public void setPublicationCategory(String publicationCategory) {
        this.publicationCategory = publicationCategory;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getFromSystem() {
        return fromSystem;
    }

    public void setFromSystem(String fromSystem) {
        this.fromSystem = fromSystem;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUseCase() {
        return useCase;
    }

    public void setUseCase(String useCase) {
        this.useCase = useCase;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public List<AlertVariableDTO> getVariables() {
        return variables;
    }

    public void setVariables(List<AlertVariableDTO> variables) {
        this.variables = variables;
    }

    public String getBookingCenter() {
        return bookingCenter;
    }

    public void setBookingCenter(String bookingCenter) {
        this.bookingCenter = bookingCenter;
    }

    public List<String> getProductList() {
        return productList;
    }

    public void setProductList(List<String> productList) {
        this.productList = productList;
    }

    public List<String> getMarketsUnderlying() {
        return marketsUnderlying;
    }

}
