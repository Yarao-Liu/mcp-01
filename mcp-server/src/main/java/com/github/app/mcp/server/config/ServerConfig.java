package com.github.app.mcp.server.config;

import com.github.app.mcp.server.tool.WeatherService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Configuration
public class ServerConfig {

    @Bean
    public ToolCallbackProvider weatherToolProvider(WeatherService weatherService) {
        return MethodToolCallbackProvider.builder().toolObjects(weatherService).build();
    }


    @Bean
    public ToolCallbackProvider autoRegisterTools(ApplicationContext applicationContext) {

    // 获取所有标记了@Component注解且名称以Facade结尾的Bean
    String[] beanNames = applicationContext.getBeanNamesForAnnotation(Component.class);
    List<Object> toolBeans = new ArrayList<>();
    for(String beanName :beanNames) {
        // 可以根据命名规则或其他条件筛选要注册的工具
        if (beanName.endsWith("Service") || beanName.endsWith("Facade")) {
            toolBeans.add(applicationContext.getBean(beanName));
        }
    }
    return MethodToolCallbackProvider.builder()
            .toolObjects(toolBeans.toArray())
            .build();
}
}
