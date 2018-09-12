package cn.itclass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@ComponentScan(basePackages="cn.itclass")
public class Application extends SpringBootServletInitializer {
    private static Logger logger = LoggerFactory.getLogger(Application.class);

    /**
     * Main Start
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.info("============= SpringBoot Start Success =============");
    }
 
}