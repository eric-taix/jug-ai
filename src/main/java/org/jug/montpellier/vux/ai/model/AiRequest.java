package org.jug.montpellier.vux.ai.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AiRequest {

    @JsonProperty("intent")
    private String intent;
    @JsonProperty("raw_inputs")
    private List<AiInput> rawInputs;
    @JsonProperty("raw_arguments")
    private List<AiArgument> arguments;

    public String getIntent() {
        return intent;
    }

    public AiRequest setIntent(String intent) {
        this.intent = intent;
        return this;
    }

    public List<AiInput> getRawInputs() {
        return rawInputs;
    }

    public AiRequest setRawInputs(List<AiInput> rawInputs) {
        this.rawInputs = rawInputs;
        return this;
    }

    public List<AiArgument> getArguments() {
        return arguments;
    }

    public AiRequest setArguments(List<AiArgument> arguments) {
        this.arguments = arguments;
        return this;
    }

    @Override
    public String toString() {
        return "Intent: " + intent +
                "\n\trawInputs: " + rawInputs +
                "\n\targuments: " + arguments
                ;
    }
}
