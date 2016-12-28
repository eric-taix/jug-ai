package org.jug.montpellier.vux.ai.controller;

import ai.api.model.AIResponse;
import ai.api.model.Fulfillment;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/ai")
public class AiController {

    private static final Logger LOG = LoggerFactory.getLogger(AiController.class);

    @RequestMapping(method = RequestMethod.POST)
    public Fulfillment handle(@RequestBody AIResponse response, HttpServletRequest httpServletRequest) throws IOException {
        LOG.info("" + response);
        Fulfillment fulfillment = new Fulfillment();
        fulfillment.setSpeech("Bonjour Eric");
        fulfillment.setDisplayText("Comment vas tu aujourd'hui ?");
        return fulfillment;
    }

}
