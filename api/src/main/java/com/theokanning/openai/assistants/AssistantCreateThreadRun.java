package com.theokanning.openai.assistants;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.theokanning.openai.utils.TikTokensUtil.ModelEnum;

import lombok.Data;

@Data
public class AssistantCreateThreadRun {
	@JsonProperty("assistant_id")
	String assistantId;
	AssistantThread thread;
	ModelEnum model;
	String instructions;
	List<AssistantTools> tools;
	Map<String, String> metadata;
}
