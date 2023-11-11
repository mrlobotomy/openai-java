package com.theokanning.openai.assistants;

import lombok.Data;

@Data
public class AssistantMessageText {
	/**
	 * The data that makes up the text.
	 */
	String value;
	/**
	 * TODO: update this to be an object
	 */
	String annotations;
}
