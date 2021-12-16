package com.sean.configs;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

/*
 * Description: This class allows multiple apps to access the same
 * H2 database via the connection string:
 *  - jdbc:h2:tcp://localhost:9090/mem:testdb
 *
 * Source: https://www.baeldung.com/spring-boot-access-h2-database-multiple-apps
 */
@Configuration
public class H2Configs {

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server inMemoryH2DatabaseServer() throws SQLException {
        return Server.createTcpServer(
                "-tcp", "-tcpAllowOthers", "-tcpPort", "9093");
    }
}
