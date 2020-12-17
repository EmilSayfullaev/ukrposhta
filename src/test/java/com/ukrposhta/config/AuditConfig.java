package com.ukrposhta.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Optional;
import java.util.UUID;

@Configuration
@Profile("test")
public class AuditConfig {
    @Bean
    public AuditorAware<UUID> auditorProvider() {
        return new SecurityAuditor();
    }

    @Bean
    public AuditingEntityListener createAuditingListener() {
        return new AuditingEntityListener();
    }

    private static class SecurityAuditor implements AuditorAware<UUID> {
        @Override
        public Optional<UUID> getCurrentAuditor() {
            return Optional.of(UUID.randomUUID());
        }
    }
}