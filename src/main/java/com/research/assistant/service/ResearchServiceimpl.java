package com.research.assistant.service;

import java.net.URI;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.research.assistant.model.ResearchRequest;
import com.research.assistant.response.GeminiResponse;

@Service
public class ResearchServiceimpl implements ResearchService {
	
	@Value("${gemini.api.url}")
	private String geminiApiUrl;
	
	@Value("${gemini.api.key}")
	private String geminiApiKey;
	
	private final WebClient webClient;
	
	private final ObjectMapper objectMapper;
 	
     public ResearchServiceimpl(WebClient.Builder webClientbBuilder,ObjectMapper objectMapper) {
		this.webClient = webClientbBuilder.build();
		this.objectMapper=objectMapper;
	}
	
	
	
	

     @Override
     public String processContent(ResearchRequest request) {
         
         // Build the prompt
         String prompt = buildPrompt(request);
         
         // Query the API model
         Map<String, Object> requestBodyMap = Map.of(
             "contents", new Object[] {
                 Map.of("parts", new Object[] {
                     Map.of("text", prompt)
                 })
             }
         );
         
         
      // Parse the response
         String response = webClient.post()
           .uri(geminiApiUrl + geminiApiKey)
           .bodyValue(requestBodyMap)  // Fixed method name
           .retrieve()
           .bodyToMono(String.class)
           .block();
           
       
         return extractTextfromResponse(response);
     }

     private String extractTextfromResponse(String response) {
         try {
             GeminiResponse geminiResponse = objectMapper.readValue(response, GeminiResponse.class);
             if (geminiResponse.getCandidates() != null && !geminiResponse.getCandidates().isEmpty()) {
                 GeminiResponse.Candidate firstCandidate = geminiResponse.getCandidates().get(0);
                 if (firstCandidate.getContent() != null &&
                     firstCandidate.getContent().getParts() != null &&
                     !firstCandidate.getContent().getParts().isEmpty()) {  // Fixed condition
                     return firstCandidate.getContent().getParts().get(0).getText();
                 }
             }
             return "No Content Found in response";
         } catch (Exception e) {
             System.err.println("Error parsing response: " + e.getMessage());  // Logging
             return "Parsing Error: " + e.getMessage();
         }
     }

     private String buildPrompt(ResearchRequest request) {
         StringBuilder prompt = new StringBuilder();
         switch (request.getOperation()) {
             case "summarize": 
                 prompt.append("Provide a clear and concise summary of the following text in a few sentences:\n\n");
                 break;
             case "suggest": 
                 prompt.append("Based on the following content, suggest related topics and further reading. Format the response with clear headings and bullet points:\n\n");
                 break;
             default:
                 throw new IllegalArgumentException("Unknown Operation: " + request.getOperation());
         }
         prompt.append(request.getContent());
         return prompt.toString();
     }


}
