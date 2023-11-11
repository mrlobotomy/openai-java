package com.theokanning.openai.file;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AssistantFile extends File {
    @JsonProperty("assistant_id")
    Long assistandId;

}
