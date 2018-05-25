package com.study.task.task3;

import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;

@Configuration
@Conditional(WhitePaperColorConditionConf.Condition.class)
@ImportResource("classpath:spring/white-paper.xml")
public class WhitePaperColorConditionConf {
    static class Condition implements ConfigurationCondition {
        @Override
        public ConfigurationPhase getConfigurationPhase() {
            return ConfigurationPhase.PARSE_CONFIGURATION;
        }

        @Override
        public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
            return Paper.MY_FAVORITE_COLOR.equals("White");
        }
    }
}
