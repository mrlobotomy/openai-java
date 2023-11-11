package com.theokanning.openai.assistants;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.theokanning.openai.OpenAiError;
import com.theokanning.openai.file.AssistantFile;

import lombok.Data;

@Data
public class AssistantRun {
	String id;
	String object;
	@JsonProperty("created_at")
	Long createdAt;	
	@JsonProperty("thread_id")
	String threadId;
	@JsonProperty("assistant_id")
	String assistantId;
	AssistantRunStatusEnum status;
	@JsonProperty("expires_at")
	Long expiresAt;
	@JsonProperty("started_at")
	Long startedAt;
	@JsonProperty("cancelled_at")
	Long cancelledAt;
	@JsonProperty("failed_at")
	Long failedAt;
	@JsonProperty("completed_at")
	Long completedAt;
	String model;
	String instructions;
	List<AssistantTools> tools;
	@JsonProperty("file_ids")
	List<AssistantFile> fileIds;
	Map<String, String> metadata;
	@JsonProperty("required_action")
	Action requiredAction;
	@JsonProperty("last_error")
	OpenAiError lastError;
	
	public class Action {
		String type;
		// TODO: make this not shit
		@JsonProperty("submit_tool_outputs")
		SubmitToolOutputs submitToolOutputs;
	}
	
	public class SubmitToolOutputs {
		@JsonProperty("tool_calls")
		List<AssistantTools> toolCalls;
	}

}
