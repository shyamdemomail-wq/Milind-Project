package com.insurance.ai.application.ports;

import java.util.Map;

public interface AiServicePort {
    <T> T callAiAndParse(String promptTemplateString, Map<String, Object> variables, Class<T> responseType);
}
