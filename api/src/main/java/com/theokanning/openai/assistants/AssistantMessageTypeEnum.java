package com.theokanning.openai.assistants;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum AssistantMessageTypeEnum {
	@JsonProperty("text")	
	TEXT,
	@JsonProperty("image_file")	
	IMAGE_FILE,
	;
}
