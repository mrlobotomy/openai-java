package com.theokanning.openai;

import com.theokanning.openai.DeleteResult;
import com.theokanning.openai.OpenAiResponse;
import com.theokanning.openai.assistants.Assistant;
import com.theokanning.openai.assistants.AssistantBody;
import com.theokanning.openai.assistants.AssistantMessage;
import com.theokanning.openai.assistants.AssistantMessageFile;
import com.theokanning.openai.assistants.AssistantThread;
import com.theokanning.openai.assistants.AssistantThreadResponse;
import com.theokanning.openai.assistants.ListAssistantsRequest;
import com.theokanning.openai.assistants.ListAssistantsResponse;
import com.theokanning.openai.audio.TranscriptionResult;
import com.theokanning.openai.audio.TranslationResult;
import com.theokanning.openai.billing.BillingUsage;
import com.theokanning.openai.billing.Subscription;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatCompletionResult;
import com.theokanning.openai.edit.EditRequest;
import com.theokanning.openai.edit.EditResult;
import com.theokanning.openai.embedding.EmbeddingRequest;
import com.theokanning.openai.embedding.EmbeddingResult;
import com.theokanning.openai.engine.Engine;
import com.theokanning.openai.file.AssistantFile;
import com.theokanning.openai.file.File;
import com.theokanning.openai.fine_tuning.FineTuningEvent;
import com.theokanning.openai.fine_tuning.FineTuningJob;
import com.theokanning.openai.fine_tuning.FineTuningJobRequest;
import com.theokanning.openai.finetune.FineTuneEvent;
import com.theokanning.openai.finetune.FineTuneRequest;
import com.theokanning.openai.finetune.FineTuneResult;
import com.theokanning.openai.image.CreateImageRequest;
import com.theokanning.openai.image.ImageResult;
import com.theokanning.openai.model.Model;
import com.theokanning.openai.moderation.ModerationRequest;
import com.theokanning.openai.moderation.ModerationResult;
import io.reactivex.Single;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.time.LocalDate;

public interface OpenAiApi {

    @GET("v1/models")
    Single<OpenAiResponse<Model>> listModels();

    @GET("/v1/models/{model_id}")
    Single<Model> getModel(@Path("model_id") String modelId);
    
    // remove this header when out of beta
    @Headers({"OpenAI-Beta: assistants=v1"})
    @POST("/v1/assistants")
    Single<Assistant> createAssistants(@Body AssistantBody requestBody);

    // remove this header when out of beta
    @Headers({"OpenAI-Beta: assistants=v1"})
    @GET("/v1/assistants/{assistant_id}")
    Single<Assistant> getAssistants(@Path("assistant_id") String assistantId);
    
    // remove this header when out of beta
    @Headers({"OpenAI-Beta: assistants=v1"})
    @POST("/v1/assistants/{assistant_id}")
    Single<Assistant> modifyAssistants(@Path("assistant_id") String assistantId, @Body AssistantBody requestBody);

    // remove this header when out of beta
    @Headers({"OpenAI-Beta: assistants=v1"})
    @DELETE("/v1/assistants/{assistant_id}")
    Single<DeleteResult> deleteAssistants(@Path("assistant_id") String assistantId);

    // remove this header when out of beta
    @Headers({"OpenAI-Beta: assistants=v1"})
    @GET("/v1/assistants")
    Single<ListAssistantsResponse<Assistant>> listAssistants(@Query(value = "") ListAssistantsRequest request);
    
    // remove this header when out of beta
    @Headers({"OpenAI-Beta: assistants=v1"})
    @POST("/v1/threads")
    Single<AssistantThreadResponse> createThread(@Body AssistantThread requestBody);
    
    // remove this header when out of beta
    @Headers({"OpenAI-Beta: assistants=v1"})
    @GET("/v1/threads/{thread_id}")
    Single<AssistantThreadResponse> getThread(@Path("thread_id") String threadId);
   
    // remove this header when out of beta
    @Headers({"OpenAI-Beta: assistants=v1"})
    @POST("/v1/threads/{thread_id}")
    Single<AssistantThreadResponse> modifyThread(@Path("thread_id") String threadId, @Body AssistantThread requestBody);
 
    // remove this header when out of beta
    @Headers({"OpenAI-Beta: assistants=v1"})
    @DELETE("/v1/threads/{thread_id}")
    Single<DeleteResult> deleteThread(@Path("thread_id") String threadId);

    // remove this header when out of beta
    @Headers({"OpenAI-Beta: assistants=v1"})
    @POST("/v1/threads/{thread_id}/messages")
    Single<AssistantMessage> createMessage(@Path("thread_id") String threadId, @Body AssistantMessage requestBody);
    
    // remove this header when out of beta
    @Headers({"OpenAI-Beta: assistants=v1"})
    @GET("/v1/threads/{thread_id}/messages/{message_id}")
    Single<AssistantMessage> getMessage(@Path("thread_id") String threadId, @Path("message_id") String messageId);

    // remove this header when out of beta
    @Headers({"OpenAI-Beta: assistants=v1"})
    @POST("/v1/threads/{thread_id}/messages/{message_id}")
    Single<AssistantMessage> createMessage(@Path("thread_id") String threadId, @Path("message_id") String messageId , @Body AssistantMessage requestBody);
    
    // remove this header when out of beta
    @Headers({"OpenAI-Beta: assistants=v1"})
    @GET("/v1/threads/{thread_id}/messages")
    Single<ListAssistantsResponse<AssistantMessage>> listMessages(@Path("thread_id") String threadId, @Query(value = "") ListAssistantsRequest request);
   
    // remove this header when out of beta
    @Headers({"OpenAI-Beta: assistants=v1"})
    @GET("/v1/threads/{thread_id}/messages/{message_id}/files/{file_id}")
    Single<AssistantMessageFile> getMessage(@Path("thread_id") String threadId, @Path("message_id") String messageId, @Path("file_id") String fileId);

    // remove this header when out of beta
    @Headers({"OpenAI-Beta: assistants=v1"})
    @GET("v1/threads/{thread_id}/messages/{message_id}/files")
    Single<ListAssistantsResponse<AssistantMessageFile>> listMessages(@Path("thread_id") String threadId, @Path("message_id") String messageId,
    		@Query(value = "") ListAssistantsRequest request);
   
    
    @POST("/v1/completions")
    Single<CompletionResult> createCompletion(@Body CompletionRequest request);

    @Streaming
    @POST("/v1/completions")
    Call<ResponseBody> createCompletionStream(@Body CompletionRequest request);

    @POST("/v1/chat/completions")
    Single<ChatCompletionResult> createChatCompletion(@Body ChatCompletionRequest request);

    @Streaming
    @POST("/v1/chat/completions")
    Call<ResponseBody> createChatCompletionStream(@Body ChatCompletionRequest request);

    @Deprecated
    @POST("/v1/engines/{engine_id}/completions")
    Single<CompletionResult> createCompletion(@Path("engine_id") String engineId, @Body CompletionRequest request);

    @POST("/v1/edits")
    Single<EditResult> createEdit(@Body EditRequest request);

    @Deprecated
    @POST("/v1/engines/{engine_id}/edits")
    Single<EditResult> createEdit(@Path("engine_id") String engineId, @Body EditRequest request);

    @POST("/v1/embeddings")
    Single<EmbeddingResult> createEmbeddings(@Body EmbeddingRequest request);

    @Deprecated
    @POST("/v1/engines/{engine_id}/embeddings")
    Single<EmbeddingResult> createEmbeddings(@Path("engine_id") String engineId, @Body EmbeddingRequest request);

    @GET("/v1/assistants/{assistant_id}/files")
    Single<OpenAiResponse<AssistantFile>> listAssistantFiles(@Path("assistant_id") String assistantId);

    @Multipart
    @POST("/v1/assistants/{assistant_id}/files")
    Single<AssistantFile> uploadAssistantFile(@Path("assistant_id") String assistantId, @Part("purpose") RequestBody purpose, @Part MultipartBody.Part file);

    @DELETE("/v1/assistants/{assistant_id}/files/{file_id}")
    Single<DeleteResult> deleteAssistantFile(@Path("assistant_id") String assistantId, @Path("file_id") String fileId);

    @GET("/v1/assistants/{assistant_id}/files/{file_id}")
    Single<AssistantFile> retrieveAssistantFile(@Path("assistant_id") String assistantId, @Path("file_id") String fileId);
    
    @GET("/v1/files")
    Single<OpenAiResponse<File>> listFiles();

    @Multipart
    @POST("/v1/files")
    Single<File> uploadFile(@Part("purpose") RequestBody purpose, @Part MultipartBody.Part file);

    @DELETE("/v1/files/{file_id}")
    Single<DeleteResult> deleteFile(@Path("file_id") String fileId);

    @GET("/v1/files/{file_id}")
    Single<File> retrieveFile(@Path("file_id") String fileId);

    @Streaming
    @GET("/v1/files/{file_id}/content")
    Single<ResponseBody> retrieveFileContent(@Path("file_id") String fileId);

    @POST("/v1/fine_tuning/jobs")
    Single<FineTuningJob> createFineTuningJob(@Body FineTuningJobRequest request);

    @GET("/v1/fine_tuning/jobs")
    Single<OpenAiResponse<FineTuningJob>> listFineTuningJobs();

    @GET("/v1/fine_tuning/jobs/{fine_tuning_job_id}")
    Single<FineTuningJob> retrieveFineTuningJob(@Path("fine_tuning_job_id") String fineTuningJobId);

    @POST("/v1/fine_tuning/jobs/{fine_tuning_job_id}/cancel")
    Single<FineTuningJob> cancelFineTuningJob(@Path("fine_tuning_job_id") String fineTuningJobId);

    @GET("/v1/fine_tuning/jobs/{fine_tuning_job_id}/events")
    Single<OpenAiResponse<FineTuningEvent>> listFineTuningJobEvents(@Path("fine_tuning_job_id") String fineTuningJobId);

    @Deprecated
    @POST("/v1/fine-tunes")
    Single<FineTuneResult> createFineTune(@Body FineTuneRequest request);

    @POST("/v1/completions")
    Single<CompletionResult> createFineTuneCompletion(@Body CompletionRequest request);

    @Deprecated
    @GET("/v1/fine-tunes")
    Single<OpenAiResponse<FineTuneResult>> listFineTunes();

    @Deprecated
    @GET("/v1/fine-tunes/{fine_tune_id}")
    Single<FineTuneResult> retrieveFineTune(@Path("fine_tune_id") String fineTuneId);

    @Deprecated
    @POST("/v1/fine-tunes/{fine_tune_id}/cancel")
    Single<FineTuneResult> cancelFineTune(@Path("fine_tune_id") String fineTuneId);

    @Deprecated
    @GET("/v1/fine-tunes/{fine_tune_id}/events")
    Single<OpenAiResponse<FineTuneEvent>> listFineTuneEvents(@Path("fine_tune_id") String fineTuneId);

    @DELETE("/v1/models/{fine_tune_id}")
    Single<DeleteResult> deleteFineTune(@Path("fine_tune_id") String fineTuneId);

    @POST("/v1/images/generations")
    Single<ImageResult> createImage(@Body CreateImageRequest request);

    @POST("/v1/images/edits")
    Single<ImageResult> createImageEdit(@Body RequestBody requestBody);

    @POST("/v1/images/variations")
    Single<ImageResult> createImageVariation(@Body RequestBody requestBody);

    @POST("/v1/audio/transcriptions")
    Single<TranscriptionResult> createTranscription(@Body RequestBody requestBody);

    @POST("/v1/audio/translations")
    Single<TranslationResult> createTranslation(@Body RequestBody requestBody);

    @POST("/v1/moderations")
    Single<ModerationResult> createModeration(@Body ModerationRequest request);

    @Deprecated
    @GET("v1/engines")
    Single<OpenAiResponse<Engine>> getEngines();

    @Deprecated
    @GET("/v1/engines/{engine_id}")
    Single<Engine> getEngine(@Path("engine_id") String engineId);

    /**
     * Account information inquiry: It contains total amount (in US dollars) and other information.
     *
     * @return
     */
    @Deprecated
    @GET("v1/dashboard/billing/subscription")
    Single<Subscription> subscription();

    /**
     * Account call interface consumption amount inquiry.
     * totalUsage = Total amount used by the account (in US cents).
     *
     * @param starDate
     * @param endDate
     * @return Consumption amount information.
     */
    @Deprecated
    @GET("v1/dashboard/billing/usage")
    Single<BillingUsage> billingUsage(@Query("start_date") LocalDate starDate, @Query("end_date") LocalDate endDate);

}
