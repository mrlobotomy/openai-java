package com.theokanning.openai.assistants;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AssistantMessageFile {
	String id;
	String object;
	@JsonProperty("created_at")
	long createdAt;
	@JsonProperty("message_id")
	String messageId;
}
