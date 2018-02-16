package com.example.demo.system.config.db;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.datasource.slave")
public class SlaveDataSourceProperties extends DataSourceProperties {
    // NOP
}