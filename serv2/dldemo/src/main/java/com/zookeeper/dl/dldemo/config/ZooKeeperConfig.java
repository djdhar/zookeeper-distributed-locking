package com.zookeeper.dl.dldemo.config;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZooKeeperConfig {

    private static final String ZOOKEEPER_CONNECTION_STRING = "localhost:2181,localhost:2182,localhost:2183";  // Adjust as necessary

    @Bean
    public CuratorFramework curatorFramework() {
        CuratorFramework client = CuratorFrameworkFactory.newClient(
                ZOOKEEPER_CONNECTION_STRING,
                new ExponentialBackoffRetry(1000, 3)
        );
        client.start();
        return client;
    }
}
