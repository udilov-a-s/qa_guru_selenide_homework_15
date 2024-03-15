package com.udilov.it.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:com.udilov.it.config/${environment}.properties")
public interface ProjectConfig extends Config {

    @Key("first_name")
    String firstName();
    @Key("last_name")
    String lastName();
}