package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.context.annotation.Profile;

@Profile("heroku")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AttachmentByType {

    @JsonProperty("trello")
    private Trello trello;
}
