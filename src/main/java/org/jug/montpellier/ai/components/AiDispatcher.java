package org.jug.montpellier.ai.components;

import ai.api.model.AIResponse;
import ai.api.model.Fulfillment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("${ai.uri:/ai}")
public class AiDispatcher {

    private static final Logger LOG = LoggerFactory.getLogger(AiDispatcher.class);

    private final AIRouter router;

    public AiDispatcher(AIRouter router) {
        this.router = router;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Fulfillment handle(@RequestBody AIResponse response) throws Exception {
        LOG.debug("Received AI response: {}", response);
        return router.handle(response);
    }

}
