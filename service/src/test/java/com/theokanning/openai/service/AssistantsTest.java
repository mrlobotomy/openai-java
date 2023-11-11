package com.theokanning.openai.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import com.theokanning.openai.DeleteResult;
import com.theokanning.openai.assistants.Assistant;
import com.theokanning.openai.assistants.AssistantBody;
import com.theokanning.openai.assistants.ListAssistantsRequest;
import com.theokanning.openai.assistants.ListAssistantsResponse;
import com.theokanning.openai.utils.TikTokensUtil.ModelEnum;

/** 
 * TODO: Update GPT_4_1106 preview with non preview version when it's released
 * @author Graham Corrigan
 *
 */
public class AssistantsTest {
    String token = System.getenv("OPENAI_TOKEN");
    OpenAiService service = new OpenAiService(token, Duration.ofSeconds(30));

    @Test
    void createAssistants() {
        AssistantBody createAssistantsRequest = AssistantBody.builder()
                .model(ModelEnum.GPT_4_1106_preview.getName()).name("test").instructions("this is a test")
                .build();

        Assistant assistantsResponse = service.createAssistants(createAssistantsRequest);
        assertNotNull(assistantsResponse);
        assertEquals(assistantsResponse.getName(), "test");
        assertNotNull(assistantsResponse.getId());
    }
   
    @Test
    void getAssistants() {
        AssistantBody createAssistantsRequest = AssistantBody.builder()
                .model(ModelEnum.GPT_4_1106_preview.getName()).name("test").instructions("this is a test")
                .build();

        Assistant createAssistantsResponse = service.createAssistants(createAssistantsRequest);
        assertNotNull(createAssistantsResponse);
        assertEquals(createAssistantsResponse.getName(), "test");
        assertNotNull(createAssistantsResponse.getId());

        Assistant assistantsResponse = service.getAssistants(createAssistantsResponse.getId());
        assertNotNull(assistantsResponse);
        assertEquals(assistantsResponse.getName(), "test");
        assertNotNull(assistantsResponse.getId());
        assertEquals(createAssistantsResponse.getId(), assistantsResponse.getId());
    }

    @Test
    void modifyAssistants() {
        AssistantBody createAssistantsRequest = AssistantBody.builder()
                .model(ModelEnum.GPT_4_1106_preview.getName()).name("test").instructions("this is a test")
                .build();

        Assistant createAssistantsResponse = service.createAssistants(createAssistantsRequest);
        assertNotNull(createAssistantsResponse);
        assertEquals(createAssistantsResponse.getName(), "test");
        assertNotNull(createAssistantsResponse.getId());
        createAssistantsResponse.setName("test updated");
        Assistant modifyAssistantsResponse = service.modifyAssistants(createAssistantsResponse.getId(), createAssistantsResponse);
        assertNotNull(modifyAssistantsResponse);
        assertEquals(modifyAssistantsResponse.getName(), "test updated");
        assertNotNull(modifyAssistantsResponse.getId());
        assertEquals(createAssistantsResponse.getId(), modifyAssistantsResponse.getId());
    }

    @Test
    void listAssistants() throws Exception {
    	ListAssistantsRequest listAssistantsRequest = ListAssistantsRequest.builder().build();
    	
    	ListAssistantsResponse<Assistant> listAssistanceResponse = service.listAssistants(listAssistantsRequest);
    	assertNotNull(listAssistanceResponse);
    }
    
    @Test
    void deleteAssistants() {
        AssistantBody createAssistantsRequest = AssistantBody.builder()
                .model(ModelEnum.GPT_4_1106_preview.getName()).name("test").instructions("this is a test")
                .build();

        Assistant assistantsResponse = service.createAssistants(createAssistantsRequest);
        assertNotNull(assistantsResponse);
        assertNotNull(assistantsResponse.getId());
        assertEquals(assistantsResponse.getObject(), "assistant");
        DeleteResult deleteAssistantsResponse = service.deleteAssistants(assistantsResponse.getId());
        assertNotNull(deleteAssistantsResponse);
        assertEquals(deleteAssistantsResponse.getObject(), "assistant.deleted");
    }
}
