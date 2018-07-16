package edu.mum.cs.cs472wap.efcar.model;

public class CardInfo {

    private Long code;
    private String name;
    private String iconUrl;

    public CardInfo(Long code, String name, String iconUrl) {
        this.code = code;
        this.name = name;
        this.iconUrl = iconUrl;
    }

    public CardInfo() {
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}
