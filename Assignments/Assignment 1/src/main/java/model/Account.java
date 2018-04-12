package model;

import org.joda.time.DateTime;

public class Account {
    private Long id;
    private String type;
    private Long amountOfMoney;
    private DateTime dateOfCreation;
    private Long clientId;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(Long amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public DateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(DateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }
}
