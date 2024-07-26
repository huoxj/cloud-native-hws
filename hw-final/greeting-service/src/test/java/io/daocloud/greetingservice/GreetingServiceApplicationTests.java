package io.daocloud.greetingservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GreetingServiceApplicationTests {

    @Autowired
    GreetingController greetingController;

    @Test
    void messageTest() {
        Message expect = new Message();
        Assertions.assertEquals(expect, greetingController.greeting());
    }

}
