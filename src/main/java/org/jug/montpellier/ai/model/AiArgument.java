package org.jug.montpellier.ai.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AiArgument {

    @JsonProperty("create_time.seconds")
    private Integer	createTimeSeconds;
    @JsonProperty("create_time.nanos")
    private Integer	createTimeNano;
    @JsonProperty("input_type")
    private AiInputType inputType;
    @JsonProperty("query")
    private String query;

    public Integer getCreateTimeSeconds() {
        return createTimeSeconds;
    }

    public AiArgument setCreateTimeSeconds(Integer createTimeSeconds) {
        this.createTimeSeconds = createTimeSeconds;
        return this;
    }

    public Integer getCreateTimeNano() {
        return createTimeNano;
    }

    public AiArgument setCreateTimeNano(Integer createTimeNano) {
        this.createTimeNano = createTimeNano;
        return this;
    }

    public AiInputType getInputType() {
        return inputType;
    }

    public AiArgument setInputType(AiInputType inputType) {
        this.inputType = inputType;
        return this;
    }

    public String getQuery() {
        return query;
    }

    public AiArgument setQuery(String query) {
        this.query = query;
        return this;
    }
}
