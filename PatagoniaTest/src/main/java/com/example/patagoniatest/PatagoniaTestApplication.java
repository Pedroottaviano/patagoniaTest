package com.example.patagoniatest;

import com.example.patagoniatest.model.Role;
import com.example.patagoniatest.service.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
//@EnableEurekaClient
public class PatagoniaTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatagoniaTestApplication.class, args);

    }

    @Bean
    CommandLineRunner run(ClientService clientService){
        return args -> {
            //clientService.addClient(new Client(null,"Ada",0, "123456",null,null));
            //clientService.addClient(new Client(null,"Richard",0, "123456",null,null));
            //clientService.addClient(new Client(null,"Steve",0, "123456",null,null));

            //clientService.saveRole(new Role(null, "ROLE_USER"));
            //clientService.saveRole(new Role(null, "ROLE_ADMINISTRATOR"));
            //clientService.saveRole(new Role(null, "ROLE_MANAGER"));

            //clientService.addRoleToClient("Richard", "ROLE_USER");
            //clientService.addRoleToClient("Richard", "ROLE_MANAGER");
            //clientService.addRoleToClient("Ada", "ROLE_ADMINISTRATOR");
        };
    }

}
