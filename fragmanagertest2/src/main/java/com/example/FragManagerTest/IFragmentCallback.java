package com.example.FragManagerTest;

public interface IFragmentCallback {
    void sendMsgToActivity(String msg);
    String getMsgFromActivity(String msg);
}
