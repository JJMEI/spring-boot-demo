package com.meijunjie.springboot.properties_config.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 *
 * @author meijunjie
 * @date 2018/9/21
 */

@Configuration
// 指定自定义配置文件的前缀
@ConfigurationProperties(prefix = "com.app")
// 指定自定义配置文件的
@PropertySource("classpath:SelfDefinitionProperties.properties")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SelfDefinitionPropertiesBean {

    private String name;
    private String author;
}
