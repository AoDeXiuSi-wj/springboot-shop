package com.example.shop.session;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.session.config.annotation.web.http.SpringHttpSessionConfiguration;
import org.springframework.util.StringValueResolver;

@Configuration
@EnableScheduling
public class RedisHttpSessionConfig
        extends SpringHttpSessionConfiguration
        implements BeanClassLoaderAware
        ,EmbeddedValueResolverAware
        ,ImportAware
        ,SchedulingConfigurer {

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {

    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {

    }

    @Override
    public void setImportMetadata(AnnotationMetadata importMetadata) {

    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

    }
}