package com.ukrposhta.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Optional;
import java.util.UUID;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(value = "com.ukrposhta.repository")
@EnableJpaAuditing
@EntityScan(value = "com.ukrposhta")
public class JpaConfig {

    @Bean
    public AuditorAware<Long> auditorProvider() {
        return new SecurityAuditor();
    }

    @Bean
    public AuditingEntityListener createAuditingListener() {
        return new AuditingEntityListener();
    }

    public static class SecurityAuditor implements AuditorAware<Long> {

        @Override
        public Optional<Long> getCurrentAuditor() {
            return Optional.of(UserUtil.getCurrentUserUuid());
        }
    }

    public static class UserUtil {
        private static final Long DEFAULT_USER = 1111L;

        private UserUtil() {
        }

        public static Long getCurrentUserUuid() {
            return getDefaultPrincipal();
        }

        private static Long getDefaultPrincipal() {
            return DEFAULT_USER;
        }
    }

}
