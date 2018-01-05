package com.phfund.aplus.zipkin;


import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import zipkin.server.EnableZipkinServer;
import zipkin.storage.mysql.MySQLStorage;

@SpringBootApplication
@EnableZipkinServer
@EnableDiscoveryClient
public class ServerZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerZipkinApplication.class, args);
	}
	
	
	 @Bean
	    public MySQLStorage mySQLStorage(DataSource datasource) {
	        return MySQLStorage.builder().datasource(datasource).executor(Runnable::run).build();
	    }
	
	
}
