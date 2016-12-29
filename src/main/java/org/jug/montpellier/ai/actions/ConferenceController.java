package org.jug.montpellier.ai.actions;

import ai.api.model.AIResponse;
import ai.api.model.Fulfillment;
import org.jug.montpellier.ai.annotations.AIAction;
import org.jug.montpellier.ai.annotations.AIController;

@AIController
@AIAction("conference")
public class ConferenceController {

    @AIAction("next")
    public Fulfillment nextAction(AIResponse defaultReponse) {
        return defaultReponse.getResult().getFulfillment();
    }
}
