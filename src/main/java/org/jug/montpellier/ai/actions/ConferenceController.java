package org.jug.montpellier.ai.actions;

import ai.api.model.AIResponse;
import ai.api.model.Fulfillment;
import org.jug.montpellier.ai.actions.services.ConferenceOutputContext;
import org.jug.montpellier.ai.actions.services.ConferenceService;
import org.jug.montpellier.ai.annotations.AIAction;
import org.jug.montpellier.ai.annotations.AIController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

@AIController
@AIAction("conference")
public class ConferenceController {

    @Autowired
    private ConferenceService service;

    @AIAction("next")
    public Fulfillment next(AIResponse defaultReponse) {
        Conference[] conferences = service.getUpcoming();
        if (conferences.length > 0) {
            Conference conference = conferences[0];
            Fulfillment result = new Fulfillment();
            result.setSpeech("La prochaine conférence portera sur " + conference.getTitle() + ". Elle aura lieu le " + conference.getDate() + " à " + conference.getLocation());
            return result;
        }
        else {
            Fulfillment result = new Fulfillment();
            result.setSpeech("Il n'y a aucune conférence de prévue pour l'instant ! Mais pas d'inquiétude, les conférences ont lieu les 3ème mercredi du mois à coup sûr.");
            return result;
        }
    }

    @AIAction("past")
    public Fulfillment past(AIResponse defaultReponse) {
        Conference[] conferences = service.getPrevious();
        if (conferences.length > 0) {
            Conference lastConference = conferences[0];
            Fulfillment result = new Fulfillment();
            result.setSpeech("Il y a eu " + conferences.length + " conférences depuis la création du JUG. " +
                    "La dernière s'est déroulée le " + lastConference.getDate() + " et portait sur " + lastConference.getTitle());
           // result.setContextOut(Arrays.asList(new ConferenceOutputContext(lastConference).context()));
            return result;
        }
        else {
            Fulfillment result = new Fulfillment();
            result.setSpeech("Il n'y a aucune conférence jusqu'à maintenant");
            return result;
        }
    }

}
