package com.yukan.demo.websocket.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * WebSocket配置类
 * 注入ServerEndpointExporter，这个bean自动注册 使用了@ServerEndpoint注解声明的 Websocket endpoint
 * 如果使用独立的servlet容器而不是Springboot的内置容器，就不用注入ServerEndpointExporter
 * 因为它将由容器自己提供和管理
 *
 * @author yukan
 */
@Configuration
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}
