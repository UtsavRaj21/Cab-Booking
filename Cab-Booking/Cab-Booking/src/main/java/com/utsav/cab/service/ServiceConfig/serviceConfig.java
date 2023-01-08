package com.utsav.cab.service.ServiceConfig;

import com.utsav.cab.service.DriverService;
import com.utsav.cab.service.Implementations.DriverServiceImpl;
import com.utsav.cab.service.Implementations.LocationServiceImpl;
import com.utsav.cab.service.Implementations.UserServiceImpl;
import com.utsav.cab.service.LocationService;
import com.utsav.cab.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class serviceConfig {

    @Bean
    DriverService driverService(){
        return new DriverServiceImpl();
    }

    @Bean
    LocationService locationService(){
        return new LocationServiceImpl();
    }

    @Bean
    UserService userService(){
        return new UserServiceImpl();
    }
}
