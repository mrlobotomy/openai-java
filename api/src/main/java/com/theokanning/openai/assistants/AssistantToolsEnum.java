package com.theokanning.openai.assistants;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum AssistantToolsEnum {
	@JsonProperty("code_interpreter")
	CODE_INTERPRETER,
	@JsonProperty("retrieval")
	RETRIEVAL,
	@JsonProperty("function")
	FUNCTION,
	;
}
