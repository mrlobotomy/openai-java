package com.theokanning.openai.assistants;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum AssistantRunStatusEnum {
	@JsonProperty("started_at")
	QUEUED,
	@JsonProperty("in_progress")
	IN_PROGRESS,
	@JsonProperty("requires_action")
	REQUIRES_ACTION,
	@JsonProperty("cancelling")
	CANCELLING,
	@JsonProperty("cancelled")
	CANCELLED,
	@JsonProperty("failed")
	FAILED,
	@JsonProperty("completed")
	COMPLETED,
	@JsonProperty("expired")
	EXPIRED,
	;

}
