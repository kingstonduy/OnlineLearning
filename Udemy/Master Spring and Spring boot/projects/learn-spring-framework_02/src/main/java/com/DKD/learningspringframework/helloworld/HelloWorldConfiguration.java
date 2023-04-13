/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DKD.learningspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 *
 * @author ADMIN
 */
record Person (String name, int age, Address address){};
record Address (String firstLine, String city){};
@Configuration
public class HelloWorldConfiguration{
	@Bean
	// this method creates a bean and this bean is managed by the spring context
	public String name(){ return "Duy";}
	@Bean
	public int age() { return 21; }
        @Bean
        @Primary
        public Address address1(){ return new Address("address 1", "HCM"); }
        @Bean
        @Qualifier("addressQualifier2")
        public Address address2(){ return new Address("address 2", "HCM"); }
        @Bean
        @Primary
        public Person person1(String name, int age, Address address){   return new Person(name, age, address);  }
        @Bean
        @Qualifier("personQualifier")
        public Person person2(String name, int age, @Qualifier("addressQualifier") Address address){   return new Person(name, age, address);  }
}