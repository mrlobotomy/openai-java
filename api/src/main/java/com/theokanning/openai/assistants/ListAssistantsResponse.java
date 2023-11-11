package com.theokanning.openai.assistants;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.theokanning.openai.OpenAiResponse;

public class ListAssistantsResponse<T> extends OpenAiResponse<T> {
	@JsonProperty("has_more")
	boolean hasMore;
	@JsonProperty("first_id")
	String firstId;
	@JsonProperty("last_id")
	String lastId;
}
