package com.theokanning.openai.assistants;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.theokanning.openai.file.File;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
/**
 * https://platform.openai.com/docs/api-reference/assistants/object
 *
 */
public class AssistantBody {
	/**
	 * ID of the model to use. You can use the List models API to see all of your
	 * available models, or see our Model overview for descriptions of them.
	 */
	@NonNull
	String model;
	/**
	 * The name of the assistant. The maximum length is 256 characters.
	 */
	String name;
	/**
	 * The description of the assistant. The maximum length is 512 characters.
	 */
	String description;
	/**
	 * The system instructions that the assistant uses. The maximum length is 32768
	 * characters.
	 */
	String instructions;
	/**
	 * A list of tool enabled on the assistant. There can be a maximum of 128 tools
	 * per assistant. Tools can be of types code_interpreter, retrieval, or
	 * function.
	 */
	List<AssistantTools> tools;
	/**
	 * A list of file IDs attached to this assistant. There can be a maximum of 20
	 * files attached to the assistant. Files are ordered by their creation date in
	 * ascending order.
	 */
	@JsonProperty("file_ids")
	List<File> fileIds;
	/**
	 * Set of 16 key-value pairs that can be attached to an object. This can be
	 * useful for storing additional information about the object in a structured
	 * format. Keys can be a maximum of 64 characters long and values can be a
	 * maximum of 512 characters long.
	 */
	Map<String, String> metadata;
}
