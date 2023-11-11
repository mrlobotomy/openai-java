package com.theokanning.openai.assistants;

import lombok.Data;

@Data
public class AssistantTools {
	AssistantToolsEnum type;
	AssistantsFunction function;
}
