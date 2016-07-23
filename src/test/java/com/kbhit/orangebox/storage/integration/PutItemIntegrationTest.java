package com.kbhit.orangebox.storage.integration;

import com.kbhit.orangebox.storage.IntegrationTestContext;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = IntegrationTestContext.class)
@WebAppConfiguration
public class PutItemIntegrationTest {


}
