package com.example.guardian.model;

public interface IMessageListener<T> {
    public void onsucess(T responseMessage);
    public void onFailure(String errorResponseMessage);

}
