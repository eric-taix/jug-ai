package org.jug.montpellier.vux.ai.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.jug.montpellier.vux.ai.model.AiRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ai")
public class AiController {

    private static final Logger LOG = LoggerFactory.getLogger(AiController.class);

    @RequestMapping(method = RequestMethod.POST)
    public void handle(AiRequest request, HttpServletRequest httpRequest) throws IOException {
        String body = httpRequest.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        LOG.info("" + body);
    }

}
