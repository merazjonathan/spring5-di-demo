package com.jonathanmeraz.didemo.configuration;

import com.jonathanmeraz.didemo.examplebeans.FakeDataSource;
import com.jonathanmeraz.didemo.examplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
public class PropertyConfiguration {

    @Value("${com.jonathanmeraz.datasource.user}")
    String user;

    @Value("${com.jonathanmeraz.datasource.password}")
    String password;

    @Value("${com.jonathanmeraz.datasource.url}")
    String url;

    @Value("${com.jonathanmeraz.jms.user}")
    String jmsUser;

    @Value("${com.jonathanmeraz.jms.password}")
    String jmsPassword;

    @Value("${com.jonathanmeraz.jms.url}")
    String jmsUrl;

    @Bean
    public FakeJmsBroker fakeJmsBroker() {
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setUser(jmsUser);
        fakeJmsBroker.setPassword(jmsPassword);
        fakeJmsBroker.setUrl(jmsUrl);
        return fakeJmsBroker;
    }

    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(user);
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);
        return fakeDataSource;
    }

}
