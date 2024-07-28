package com.zookeeper.dl.dldemo;

import com.zookeeper.dl.dldemo.service.DistributedLockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DldemoApplication implements CommandLineRunner {

	@Autowired
	private DistributedLockService lockService;

	public static void main(String[] args) {
		SpringApplication.run(DldemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		lockService.performTaskWithLock(() -> {
			System.out.println("Task performed with distributed lock");
			while (true) {

			}
			// Your task logic here
		});
	}
}
