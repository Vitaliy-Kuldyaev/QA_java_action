package Interfaces;

import annotations.Key;
import annotations.Source;

import java.lang.reflect.Field;

@Source("classpath:config.properties")
public interface ProjectConfig {
    @Key("app.url")
    String appUrl();
}
