package com.wanchenyang.demo02web01.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration
{
    @Bean
    public FilterRegistrationBean testFilterRegisteration()
    {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("MyFilter");
        registrationBean.setOrder(6);
        return registrationBean;
    }
    @Bean
    public FilterRegistrationBean test2FilterRegisteration()
    {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter2());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("MyFilter2");
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
