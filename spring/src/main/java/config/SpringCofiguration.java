package config;

import bean.Cat;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(value = "bean", useDefaultFilters = true)
@Import(Cat.class)
public class SpringCofiguration {

}