package com.mamamoney.assignment.service;
import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import redis.clients.jedis.Jedis;

public class RedisCache {

    private RedissonClient cache;

    public RedisCache() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://redis:6379");
        this.cache = Redisson.create(config);

    }

    public Object getCachedObject(String sessionID) {
        return cache.getBucket(sessionID).get();
    }

    public void putCachedObject(String sessionID, Object object) {
        cache.getBucket(sessionID).set(object);
    }
}