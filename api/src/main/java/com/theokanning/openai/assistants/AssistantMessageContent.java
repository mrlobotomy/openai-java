package com.theokanning.openai.assistants;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AssistantMessageContent {
	AssistantMessageTypeEnum type;
	Optional<AssistantMessageText> text;
	@JsonProperty("image_file")	
	Optional<AssistantMessageImage> imageFile;
}
