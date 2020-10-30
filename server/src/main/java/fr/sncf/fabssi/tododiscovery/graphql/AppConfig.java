package fr.sncf.fabssi.tododiscovery.graphql;
import graphql.execution.ExecutionStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.HashMap;
import java.util.Map;
@Configuration
public class AppConfig {
    /**
     * Configuration GraphQL pour créer une transaction par query
     */
    @Bean
    public Map<String, ExecutionStrategy> executionStrategies() {
        Map<String, ExecutionStrategy> executionStrategyMap = new HashMap<>();
        executionStrategyMap.put("queryExecutionStrategy", new AsyncTransactionalExecutionStrategy());
        return executionStrategyMap;
    }
}