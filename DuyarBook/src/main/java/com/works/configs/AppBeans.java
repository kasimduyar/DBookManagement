package com.works.configs;

import com.works.repositories.CustomerRepository;
import com.works.utils.SecurityUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppBeans {

    int i = 0;
    @Bean(name = "objModelMapper")
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


    @Bean(name = "objConfigModelMapper")
    public ModelMapper modelMapper2(CustomerRepository customerRepository) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration();
        return modelMapper;
    }

    @Bean
    public SecurityUtil securityUtil(HttpServletRequest httpServletRequest) {
        return new SecurityUtil();
    }


}