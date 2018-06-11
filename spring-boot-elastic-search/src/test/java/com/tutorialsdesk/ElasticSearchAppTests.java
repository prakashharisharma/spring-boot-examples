package com.tutorialsdesk;

import com.tutorialsdesk.config.TestElasticSearchConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles({"test"})
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestElasticSearchConfig.class)
public class ElasticSearchAppTests {

    @Test
    public void contextLoads() {

    }

}
