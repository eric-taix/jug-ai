package org.jug.montpellier.ai.configuration;

import ai.api.model.ResponseMessage;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfiguration {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer objectMapperBuilderCustomizer() {
        return jackson2ObjectMapperBuilder -> {
            // Add mix-in to support concret classes instanciation according to JSON field 'type'
            jackson2ObjectMapperBuilder.mixIn(ResponseMessage.class, ResponseMessageMixIn.class);
            // Support single value as array
            jackson2ObjectMapperBuilder.featuresToEnable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        };
    }

    @Bean
    public Module aiModule() {
        SimpleModule module = new SimpleModule();
        // Define default implementation for abstract JsonElement
        module.addAbstractTypeMapping(JsonElement.class, JsonPrimitive.class);
        return module;
    }
}
