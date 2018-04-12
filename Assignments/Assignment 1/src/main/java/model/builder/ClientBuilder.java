package model.builder;

import model.Client;

public class ClientBuilder {
    private Client client;

    public ClientBuilder(){
        client=new Client();
    }

    public ClientBuilder setName(String name){
        client.setName(name);
        return this;
    }

    public ClientBuilder setIcn(Long icn){
        client.setIcn(icn);
        return this;
    }

    public ClientBuilder setPersonalNumericalCode(Long personalNumericalCode){
        client.setPersonalNumericalCode(personalNumericalCode);
        return this;
    }

    public ClientBuilder setAddress(String address){
        client.setAddress(address);
        return this;
    }

    public Client build(){
        return client;
    }
}
