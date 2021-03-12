package com.ukrposhta.test;

import com.ukrposhta.config.MvcLayerEmbeddedDataSourceTestConfig;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {MvcLayerEmbeddedDataSourceTestConfig.class})
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
class TestApplicationTests {

    @Test
    void contextLoads() {
    }

}
