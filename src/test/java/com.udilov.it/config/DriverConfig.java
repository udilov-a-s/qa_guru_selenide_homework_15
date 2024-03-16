package com.udilov.it.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
        "classpath:config/driver.properties"
})
public interface DriverConfig extends Config {

    @Key("browser_name")
    @DefaultValue("chrome")
    String browserName();

    @Key("browser_version")
    @DefaultValue("122.0")
    String browserVersion();

    @Key("browser_size")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("browser_remote_url")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    String browserRemoteUrl();
}
