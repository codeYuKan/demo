package com.yukan.demo.reactive.webflux;

import com.yukan.demo.reactive.rest.HelloController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * @author yukan
 * @date 2020/12/16
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
// //这里只写SpringBootTest这个注解; 如果是junit4的话, 就要加上@RunWith(SpringRunner.class)
//@SpringBootTest
@WebFluxTest(controllers = HelloController.class)
public class HelloTest {

    @Autowired
    WebTestClient client;

    @Test
    public void getHello() {
        client.get().uri("/hello").exchange().expectStatus().isOk();
    }
}
