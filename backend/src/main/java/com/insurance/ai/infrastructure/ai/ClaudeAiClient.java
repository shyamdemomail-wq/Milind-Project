package com.insurance.ai.infrastructure.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.Map;
import com.insurance.ai.application.ports.AiServicePort;
import com.insurance.ai.common.exceptions.AiIntegrationException;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClaudeAiClient implements AiServicePort {

    private final ChatClient chatClient;

    @Override
    @Retryable(retryFor = { RuntimeException.class }, maxAttempts = 3, backoff = @Backoff(delay = 2000, multiplier = 2))
    public <T> T callAiAndParse(String promptTemplateString, Map<String, Object> variables, Class<T> responseType) {
        try {
            PromptTemplate template = new PromptTemplate(promptTemplateString);
            String prompt = template.create(variables).getContents();

            log.info("Sending prompt to Claude AI for type: {}", responseType.getSimpleName());

            T result = chatClient.prompt()
                    .user(prompt)
                    .call()
                    .entity(responseType);

            log.info("Successfully received and parsed Claude AI response for type: {}", responseType.getSimpleName());

            return result;
        } catch (Exception e) {
            log.error("Error processing AI request for type: {}", responseType.getSimpleName(), e);
            throw new AiIntegrationException("Failed to process AI request: " + e.getMessage(), e);
        }
    }
}
