package com.auditoria.javers.config;

import com.mongodb.MongoClientSettings;
import org.javers.spring.auditable.AuthorProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class JaversConfiguration {

    @Bean
    public AuthorProvider provideJaversAuthor() {
        return new SimpleAuthorProvider();
    }

    private static class SimpleAuthorProvider implements AuthorProvider {
        @Override
        public String provide() {
            return "06235074575";
        }
    }

    @Bean("javersMongoClientSettings")
    public MongoClientSettings clientSettings() {
        return MongoClientSettings.builder()
                .applyToSslSettings(builder -> builder.enabled(false))
                .applyToSocketSettings(
                        builder -> builder.connectTimeout(500, TimeUnit.MILLISECONDS))
                .build();
    }
}
