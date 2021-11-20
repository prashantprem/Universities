package com.example.universities;
import com.google.gson.annotations.SerializedName;
public class Model {

    public Model(String stateProvince, String country, String[] webPages, String name, String alphaTwoCode, String[] domains)
    {
        this.stateProvince = stateProvince;
        this.country = country;
        this.webPages = webPages;
        this.name = name;
        this.alphaTwoCode = alphaTwoCode;
        this.domains = domains;

    }


    @SerializedName("state-province")
    private String stateProvince;
    @SerializedName("country")
    private String country;
    @SerializedName("web_pages")
    private String[] webPages;
    @SerializedName("name")
    private String name;
    @SerializedName("alpha_two_code")
    private String alphaTwoCode;
    @SerializedName("domains")
    private String[] domains;

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String[] getWebPages() {
        return webPages;
    }

    public void setWebPages(String[] webPages) {
        this.webPages = webPages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlphaTwoCode() {
        return alphaTwoCode;
    }

    public void setAlphaTwoCode(String alphaTwoCode) {
        this.alphaTwoCode = alphaTwoCode;
    }

    public String[] getDomains() {
        return domains;
    }

    public void setDomains(String[] domains) {
        this.domains = domains;
    }
}


