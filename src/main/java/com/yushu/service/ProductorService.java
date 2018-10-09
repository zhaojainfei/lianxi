package com.yushu.service;

import javax.jms.Destination;

public interface ProductorService {
    void sendMessage(Destination destination,final String message);
    void sendMessage(final String message);
    void publishMsg(final String message);
}
