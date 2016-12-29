package org.jug.montpellier.ai.controller;

import ai.api.model.AIResponse;
import ai.api.model.Fulfillment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("${ai.uri:/ai}")
public class AiDispatcher {

    private static final Logger LOG = LoggerFactory.getLogger(AiDispatcher.class);

    @RequestMapping(method = RequestMethod.POST)
    public Fulfillment handle(@RequestBody AIResponse response) throws IOException {
        LOG.info("" + response);
        Fulfillment fulfillment = new Fulfillment();
        fulfillment.setSpeech("Bonjour Eric");
        fulfillment.setDisplayText("Comment vas tu aujourd'hui ?");
        return fulfillment;
    }

}
