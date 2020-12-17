package com.ukrposhta.config;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.ClassicConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.io.IOException;

@TestConfiguration
public class MvcLayerEmbeddedDataSourceTestConfig {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Bean
    @Primary
    public DataSource dataSource() throws IOException {
        LOGGER.info("init test embedded dataSource");
        EmbeddedPostgres pg = EmbeddedPostgres.builder()
                .start();
        return pg.getPostgresDatabase();
    }

    @Bean(initMethod = "migrate")
    Flyway flyway() throws IOException {
        ClassicConfiguration configuration = new ClassicConfiguration();
        configuration.setBaselineOnMigrate(true);
        configuration.setLocationsAsStrings("classpath:/db/migration");
        configuration.setDataSource(dataSource());
        return new Flyway(configuration);
    }
}
