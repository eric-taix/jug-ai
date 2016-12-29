package org.jug.montpellier.ai.actions.services;

import org.jug.montpellier.ai.actions.Conference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConferenceService {

    @Value("${jug.url:https://www.jug-montpellier.org}")
    private String baseUrl;

    @Autowired
    private RestTemplate restTemplate;

    public Conference[] getPrevious() {
        return getConferences("/restEvents/past");
    }

    public Conference[] getUpcoming() {
        return getConferences("/restEvents/upcoming");
    }

    private Conference[] getConferences(String uri) {
        ResponseEntity<Conference[]> response = restTemplate.getForEntity(baseUrl + uri, Conference[].class);
        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null && response.getBody().length > 0) {
            return response.getBody();
        }
        return new Conference[0];
    }


}
