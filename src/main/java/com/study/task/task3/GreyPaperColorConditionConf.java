package com.study.task.task3;

import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;

@Configuration
@Conditional(GreyPaperColorConditionConf.Condition.class)
@ImportResource("classpath:spring/grey-paper.xml")
public class GreyPaperColorConditionConf {
    static class Condition implements ConfigurationCondition {
        @Override
        public ConfigurationPhase getConfigurationPhase() {
            return ConfigurationPhase.PARSE_CONFIGURATION;
        }

        @Override
        public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
            return Paper.MY_FAVORITE_COLOR.equals("Grey");
        }
    }
}
