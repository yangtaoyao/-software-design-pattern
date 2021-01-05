package com.yty.pattern.strategy.StrategyFactory;

import org.springframework.stereotype.Service;

@Service
public class Channel02ServiceImpl extends ChannelService {
    @Override
    void login(String username, String pwd) {
        System.out.println("channel02: "+username+", "+pwd);
    }
}
