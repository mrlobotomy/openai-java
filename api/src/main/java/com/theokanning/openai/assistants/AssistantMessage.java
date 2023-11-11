package com.theokanning.openai.assistants;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.theokanning.openai.file.File;

import lombok.Data;

@Data
public class AssistantMessage {
	String id;
	String object;
	@JsonProperty("created_at")
	long createdAt;
	@JsonProperty("thread_id")
	String threadId;
	String role;
	List<AssistantMessageContent> content;
	@JsonProperty("assistant_id")
	String assistantId;
	@JsonProperty("run_id")
	String runId;
	@JsonProperty("file_ids")
	List<File> fileIds;
	Map<String, String> metadata;
}
