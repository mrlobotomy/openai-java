package com.theokanning.openai.assistants;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum AssistantsOrderEnum {
	@JsonProperty("asc")	
	ASC, 
	@JsonProperty("desc")	
	DESC,
	;
}
