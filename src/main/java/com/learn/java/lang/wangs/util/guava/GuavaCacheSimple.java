package com.learn.java.lang.wangs.util.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 *
 * @ProjectName: basic
 * @Package: com.learn.java.lang.wangs.util.guava
 * @ClassName: GuavaCacheService
 * @Author: [wang sai]
 * @Date: 2021/9/3 3:51 下午
 * @Version: V1.0
 **/
public class GuavaCacheSimple {

    private Cache<String, Map<Integer, String>> baseDataCache =
            CacheBuilder.newBuilder().concurrencyLevel(64).maximumSize(50).expireAfterWrite(60, TimeUnit.MINUTES).build();

    public static void main(String[] args) {
        GuavaCacheSimple g = new GuavaCacheSimple();

        g.setCache();
    }

    public void setCache() {
        Cache<Integer, String> cache = CacheBuilder.newBuilder()
                //设置并发级别为8，并发级别是指可以同时写缓存的线程数
                .concurrencyLevel(8)
                //设置缓存容器的初始容量为10
                .initialCapacity(10)
                //设置缓存最大容量为100，超过100之后就会按照LRU最近虽少使用算法来移除缓存项
                .maximumSize(100)
                //是否需要统计缓存情况,该操作消耗一定的性能,生产环境应该去除
                .recordStats()
                //设置写缓存后n秒钟过期
                .expireAfterWrite(10, TimeUnit.SECONDS)
                //设置读写缓存后n秒钟过期,实际很少用到,类似于expireAfterWrite
                //.expireAfterAccess(17, TimeUnit.SECONDS)
                //只阻塞当前数据加载线程，其他线程返回旧值
                //.refreshAfterWrite(13, TimeUnit.SECONDS)
                //设置缓存的移除通知
                .removalListener(notification -> {
                    System.out.println("key:" + notification.getKey() + " " + notification.getValue() + " removed, cause:" + notification.getCause());
                })
                //build方法中可以指定CacheLoader，在缓存不存在时通过CacheLoader的实现自动加载缓存
                //采用CacheLoader方式创建元素，当调用get从cache中获取指定key的值时，发现没有，则调用cacheLoader计算得到一个该key对应的值，并添加到cache中，然后返回该值
                .build();

        try {
            // getOrDefault
            cache.get(1, ()->"fuck u");
            // put a value
            cache.put(2, "baby");
            System.out.println(cache.get(1,()->"eat my big diao"));
            System.out.println(cache.get(2,()->"eat my big diao"));
        } catch (Exception e) {
        }
        //缓存状态查看
        System.out.println(cache.stats().toString());
    }

}
