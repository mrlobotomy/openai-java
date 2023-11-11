package com.theokanning.openai.assistants;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AssistantThreadResponse {
	String id;
	String object;
	@JsonProperty("created_at")
	long createdAt;
	Map<String, String> metadata;
}
