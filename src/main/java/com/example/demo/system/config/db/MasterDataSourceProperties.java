package com.example.demo.system.config.db;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.datasource.master")
public class MasterDataSourceProperties extends DataSourceProperties {
    // NOP
}