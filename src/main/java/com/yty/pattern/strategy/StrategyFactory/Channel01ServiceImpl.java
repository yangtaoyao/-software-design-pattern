package com.yty.pattern.strategy.StrategyFactory;

import org.springframework.stereotype.Service;

@Service
public class Channel01ServiceImpl extends ChannelService {
    @Override
    void login(String username, String pwd) {
        System.out.println("channel01: "+username+", "+pwd);
    }
}
