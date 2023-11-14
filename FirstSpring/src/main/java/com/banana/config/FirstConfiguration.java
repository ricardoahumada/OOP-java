package com.banana.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({PropertiesConfig.class, MessageConfig.class, UserConfig.class})
public class FirstConfiguration {

}
