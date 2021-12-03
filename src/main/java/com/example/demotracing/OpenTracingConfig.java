package com.example.demotracing;

import co.elastic.apm.opentracing.ElasticApmTracer;
import io.opentracing.Tracer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenTracingConfig {
    @Bean
    public Tracer getTracer() {
        return new ElasticApmTracer();
    }
}