package model;

public class Client {
    private Long id;
    private Long icn;
    private Long personalNumericalCode;
    private String name;
    private String address;

    public Long getIcn() {
        return icn;
    }

    public void setIcn(Long icn) {
        this.icn = icn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonalNumericalCode() {
        return personalNumericalCode;
    }

    public void setPersonalNumericalCode(Long personalNumericalCode) {
        this.personalNumericalCode = personalNumericalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
