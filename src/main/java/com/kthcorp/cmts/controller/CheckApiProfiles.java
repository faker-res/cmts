package com.kthcorp.cmts.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class CheckApiProfiles implements Condition {
    private static final Logger logger = LoggerFactory.getLogger(CheckApiProfiles.class);

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        boolean isActive = false;

        //@Profile({"local","dev","dev_crawl","dev_no_sched","prod_crawl"})
        isActive = (context.getEnvironment().acceptsProfiles("local")
                || context.getEnvironment().acceptsProfiles("dev")
                || context.getEnvironment().acceptsProfiles("dev_crawl")
                || context.getEnvironment().acceptsProfiles("dev_no_sched")
                || context.getEnvironment().acceptsProfiles("staging")
                || context.getEnvironment().acceptsProfiles("prod_api")
                || context.getEnvironment().acceptsProfiles("prod_crawl")
        );
        logger.info("##CheckApiProfiles result isActive:"+isActive);
        return isActive;
    }
}
