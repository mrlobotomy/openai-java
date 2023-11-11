package com.theokanning.openai.assistants;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AssistantMessageImage {
	@JsonProperty("fileId")	
	String fileId;
}
