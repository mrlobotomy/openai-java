package com.theokanning.openai.assistants;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AssistantThread {
	/**
	 * The identifier, which can be referenced in API endpoints.
	 */
	String id;
	/**
	 * The object type, which is always thread.
	 */
	String object;
	/**
	 * The Unix timestamp (in seconds) for when the thread was created.
	 */
	@JsonProperty("created_at")
	long createdAt;
	/**
	 * Set of 16 key-value pairs that can be attached to an object. This can be
	 * useful for storing additional information about the object in a structured
	 * format. Keys can be a maximum of 64 characters long and values can be a
	 * maximum of 512 characters long.
	 */
	Map<String, String> metadata;
	
	/**
	 * Only used for create thread and run
	 */
	List<AssistantMessage> messages;
}
