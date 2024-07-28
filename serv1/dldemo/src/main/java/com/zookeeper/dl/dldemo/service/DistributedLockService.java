package com.zookeeper.dl.dldemo.service;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class DistributedLockService {

    private final InterProcessMutex lock;

    @Autowired
    public DistributedLockService(CuratorFramework client) {
        String lockPath = "/distributed-lock";
        this.lock = new InterProcessMutex(client, lockPath);
    }

    public void performTaskWithLock(Runnable task) {
        boolean lockAcquired = false;
        while (!lockAcquired) {
            try {
                lockAcquired = lock.acquire(5, TimeUnit.SECONDS);
                if (lockAcquired) {
                    try {
                        task.run();
                    } finally {
                        lock.release();
                    }
                } else {
                    System.out.println("Unable to acquire lock, retrying...");
                    // Optionally, you can add a sleep interval before retrying to avoid tight loop
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

