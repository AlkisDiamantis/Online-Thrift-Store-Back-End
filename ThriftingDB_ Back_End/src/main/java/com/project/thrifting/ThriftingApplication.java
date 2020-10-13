package com.project.thrifting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ThriftingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThriftingApplication.class, args);

    }

//    @Configuration
//    public class WebConfig implements WebMvcConfigurer {
//
//        @Override
//        public void addResourceHandlers(ResourceHandlerRegistry registry) {
//            registry.addResourceHandler("/images/**").addResourceLocations("file:C:\\images\\");
//        }
//    }

}
