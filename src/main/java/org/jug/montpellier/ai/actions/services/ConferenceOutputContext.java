package org.jug.montpellier.ai.actions.services;

import ai.api.model.AIOutputContext;
import com.google.gson.JsonPrimitive;
import org.jug.montpellier.ai.actions.Conference;

import java.util.HashMap;

public class ConferenceOutputContext {

    private Conference conference;

    public ConferenceOutputContext(Conference conference) {
        this.conference = conference;
    }

    public AIOutputContext context() {
        AIOutputContext context = new AIOutputContext();
        context.setName("conference");
        context.setParameters(new HashMap<>());
        context.getParameters().put("id", new JsonPrimitive(conference.getId()));
        //context.getParameters().put("name", new JsonPrimitive(conference.getTitle()));
        return context;
    }
}
