package com.yty.pattern.strategy.StrategyFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ChannelFactory {
    @Autowired
    private Map<String, ChannelService> map = new ConcurrentHashMap<>();

    public ChannelService getService(String channelService){
        return map.get(channelService);
    }
}
