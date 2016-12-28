package org.jug.montpellier.ai.controller;

import org.jug.montpellier.ai.model.AiRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class AiController {

    private static final Logger LOG = LoggerFactory.getLogger(AiController.class);

    @RequestMapping(method = RequestMethod.POST)
    public void handle(AiRequest request) {
        LOG.info("" + request);
    }

}
