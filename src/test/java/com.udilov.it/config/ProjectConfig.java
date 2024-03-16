package com.udilov.it.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({"classpath:config/${environment}.properties", "classpath:config/prod.properties"})
public interface ProjectConfig extends Config {

    @Key("first_name")
    String firstName();
    @Key("last_name")
    String lastName();
}