package org.jug.montpellier.ai.configuration;

import ai.api.model.ResponseMessage;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ResponseMessage.ResponseSpeech.class, name = "0"),
        @JsonSubTypes.Type(value = ResponseMessage.ResponseCard.class, name = "1"),
        @JsonSubTypes.Type(value = ResponseMessage.ResponseQuickReply.class, name = "2"),
        @JsonSubTypes.Type(value = ResponseMessage.ResponseImage.class, name = "3"),
        @JsonSubTypes.Type(value = ResponseMessage.ResponsePayload.class, name = "4"),
})
public abstract class ResponseMessageMixIn {
}
