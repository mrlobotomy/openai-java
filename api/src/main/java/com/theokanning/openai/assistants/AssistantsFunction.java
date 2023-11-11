package com.theokanning.openai.assistants;

import lombok.Data;

@Data
public class AssistantsFunction {
	/**
	 * A description of what the function does, used by the model to choose when and
	 * how to call the function.
	 */
	String description;
	/**
	 * The name of the function to be called. Must be a-z, A-Z, 0-9, or contain
	 * underscores and dashes, with a maximum length of 64.
	 */
	String name;
	/**
	 * The parameters the functions accepts, described as a JSON Schema object. See
	 * the guide for examples, and the JSON Schema reference for documentation about
	 * the format.
	 * 
	 * To describe a function that accepts no parameters, provide the value {"type":
	 * "object", "properties": {}}.
	 * 
	 * Note: this will be a JSON string
	 */
	String parameters;
}
