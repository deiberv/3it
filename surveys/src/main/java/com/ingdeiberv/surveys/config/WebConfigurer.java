package com.ingdeiberv.surveys.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
public class WebConfigurer {
  private final Logger log = LoggerFactory.getLogger(WebConfigurer.class);

  @Bean
  public CorsFilter corsFilter() {
    log.debug("Registering CORS filter");
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration config = new CorsConfiguration();
    config.setAllowedMethods(List.of("*"));
    config.setAllowedHeaders(List.of("*"));
    config.setAllowCredentials(true);
    config.setMaxAge(1800L);
    config.addAllowedOrigin("http://localhost:4200");
    config.addAllowedOrigin("https://localhost:4200");
    source.registerCorsConfiguration("/api/**", config);

    return new CorsFilter(source);
  }
}
