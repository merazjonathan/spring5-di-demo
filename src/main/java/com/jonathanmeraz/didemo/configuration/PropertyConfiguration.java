package com.jonathanmeraz.didemo.configuration;

import com.jonathanmeraz.didemo.examplebeans.FakeDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:datasource.properties")
public class PropertyConfiguration {

    @Value("${com.jonathanmeraz.datasource.user}")
    String user;

    @Value("${com.jonathanmeraz.datasource.password}")
    String password;

    @Value("${com.jonathanmeraz.datasource.url}")
    String url;

    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(user);
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);
        return fakeDataSource;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        // this reads the file designated by @PropertySource, enabling the @Value annotations
        return new PropertySourcesPlaceholderConfigurer();
    }
}
