package com.study.springrestfulapi;

import com.study.springrestfulapi.resources.PostResource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringRestfulApiApplicationTests {

    @Autowired
    private PostResource postResource;

    @Test
    void contextLoads() {
        assertThat(postResource).isNotNull();
    }

}
