package org.jug.montpellier.ai.components;

import ai.api.model.AIResponse;
import ai.api.model.Fulfillment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AIRouter {

    private static final Logger LOG = LoggerFactory.getLogger(AIRouter.class);

    private Map<String, AIRoute> routes = new HashMap<>();

    public void register(String action, AIRoute route) {
        routes.put(action, route);
    }

    public Fulfillment handle(AIResponse response) throws Exception {
        AIRoute route = routes.get(response.getResult().getAction());
        if (route != null) {
            try {
                return route.execute(response);
            } catch (Exception e) {
                LOG.error("Route " + route + " thrown an exception", e);
                throw new Exception();
            }
        }
        else {
            LOG.warn("Action '{}' has not been registered", response.getResult().getAction());
            return response.getResult().getFulfillment();
        }
    }
}
