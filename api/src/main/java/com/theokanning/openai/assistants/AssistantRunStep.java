package com.theokanning.openai.assistants;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AssistantRunStep {
	String id;
	String object;
	@JsonProperty("created_at")
	Long createdAt;	
	@JsonProperty("thread_id")
	String threadId;
	@JsonProperty("assistant_id")
	String assistantId;
	@JsonProperty("run_id")
	String runId;
	AssistantRunStatusEnum status;
	String type;
	@JsonProperty("step_details")
	StepDetails stepDetails;
	@JsonProperty("expires_at")
	Long expiresAt;
	@JsonProperty("cancelled_at")
	Long cancelledAt;
	@JsonProperty("failed_at")
	Long failedAt;
	@JsonProperty("completed_at")
	Long completedAt;
	Map<String, String> metadata;

	public class StepDetails {
		String type;
		@JsonProperty("message_creation")
		MessageCreation messageCreation;
		// TODO: make sense of this
		@JsonProperty("tool_calls")
		String toolCalls;
	}
	
	public class MessageCreation {
		@JsonProperty("message_id")
		String messageId;
	}
}
